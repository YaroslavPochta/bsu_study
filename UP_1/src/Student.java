import java.io.BufferedReader;

public class Student extends Person implements Notifiable{
    private String login;
    private String email;

    Student(String login, String email, String name) {
        super(name);
        this.login = login;
        this.email = email;
    }

    public void notify(String message){
        System.out.println(this.toString() + ": " + message + ".");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
