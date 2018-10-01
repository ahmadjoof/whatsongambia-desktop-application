package controllers;

import Utils.CloseMiniMax;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsViews implements Initializable {
    CloseMiniMax closeMiniMax = new CloseMiniMax();

    @FXML
    void move(MouseEvent event) {
        closeMiniMax.MoveAround(event);
    }

    @FXML
    void onCloseBtn(MouseEvent event) {
        closeMiniMax.close(event);
    }

    @FXML
    void pressed(MouseEvent event) {
        closeMiniMax.PressedButton(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
