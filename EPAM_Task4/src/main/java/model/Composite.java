package model;

import java.nio.charset.CoderMalfunctionError;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    private ComponentType componentType;
    private static final String DELIMER = " ";
    private static final String PARAGRAPH_DELIMER = "\n";

    public Composite() {
        children = new ArrayList<>();
    }

    public Composite( List<Component> children, ComponentType componentType ) {
        this.children = children;
        this.componentType = componentType;
    }

    public Composite( ComponentType componentType ) {
        this.componentType = componentType;
    }

    public Composite( List<Component> children ) {
        this.children = children;
    }

    @Override
    public void add( Component component, ComponentType componentType1 ) {
        children.add(component);
        this.componentType = componentType1;
    }

    @Override
    public List<Component> getChildren() {
        return children;
    }

    @Override
    public String getValue() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Component component : children) {
            stringBuilder.append(component.getValue()).append(" ");
        }
        return stringBuilder.toString();
    }

    @Override
    public ComponentType getType() {
        return componentType;
    }

    @Override
    public boolean equals( Object o ) {
        if (this == o) {
            return true;
        }
        if (!( o instanceof Composite )) {
            return false;
        }
        Composite composite = (Composite) o;
        return Objects.equals(getChildren(), composite.getChildren());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getChildren());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < children.size(); i++) {
            sb.append(children.get(i));
            if (componentType == ComponentType.PARAGRAPH && i != children.size()-1){
                sb.append(PARAGRAPH_DELIMER);
            }
        }
        return sb.toString();
    }
}