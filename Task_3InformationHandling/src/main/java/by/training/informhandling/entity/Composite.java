package by.training.informhandling.entity;

import by.training.informhandling.parsing.parsingexpression.interpretationtorpn.Calculator;
import by.training.informhandling.parsing.parsingexpression.interpretationtorpn.Client;
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    private Category category;

    private static boolean isOutputText = true;

    public Composite() {
    }

    public Composite(final Category textCategory) {
        this.category = textCategory;
    }

    @Override
    public List<Component> getComponents() {
        return components;
    }

    @Override
    public Category getCategory() {
        return this.category;
    }

    @Override
    public void setIsOutputText(final boolean isReading) {
        isOutputText = isReading;
    }

    @Override
    public void add(final Component component, final Category currentCategory) {
        this.category = currentCategory;
        components.add(component);
    }

    @Override
    public Component clone(final Component cloneComponent,
                           final Component component) {
        for (int i = 0; i < component.getComponents().size(); i++) {
            Component cloneChild = new Composite(component
                    .getComponents().get(i).getCategory());
            cloneChild = component.getComponents().get(i).clone(cloneChild,
                    this.getComponents().get(i));
            cloneComponent.add(cloneChild, this.getCategory());
        }

        return cloneComponent;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (var component : components) {
            stringBuilder.append(component.toString());
        }

        if (category == Category.EXPRESSION && isOutputText) {
            String expression
                    = Calculator.expressionToRPN(stringBuilder.toString());
            stringBuilder.delete(0,
                    stringBuilder.length());
            Client interpreter = new Client(expression);
            stringBuilder.append(interpreter.calculate());
            stringBuilder.append(" ");
        } else {
            if (category == Category.SENTENCE) {
                stringBuilder.append("\n");
            } else {
                if (category == Category.WORD && isOutputText) {
                    stringBuilder.append(" ");
                }
            }
        }

        return stringBuilder.toString();
    }
}
