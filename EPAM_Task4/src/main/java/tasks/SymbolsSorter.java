package tasks;

import model.Component;
import model.Composite;

import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class SymbolsSorter {
    public Component sortByQuantityOfGivenSymbols( Component component, char symbol ) {
        List<Component> sortedSentence = component.getChildren();
        sortedSentence.sort(new Comparator<Component>() {
            @Override
            public int compare( Component o1, Component o2 ) {
                int symbolsInFirstComponent = 0;
                int symbolsInSecondComponent = 0;
                String tempFirstVal = o1.getValue();
                String tempSecondVal = o2.getValue();
                for (int i = 0; i < tempFirstVal.length(); i++) {
                    if (( tempFirstVal.charAt(i) ) == symbol) {
                        symbolsInFirstComponent++;
                    }
                }
                for (int i = 0; i < tempSecondVal.length(); i++) {
                    if (( tempSecondVal.charAt(i) ) == symbol) {
                        symbolsInSecondComponent++;
                    }
                }
                if (symbolsInFirstComponent == symbolsInSecondComponent) {
                    return tempFirstVal.compareToIgnoreCase(tempSecondVal);
                }
                return - (symbolsInFirstComponent - symbolsInSecondComponent);
            }
        });
        return new Composite(sortedSentence);
    }
}