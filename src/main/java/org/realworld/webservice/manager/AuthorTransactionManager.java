package org.realworld.webservice.manager;

import org.realworld.webservice.data.AuthorDao;
import org.realworld.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true, timeout = 5)
public class AuthorTransactionManager {

    @Autowired
    private AuthorDao authorDao;

    public User getAuthorById(Long id) {
        return authorDao.getAuthorById(id);
    }

}