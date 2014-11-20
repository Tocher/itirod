package com.sprhib.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "posts", catalog = "spring_social_db")
public class Post {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Integer id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "contentFull", nullable = true)
    private String contentFull;

    @Column(name = "date", nullable = false)
    private Date date;

    @OneToMany(mappedBy = "post")
    private List<Comment> comments;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Tag> tags = new ArrayList<Tag>();

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
    public String getContentFull() {
        return contentFull;
    }
    public void setContentFull(String contentFull) {
        this.contentFull = contentFull;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public List<Tag> getTags() {
        return tags;
    }
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    public List<Comment> getComments() {
        return comments;
    }
    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

}

