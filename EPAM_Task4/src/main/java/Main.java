import exceptions.FileException;
import model.Component;
import model.ComponentType;
import model.Composite;
import model.Lexeme;
import parser.TextParser;
import reader.Reader;
import tasks.SentenceQuantitySorter;
import tasks.SymbolsSorter;
import tasks.WordsLengthSorter;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main( String[] args ) {
        try {
            Reader reader = new Reader();
            Component component = new Composite();
            TextParser textParser = new TextParser();

            textParser.parse(component, reader.readFromFile("C:\\Users\\Yaroslav\\IdeaProjects\\EPAM_Task4\\src\\main\\resources\\input.txt"));
            System.out.println(component);
            System.out.println(new SentenceQuantitySorter().sortBySentenceQuantity(component));
            Component temp = new Composite();
            List<Component> tempList = Arrays.asList(new Lexeme("ttttttttt", ComponentType.WORD),
                    new Lexeme("qttttttt", ComponentType.WORD),
                    new Lexeme("tttt", ComponentType.WORD),
                    new Lexeme("aaaaaaa", ComponentType.WORD),
                    new Lexeme("abbbbbbbtt", ComponentType.WORD),
                    new Lexeme("abc", ComponentType.WORD)
            );
            temp = new Composite(tempList);
            System.out.println(new SymbolsSorter().sortByQuantityOfGivenSymbols(temp, 't'));
            System.out.println(new WordsLengthSorter().sortWordsByLength(temp));
        } catch (FileException e) {

        }
    }
}
