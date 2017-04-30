package org.realworld.webservice.data;

import org.realworld.webservice.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ArticleRowMapper articleRowMapper;

    public List<Article> getArticles() {
        return jdbcTemplate.query("select * from articles", articleRowMapper);
    }
}
