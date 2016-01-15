import org.junit.*;
import static org.junit.Assert.*;

public class DefinitionTest {

    @Rule
    public ClearRule clearRule = new ClearRule();

    @Test
    public void definition_instantiatesCorrectly_true() {
        Definition definition = new Definition("a flying animal", "the bird flew away");
        assertEquals(true, definition instanceof Definition);
    }

    public void definition_hasDefinitionString_correctString() {
        Definition definition = new Definition("a flying animal", "the bird flew away");
        assertEquals("a flying animal", definition.getString());
    }

    public void definition_hasExample_correctString() {
        Definition definition = new Definition("a flying animal", "the bird flew away");
        assertEquals("the bird flew away", definition.getExample());
    }

}
