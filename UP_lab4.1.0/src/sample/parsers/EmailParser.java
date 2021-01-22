package sample.parsers;

import java.util.regex.Pattern;

public class EmailParser extends AbstractParser {
    public boolean isEmail(String string){
        return Pattern.matches(getEMAIL_REGEX(), string);
    }
}
