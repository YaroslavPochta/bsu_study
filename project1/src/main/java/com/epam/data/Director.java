package com.epam.data;

import com.epam.exceptions.DataException;
import com.epam.model.Ball;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.ArrayList;
import java.util.List;

public class Director {
    private final String filename;
    private final Reader reader;
    private final Parser parser;
    private final Validator validator;
    private static final Logger LOGGER = LogManager.getLogger(Director.class);

    public Director( String filename, Reader reader, Parser parser, Validator validator ) {
        this.filename = filename;
        this.reader = reader;
        this.parser = parser;
        this.validator = validator;
    }

    public List<Ball> process() {
        LOGGER.info("Director.process() starts.");
        List<Ball> ballList = new ArrayList<Ball>();
        try {
            List<String> data = reader.readLines(filename);
            for (String line : data) {
                if (validator.isValid(line)) {
                    ballList.add(parser.parse(line));
                }
            }
        } catch (DataException e) {
            LOGGER.error("Error in Director.process(): " + e.getMessage()
                    + " Cause: " + e.getCause());
        }
        return ballList;
    }
}