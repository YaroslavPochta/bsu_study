package com.epam.data;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class Validator {
    private final String DOUBLE_COORDINATE_PATTERNS = "[+-]?\\d+.?(\\d+)?";
    private final String SPECIAL_RADIUS_PATTERNS = "\\d+.?(\\d+)?";
    private final String REGEX = " ";
    private static final Logger LOGGER = LogManager.getLogger(Validator.class);

    public boolean isValid( String data ) {
        String[] strArray = data.split(REGEX);
        if (strArray.length != 4) {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!Pattern.matches(DOUBLE_COORDINATE_PATTERNS, strArray[i])) {
                LOGGER.error("Invalid point");
                return false;
            }
        }
        return Pattern.matches(SPECIAL_RADIUS_PATTERNS, strArray[3]);
    }
}
