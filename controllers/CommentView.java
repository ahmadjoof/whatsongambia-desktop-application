package controllers;

import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import models.NewsPagesDAO;

import javax.swing.text.html.ImageView;
import java.net.URL;
import java.util.ResourceBundle;

public class CommentView implements Initializable {

    @FXML
    private JFXTextArea commentTxtArea;

    @FXML
    private Label userTyping;

    @FXML
    private Label typing;

    NewsPagesDAO pagesDAO = new NewsPagesDAO();


    @FXML
    void sendMouseClicked(MouseEvent event) throws Exception {

        /*
        if (commentTxtArea != null){
            try {
                pagesDAO.insertComment(commentTxtArea.getText(), );
                commentTxtArea.setText(null);
            }catch (Exception e){
                System.out.println("Error updating comment" + e);
                e.printStackTrace();
                throw e;
            }
        }*/
    }

    @FXML
    void commentKeyPressed(KeyEvent event) throws Exception {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
