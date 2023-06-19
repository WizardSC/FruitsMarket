package Controller;

import DTO.FruitDTO;
import Model.Fruit;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import main.Main;

import java.util.ArrayList;

public class ItemController {

    @FXML
    private ImageView img;

    @FXML
    private Label nameLabel;

    @FXML
    private Label priceLabel;

    private FruitDTO fruit;

    public void setData(FruitDTO fruit) {
        this.fruit = fruit;
        nameLabel.setText(fruit.getName());
//        nameLabel.setText(fruit.getName());
//        priceLabel.setText(Main.CURRENCY + fruit.getPrice());
//        Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
//        img.setImage(image);
    }
}
