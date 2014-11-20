package com.sprhib.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="comments", catalog = "spring_social_db")
public class Comment {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    private Post post;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public Post getPost() {
        return post;
    }
    public void setPost(Post post) {
        this.post = post;
    }
}
