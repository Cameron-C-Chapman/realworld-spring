package org.realworld.webservice.data;

import org.realworld.webservice.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDao {

    @Value("${sql.getAllArticles}")
    private String getAllArticlesSql;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ArticleRowMapper articleRowMapper;

    public List<Article> getArticles() {
        return jdbcTemplate.query(getAllArticlesSql, articleRowMapper);
    }
}
