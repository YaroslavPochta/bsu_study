package tasks;

import model.Component;
import model.ComponentType;
import model.Composite;
import model.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SentenceQuantitySorterTest {
    private static final Component sentence1 = new Composite(Arrays.asList(
            new Lexeme("tttt", ComponentType.WORD),
            new Lexeme("aaaaaaa", ComponentType.WORD),
            new Lexeme("tytyty", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final Component sentence2 = new Composite(Arrays.asList(
            new Lexeme("tttt", ComponentType.WORD),
            new Lexeme("tttyttttgfftt", ComponentType.WORD),
            new Lexeme("tyui", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final Component sentence3 = new Composite(Arrays.asList(
            new Lexeme("aaaaaaa", ComponentType.WORD),
            new Lexeme("tttt", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final Component paragraph1 = new Composite(Arrays.asList(sentence1, sentence2, sentence3, sentence2), ComponentType.PARAGRAPH);
    private static final Component paragraph2 = new Composite(Arrays.asList(sentence3, sentence1, sentence2), ComponentType.PARAGRAPH);
    private static final Component paragraph3 = new Composite(Arrays.asList(sentence2, sentence2), ComponentType.PARAGRAPH);

    private static final Component inputText = new Composite(Arrays.asList(paragraph1, paragraph2, paragraph3));
    private static final Component expectedText = new Composite(Arrays.asList(paragraph3, paragraph2, paragraph1));

    @Test
    public void testSortBySentenceQuantityShouldReturnExpectedText() {
        SentenceQuantitySorter sentenceQuantitySorter = new SentenceQuantitySorter();
        var result = sentenceQuantitySorter.sortBySentenceQuantity(inputText);
        Assert.assertEquals(result, expectedText);
    }


}
