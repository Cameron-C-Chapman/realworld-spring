package org.realworld.webservice.data;


import org.realworld.webservice.model.Article;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class ArticleRowMapper implements RowMapper<Article> {

    private static final String ID_COL = "id";
    private static final String TITLE_COL = "title";
    private static final String SLUG_COL = "slug";
    private static final String BODY_COL = "body";
    private static final String DESCRIPTION_COL = "description";
    private static final String FAVORITE_COUNT_COL = "favorite_count";
    private static final String AUTHOR_ID_COL = "author_id";
    private static final String CREATED_AT_COL = "created_at";
    private static final String UPDATED_AT_COL = "updated_at";

    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();
        article.setId(rs.getLong(ID_COL));
        article.setTitle(rs.getString(TITLE_COL));
        article.setSlug(rs.getString(SLUG_COL));
        article.setBody(rs.getString(BODY_COL));
        article.setDescription(rs.getString(DESCRIPTION_COL));
        article.setFavoritesCount(rs.getInt(FAVORITE_COUNT_COL));
        article.setAuthor(rs.getLong(AUTHOR_ID_COL));
        article.setCreatedAt(rs.getDate(CREATED_AT_COL));
        article.setUpdatedAt(rs.getDate(UPDATED_AT_COL));
        return article;
    }
}
