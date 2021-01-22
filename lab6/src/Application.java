import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Application extends JFrame {

    private JPanel panel;
    private JButton button;
    private JLabel label;

    private Application() {
        createLayout();
        addListeners();
        setWindowParams();
    }

    private void createLayout() {

        panel = new JPanel();
        panel.setLayout(null);

        button = new JButton("");
        button.setSize(80, 20);
        panel.add(button);

        label = new JLabel("(x, y): (, )");

        var pane = getContentPane();
        var layout = new BorderLayout();
        pane.setLayout(layout);
        pane.add(label, BorderLayout.SOUTH);
        pane.add(panel, BorderLayout.CENTER);
    }

    private void addListeners() {

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                var mouseLocation = event.getPoint();
                button.setLocation(mouseLocation);
            }
        });

        panel.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent event) {
                var x = event.getX();
                var y = event.getY();
                var str = String.format("(x, y): (%d, %d)", x, y);
                label.setText(str);
            }
            @Override
            public void mouseDragged(MouseEvent event) {
                var x = event.getX();
                var y = event.getY();
                var str = String.format("(x, y): (%d, %d)", x, y);
                label.setText(str);
            }
        });

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                var x = event.getX() + button.getX();
                var y = event.getY() + button.getY();
                button.setLocation(x, y);
            }
        });

        button.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent event) {
                var x = event.getX() + button.getX();
                var y = event.getY() + button.getY();
                var str = String.format("(x, y): (%d, %d)", x, y);
                label.setText(str);
            }
            @Override
            public void mouseDragged(MouseEvent event) {
                var x = event.getX() + button.getX();
                var y = event.getY() + button.getY();
                var str = String.format("(x, y): (%d, %d)", x, y);
                label.setText(str);

                if (event.isControlDown()) {
                    button.setLocation(x, y);
                }
            }
        });

        button.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent event) {

                var key = event.getKeyChar();
                var buttonStr = button.getText();

                switch (key) {
                    case KeyEvent.VK_BACK_SPACE: {
                        var len = buttonStr.length() - 1;
                        if (len >= 0) {
                            var newButtonStr = buttonStr.substring(0, len);
                            button.setText(newButtonStr);
                        }
                        break;
                    }
                    default: {
                        button.setText(buttonStr + key);
                        break;
                    }
                }
            }
        });
    }

    private void setWindowParams() {
        setTitle("Jumping button");
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var app = new Application();
            app.setVisible(true);
        });
    }
}