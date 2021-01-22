import javax.swing.*;

public class DiagramObject {
    private final String name;
    private final double value;
    private ImageIcon imageIcon;

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }

    public DiagramObject( String name, double value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public String toString() {
        return name + " " + value;
    }

    public double getValue() {
        return value;
    }
}
