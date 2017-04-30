package org.realworld.webservice.manager;

import org.realworld.webservice.data.ArticleDao;
import org.realworld.webservice.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@Transactional(readOnly = true, timeout = 5)
public class ArticleTransactionManager {

    @Autowired
    ArticleDao articleDao;

    public List<Article> getArticles() {
        return articleDao.getArticles();
    }
}
