package models;

import org.junit.*;
import static org.junit.Assert.*;
import play.test.WithApplication;
import static play.test.Helpers.*;

public class ModelsTest extends WithApplication {
    @Before
    public void setUp() {
        start(fakeApplication(inMemoryDatabase()));
    }

    @Test
    public void createVisitor() {
        Visitor.saveType("intelligent","tester");
        Visitor new_visitor = Visitor.find.where().eq("adjective","intelligent").eq("noun","tester").findUnique();
        assertNotNull(new_visitor);
        assertEquals("intelligent",new_visitor.adjective);
        assertEquals("tester",new_visitor.noun);
    }
}