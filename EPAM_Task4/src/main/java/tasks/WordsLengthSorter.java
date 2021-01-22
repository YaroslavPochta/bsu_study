package tasks;

import model.Component;
import model.Composite;
import java.util.Comparator;

public class WordsLengthSorter {
    public Component sortWordsByLength( Component component ) {
        Component sortedSentence = new Composite(component.getChildren());
        sortedSentence.getChildren().sort(new Comparator<Component>() {
            @Override
            public int compare( Component o1, Component o2 ) {
                return o1.getValue().length() - o2.getValue().length();
            }
        });
        return sortedSentence;
    }
}
