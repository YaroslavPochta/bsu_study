package exceptions;

public class ProgramException extends Exception {
    public ProgramException() {
    }

    public ProgramException( String str, Throwable exception ) {
        super(str, exception);
    }

    public ProgramException( Throwable exception ) {
        super(exception);
    }

    public ProgramException( String str ) {
        super(str);
    }
}