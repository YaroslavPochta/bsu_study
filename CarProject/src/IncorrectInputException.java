public class IncorrectInputException extends Throwable{
    String message;

    @Override
    public String getMessage() {
        return message;
    }

    public IncorrectInputException(String message){
        this.message = message;
    }
}
