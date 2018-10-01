package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginSignUpReporterViewAcc implements Initializable {

    @FXML
    private VBox vBoxLogin;

    @FXML
    void onClickBeAReporter(MouseEvent event) throws IOException {

        VBox vBox = FXMLLoader.load(getClass().getResource("../views/reporterAccount.fxml"));
        vBoxLogin.getChildren().setAll(vBox);
    }

    @FXML
    void onClickSignUp(MouseEvent event) throws IOException {
        VBox vBox = FXMLLoader.load(getClass().getResource("../views/signUpAccount.fxml"));
        vBoxLogin.getChildren().setAll(vBox);
    }

    @FXML
    void onClickedLogin(MouseEvent event) throws IOException {
        setLoginVbox();
    }

    //SetLoginVbox
    private void setLoginVbox() throws IOException {
        VBox vBox = FXMLLoader.load(getClass().getResource("../views/loginAccount.fxml"));
        vBoxLogin.getChildren().setAll(vBox);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            setLoginVbox();
        } catch (IOException e) {
            System.out.println("Error showing the login Vbox " + e);
            e.printStackTrace();
            try {
                throw e;
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
