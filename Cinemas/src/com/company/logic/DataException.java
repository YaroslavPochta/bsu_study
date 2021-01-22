package com.company.logic;

public class DataException extends Throwable {
    public DataException( String message, Throwable cause ) {
        super(message, cause);
    }

    public DataException( String message ) {
        super(message);
    }
}
