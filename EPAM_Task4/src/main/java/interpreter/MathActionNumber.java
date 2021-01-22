package interpreter;

import interpreter.actions.AbstractMathAction;

public class MathActionNumber extends AbstractMathAction {
    private int number;

    public MathActionNumber( int number ) {
        this.number = number;
    }

    @Override
    public void interpret( Expression c ) {
        c.pushValue(number);
    }
}