package com.sda.springjavapoz4.model;


import org.apache.commons.lang3.StringUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private String smallImgPath;
    private String bigImgPath;
    @ManyToOne
    private User author;

    public News() {
    }

    public News(String title, String description, LocalDate date, User author) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.author = author;
    }

    public News(String title, String description, LocalDate date, String smallImgPath, String bigImgPath, User author) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.smallImgPath = smallImgPath;
        this.bigImgPath = bigImgPath;
        this.author = author;
    }

    public String getAbbreviateDescription() {
        return StringUtils.abbreviate(description, 30);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getSmallImgPath() {
        return smallImgPath;
    }

    public void setSmallImgPath(String smallImgPath) {
        this.smallImgPath = smallImgPath;
    }

    public String getBigImgPath() {
        return bigImgPath;
    }

    public void setBigImgPath(String bigImgPath) {
        this.bigImgPath = bigImgPath;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", smallImgPath='" + smallImgPath + '\'' +
                ", bigImgPath='" + bigImgPath + '\'' +
                ", author=" + author +
                '}';
    }
}
