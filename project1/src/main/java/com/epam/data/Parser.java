package com.epam.data;

import com.epam.model.Ball;
import com.epam.model.Point;

public class Parser {
    public Ball parse( String data ) {
        String[] stringArray = data.split(" ");
        return new Ball(new Point(Double.parseDouble(stringArray[0]),
                Double.parseDouble(stringArray[1]),
                Double.parseDouble(stringArray[2])),
                Double.parseDouble(stringArray[3]));
    }
}
