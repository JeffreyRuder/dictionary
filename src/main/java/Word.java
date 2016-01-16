import java.time.LocalDate;
import java.util.ArrayList;
import java.util.TreeMap;

public class Word {

    private static TreeMap<String, Word> mInstances = new TreeMap<String, Word>();

    private final String mString;
    private final LocalDate mCreatedAt;
    private ArrayList<Definition> mDefinitions;

    public Word(String wordString) {
        mString = wordString.trim().toLowerCase();
        mCreatedAt = LocalDate.now();
        mDefinitions = new ArrayList<Definition>();
        mInstances.put(mString, this);
    }

    public static Word getWord(String wordString) {
        return mInstances.get(wordString);
    }

    public static void removeWord(String wordString) {
        mInstances.remove(wordString);
    }

    public static TreeMap<String, Word> getAll() {
        return mInstances;
    }

    public static void clearAll() {
        mInstances.clear();
    }

    public String getString() {
        return mString;
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
