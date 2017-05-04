package org.realworld.webservice.model;

import java.util.Date;

public class Article {

    private String title;
    private String slug;
    private String body;
    private Date createdAt;
    private Date updatedAt;
    private String description;
    private Tags tagList;
    private ArticleAuthor author;
    private boolean favorited;
    private Integer favoritesCount;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Tags getTagList() {
        return tagList;
    }

    public void setTagList(Tags tagList) {
        this.tagList = tagList;
    }

    public ArticleAuthor getAuthor() {
        return author;
    }

    public void setAuthor(ArticleAuthor author) {
        this.author = author;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public Integer getFavoritesCount() {
        return favoritesCount;
    }

    public void setFavoritesCount(Integer favoritesCount) {
        this.favoritesCount = favoritesCount;
    }

}