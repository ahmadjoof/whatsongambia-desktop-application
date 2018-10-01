package models;

import Utils.NewsDataAccessor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.sql.Blob;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsPagesDAO{

    String userId = String.valueOf(Math.random());
    String newsPagesId = String.valueOf(Math.random());

    //*****************
    //SELECT Whatsongambia
    //**********************

    public static ObservableList<NewsPagesSgc> allNewsPagesMain() throws Exception {
        //Declare SELECT statement
        String selectStmt = "SELECT * FROM newspages";
        try {
            //Get Result from dbExecuteQuery method
            ResultSet resultSet = NewsDataAccessor.dbExecuteQuery(selectStmt);

            //Send result to the getwhatsongambia method and get whatsongambia object
            ObservableList<NewsPagesSgc> pagesList = getNewsPagesList(resultSet);

            //Return whatsongambia object
            return pagesList;
        } catch (Exception e) {
            System.out.println("SQL select operation hase been failed: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    //Select * from employees operation
    private static ObservableList<NewsPagesSgc> getNewsPagesList(ResultSet resultSet) throws SQLException {
        //Declare a observable List which comprises of Employee objects
        ObservableList<NewsPagesSgc> pagesSgcObservableList = FXCollections.observableArrayList();

        while (resultSet.next()){
            NewsPagesSgc pagesSgc = new NewsPagesSgc();
            pagesSgc.setMain_id(resultSet.getInt("MAIN_ID"));
            pagesSgc.setImage_description(resultSet.getString("IMAGE_DESCRIPTION"));
            pagesSgc.setDescription(resultSet.getString("DESCRIPTION"));
            pagesSgc.setTitle(resultSet.getString("TITLE"));
            pagesSgc.setCategory(resultSet.getString("CATEGORY"));
            pagesSgc.setReporter(resultSet.getString("REPORTER"));
            pagesSgc.setSubdescription(resultSet.getString("SUBDESCRIPTION"));
            pagesSgc.setDate(resultSet.getDate("DATE"));
            pagesSgc.setNews_details(resultSet.getString("NEWS_DETAILS"));

            pagesSgcObservableList.add(pagesSgc);
        }
        return pagesSgcObservableList;
    }

    //************************************
    //DELETE an employee
    //************************************
    public static void deleteNewsPagesWithId(String NPId) throws Exception {
        //Declare a DELETE statement
        String updateStmt = "DELETE FROM newspages WHERE ID = " + NPId;

        //Execute UPDATE operation
        try {
            NewsDataAccessor.dbExecuteUpdate(updateStmt);
        } catch (Exception e) {
            System.out.println("Error occurred while Delete Operation: " + e);
            e.printStackTrace();
            throw e;
        }
    }

    //INSERT COMMENTS
    public String insertComment(String comment, String image) throws Exception {

        image = "SELECT PROFILE_IMAGE FROM profilesetup WHERE ID =" + userId;

        String updateComment = "INSERT INTO comments(ID, COMMENT) VALUES('" + userId +"', '" + comment +"', SYSDATE, '" + image +"');";
        try {
            NewsDataAccessor.dbExecuteUpdate(updateComment);
        }catch (Exception e){
            System.out.println("Error updating the comments " + e);
            e.printStackTrace();
            throw e;
        }
        return updateComment;
    }

    //INSERT NEWSPAGES
    public String insertNewsPages(String title, String image_description, String description,
                                  String subdescription, String news_details,
                                  String reporter_name, String category, Blob image ) throws Exception{
        String updateNewspages = "INSERT INTO newspages(MAIN_ID, IMAGE, TITLE, DESCRIPTION, DATE, CATEGORY, REPORTER, SUBDESCRIPTION, " +
                "IMAGE_DESCRIPTION, NEWS_DETAILS) VALUES('"+ newsPagesId +"', '" + image + "', " +
                "'" + title + "', '" + description +"', SYSDATE, '" + category +"', '" + reporter_name +"', '" + subdescription +"', '" + image_description +"', '" + news_details +"');";
        try {
            NewsDataAccessor.dbExecuteUpdate(updateNewspages);
        } catch (Exception e) {
            System.out.println("Error uploading newspages " + e);
            e.printStackTrace();
            throw e;
        }
        return updateNewspages;
    }

    //INSERT VIDEO AND MUSIC NEWS
    public String insertVideoNews(String artist_name, Blob video, Blob video_image, String image_description,
                                  String description, String title, String subdescription, String news_details, String reporter, String category) throws Exception {

        String updateVideoNewsPages = "INSERT INTO videonewspagesandmusic (ID, ARTIST_NAME, VIDEO, VIDEO_IMAGE, IMAGE_DESCRIPTION, DESCRIPTION, TITLE, " +
                "SUBDESCRIPTION, NEWS_DETAILS, DATE_PUBLISH, REPORTER, CATEGORY) VALUE ('" + newsPagesId +"', '" + artist_name +"', '" + video +"', '" + video_image +"'," +
                " '" + image_description +"', '" + description +"', '" + title +"', '" + subdescription +"', '" + news_details +"', SYSDATE, '" + reporter +"', '" + category +"');";
        try {
            NewsDataAccessor.dbExecuteUpdate(updateVideoNewsPages);
        } catch (Exception e) {
            System.out.println("Error uploading video or music" + e);
            e.printStackTrace();
            throw e;
        }
        return updateVideoNewsPages;
    }

    public String insertReport(String fullName, String report_title, String email) throws Exception {
        fullName = "SELECT FULL_NAME FROM signupaccount WHERE ID =" + userId;
        email = "SELECT EMAIL FROM signupaccount WHERE ID =" + userId;

        String updateReport = "INSERT INTO report(ID, FULL_NAME, REPORT_TITLE, EMAIL) VALUE ('" + userId +"', '" + fullName +"', '" + report_title +"', '" + email +"');";
        try {
            NewsDataAccessor.dbExecuteUpdate(updateReport);
        } catch (Exception e) {
            System.out.println("Error uploading report " + e);
            e.printStackTrace();
            throw e;
        }

        return updateReport;
    }

    public static String sample(String ID) throws Exception {

        String updatenews = "select TITLE from newspages where MAIN_ID = " + ID;

        try {
            NewsDataAccessor.dbExecuteQuery(updatenews);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return updatenews;
    }


}
