package interpreter.actions;

import interpreter.Expression;

public class DivideAction extends AbstractMathAction {
    @Override
    public void interpret( Expression elem ) {
        elem.pushValue(( elem.popValue() / elem.popValue() ));
    }
}