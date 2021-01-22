
public class EmptyCollectionException extends Throwable {
    private String messege;
    public String getMessege() {
        return messege;
    }
    public EmptyCollectionException() {
    }
    public EmptyCollectionException( String message) {
        super(message);
    }
}