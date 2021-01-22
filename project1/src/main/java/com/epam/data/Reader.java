package com.epam.data;

import com.epam.exceptions.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private static final Logger LOGGER = LogManager.getLogger(Reader.class);

    public List<String> readLines( String filename ) throws DataException {
        List<String> dataList = new ArrayList<String>();
        try {
            FileReader fileReader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str;
            while (( str = bufferedReader.readLine() ) != null) {
                dataList.add(str);
            }
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
            throw new DataException(e.getMessage(), e.getCause());
        }
        if (dataList.isEmpty()) {
            LOGGER.warn("File " + filename + " is empty or haven't valid data.");
        }
        return dataList;
    }
}
