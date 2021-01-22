import java.util.HashSet;
import java.util.Set;

public class ProgrammingTest {
    public static void main( String[] args ) {
        Set<Student> students = new HashSet<Student>();
        students.add(new Undergraduate("roma21", "romasemizon@gmail.com", "Roman", new Academic("Max")));
        students.add(new Undergraduate("vlad2", "vladradion@gmail.com", "Vladislav", new Academic("Bob")));
        students.add(new Postgraduate("slava3", "slavaKalinin@gmail.com", "Slava", new Academic("Max")));
        students.add(new Postgraduate("pasha5", "pashastruk@gmail.com", "Pasha", new Academic("Bob")));
        students.add(new Postgraduate("sasha2", "sashanar@gmail.com", "Sasha", new Academic("Max")));

        Course course = new Course(students, "Programing");
        Set<Postgraduate> postgraduates = course.getPostgraduates("Max");

        for (var i : postgraduates) {
            System.out.println(i.toString());
        }

        Notifier notifier = new Notifier(postgraduates);
        notifier.doNotifyAll("Hello students!!!");
    }
}
