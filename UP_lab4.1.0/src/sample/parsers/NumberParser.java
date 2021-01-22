package sample.parsers;

import java.util.regex.Pattern;

public class NumberParser extends AbstractParser {
    public boolean isNaturalNumber(String string){
    //    double num = 4.e315;
        return Pattern.matches(getNATURAL_REGEX(),string);
    }
    public boolean isIntegerNumber( String string){
        return Pattern.matches(getINTEGER_REGEX(),string);
    }
    public boolean isDoubleNumber(String string){
        return Pattern.matches(getDOUBLE_REGEX(),string);
    }
}
