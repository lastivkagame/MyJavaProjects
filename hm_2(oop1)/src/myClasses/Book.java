package myClasses;

import java.util.Date;

public class Book {
    public String name;
    public String author;
    public int datePublish;
    public String namePublisher;
    public String gendre;
    public int pages;

    //Constructers
    public Book(String name, String author, int datePublish, String namePublisher, String gendre, int pages) {
        this.name = name;
        this.author = author;
        this.datePublish = datePublish;
        this.namePublisher = namePublisher;
        this.gendre = gendre;
        this.pages = pages;
    }

    public Book() {
    }

    //Getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public int getDatePublish() {
        return datePublish;
    }

    public String getNamePublisher() {
        return namePublisher;
    }

    public String getGendre() {
        return gendre;
    }

    public int getPages() {
        return pages;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDatePublish(int datePublish) {
        this.datePublish = datePublish;
    }

    public void setNamePublisher(String namePublisher) {
        this.namePublisher = namePublisher;
    }

    public void setGendre(String gendre) {
        this.gendre = gendre;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    //Override Methods
    @Override
    public String toString() {
        return "Book: \n" +
                "name='" + name + '\'' +
                ",\n author='" + author + '\'' +
                ",\n datePublish=" + datePublish +
                ",\n namePublisher='" + namePublisher + '\'' +
                ",\n gendre='" + gendre + '\'' +
                ",\n pages=" + pages;
    }
}
