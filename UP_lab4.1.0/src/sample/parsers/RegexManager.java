package sample.parsers;

public class RegexManager {
    private final String DATA_REGEX = "^(((([0]?[1-9])|([12]\\d)|(30))[./-](([0]?[469])|(11)))|((([0]?[1-9])|([12]\\d)|(31)|(30))[./-](([0]?[13578])|([1][02])))|(([0]?[1-9])|([12]\\d))[./-]([0]?[2]))[./-](\\d+)$";
    private final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private final String NATURAL_REGEX = "^[1-9][0-9]*$";
    private final String INTEGER_REGEX = "^[+-]?[1-9]?[0-9]+$";
    private final String DOUBLE_REGEX = "[+-]?(([0-9]+([.][0-9]*)?|[.][0-9]+)|(([0-9]*[.]?)?(e)([[+]|[-]])?[0-9]+))";
    private final String TIME_REGEX = "^([01]?[0-9]|2[0-3]):[0-5][0-9]$";

    public RegexManager() {
    }

    public String getDATA_REGEX() {
        return DATA_REGEX;
    }

    public String getEMAIL_REGEX() {
        return EMAIL_REGEX;
    }

    public String getNATURAL_REGEX() {
        return NATURAL_REGEX;
    }

    public String getINTEGER_REGEX() {
        return INTEGER_REGEX;
    }

    public String getDOUBLE_REGEX() {
        return DOUBLE_REGEX;
    }

    public String getTIME_REGEX() {
        return TIME_REGEX;
    }
}
