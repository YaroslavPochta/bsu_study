package sample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataParser {
    private final String DATA_REGEX = "(((([0]?[1-9])|([12]\\d)|(30))[./-](([0]?[469])|(11)))|((([0]?[1-9])|([12]\\d)|(31)|(30))[./-](([0]?[13578])|([1][02])))|(([0]?[1-9])|([12]\\d))[./-]([0]?[2]))[./-](\\d+)";

    public String isData(String string) {
        Pattern pattern = Pattern.compile(DATA_REGEX);
        Matcher matcher = pattern.matcher(string);
        StringBuilder stringBuilder = new StringBuilder();
        while (matcher.find()) {
            stringBuilder.append(matcher.group() + " ");
        }
        return stringBuilder.toString();
    }
}

