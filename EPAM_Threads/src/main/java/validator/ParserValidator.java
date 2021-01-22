package validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.StringTokenizer;

public class ParserValidator {
    private static final Logger LOGGER = LogManager.getLogger(ParserValidator.class);
    private static final String INCORRECT_LINE = "Incorrect line!";

    public boolean validate( String string ) {
        try {
            StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
            String.valueOf(stringTokenizer.nextToken());
            Integer.parseInt(stringTokenizer.nextToken());
        } catch (NumberFormatException ex) {
            LOGGER.debug(INCORRECT_LINE);
            return false;
        }
        return true;
    }
}