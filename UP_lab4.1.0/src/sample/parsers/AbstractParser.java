package sample.parsers;

public class AbstractParser {
    private final RegexManager regexManager = new RegexManager();

    public RegexManager getRegexManager() {
        return regexManager;
    }

    public String getDATA_REGEX() {
        return regexManager.getDATA_REGEX();
    }

    public String getEMAIL_REGEX() {
        return regexManager.getEMAIL_REGEX();
    }

    public String getNATURAL_REGEX() {
        return regexManager.getNATURAL_REGEX();
    }

    public String getINTEGER_REGEX() {
        return regexManager.getINTEGER_REGEX();
    }

    public String getDOUBLE_REGEX() {
        return regexManager.getDOUBLE_REGEX();
    }

    public String getTIME_REGEX() {
        return regexManager.getTIME_REGEX();
    }
}
