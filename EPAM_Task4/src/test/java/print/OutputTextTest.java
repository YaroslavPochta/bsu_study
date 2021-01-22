package print;

import model.Component;
import model.ComponentType;
import model.Composite;
import model.Lexeme;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class OutputTextTest {
    private static final String inputText = "The United States Declaration of Independence. " + "\n" +
            "Adopted by the Second Continental Congress. ";
    private static final Component sentence1 = new Composite(Arrays.asList(
            new Lexeme("The", ComponentType.WORD),
            new Lexeme("United", ComponentType.WORD),
            new Lexeme("States", ComponentType.WORD),
            new Lexeme("Declaration", ComponentType.WORD),
            new Lexeme("of", ComponentType.WORD),
            new Lexeme("Independence.", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final Component sentence2 = new Composite(Arrays.asList(
            new Lexeme("Adopted", ComponentType.WORD),
            new Lexeme("by", ComponentType.WORD),
            new Lexeme("the", ComponentType.WORD),
            new Lexeme("Second", ComponentType.WORD),
            new Lexeme("Continental", ComponentType.WORD),
            new Lexeme("Congress.", ComponentType.WORD)),
            ComponentType.SENTENCE);

    private static final Component text = new Composite(Arrays.asList(sentence1,sentence2), ComponentType.PARAGRAPH);

    @Test
    public void testRestoreTextShouldReturnOriginalInputText(){
        OutputText outputText = new OutputText();
        String result = outputText.restoreText(text);
        Assert.assertEquals(inputText, result);
    }
}
