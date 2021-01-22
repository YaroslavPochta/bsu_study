package by.training.informhandling.actions;

import by.training.informhandling.entity.Component;
import by.training.informhandling.entity.Composite;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Comparator;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextAction {
    private static final Logger LOGGER = LogManager.getLogger(TextAction.class);
    private static final String REGULAR_EXPRESSION = "[A-Za-z]+";
    private static Pattern pattern = Pattern.compile(REGULAR_EXPRESSION);
    private static Comparator<Component>
            comparatorForSortingByNumberOfSentences
            = (o1, o2) -> Integer.compare(o1.getComponents().size(),
                o2.getComponents().size());

    private static Comparator<Component> comparatorForSortingWordsByLength
            = (o1, o2) -> {
        String wordFromSentence1 = getWordFromLexeme(o1.toString());
        String wordFromSentence2 = getWordFromLexeme(o2.toString());
        return Integer.compare(wordFromSentence1.length(),
                wordFromSentence2.length());
    };

    private static String getWordFromLexeme(final String lexeme) {
        Matcher matcher = pattern.matcher(lexeme);
        if (matcher.find()) {
            return matcher.group();
        }
        return lexeme;
    }

    public void sortByNumberOfSentences(final Composite composite) {
        composite.setIsOutputText(false);
        Collections.sort(composite.getComponents(),
                comparatorForSortingByNumberOfSentences);
        LOGGER.info("Sorting paragraphs by number of sentences ended"
                + " successful");
        composite.setIsOutputText(true);
    }

    public void sortWordsByLength(final Composite composite) {
        composite.setIsOutputText(false);
        for (var paragraphComponent : composite.getComponents()) {
            for (var sentenceComponent : paragraphComponent.getComponents()) {
                Collections.sort(sentenceComponent.getComponents(),
                        comparatorForSortingWordsByLength);
            }
        }
        LOGGER.info("Sorting words in every sentence by length of word ended"
                + " successful");
        composite.setIsOutputText(true);
    }

    public String sortLexemesByEntranceOfSomeSymbol(final Composite composite,
            final String symbol) {
        Comparator<String> comparatorForSortingByNumberOfEntrance
                = (o1, o2) -> {
            int numberOfEntrance1
                    = getNumberOfEntrance(o1, symbol);
            int numberOfEntrance2
                    = getNumberOfEntrance(o2, symbol);
            int difference = Integer.compare(numberOfEntrance2,
                    numberOfEntrance1);

            if (difference == 0) {
                return o1.compareTo(o2);
            } else {
                return difference;
            }
        };

        List<String> listWithLexemes = new ArrayList<>();

        for (var paragraph : composite.getComponents()) {
            for (var sentence : paragraph.getComponents()) {
                sentence.setIsOutputText(false);
                for (var lexeme : sentence.getComponents()) {
                    listWithLexemes.add(lexeme.toString());
                }
                sentence.setIsOutputText(true);
            }
        }

        Collections.sort(listWithLexemes,
                comparatorForSortingByNumberOfEntrance);
        LOGGER.info("Sorting lexemes in text by number of entrance of some " + "symbol ended successful");

        StringBuilder stringSortedLexemesByEntrance = new StringBuilder();
        for (var lexeme : listWithLexemes) {
            stringSortedLexemesByEntrance.append(lexeme + " ");
        }
        return stringSortedLexemesByEntrance.toString();
    }

    private static int getNumberOfEntrance(final String lexeme,
                                           final String symbol) {
        return lexeme.length() - lexeme.replace(symbol, "").length();
    }
}
