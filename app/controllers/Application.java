package controllers;

import models.Visitor;
import play.data.validation.Constraints.*;
import play.mvc.*;
import play.data.*;
import static play.data.Form.*;
import static play.libs.Json.toJson;
import views.html.*;
import java.util.List;

public class Application extends Controller {

    // standard index which provides an assertion about the visitor, and provides a form to correct the assertion
    public static Result index(String adjective, String noun) {
        return ok(index.render(form(Correction.class), Visitor.find.all(), adjective, noun));
    }

    // returns JSON string of all known visitors
    public static Result provideVisitors() {
        List<Visitor> visitors = Visitor.find.all();
        return ok(toJson(visitors));
    }

    // a class which defines what a correction looks like, and validates it
    public static class Correction {
        @Required
        public String adjective;
        @Required
        public String noun;

        public String validate() {
            if(adjective.matches(".*\\d.*") || noun.matches(".*\\d.*")) {
                return "Totes Not Valid! Numbers aren't things, and don't describe things!";
            }
            return null;
        }
    }

    // called on post of /, handles correction form submit
    public static Result submitCorrection() {
        Form<Correction> form = form(Correction.class).bindFromRequest();
        if(form.hasErrors()){
            return badRequest(index.render(form,Visitor.find.all(),"magnificent","donkey"));
        } else {
            Correction data = form.get();
            boolean itemExists = Visitor.find.where().eq("adjective", data.adjective).eq("noun", data.noun).findRowCount() == 0 ? false : true;
            if(itemExists == false) {
                Visitor.saveType(data.adjective,data.noun);
            }
            return ok(index.render(form(Correction.class),Visitor.find.all(),data.adjective,data.noun));
        }
    }
}
