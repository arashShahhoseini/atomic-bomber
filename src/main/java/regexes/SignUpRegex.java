package regexes;

public enum SignUpRegex {

    username("^[a-zA-Z0-9_]{4,20}$"),
    password("^\\S{6,}$");

    private final String regex;

    SignUpRegex(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }
}
