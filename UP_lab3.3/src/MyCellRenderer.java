import javax.swing.*;
import java.awt.*;

class MyCellRenderer extends JLabel implements ListCellRenderer {
    public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ) {
        if(value instanceof DiagramObject) {
            DiagramObject country = (DiagramObject) value;
            setText(country.toString() + "  ");
            setIcon(country.getImageIcon());
            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }
            setEnabled(list.isEnabled());
            setFont(list.getFont());
            setOpaque(true);
        }
        return this;
    }
}