package tasks;

import model.Component;
import model.Composite;

import java.util.Comparator;

public class SentenceQuantitySorter {
    public Component sortBySentenceQuantity( Component component ) {
        Component sorterParagraph = new Composite(component.getChildren());
        sorterParagraph.getChildren().sort(new Comparator<Component>() {
            @Override
            public int compare( Component o1, Component o2 ) {
                return o1.getChildren().size() - o2.getChildren().size();
            }
        });
        return sorterParagraph;
    }
}
