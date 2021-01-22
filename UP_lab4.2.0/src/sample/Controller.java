package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

public class Controller implements Initializable {
 private final String INPUT_FILENAME = "input.txt";

    @FXML
    private TextArea textArea;

    @FXML
    private ListView<String> listView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options = FXCollections.observableArrayList();
        listView.setItems(options);
        Reader reader = new Reader();
        DataParser dataParser = new DataParser();
        try {
            String text = reader.read(INPUT_FILENAME);
            textArea.setText(text);
            writeInList(dataParser.isData(text), options);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("File not found");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        textArea.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                listView.getItems().clear();
                writeInList(dataParser.isData(textArea.getText()), options);
            }
        });
    }

    private void writeInList(String string, ObservableList<String> options) {
        StringTokenizer stringTokenizer = new StringTokenizer(string, " ");
        while (stringTokenizer.hasMoreTokens()) {
            options.add(stringTokenizer.nextToken());
        }
    }
}
