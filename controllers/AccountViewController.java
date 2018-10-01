package controllers;

import com.oracle.javafx.scenebuilder.kit.editor.panel.inspector.editors.FxIdEditor;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AccountViewController implements Initializable {

    @FXML
    private AnchorPane anchorAccountSetUp;

    @FXML
    public VBox vBoxMainAccount;


    @FXML
    void onClickedAccount(MouseEvent event) throws IOException {
        setLoginSignUpReporterAcc();
    }

    @FXML
    void onClickedForgetPassword(MouseEvent event) throws IOException {
        VBox vBox = FXMLLoader.load(getClass().getResource("../views/forgetPasswordAccount.fxml"));
        vBoxMainAccount.getChildren().setAll(vBox);
    }

    //SetLoginSignUpReporter
    public void setLoginSignUpReporterAcc() throws IOException {
        VBox vBox = FXMLLoader.load(getClass().getResource("../views/loginSignUpReporterViewAcc.fxml"));
        vBoxMainAccount.getChildren().setAll(vBox);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        //Setting LoginSignUpReporterAcc
        try {
            setLoginSignUpReporterAcc();
        } catch (IOException e) {
            System.out.println("Error showing the loginSigUp " + e);
            e.printStackTrace();
            try {
                throw e;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
