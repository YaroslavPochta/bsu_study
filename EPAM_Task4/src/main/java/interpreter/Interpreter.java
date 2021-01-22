package interpreter;

import interpreter.actions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Interpreter {

    private List<AbstractMathAction> expressionList;

    public Interpreter( String expression ) {
        expressionList = new ArrayList<>();
        parse(expression);
    }

    public Integer calculate() {
        Expression expression = new Expression();
        for (AbstractMathAction mathAction : expressionList) {
            mathAction.interpret(expression);
        }
        return expression.popValue();
    }

    private void parse( String expression ) {
        for (String lexeme : expression
                .substring(1, expression.length() - 1)
                .split("_")) {
            char symbol = lexeme.charAt(0);
            switch (symbol) {
                case '+':
                    expressionList.add(new PlusAction());
                    break;
                case '-':
                    expressionList.add(new MinusAction());
                    break;
                case '*':
                    expressionList.add(new MultiplyAction());
                    break;
                case '/':
                    expressionList.add(new DivideAction());
                    break;
                default:
                    Scanner scanner = new Scanner(lexeme);
                    if (scanner.hasNextInt()) {
                        expressionList.add(new MathActionNumber(scanner.nextInt()));
                    }
            }
        }
    }
}