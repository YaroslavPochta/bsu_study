
import javax.swing.*;
import javax.swing.tree.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class StudentsFrame extends JFrame
{

    //первый интеджер это номер курса, потом группы и студенты в этих группах в TreeMap.
    private TreeMap<Integer, TreeMap<Integer, List<Student>>> collection;
    private JTree tree;

    public StudentsFrame(String title)
    {
        super(title);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JMenuBar jMenu = new JMenuBar();
        JMenu menuStudent = new JMenu("Студенты");
        JMenu buttonDeleteStudent = new JMenu("Удалить студента");
        this.setJMenuBar(jMenu);
        jMenu.add(menuStudent);
        menuStudent.add(buttonDeleteStudent);

        try {
            collection = new TreeMap<>();
            StudentUtils.readXMLFile(collection, new File("src\\input.xml"));
            DefaultMutableTreeNode root = StudentUtils.makeJTree(collection);
            tree = new JTree(root);
            tree.setCellRenderer(new CellRenderer());
            add(new JScrollPane(tree));

            buttonDeleteStudent.addMouseListener(new DeleteStudentButtonClicked());
            tree.addMouseListener(new AddStudentButtonClicked());
            tree.addMouseListener(new ChangeInfoStudentButtonClicked());
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setSize(500, 1000);
            this.setVisible(true);
            setVisible(true);

        }
        catch ( javax.xml.parsers.ParserConfigurationException | org.xml.sax.SAXException | java.io.IOException ex){
            System.out.println(ex);
        }

    }
    private class AddStudentButtonClicked extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if(e.getButton() == MouseEvent.BUTTON3) {
                DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                Object obj = tree.getLastSelectedPathComponent();
                if (obj != null) {
                    DefaultMutableTreeNode sel = (DefaultMutableTreeNode) obj;
                    String ansQuestion = null;
                    if (sel.getLevel() == 0) {
                        ansQuestion = JOptionPane.showInputDialog(StudentsFrame.this, "input course");
                    } else if (sel.getLevel() == 1) {
                        ansQuestion = JOptionPane.showInputDialog(StudentsFrame.this, "input group");
                    } else if (sel.getLevel() == 2) {
                        ansQuestion = JOptionPane.showInputDialog(StudentsFrame.this, "input surname");
                    } else {
                        JOptionPane.showMessageDialog(StudentsFrame.this, "Impossible to add to student");
                    }
                    if (ansQuestion != null) {
                        DefaultMutableTreeNode tmp = new DefaultMutableTreeNode(ansQuestion);
                        model.insertNodeInto(tmp, sel, sel.getChildCount());
                        tree.expandPath(new TreePath(sel.getPath()));
                    }
                }
            }
        }
    }

    private class DeleteStudentButtonClicked extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            DefaultTreeModel model = (DefaultTreeModel)tree.getModel();
            Object obj = tree.getLastSelectedPathComponent();
            if(obj!=null) {
                DefaultMutableTreeNode sel = (DefaultMutableTreeNode)obj;
                if(sel.getLevel() == 3) {
                    int course = model.getIndexOfChild(model.getRoot(), sel.getParent().getParent());
                    int group = model.getIndexOfChild(sel.getParent().getParent(), sel.getParent());
                    int numStudent = model.getIndexOfChild(sel.getParent(), sel);
                    model.removeNodeFromParent(sel);
                    StudentsFrame.this.collection.get(course + 1).get(group + 1).remove(numStudent);
                }else{
                    JOptionPane.showMessageDialog(StudentsFrame.this, "You can delete only student!");
                }
            }
        }
    }

    private class ChangeInfoStudentButtonClicked extends MouseAdapter {
        public void mouseClicked(MouseEvent e) {
            if(e.getClickCount() == 3) {
                DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
                Object obj = tree.getLastSelectedPathComponent();
                if (obj != null) {
                    DefaultMutableTreeNode sel = (DefaultMutableTreeNode) obj;
                    if (sel.getLevel() == 3) {
                        String input = JOptionPane.showInputDialog(StudentsFrame.this, "Input : surname; course; group;");
                        if(input != null) {
                            int course = model.getIndexOfChild(model.getRoot(), sel.getParent().getParent());
                            int group = model.getIndexOfChild(sel.getParent().getParent(), sel.getParent());
                            int numStudent = model.getIndexOfChild(sel.getParent(), sel);
                            StringTokenizer strTok = new StringTokenizer(input, "; ");
                            try {
                                Student student = new Student(strTok.nextToken(), Integer.parseInt(strTok.nextToken()), Integer.parseInt(strTok.nextToken()));
                                StudentsFrame.this.collection.get(course + 1).get(group + 1).remove(numStudent);
                                StudentUtils.addStudent(StudentsFrame.this.collection, student);
                                model.removeNodeFromParent(sel);
                                model.setRoot(StudentUtils.makeJTree(collection));

                            } catch (NumberFormatException ex) {
                                JOptionPane.showMessageDialog(StudentsFrame.this, ex);
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(StudentsFrame.this, "You can change only student!");
                    }
                }
            }
        }
    }

    private class CellRenderer extends DefaultTreeCellRenderer {
        private JLabel label;

        CellRenderer() {
            label = new JLabel();
        }

        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded,
                                                      boolean leaf, int row, boolean hasFocus) {
            DefaultMutableTreeNode node = ((DefaultMutableTreeNode) value);
            if(node.getLevel() == 0){
                label.setIcon(new ImageIcon("fpmi.jpg"));
            } else if (node.getLevel() == 1) {
                label.setIcon(new ImageIcon("course.jpg"));
            }else if(node.getLevel() == 2){
                label.setIcon(new ImageIcon("group.png"));
            }else if(node.getLevel() == 3){
                label.setIcon(new ImageIcon("student.jpg"));
            }else{
                label.setIcon(null);
            }
            label.setText((String)((DefaultMutableTreeNode) value).getUserObject());
            if (node == tree.getLastSelectedPathComponent()){
                label.setForeground(Color.RED);
            }else{
                label.setForeground(Color.BLACK);
            }
            return label;
        }
    }



    public static void main(String[] args) {
        new StudentsFrame("");
    }
}