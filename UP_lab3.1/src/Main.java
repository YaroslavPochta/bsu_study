import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;


public class Main extends JFrame {
    private Timer timer;
    private Clock clock;
    private int time = 0;
    ClockPanel clockPanel;

    public static void main(String[] args) throws Exception {
        try {
            new Main();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    Main() {
        super("Clock");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        clock = new Clock(0);
        clockPanel = new ClockPanel(clock);
        startTimer();
        add(clockPanel, BorderLayout.CENTER);


        pack();
        setVisible(true);
    }

    private void startTimer() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            public void run() {
                clockPanel.getClock().setMinutes(time);
                clockPanel.repaint();
                time++;
            }
        };
        timer.scheduleAtFixedRate(timerTask, 1000, 1000);
    }

}