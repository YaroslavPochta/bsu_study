package validator;

import exceptions.ProgramException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;

public class CreatorValidator {
    private static final Logger LOGGER = LogManager.getLogger(CreatorValidator.class);
    private static final String INCORRECT_LINE = "Incorrect line!";

    public boolean isRightParameters( Map.Entry<String, Integer> list ) {
        try {
            if (list.getValue() <= 0) {
                throw new ProgramException();
            }
        } catch (ProgramException ex) {
            LOGGER.error(INCORRECT_LINE);
            return false;
        }
        return true;
    }
}