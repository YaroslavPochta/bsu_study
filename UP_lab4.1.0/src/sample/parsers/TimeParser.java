package sample.parsers;

import java.util.regex.Pattern;

public class TimeParser extends AbstractParser {
    public boolean isTime(String string){
        return Pattern.matches(getTIME_REGEX(),string);
    }
}
