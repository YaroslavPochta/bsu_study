package interpreter;

import java.util.ArrayDeque;
public class Expression {
    private ArrayDeque<Integer> contextValues = new ArrayDeque<>();

    public Integer popValue() {
        return contextValues.pop();
    }

    public void pushValue( Integer value ) {
        this.contextValues.push(value);
    }
}
