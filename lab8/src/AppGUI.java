import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class AppGUI extends JFrame {

    private JPanel mainPanel;
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JList list1;
    private JList list2;
    private JButton toRightButton;
    private JButton toLeftButton;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;

    private AppGUI() {
        setFirstTab();
        setSecondTab();
        setThirdTab();
        setWindowParams();
    }

    private void setFirstTab() {
        toRightButton.addActionListener(event -> moveSelectedItems(list1, list2));
        toLeftButton.addActionListener(event -> moveSelectedItems(list2, list1));
    }

    private void moveSelectedItems(JList fromList, JList toList) {
        var fromModel = (DefaultListModel) fromList.getModel();
        var toModel = (DefaultListModel) toList.getModel();
        var selectedIndices = fromList.getSelectedIndices();
        for (int i = selectedIndices.length - 1; i >= 0; --i) {
            var k = selectedIndices[i];
            toModel.addElement(fromModel.get(k));
            fromModel.remove(k);
        }
    }

    private void setSecondTab() {

        var rows = 5;
        var columns = 5;

        panel2.setLayout(new GridLayout(rows, columns));

        var gridButtonMouseAdapter = new MouseAdapter() {
            private Color normalColor;
            private String normalLabel;
            @Override
            public void mouseEntered(MouseEvent event) {
                var component = event.getComponent();
                normalColor = component.getBackground();
                component.setBackground(Color.YELLOW);
            }
            @Override
            public void mouseExited(MouseEvent event) {
                var component = event.getComponent();
                component.setBackground(normalColor);
            }
            @Override
            public void mousePressed(MouseEvent event) {
                var button = (Button) event.getComponent();
                normalLabel = button.getLabel();
                button.setLabel("Clicked!");
            }
            @Override
            public void mouseReleased(MouseEvent event) {
                var button = (Button) event.getComponent();
                button.setLabel(normalLabel);
            }
        };

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                var label = Integer.toString(1 + i * columns + j);
                var button = new Button(label);
                button.addMouseListener(gridButtonMouseAdapter);
                panel2.add(button);

            }
        }
    }

    private void setThirdTab() {

        var icon1 = new ImageIcon("images/rb1.png");
        var icon2 = new ImageIcon("images/rb2.png");
        var icon3 = new ImageIcon("images/rb3.png");
        var icon4 = new ImageIcon("images/rb4.png");

        JRadioButton[] rButtons = {radioButton1, radioButton2, radioButton3};

        for (var button : rButtons) {
            button.setIcon(icon1);
            button.setRolloverIcon(icon2);
            button.setPressedIcon(icon3);
            button.setSelectedIcon(icon4);
        }
    }

    private void setWindowParams() {
        setContentPane(mainPanel);
        setTitle("App");
        setSize(400, 400);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(AppGUI::new);
    }
}