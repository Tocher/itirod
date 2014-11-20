package com.sprhib.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.TagDAO;
import com.sprhib.model.Tag;

@Service
@Transactional
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDAO tagDAO;

    public void addTag(Tag tag) {
        tagDAO.addTag(tag);
    }

    public void updateTag(Tag tag) {
        tagDAO.updateTag(tag);
    }

    public Tag getTag(int id) {
        return tagDAO.getTag(id);
    }

    public Tag getTagBySlug(String slug) {
        return tagDAO.getTagBySlug(slug);
    }

    public void deleteTag(int id) {
        tagDAO.deleteTag(id);
    }

    public List<Tag> getTags() {
        return tagDAO.getTags();
    }

}
