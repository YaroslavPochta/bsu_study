public class Student implements Comparable<Student> {

    private double averageMark;
    private String surname;

    public Student(int averageMark_, String surname_)
    {
        this.averageMark = averageMark_;
        this.surname = surname_;
    }

    @Override
    public int compareTo(Student other)
    {
        if (this.averageMark != other.averageMark) return Double.compare(this.averageMark, other.averageMark);
        else return this.surname.compareTo(other.surname);
    }

    @Override
    public String toString()
    {
        return "Student"  + surname + "has an average mark " + averageMark +  '\'' + '}';
    }
}