package Controller;

import DTO.FruitDTO;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

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
    private List<FruitDTO> listFruits = new ArrayList<>();

    private List<FruitDTO> getData() {
        List<FruitDTO> listFruits = new ArrayList<>();
        FruitDTO fruit;
        for (int i = 0; i < 20; i++) {
            fruit = new FruitDTO();
            fruit.setName("Kiwi");
            fruit.setPrice(2.99);
            fruit.setImgSrc("");
            fruit.  setColor("/img/kiwi.png");
            listFruits.add(fruit);
        }
        return listFruits;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listFruits.addAll(getData());
        int column = 0;
        int row = 0;
        try {
            for (int i = 0; i < listFruits.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/View/item.fxml"));

                AnchorPane anchorPane = fxmlLoader.load();
                ItemController itemController = fxmlLoader.getController();
                itemController.setData(listFruits.get(i));
                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
