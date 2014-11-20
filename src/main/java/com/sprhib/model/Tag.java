package com.sprhib.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="tags", catalog = "spring_social_db")
public class Tag {

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, unique = true, length = 11)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "urlSlug", nullable = false)
    private String urlSlug;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "tags")
    private List<Post> posts = new ArrayList<Post>();

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
    public String getUrlSlug() {
        return urlSlug;
    }
    public void setUrlSlug(String urlSlug) {
        this.urlSlug = urlSlug;
    }
    public List<Post> getPosts() {
        return posts;
    }
    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

}

