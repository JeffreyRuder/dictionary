import org.junit.*;
import static org.junit.Assert.*;

public class WordTest {

    @Rule
    public ClearRule clearRule = new ClearRule();

    @Test
    public void word_instantiatesCorrectly_true() {
        Word word = new Word("coding");
        assertEquals(true, word instanceof Word);
    }

    @Test
    public void word_hasWordString_bird() {
        Word word = new Word("bird");
        assertEquals("bird", word.getString());
    }

    @Test
    public void getWord_returnsCorrectWord_true() {
        Word firstWord = new Word("coding");
        Word secondWord = new Word("bird");
        assertEquals(secondWord, Word.getWord("bird"));
    }

    @Test
    public void getWord_returnsNullWhenNoWord_true() {
        assertEquals(null, Word.getWord("bird"));
    }

    @Test
    public void getAll_returnsAllWords_true() {
        Word firstWord = new Word("coding");
        Word secondWord = new Word("bird");
        assertTrue(Word.getAll().containsValue(firstWord));
        assertTrue(Word.getAll().containsValue(secondWord));
    }

    @Test
    public void clearAll_clearsAllWords() {
        Word firstWord = new Word("coding");
        Word secondWord = new Word("bird");
        Word.clearAll();
        assertFalse(Word.getAll().containsValue(firstWord));
        assertFalse(Word.getAll().containsValue(secondWord));
    }

    @Test
    public void addDefinition_addsDefinitionToWord() {
        Word word = new Word("bird");
        Definition definition = new Definition("a flying animal", "the bird flew away");
        word.addDefinition(definition);
        assertTrue(word.getAllDefinitions().contains(definition));
    }

    @Test
    public void removeDefinition_removesDefinitionFromWord() {
        Word word = new Word("bird");
        Definition definition = new Definition("a flying animal", "the bird flew away");
        word.addDefinition(definition);
        word.removeDefinition(definition);
        assertFalse(word.getAllDefinitions().contains(definition));
    }
}
