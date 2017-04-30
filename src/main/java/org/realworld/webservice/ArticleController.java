package org.realworld.webservice;

import org.realworld.webservice.manager.ArticleTransactionManager;
import org.realworld.webservice.model.Article;
import org.realworld.webservice.model.ArticlesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    ArticleTransactionManager articleTransactionManager;

    @RequestMapping("/articles")
    public ResponseEntity<ArticlesResponse> getArticles() {
        ArticlesResponse response = new ArticlesResponse();
        List<Article> articles = articleTransactionManager.getArticles();
        response.setArticles(articles);
        response.setArticlesCount(articles.size());
        return new ResponseEntity<ArticlesResponse>(response, HttpStatus.OK);
    }

}
