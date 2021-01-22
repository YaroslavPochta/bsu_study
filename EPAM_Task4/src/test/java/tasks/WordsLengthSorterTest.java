package tasks;

import model.Component;
import model.ComponentType;
import model.Composite;
import model.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class WordsLengthSorterTest {
    private static final Component inputSentence = new Composite(Arrays.asList(
            new Lexeme("tttt", ComponentType.WORD),
            new Lexeme("a", ComponentType.WORD),
            new Lexeme("abb", ComponentType.WORD),
            new Lexeme("tttyttttgfftt", ComponentType.WORD),
            new Lexeme("tyuik", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final Component expectedSentence = new Composite(Arrays.asList(
            new Lexeme("a", ComponentType.WORD),
            new Lexeme("abb", ComponentType.WORD),
            new Lexeme("tttt", ComponentType.WORD),
            new Lexeme("tyuik", ComponentType.WORD),
            new Lexeme("tttyttttgfftt", ComponentType.WORD)),
            ComponentType.SENTENCE);

    @Test
    public void testSortWordsByLengthShouldReturnExpectedSentence(){
        WordsLengthSorter wordsLengthSorter = new WordsLengthSorter();
        var resultCmponent = wordsLengthSorter.sortWordsByLength(inputSentence);
        Assert.assertEquals(resultCmponent, expectedSentence);
    }
}
