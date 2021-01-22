package parser;

import model.Component;
import model.ComponentType;
import model.Composite;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphParser extends AbstractParser {
    public Component parse( Component curTextElement, String text ) {
        setSuccessor(new SentenceParser());
        Matcher matcher = Pattern.compile(".*?([!?]|[.]+)")
                .matcher(text);
        while (matcher.find()) {
            Composite sentence = new Composite(ComponentType.SENTENCE);
            curTextElement.add(
                    getSuccessor().parse(
                            sentence, matcher.group()),
                    ComponentType.SENTENCE
            );
        }

        return curTextElement;
    }
}
