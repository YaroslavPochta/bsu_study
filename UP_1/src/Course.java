import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Course {
    private Set<Student> students;
    private String name;

    public Course(Set<Student> students, String name) {
        this.students = students;
        this.name = name;
    }

    public Set<Postgraduate> getPostgraduates(String nameOfSupervisor){
        Set<Postgraduate> postgraduates = new HashSet<Postgraduate>();
        for(var i: students){
            if((i instanceof Postgraduate) && ((Postgraduate) i)
                    .getTutor().getName().equals(nameOfSupervisor)){
                postgraduates.add((Postgraduate) i);
            }
        }
        return postgraduates;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
