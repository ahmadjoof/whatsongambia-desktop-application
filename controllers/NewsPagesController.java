package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import models.NewsPagesDAO;
import java.sql.SQLException;

public class NewsPagesController {
    @FXML
    private JFXButton btnSubmit;
    @FXML
    private JFXTextField txtImageDescription;
    @FXML
    private JFXTextField txtTitle;
    @FXML
    private JFXTextField txtDescription;
    @FXML
    private Label txtLabel;
    @FXML
    private TextArea txtTextArea;


//Search all newspages

    @FXML
    private void submitInformation(ActionEvent actionEvent) throws Exception {

    }
}


