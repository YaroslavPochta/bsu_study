package model;

import interpreter.Interpreter;

import java.util.List;
import java.util.Objects;

public class Lexeme implements Component {
    private String data;
    private ComponentType type;

    public Lexeme( String data, ComponentType type ) {
        this.data = data;
        this.type = type;
    }

    public Lexeme( ComponentType type ) {
        this.type = type;
    }

    public List<Component> getChildren() {
        return null;
    }

    public String getValue() {
        return data;
    }

    public ComponentType getType() {
        return type;
    }

    public static Lexeme word( String value ) {
        return new Lexeme(value, ComponentType.WORD);
    }

    public static Lexeme expression( String value ) {
        return new Lexeme(value, ComponentType.EXPRESSION);
    }

    public void add( Component component, ComponentType componentType ) {
    }

    @Override
    public String toString() {
        String temp;
        if (type == ComponentType.EXPRESSION) {
            temp = new Interpreter(data).calculate().toString();
        } else {
            temp = data;
        }
        temp += " ";
        return temp;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) {
            return true;
        }
        if (!( o instanceof Lexeme )) {
            return false;
        }
        Lexeme lexeme = (Lexeme) o;
        return Objects.equals(data, lexeme.data) &&
                getType() == lexeme.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, getType());
    }
}
