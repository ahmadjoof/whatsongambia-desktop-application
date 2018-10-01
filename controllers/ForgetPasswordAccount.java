package controllers;

import Utils.CloseMiniMax;
import com.oracle.javafx.scenebuilder.kit.editor.panel.inspector.editors.FxIdEditor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForgetPasswordAccount extends AccountViewController implements Initializable {


    @FXML
    private VBox vBoxLogin;

    @FXML
    private ImageView closeForgetPwrd;

    @FXML
    void onClickedClosed(MouseEvent event) throws IOException {
        setLoginSignUpReporterAcc();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
