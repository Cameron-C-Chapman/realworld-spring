package org.realworld.webservice.manager;

import org.realworld.webservice.data.UserDao;
import org.realworld.webservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true, timeout = 5)
public class UserTransactionManager {

    @Autowired
    private UserDao userDao;

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

}
