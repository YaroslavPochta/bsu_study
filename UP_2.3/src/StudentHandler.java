import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.List;
import java.util.TreeMap;

public class StudentHandler extends DefaultHandler {

    private boolean surnameTagStart;
    private boolean groupTagStart;
    private boolean courseTagStart;
    private TreeMap<Integer, TreeMap<Integer, List<Student>>> treeMap;
    private Student student;

    public StudentHandler(TreeMap<Integer, TreeMap<Integer, List<Student>>> treeMap) {
        this.surnameTagStart = false;
        this.groupTagStart = false;
        this.courseTagStart = false;
        this.treeMap = treeMap;
    }
    // Метод вызывается когда SAXParser "натыкается" на начало тэга
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (qName.equalsIgnoreCase("Student")) {
            student = new Student();
        }
        else if (qName.equalsIgnoreCase("surname")) {
            surnameTagStart = true;
        }
        else if (qName.equalsIgnoreCase("course")) {
            courseTagStart = true;
        }
        else if (qName.equalsIgnoreCase("group")) {
            groupTagStart = true;
        }
    }

    // Метод вызывается когда SAXParser считывает текст между тэгами
    @Override
    public void characters(char ch[], int start, int length) throws SAXException, NumberFormatException {
        if (surnameTagStart) {
            student.setSurname(new String(ch, start, length));
            surnameTagStart = false;
        }
        else if (courseTagStart) {
            student.setCourse(Integer.parseUnsignedInt(new String(ch, start, length).trim()));
            courseTagStart = false;
        }
        else if (groupTagStart) {
            student.setGroup(Integer.parseUnsignedInt(new String(ch, start, length).trim()));
            groupTagStart = false;
        }
    }

    // Метод вызывается когда SAXParser "натыкается" на конец тэга
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (qName.equalsIgnoreCase("Student")) {
            StudentUtils.addStudent(treeMap,student);

        }
    }
}
