public class Postgraduate extends Student{//аспирант
    Academic tutor;

    public Postgraduate(String login, String email, String name, Academic tutor) {
        super(login, email, name);
        this.tutor = tutor;
    }

    public Academic getTutor() {
        return tutor;
    }

    public void setTutor(Academic tutor) {
        this.tutor = tutor;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
