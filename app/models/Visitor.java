package models;

import javax.persistence.*;
import play.db.ebean.Model;
import com.avaje.ebean.*;

@Entity
public class Visitor extends Model {

    @Id
    public Integer id;
    public String adjective;
    public String noun;

    public Visitor(String adjective,String noun) {
        this.adjective = adjective;
        this.noun = noun;
    }

    public static Finder<String,Visitor> find = new Finder<String,Visitor>(
        String.class, Visitor.class
    );

    public static void saveType(String adjective, String noun) {
        Visitor thisVisitor = new Visitor(adjective,noun);
        Ebean.save(thisVisitor);
    }
}
