package parser;

import model.Component;
import model.ComponentType;
import model.Composite;
import model.Lexeme;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractParser {
    private static final String LEXEME_REGEX = "(^\\[\\d+_\\d+_((\\d+|([+\\-*/]))_)*([+\\-*/])]$)|([a-zA-Z,:;']+([.]{3}|[!?.])?)";
    private static final String EXPRESSION_REGEX = "^\\[\\d+_\\d+_((\\d+|([+\\-*/]))_)*([+\\-*/])]$";

    @Override
    public Component parse( Component curTextElement, String text ) {

        Pattern lexemePattern = Pattern.compile(LEXEME_REGEX);
        Matcher matcher = lexemePattern.matcher(text);
        while (matcher.find()) {
            Pattern expressionPattern = Pattern.compile(EXPRESSION_REGEX);
            Matcher matcher1 = expressionPattern.matcher(matcher.group());
            if (matcher1.find() &&
                    matcher1.group().length() >= 2) {
                curTextElement.add(new Lexeme(matcher.group(), ComponentType.EXPRESSION),
                        ComponentType.EXPRESSION);
            } else {
                curTextElement.add(new Lexeme(matcher.group(), ComponentType.WORD),
                        ComponentType.WORD);
            }
        }
        return curTextElement;
    }
}