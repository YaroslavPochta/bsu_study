package adding;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sample.Controller;
import sample.Country;

public class AddingAndChanging {
    @FXML
    private Button addingButton;

    @FXML
    private TextField descriptionText;

    @FXML
    private TextField priceField;

    @FXML
    private TextField imageText;

    private Controller controller = new Controller();

    public TextField getDescriptionText() {
        return descriptionText;
    }

    public TextField getPriceField() {
        return priceField;
    }

    public TextField getImageText() {
        return imageText;
    }

    public void setImageText(TextField imageText) {
        this.imageText = imageText;
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }

    public void add(ActionEvent event){
        /*country.setImage(new ImageView(new Image(
                "file:///D:/инфа/UP_4Sem/UP_2.2/src/flagsPictures/flag_albania.png")));
        country.setDescription(descriptionText.getText());
        country.setPrice(Double.parseDouble(priceField.getText()));*/
        actionClose(event);
    }

}
