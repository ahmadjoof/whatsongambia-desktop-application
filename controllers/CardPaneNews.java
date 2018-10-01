package controllers;

import Utils.NewsDataAccessor;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import models.NewsPagesSgc;

import javax.xml.transform.Result;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.List;
import java.util.ResourceBundle;

public class CardPaneNews extends ListCell<String> implements Initializable{

    @FXML
    private ImageView imageView;

    @FXML
    private ImageView dropDownList;

    @FXML
    public Label txtTitle;

    @FXML
    private Label txtDate;

    @FXML
    private Label txtCategory;

    @FXML
    private HBox listCardPane;

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if (empty){
            setText(null);
            setContentDisplay(ContentDisplay.TEXT_ONLY);
        }else {
            setGraphic(listCardPane);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
