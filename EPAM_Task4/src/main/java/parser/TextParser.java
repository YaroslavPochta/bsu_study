package parser;

import model.Component;
import model.ComponentType;
import model.Composite;

import javax.management.openmbean.CompositeType;

public class TextParser extends AbstractParser {
    private static final String REGULAR_EXPRESSION = "\n";

    @Override
    public Component parse( Component curTextElement, String text ) {
        String[] sentences = text.split(REGULAR_EXPRESSION);
        for (int i = 0; i < sentences.length; i++) {
            Composite paragraph = new Composite(ComponentType.PARAGRAPH);
            setSuccessor(new ParagraphParser());
            curTextElement.add(getSuccessor().parse(paragraph, sentences[i]),
                    ComponentType.PARAGRAPH);
        }

        return curTextElement;
    }
}