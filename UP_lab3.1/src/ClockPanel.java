import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.*;

class ClockPanel extends JPanel {
    private Clock clock;

    public ClockPanel(Clock сlock) {
        setDoubleBuffered(true);
        setPreferredSize(new Dimension(800, 800));
        setClock(сlock);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (clock != null) {
            drawClock(g, clock);
        }
    }

    private Point getEndPoint(double angle, int radius) {
        Point O = new Point(getSize().width / 2, getSize().height / 2);
        int x = (int) (O.x + radius * Math.cos(angle));
        int y = (int) (O.y - radius * Math.sin(angle));
        return new Point(x, y);
    }

    private void drawClock(Graphics g, Clock сlock) {
        Point center = new Point(getSize().width / 2, getSize().height / 2);
        int radiusClock = Math.min(center.x, center.y);
        int radiusMinute = radiusClock /2;
        double angle;
        g.drawOval(getSize().width / 2 - radiusClock/2, getSize().height / 2 - radiusClock/2,radiusClock, radiusClock);
        angle = Math.PI / 2 - clock.getMinutes() * Math.PI / 30;
        Point point = getEndPoint(angle, radiusMinute);
        g.setColor(Color.GRAY);
        g.drawLine(center.x, center.y, point.x, point.y);
    }

    public Clock getClock() {
        return clock;
    }

    public void setClock(Clock clock) {
        this.clock = clock;
    }

}
