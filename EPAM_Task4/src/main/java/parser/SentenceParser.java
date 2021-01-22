package parser;

import model.Component;
import model.ComponentType;
import model.Composite;

import java.util.regex.Pattern;

public class SentenceParser extends AbstractParser {

    @Override
    public Component parse( Component curTextElement, String text ) {
        setSuccessor(new LexemeParser());
        String[] mass = text.split("\\s+");
        for (String val : mass) {
            Composite sentence = new Composite(ComponentType.LEXEME);
            curTextElement.add(getSuccessor().parse(sentence, val),
                    ComponentType.LEXEME);
        }
        return curTextElement;
    }
}