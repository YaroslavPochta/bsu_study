package parser;

import model.Component;
import model.Composite;

public abstract class AbstractParser implements Parser {
    private Parser successor;

    public abstract Component parse( Component curTextElement, String text );

    public Parser getSuccessor() {
        return successor;
    }

    public void setSuccessor( Parser successor ) {
        this.successor = successor;
    }
}
