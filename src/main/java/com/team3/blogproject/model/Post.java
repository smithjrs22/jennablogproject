package com.team3.blogproject.model;

import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    
    @Column(name="date")
    private Date date;

    @NotEmpty(message = "Please fill out the required field")
    @Column(name="title")
    private String title;

    @NotEmpty(message = "Please fill out the required field")
    @Column(name="content")
    private String content;

    public Post() {
        this.date = new Date();
    }

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }







    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + content + '\'' +
                ", date=" + date +
                '}';
    }
}
