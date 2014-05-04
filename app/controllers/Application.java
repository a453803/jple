package controllers;

import play.mvc.*;
import play.data.*;
import static play.data.Form.*;

import views.html.*;

public class Application extends Controller {

    public static Result index(String adjective, String noun) {
        return ok(index.render(form(Correction.class), adjective, noun));
    }

    public static class Correction {
        public String adjective;
        public String noun;
    }

    public static Result submitCorrection() {
        Form<Correction> form = form(Correction.class).bindFromRequest();
        if(form.hasErrors()){
            return badRequest(index.render(form,"magnificent","donkey"));
        } else {
            Correction data = form.get();
            return ok(index.render(form(Correction.class),data.adjective,data.noun));
        }
    }
}
