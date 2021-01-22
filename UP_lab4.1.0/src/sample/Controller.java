package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import sample.parsers.DateParser;
import sample.parsers.EmailParser;
import sample.parsers.NumberParser;
import sample.parsers.TimeParser;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField textField;

    @FXML
    private ComboBox<String> comboBox;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ObservableList<String> options =
                FXCollections.observableArrayList("N", "Integer", "Double", "Data", "Time", "E-mail");
        comboBox.setItems(options);
        comboBox.setValue("N");
        textField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (check(textField.getText())) {
                    textField.setStyle("-fx-border-color: green;");
                } else {
                    textField.setStyle("-fx-border-color: red;");
                }
            }
        });
    }

    private boolean check(String string) {
        int index = comboBox.getSelectionModel().getSelectedIndex();
        boolean check;
        switch (index) {
            case 0:
                NumberParser numberParser = new NumberParser();
                check = numberParser.isNaturalNumber(string);
                break;
            case 1:
                NumberParser naturalParse = new NumberParser();
                check = naturalParse.isIntegerNumber(string);
                break;
            case 2:
                NumberParser doubleParser = new NumberParser();
                check = doubleParser.isDoubleNumber(string);
                break;
            case 3:
                DateParser dataParser = new DateParser();
                check = dataParser.isData(string);
                break;
            case 4:
                TimeParser timeParser = new TimeParser();
                check = timeParser.isTime(string);
                break;
            case 5:
                EmailParser emailParser = new EmailParser();
                check = emailParser.isEmail(string);
                break;
            default:
                check = false;
        }
        return check;
    }
}




