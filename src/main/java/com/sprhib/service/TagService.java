package com.sprhib.service;

import java.util.List;

import com.sprhib.model.Tag;

public interface TagService {

    public void addTag(Tag tag);
    public void updateTag(Tag tag);
    public Tag getTag(int id);
    public Tag getTagBySlug(String slug);
    public void deleteTag(int id);
    public List<Tag> getTags();

}
