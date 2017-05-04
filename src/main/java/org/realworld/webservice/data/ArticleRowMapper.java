package org.realworld.webservice.data;


import org.realworld.webservice.model.Article;
import org.realworld.webservice.model.ArticleAuthor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;


@Component
public class ArticleRowMapper implements RowMapper<Article> {

    private static final String TITLE_COL = "title";
    private static final String SLUG_COL = "slug";
    private static final String BODY_COL = "body";
    private static final String DESCRIPTION_COL = "description";
    private static final String FAVORITE_COUNT_COL = "favorite_count";
    private static final String CREATED_AT_COL = "created_at";
    private static final String UPDATED_AT_COL = "updated_at";
    private static final String AUTHOR_USERNAME_COL = "username";
    private static final String AUTHOR_BIO_COL = "bio";
    private static final String AUTHOR_IMAGE_COL = "image";
    private static final String AUTHOR_FOLLOWING_COL = "following";
    private static final String ARTICLE_FAVORITED_COL = "favorited";

    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();
        article.setTitle(rs.getString(TITLE_COL));
        article.setSlug(rs.getString(SLUG_COL));
        article.setBody(rs.getString(BODY_COL));
        article.setDescription(rs.getString(DESCRIPTION_COL));
        article.setFavoritesCount(rs.getInt(FAVORITE_COUNT_COL));
        article.setCreatedAt(rs.getDate(CREATED_AT_COL));
        article.setUpdatedAt(rs.getDate(UPDATED_AT_COL));
        article.setFavorited( (rs.getInt(ARTICLE_FAVORITED_COL) > 0) ? true : false );

        ArticleAuthor author = new ArticleAuthor();
        author.setUsername(rs.getString(AUTHOR_USERNAME_COL));
        author.setBio(rs.getString(AUTHOR_BIO_COL));
        author.setImage(rs.getString(AUTHOR_IMAGE_COL));
        author.setFollowing( (rs.getInt(AUTHOR_FOLLOWING_COL) > 0) ? true : false );

        article.setAuthor(author);

        return article;
    }

}
