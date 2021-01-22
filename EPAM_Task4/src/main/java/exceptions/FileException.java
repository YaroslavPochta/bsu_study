package exceptions;

public class FileException extends Throwable{
    public FileException() {
    }

    public FileException( String message ) {
        super(message);
    }

    public FileException( String message, Throwable cause ) {
        super(message, cause);
    }

    public FileException( Throwable cause ) {
        super(cause);
    }
}
