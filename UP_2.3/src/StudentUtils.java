import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class StudentUtils {

    public static void readXMLFile(TreeMap<Integer, TreeMap<Integer, List<Student>>> treeMap, File file) throws ParserConfigurationException, IOException,
            SAXException, NumberFormatException{

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();
        DefaultHandler handler = new StudentHandler(treeMap);
        treeMap.clear();
        saxParser.parse(file, handler);
    }

    public  static DefaultMutableTreeNode makeJTree(TreeMap<Integer, TreeMap<Integer, List<Student>>> collection){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("FAMCS");
        for(Integer course: collection.keySet()) {
            StringBuffer str = new StringBuffer(course.toString());
            str.append(" course");
            DefaultMutableTreeNode courseNode = new DefaultMutableTreeNode(str.toString());
            root.add(courseNode);
            for(Integer group: collection.get(course).keySet()){
                str = new StringBuffer(group.toString());
                str.append(" group");
                DefaultMutableTreeNode groupNode = new DefaultMutableTreeNode(str.toString());
                courseNode.add(groupNode);
                for(Student student: collection.get(course).get(group)){
                    DefaultMutableTreeNode studentNode = new DefaultMutableTreeNode(student.getSurname());
                    groupNode.add(studentNode);
                }
            }
        }
        return root;
    }

    public static void addStudent(TreeMap<Integer, TreeMap<Integer, List<Student>>> treeMap, Student student){
        if(!treeMap.containsKey(student.getCourse())) {
            treeMap.put(student.getCourse(), new TreeMap<>());
        }
        TreeMap<Integer, List<Student>> equalCourse = treeMap.get(student.getCourse());
        if(! equalCourse.containsKey(student.getGroup())){
            equalCourse.put(student.getGroup(), new LinkedList<>());
        }
        equalCourse.get(student.getGroup()).add(student);
    }
}
