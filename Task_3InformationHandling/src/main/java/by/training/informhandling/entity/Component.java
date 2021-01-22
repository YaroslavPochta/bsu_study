package by.training.informhandling.entity;

import java.util.ArrayList;
import java.util.List;

public interface Component {
   default List<Component> getComponents() {
        return new ArrayList<>();
    }
    Category getCategory();
    void setIsOutputText(boolean isOutputText);
    void add(Component c, Category category);
    Component clone(Component cloneComponent, Component component);
}
