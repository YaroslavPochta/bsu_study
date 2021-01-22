import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.io.IOException;

public class Main extends JFrame {
    private JPanel panel;
    private JSlider slider;
    private JList<String> list;

    public static void main( String[] args ) {
        try {
            new Main();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", 1);
        }
    }

    Main() throws IOException {
        super("lab3.2");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initPanel();
        add(panel, BorderLayout.CENTER);
        setVisible(true);
        pack();
    }

    private void initPanel() throws IOException {

        panel = new MyPanel();
        JPanel PanelForSlider = new JPanel(new GridLayout(1, 2, 10, 10));
        slider = new JSlider();
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged( ChangeEvent e ) {
                ( (MyPanel) panel ).setImageSpeed(slider.getValue());
            }
        });
        PanelForSlider.add(slider);
        initList();
        PanelForSlider.add(list);
        add(PanelForSlider, BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(500, 500));


    }

    private void initList() {
        DefaultListModel defaultListModel = new DefaultListModel();
        defaultListModel.addElement("reverse clockwise");
        defaultListModel.addElement("clockwise");
        list = new JList<>(defaultListModel);
        list.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged( ListSelectionEvent e ) {
                if (list.getSelectedIndex() == 1) {
                    if (( (MyPanel) panel ).getImageSpeed() < 0) {
                        ( (MyPanel) panel ).setImageSpeed(-1 * ( (MyPanel) panel ).getImageSpeed());
                    }
                } else {
                    if (( (MyPanel) panel ).getImageSpeed() > 0) {
                        ( (MyPanel) panel ).setImageSpeed(-1 * ( (MyPanel) panel ).getImageSpeed());

                    }
                }
            }
        });
    }
}