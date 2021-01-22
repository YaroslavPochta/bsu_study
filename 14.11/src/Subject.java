import com.sun.org.apache.xpath.internal.operations.String;

import java.text.CollationElementIterator;
import java.util.InputMismatchException;

public class Subject implements Comparable<Subject>
{
    private String name;
    private int hours;

    Subject()
    {
        name = "None";
        hours = 0;
    }

    Subject (String name_, int hours_) throws InputMismatchException
    {
        if (hours_ <= 0) throw new InputMismatchException("Quantity of hours can't be less then 0");
        hours = hours_;
        name = name_;
    }

    Subject(Subject sub)
    {
        name = sub.name;
        hours = sub.hours;
    }

    public String getName()
    {
        return name;
    }

    public int getHours()
    {
        return hours;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Subject sub = (Subject)obj;
        if (this.name.equals(sub.name) || this.hours != sub.hours)
            return false;
        return true;
    }

    @Override
    public int hashCode()
    {
        int result = hours;
        for (int i = 0; i < name.length(); i++)
        {
            result += name.charAt(i)*hours*(Math.tan(name.charAt(0) - name.charAt(name.length()))/7);
        }
        result += hours*hours + name.charAt(0);
        return result;
    }

    @Override
    public int compareTo(Subject o) {
        if (hours == o.hours) {
            return name.compareTo(o.name);
        }
        return Integer.compare(hours, o.hours);
    }

    @Override
    public String toString()
    {
        return "Subject name: " + name + "\t\t Hours of studying: " + hours + "\n";
    }
}
