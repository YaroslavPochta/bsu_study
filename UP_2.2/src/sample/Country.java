package sample;


import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;

public class Country {
    private ImageView image;
    private SimpleStringProperty description  = new SimpleStringProperty();
    private SimpleDoubleProperty price  = new SimpleDoubleProperty();
    private CheckBox checkBox;

    public Country() {
        this.checkBox = new CheckBox();
    }

    public Country(ImageView image, String description,
                   Double price) {
        this.image = image;
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleDoubleProperty(price);
        this.checkBox = new CheckBox();
    }

    public Country(String description, Double price) {
        this.image = null;
        this.description = new SimpleStringProperty(description);
        this.price = new SimpleDoubleProperty(price);
        this.checkBox = new CheckBox();
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getDescription() {
        return description.getValue();
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public Double getPrice() {
        return price.getValue();
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public CheckBox getCheckBox() {
        return checkBox;
    }

    public void setCheckBox(CheckBox checkBox) {
        this.checkBox = checkBox;
    }

    public SimpleDoubleProperty getPriceProperty() {
        return price;
    }

    public SimpleStringProperty getDescriptionProperty(){
        return description;
    }
}
