import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class Word {

    private static TreeMap<String, Word> mInstances = new TreeMap<String, Word>();

    private final String mDictionaryWord;
    private final LocalDate mCreatedAt;
    private ArrayList<Definition> mDefinitions;

    public Word(String userInput) {
        mDictionaryWord = userInput.replaceAll("(%[A-Z0-9a-z]{1,2})|(\\+)", " ").trim().toLowerCase();
        mCreatedAt = LocalDate.now();
        mDefinitions = new ArrayList<Definition>();
        mInstances.put(mDictionaryWord, this);
    }

    public static Word getWord(String word) {
        return mInstances.get(word);
    }

    public static void removeWord(String word) {
        mInstances.remove(word);
    }

    public static TreeMap<String, Word> getAll() {
        return mInstances;
    }

    public static void clearAll() {
        mInstances.clear();
    }

    public String getString() {
        return mDictionaryWord;
    }

    public void addDefinition(Definition definition) {
        mDefinitions.add(definition);
    }

    public void removeDefinition(Definition definition) {
        mDefinitions.remove(definition);
    }

    public ArrayList<Definition> getAllDefinitions() {
        return mDefinitions;
    }

    public LocalDate getCreatedAt() {
        return mCreatedAt;
    }

}
