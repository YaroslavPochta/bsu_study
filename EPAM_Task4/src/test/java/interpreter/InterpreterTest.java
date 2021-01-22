package interpreter;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class InterpreterTest {
    private static final String expressionInPolishNotationEqualsTo4 = "[2_2_+}";
    private static final String expressionInPolishNotationEqualsTo27 = "[3_10_3_*_-]";
    private static final String incorrectPolisNotation = "[1_3_4_+]";
    private static final String incorrectInputWithCorrectPolishNotationSyntax = "[1 4 +]";

    @DataProvider(name = "dataProviderForInterpreterWithCorrectData")
    public Object[][] dataProviderForInterpreterWithCorrectData() {
        return new Object[][] {{expressionInPolishNotationEqualsTo4, 4},
                {expressionInPolishNotationEqualsTo27, 27}};
    }

    @DataProvider(name = "dataProviderForInterpreterWithIncorrectData")
    public Object[][] dataProviderForInterpreterWithIncorrectData() {
        return new Object[][] {{incorrectInputWithCorrectPolishNotationSyntax, 4},
                {incorrectPolisNotation, 5}};
    }

    @Test(dataProvider = "dataProviderForInterpreterWithCorrectData")
    public void testCalculateWithCorrectData(String expression, int expected){
        Interpreter interpreter = new Interpreter(expression);
        int result = interpreter.calculate();
        Assert.assertEquals(result, expected);
    }

    @Test(dataProvider = "dataProviderForInterpreterWithIncorrectData")
    public void testCalculateWithIncorrectData(String expression, Integer expected){
        Interpreter interpreter = new Interpreter(expression);
        Integer result = interpreter.calculate();
        Assert.assertNotEquals(result, expected);
    }
}
