package models;

import javafx.beans.property.*;
import javafx.scene.image.Image;

import java.sql.Blob;
import java.util.Date;

public class NewsPagesSgc {
    //Declare newsPages
    private int  main_id;
    private String image_description;
    private String title;
    private String description;
    private Blob image;
    private Date date;
    private String category;
    private String subdescription;
    private String reporter;
    private String news_details;

    public NewsPagesSgc(){

    }

    public NewsPagesSgc(int main_id, String image_description, String title, String description, Blob image, Date date, String category, String subdescription, String reporter, String news_details) {
        this.main_id = main_id;
        this.image_description = image_description;
        this.title = title;
        this.description = description;
        this.image = image;
        this.date = date;
        this.category = category;
        this.subdescription = subdescription;
        this.reporter = reporter;
        this.news_details = news_details;
    }

    public int getMain_id() {
        return main_id;
    }

    public void setMain_id(int main_id) {
        this.main_id = main_id;
    }

    public String getImage_description() {
        return image_description;
    }

    public void setImage_description(String image_description) {
        this.image_description = image_description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubdescription() {
        return subdescription;
    }

    public void setSubdescription(String subdescription) {
        this.subdescription = subdescription;
    }

    public String getReporter() {
        return reporter;
    }

    public void setReporter(String reporter) {
        this.reporter = reporter;
    }

    public String getNews_details() {
        return news_details;
    }

    public void setNews_details(String news_details) {
        this.news_details = news_details;
    }
}









