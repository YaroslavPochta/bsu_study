import com.google.gson.*;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Vector;


public class Main extends JFrame {
    private Vector<DiagramObject> objects;
    private JPanel panel;
    private JList<DiagramObject> jList;

    public static void main(String[] args) {
        try {
            new Main();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", 1);
        }
    }

    Main() throws FileNotFoundException {
        super("lab3.3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(700, 600));
        objects = new Vector<>();
        parse();
        initPanel();
        pack();
        setVisible(true);
    }

    private void initList() {
        jList = new JList<>(objects);
        jList.setCellRenderer(new MyCellRenderer());
        JPanel panelForList = new JPanel(new BorderLayout());
        panelForList.setPreferredSize(new Dimension(150, 300));
        panelForList.add(jList, BorderLayout.CENTER);
        add(panelForList, BorderLayout.WEST);
    }

    private void initPanel() {
        panel = new JPanel(new BorderLayout());
        panel.add(new Diagram(objects), BorderLayout.CENTER);
        initList();
        add(panel, BorderLayout.CENTER);
    }

    public void parse() throws FileNotFoundException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file.json"));
        JsonParser jsonParser = new JsonParser();
        JsonArray array = jsonParser.parse(bufferedReader).getAsJsonArray();
        for (JsonElement jsonElement : array) {
            JsonObject jsonObject = jsonElement.getAsJsonObject();
            jsonObject = jsonObject.getAsJsonObject("object");
            double number;
            if ((number = Double.parseDouble(jsonObject.get("value").toString())) >= 0) {
                objects.add(new DiagramObject(jsonObject.get("name").getAsString(), number));
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect data " + jsonObject.get("name").getAsString() + " " + jsonObject.get("value").toString(), "Error", 1);
            }

        }
    }
}
