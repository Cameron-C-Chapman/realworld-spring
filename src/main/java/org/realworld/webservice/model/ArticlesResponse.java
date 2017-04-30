package org.realworld.webservice.model;

import java.util.List;

public class ArticlesResponse {

    private List<Article> articles;
    private Integer articlesCount;

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }

    public Integer getArticlesCount() {
        return articlesCount;
    }

    public void setArticlesCount(Integer articlesCount) {
        this.articlesCount = articlesCount;
    }

}