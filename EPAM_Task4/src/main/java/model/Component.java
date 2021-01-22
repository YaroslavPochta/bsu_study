package model;

import java.util.List;

public interface Component {
    void add( Component component, ComponentType componentType );

    List<Component> getChildren();

    String getValue();

    ComponentType getType();
}
