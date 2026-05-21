package regexes;

public enum Validation {

    StrongPassword("dn"),
    validUsername("lsnvd");

    private final String regex;

    Validation (String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
