package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.apache.http.util.TextUtils;

import javax.swing.plaf.PanelUI;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginAccount implements Initializable {

        @FXML
        private VBox vBoxLogin;

        @FXML
        private ImageView loginErrorId;

        @FXML
        private JFXPasswordField loginPasswordId;

        @FXML
        private JFXTextField loginFullNameId;

        @FXML
        private JFXTextField loginEmailId;

        @FXML
        private JFXButton loginButtonId;

        @FXML
        private ImageView loginFacebookId;

        @FXML
        private ImageView loginGoogleId;

        @FXML
        private ImageView fullnameErrorId;

        @FXML
        private ImageView emailErrorId;

        @FXML
        private ImageView passwordErrorId;

        @FXML
        private VBox loginProblemBackgroundId;

        @FXML
        private Text loginReasonProblemILabeld;

        HoverHighLight hoverHighLight = new HoverHighLight();

        @FXML
        void loginButtonOnAction(ActionEvent event) {
            validate();
        }

        @FXML
        void loginEmailOnAction(ActionEvent event) {

        }

        @FXML
        void loginFacebookMouseClic(MouseEvent event) {

        }

        @FXML
        void loginFullNameOnAction(ActionEvent event) {

        }

        @FXML
        void loginGoogleMouseClicked(MouseEvent event) {

        }

        @FXML
        void loginPasswordOnAction(ActionEvent event) {

        }


        @FXML
        void emailErrorMouseClicked(MouseEvent event) {

        }

        @FXML
        void emailMousePressed(MouseEvent event) {

        }

        @FXML
        void fullNameErrorMouseClicked(MouseEvent event) {

        }

        @FXML
        void fullNameMousePressed(MouseEvent event) {

        }

        @FXML
        void passwordErrorMouseClicked(MouseEvent event) {

        }

        @FXML
        void passwordMousePressed(MouseEvent event) {

        }

        private void setHoverHighLight() throws IOException {
            VBox vBox = FXMLLoader.load(getClass().getResource("../views/hover_highlight.fxml"));

        }


        private boolean validate(){
            boolean valid = true;

            String fullName = loginFullNameId.getText();
            if (TextUtils.isEmpty(fullName)){
                loginErrorId.setVisible(true);
                valid = false;
            }else if (fullName.length() <= 6) {
                emailErrorId.setVisible(true);
            }
            return valid;
        }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
