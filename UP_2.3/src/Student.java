public class Student{

    private String surname;
    private int group;
    private int course;

    public Student(){
        surname = "NanInd";
        course = 0;
        group = 0;
    }

    public Student(String surname, int course, int group) {
        this.surname = surname;
        this.course = course;
        this.group = group;
    }

    public String toString(){
        return  "Surname: " + surname + ", course: "+ course + ", group: " + group ;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public String getSurname() {
        return surname;
    }

    public int getCourse() {
        return course;
    }

    public int getGroup(){
        return this.group;
    }

}
