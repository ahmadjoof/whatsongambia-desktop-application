package controllers;

import Utils.CloseMiniMax;
import Utils.NewsDataAccessor;
import WhatsOnGambia.sample;
import com.gluonhq.charm.glisten.control.CardCell;
import com.gluonhq.charm.glisten.control.CardPane;
import com.gluonhq.charm.glisten.control.CharmListView;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.oracle.javafx.scenebuilder.kit.editor.panel.inspector.editors.FxIdEditor;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.*;
import javafx.util.Callback;
import models.NewsPagesDAO;
import models.NewsPagesSgc;

import javax.xml.ws.Holder;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.ResourceBundle;

public class MainView2 implements Initializable {

    public MenuButton menuBtnCategory;
    @FXML
    private ImageView mainImagePage;

    @FXML
    private CardPane<String> cardPane1;

    @FXML
    private AnchorPane mainScrollPaneAnchor;

    @FXML
    private Label cardpaneLabel;

    @FXML
    private ListView<NewsPagesSgc> listView1;


    @FXML
    private CharmListView<?, ?> charmListView;

    @FXML
    private HBox anchorRigthPane;

    @FXML
    private VBox mainNewsPage;

    @FXML
    private Label mainPageNewsLab1;

    @FXML
    private ImageView closeBtn;

    @FXML
    private JFXButton allBtn;

    @FXML
    private JFXButton readBtn;

    @FXML
    private JFXButton unreadBtn;

    @FXML
    private ImageView refreshBtn;

    @FXML
    private JFXTextField searchTxtField;

    @FXML
    private ImageView settingsBtn;

    @FXML
    private ImageView ratingBtn;

    @FXML
    private ImageView reportBtn;

    @FXML
    private ImageView commentBtn;

    @FXML
    private ImageView profileBtn;

    @FXML
    private ImageView adminBtn;

    @FXML
    private ImageView wogLogoImage;

    @FXML
    private Label wogLabelLogo;

    @FXML
    private JFXButton articlesBtn;

    @FXML
    private JFXButton categoryBtn;

    @FXML
    private JFXButton NasTeschIncCoolstfBtn;

    @FXML
    private JFXButton joinOurTeamBtn;

    @FXML
    private JFXButton videosId;

    @FXML
    private VBox vBoxCharmList;

    @FXML
    private VBox anchoreCenter;

    @FXML
    private MenuButton nasTechIncMenuId;

    @FXML
    private MenuItem desktopMenuId;

    @FXML
    private MenuItem androidAppMenuId;

    @FXML
    private MenuItem iosMenuId;

    @FXML
    private MenuItem webAppMenuId;

    @FXML
    private MenuItem gameAppId;

    @FXML
    private MenuItem cyberSecurityId;

    @FXML
    private VBox theMainListviewerId;

    boolean hello = true;

    CloseMiniMax closeMiniMax = new CloseMiniMax();

    private VBox vBox;
    private HBox hBox;

    //Min, Max, Close, Dragged
    @FXML
    void onCloseBtn(MouseEvent event) {
        closeMiniMax.close(event);
    }

    @FXML
    void onMini(MouseEvent event) {
        closeMiniMax.mini(event);
    }

    @FXML
    void pressed(MouseEvent event) {
        closeMiniMax.PressedButton(event);
    }

    @FXML
    void move(MouseEvent event) {
        closeMiniMax.MoveAround(event);
    }


    //**********************************

    @FXML
    void adminBtnAction(MouseEvent event) {

    }

    @FXML
    void allBtnAction(ActionEvent event) throws Exception {
        if (hello){
            allBtn.setStyle("-fx-background-color: #006A4E");
            readBtn.setStyle(null);
            unreadBtn.setStyle(null);

        }else {
            return;
        }

        String hello = "select DATE from newspages where MAIN_ID = 6";
        ResultSet resultSet = NewsDataAccessor.dbExecuteQuery(hello);
        while (resultSet.next()){
            wogLabelLogo.setText(resultSet.getString("DATE"));
        }


        VBox vBox = FXMLLoader.load(getClass().getResource("../views/AllNewsViews.fxml"));
        theMainListviewerId.getChildren().setAll(vBox);

    }

    @FXML
    void articlesBtnAction(ActionEvent event) {

    }

    @FXML
    void commentBtnAction(MouseEvent event) throws IOException {
        HBox pane = FXMLLoader.load(getClass().getResource("../views/commentView.fxml"));
        anchorRigthPane.getChildren().setAll(pane);
    }

    @FXML
    void joinOurTeamBtn(ActionEvent event) throws IOException {

        AnchorPane pane = FXMLLoader.load(getClass().getResource("../views/accountView.fxml"));
        anchorRigthPane.getChildren().setAll(pane);

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/accountView.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
        */
    }

    @FXML
    void profileBtnAction(MouseEvent event) {

    }

    @FXML
    void ratingBtnAction(MouseEvent event) {

    }

    @FXML
    void readBtnAction(ActionEvent event) throws Exception {

        //CARDPANE LIST
        //Put if(cardpane.isPressed){}
        try {

            ObservableList<NewsPagesSgc> pagesSgcs = NewsPagesDAO.allNewsPagesMain();
            System.out.println("Hello read data: " + pagesSgcs);
        }catch (Exception e){
            System.out.println("Failed to update read news pages" + e);
            e.printStackTrace();
            throw e;
        }

        //CHANGE ON BUTTON CLICK METHOD
        if (hello) {
            readBtn.setStyle("-fx-background-color: #006A4E");
            allBtn.setStyle(null);
            unreadBtn.setStyle(null);
        }else {
            return;
        }

        //CHANGE THE ANCHOR TO READNEWS
            AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("../views/readNewsPagesView.fxml"));
            mainScrollPaneAnchor.getChildren().setAll(anchorPane);

    }

    @FXML
    void refreshBtnAction(MouseEvent event) {

    }

    @FXML
    void reportBtnAction(MouseEvent event) {

    }

    @FXML
    void searchTxtFieldAction(ActionEvent event) {

    }

    @FXML
    void settingsBtnAction(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("../views/settingsViews.fxml"));
        Parent root = (Parent)fxmlLoader.load();
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initStyle(StageStyle.UNDECORATED);
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    void unreadBtnAction(ActionEvent event) throws Exception {
        //Put if(!cardpane.isPressed){}
        try {
            ObservableList<NewsPagesSgc> pagesSgcs = NewsPagesDAO.allNewsPagesMain();
            System.out.println("Hello Unread Data: " + pagesSgcs);
        } catch (Exception e) {
            System.out.println("Failed to load unread news data " + e);
            e.printStackTrace();
            throw e;
        }

        if (hello){
            unreadBtn.setStyle("-fx-background-color: #006A4E");
            allBtn.setStyle(null);
            readBtn.setStyle(null);
        }else {
            return;
        }


    }

    @FXML
    void videosOnAction(ActionEvent event) throws IOException {
        setVideosCategory();
    }


    @FXML
    void webAppOnAction(ActionEvent event) {

    }

    @FXML
    void nasTechIncOnAction(ActionEvent event) {

    }

    @FXML
    void cyberSecurtyOnAction(ActionEvent event) {

    }

    @FXML
    void desktopAppOnAction(ActionEvent event) throws IOException {
        setNasTechLablApplications();
    }

    @FXML
    void gameAppOnAction(ActionEvent event) {

    }

    @FXML
    void iosAppOnAction(ActionEvent event) {

    }

    @FXML
    void androidAppOnAction(ActionEvent event) {

    }

    //FUNCTIONS*******************************METHODS

    @FXML
    private void populateEmployee (NewsPagesSgc emp) throws ClassNotFoundException {
        //Declare and ObservableList for table view
        ObservableList<NewsPagesSgc> empData = FXCollections.observableArrayList();
        //Add employee to the ObservableList
        empData.add(emp);
    }

    private void setNasTechLablApplications() throws IOException {

            vBox = FXMLLoader.load(getClass().getResource("../views/labelNasTechIncApplication.fxml"));
            anchoreCenter.getChildren().setAll(vBox);

            hBox = FXMLLoader.load(getClass().getResource("../views/nastechIncCoolStuff.fxml"));
            anchorRigthPane.getChildren().setAll(hBox);
    }

    private void setVideosCategory() throws IOException {
         ScrollPane scrollPane = FXMLLoader.load(getClass().getResource("../views/videoNewsCategory.fxml"));
        anchoreCenter.getChildren().setAll(scrollPane);


    }

    //Initialize
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Image Styling
    }

}
