public class Definition {
    private String mString;
    private String mExample;

    public Definition(String definition, String example) {
        mString = definition.trim().toLowerCase();
        mExample = example.trim().toLowerCase();
    }

    public String getString() {
        return mString;
    }

    public String getExample() {
        return mExample;
    }
}
