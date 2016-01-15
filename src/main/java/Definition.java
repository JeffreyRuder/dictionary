public class Definition {
    private String mString;
    private String mExample;

    public Definition(String definition, String example) {
        mString = definition;
        mExample = example;
    }

    public String getString() {
        return mString;
    }

    public String getExample() {
        return mExample;
    }
}
