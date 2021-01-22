package sample.parsers;
import java.util.regex.Pattern;

public class DateParser extends AbstractParser {
    public boolean isData(String string){
        return Pattern.matches(getDATA_REGEX(),string);
    }
}
