package tasks;

import model.Component;
import model.ComponentType;
import model.Composite;
import model.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SymbolsSorterTest {
    private static final Component inputComponent = new Composite(Arrays.asList(new Lexeme("tttt", ComponentType.WORD),
            new Lexeme("aaaaaaa", ComponentType.WORD),
            new Lexeme("ttttttttt",ComponentType.WORD ),
            new Lexeme("qttttttt", ComponentType.WORD),
            new Lexeme("abbbbbbbtt", ComponentType.WORD),
            new Lexeme("abc", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final Component expectedComponent = new Composite(Arrays.asList(new Lexeme("ttttttttt",ComponentType.WORD ),
            new Lexeme("qttttttt", ComponentType.WORD),
            new Lexeme("tttt", ComponentType.WORD),
            new Lexeme("abbbbbbbtt", ComponentType.WORD),
            new Lexeme("aaaaaaa", ComponentType.WORD),
            new Lexeme("abc", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final char GIVEN_SYMBOL = 't';

    @Test
    public void testSortByQuantityOfGivenSymbolsShouldReturnExpectedComponent(){
        SymbolsSorter symbolsSorter = new SymbolsSorter();
        Component resultComponent = symbolsSorter.sortByQuantityOfGivenSymbols(inputComponent, GIVEN_SYMBOL);
        Assert.assertEquals(expectedComponent, resultComponent);
    }
}
