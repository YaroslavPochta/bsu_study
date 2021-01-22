public class Undergraduate extends Student{//студент
    Academic supervisor;

    public Undergraduate(String login, String email, String name, Academic supervisor) {
        super(login, email, name);
        this.supervisor = supervisor;
    }

    public Academic getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Academic supervisor) {
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
