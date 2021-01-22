package com.epam.exceptions;

public class SingletonException extends Throwable {
    public SingletonException( String message ) {
        super(message);
    }

    public SingletonException( String message, Throwable cause ) {
        super(message, cause);
    }
}