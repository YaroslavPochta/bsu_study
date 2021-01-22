package parser;

import model.Component;

public interface Parser {
    Component parse(Component component, String value);
}
