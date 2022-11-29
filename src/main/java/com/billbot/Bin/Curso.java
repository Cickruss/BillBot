package com.billbot.Bin;

public class Curso {

    private String title;
    private String img;
    private String courseName;
    private String descript;
    private String author;

    public Curso(String img, String courseName, String descript, String author) {
        this.img = img;
        this.courseName = courseName;
        this.descript = descript;
        this.author = author;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getDescript() {
        return descript;
    }

    public void setDescript(String descript) {
        this.descript = descript;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
