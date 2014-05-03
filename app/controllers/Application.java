package controllers;

import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {

    public static Result index(String adjective, String animal) {
        return ok(index.render(adjective, animal));
    }
}
