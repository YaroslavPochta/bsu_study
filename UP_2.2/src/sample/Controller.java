package sample;

import adding.AddingAndChanging;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import reader.Reader;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Controller implements Initializable {

    private static final Reader reader = new Reader();

    @FXML
    private TableView<Country> tableView;

    @FXML
    private TableColumn<Country, String> imageColumn;

    @FXML
    private TableColumn<Country, String> descriptionColumn;

    @FXML
    private TableColumn<Country, String> priceColumn;

    @FXML
    private TableColumn<Country, String> checkBoxColumn;

    @FXML
    private Label priceLabel;

    private Parent loader;
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private AddingAndChanging addingAndChanging;
    private Stage newStage;
    private double price = 0.0;

    public ObservableList<Country> getCountries() {
        return countries;
    }

    public void setCountries(ObservableList<Country> countries) {
        this.countries = countries;
    }

    private ObservableList<Country> countries =
            FXCollections.observableArrayList();

    private ObservableList<Price> prices = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        priceLabel.setText(String.valueOf(0));
        fxmlLoader.setLocation(getClass().getResource("/adding/adding.fxml"));
        try {
            loader = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addingAndChanging = fxmlLoader.getController();
        newStage = new Stage();
        newStage.setTitle("Таблицы");
        newStage.setScene(new Scene(loader, 500, 300));
    }

    public void calculate(ActionEvent event){
        price = 0.0;
        for(var country : countries) {
            if(country.getCheckBox().isSelected()){
                price += country.getPrice();
            }
        }

        priceLabel.setText(String.valueOf(price));
    }

    public void delete(ActionEvent event) {
        Country country = tableView.getSelectionModel().getSelectedItem();
        countries.remove(country);
    }

    public void change(ActionEvent event) {
        try {
            connectToAdditionalWindow();
            Country country = tableView.getSelectionModel().getSelectedItem();
            if (!addingAndChanging.getPriceField().getText().isEmpty()) {
                country.setPrice(Double.parseDouble(
                        addingAndChanging.getPriceField().getText()));
            }
            if (!addingAndChanging.getDescriptionText().getText().isEmpty()) {
                country.setDescription(
                        addingAndChanging.getDescriptionText().getText());
            }
            tableView.getItems().set(
                    tableView.getSelectionModel().getFocusedIndex(), country);
        } catch(RuntimeException ex) {
            ExceptionAlert.useAlert("You wrote incorrect data.");
        }
    }

    public void addInformation(ActionEvent event){
        connectToAdditionalWindow();
        Country country = new Country();
        try {
            country.setDescription(addingAndChanging.getDescriptionText().getText());
            country.setPrice(Double.parseDouble(
                    addingAndChanging.getPriceField().getText()));
            country.setCheckBox(new CheckBox());
            tableView.getItems().add(country);
        } catch(NumberFormatException ex) {
            ExceptionAlert.useAlert("You wrote incorrect data.");
        }
    }

    public void connectToAdditionalWindow(){
        newStage.setResizable(false);
        newStage.showAndWait();
    }

    public void addTable(javafx.event.ActionEvent actionEvent) {
        try {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setInitialDirectory(
                    new File("D:\\инфа\\UP_4Sem"));

            FileChooser.ExtensionFilter fileExtensions =
                    new FileChooser.ExtensionFilter(
                            "Extension filters: ",
                            "*.xls", "*.xlsx", "*.xlsm", "*.xlsb");

            fileChooser.getExtensionFilters().add(fileExtensions);

            File file = fileChooser.showOpenDialog(null);

            reader.read(file, countries);

            this.imageColumn.setCellValueFactory(
                    new PropertyValueFactory<>("image"));
            this.descriptionColumn.setCellValueFactory(
                    new PropertyValueFactory<>("description"));
            this.priceColumn.setCellValueFactory(
                    new PropertyValueFactory<>("price"));
            this.checkBoxColumn.setCellValueFactory(
                    new PropertyValueFactory<>("checkBox")
            );

            if(countries != null) {
                tableView.setItems(countries);
            }

        } catch (IllegalArgumentException ex){

        }
    }
}
