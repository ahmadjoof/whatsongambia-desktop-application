package Utils;

import controllers.AccountViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class CloseMiniMax {


    double x, y;

    public void close(MouseEvent event){
        ((ImageView) event.getSource()).getScene().getWindow().hide();
    }

    public void mini(MouseEvent event){
        Stage stage = (Stage) ((ImageView) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    public void PressedButton(MouseEvent event){
        x = event.getSceneX();
        y = event.getSceneY();
    }

    public void MoveAround(MouseEvent event){
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

}
