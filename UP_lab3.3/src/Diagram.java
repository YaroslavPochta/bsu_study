import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.List;

import javax.swing.*;

class Diagram extends JComponent {
    private List<DiagramObject> diagramObjects;

    public Diagram(List<DiagramObject> diagramObjects ) {
        this.diagramObjects = diagramObjects;
    }

    public void paint(Graphics g) {
        drawPie((Graphics2D) g, getBounds(), diagramObjects);
    }

    void drawPie(Graphics2D g, Rectangle area, List<DiagramObject> diagramObjects ) {
        double total = 0.0D;
        for (int i = 0; i < diagramObjects.size(); i++) {
            total += diagramObjects.get(i).getValue();
        }
        double curValue = 0.0D;
        double startAngle;
        for (int i = 0; i < diagramObjects.size(); i++) {
            startAngle =  Math.floor ((curValue * 360 / total));
            double arcAngle =  ( diagramObjects.get(i).getValue() * 360 / total);
            Color color = new Color((100 + i * 15)%256, (10 + i * 50)%256,(10 +  i * 50)%256);
            BufferedImage bufferedImage = new BufferedImage(10, 10,BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics = bufferedImage.createGraphics();
            graphics.setColor(color);
            graphics.fillRect(0, 0,10,10);
            diagramObjects.get(i).setImageIcon(new ImageIcon(bufferedImage));
            g.setColor(color);
            g.fillArc( area.x , area.y , area.width , area.height ,(int) startAngle , (int)(arcAngle *1.1));
            curValue += diagramObjects.get(i).getValue();
        }
    }
}