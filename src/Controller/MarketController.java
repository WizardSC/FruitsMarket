package Controller;

import DTO.FruitDTO;
import Model.Fruit;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import main.Main;
import main.MyListener;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MarketController implements Initializable {
    @FXML
    private VBox chosenFruitCard;

    @FXML
    private ImageView fruitImage;

    @FXML
    private Label fruitNameLabel;

    @FXML
    private Label fruitPriceLabel;

    @FXML
    private GridPane grid;

    @FXML
    private ScrollPane scroll;
    private ArrayList<FruitDTO> listFruits = new ArrayList<>();
    private Image image;
    private MyListener myListener;
    private ArrayList<FruitDTO> getData() {
        ArrayList<FruitDTO> listFruits = new ArrayList<>();
        FruitDTO fruit;

        fruit = new FruitDTO();
        fruit.setName("Kiwi");
        fruit.setPrice(2.99);
        fruit.setImgSrc("/img/kiwi.png");
        fruit.setColor("6A7324");
        listFruits.add(fruit);

        fruit = new FruitDTO();
        fruit.setName("Coconut");
        fruit.setPrice(3.99);
        fruit.setImgSrc("/img/coconut.png");
        fruit.setColor("A7745B");
        listFruits.add(fruit);



        fruit = new FruitDTO();
        fruit.setName("Peach");
        fruit.setPrice(1.50);
        fruit.setImgSrc("/img/peach.png");
        fruit.setColor("F16C31");

        fruit = new FruitDTO();
        fruit.setName("Grapes");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/img/grapes.png");
        fruit.setColor("291D36");
        listFruits.add(fruit);

        fruit = new FruitDTO();
        fruit.setName("Watermelon");
        fruit.setPrice(4.99);
        fruit.setImgSrc("/img/watermelon.png");
        fruit.setColor("22371D");
        listFruits.add(fruit);

        fruit = new FruitDTO();
        fruit.setName("Orange");
        fruit.setPrice(2.99);
        fruit.setImgSrc("/img/orange.png");
        fruit.setColor("FB5D03");
        listFruits.add(fruit);

        fruit = new FruitDTO();
        fruit.setName("Strawberry");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/img/strawberry.png");
        fruit.setColor("80080C");
        listFruits.add(fruit);

        fruit = new FruitDTO();
        fruit.setName("Mango");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/img/mango.png");
        fruit.setColor("FFB605");
        listFruits.add(fruit);

        fruit = new FruitDTO();
        fruit.setName("Cherry");
        fruit.setPrice(0.99);
        fruit.setImgSrc("/img/cherry.png");
        fruit.setColor("5F060E");
        listFruits.add(fruit);

        fruit = new FruitDTO();
        fruit.setName("Banana");
        fruit.setPrice(1.99);
        fruit.setImgSrc("/img/banana.png");
        fruit.setColor("E7C00F");
        listFruits.add(fruit);
        return listFruits;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listFruits.addAll(getData());
        if(listFruits.size() > 0 ){
            setChosenFruit(listFruits.get(0));
            myListener = new MyListener() {
                @Override
                public void onClickListener(FruitDTO fruit) {
                    setChosenFruit(fruit);
                }
            };
        }
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < listFruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/item.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(listFruits.get(i),myListener);
                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_COMPUTED_SIZE);
                //set grid weight
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_COMPUTED_SIZE);


                GridPane.setMargin(anchorPane, new Insets(15,5,5,15));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void setChosenFruit(FruitDTO fruit){
        fruitNameLabel.setText(fruit.getName());
        fruitPriceLabel.setText(Main.CURRENCY + fruit.getPrice());
        Image image = new Image(getClass().getResourceAsStream(fruit.getImgSrc()));
        fruitImage.setImage(image);
        chosenFruitCard.setStyle("-fx-background-color: #"+ fruit.getColor()+";\n" +
                "    -fx-background-radius: 30;");
    }
}
