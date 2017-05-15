package org.realworld.webservice.manager;

import org.realworld.webservice.data.TagsDao;
import org.realworld.webservice.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Transactional(readOnly = true, timeout = 5)
public class TagsTransactionManager {

    @Autowired
    TagsDao tagsDao;

    public Tags getTags() {
        return tagsDao.getTags();
    }
}
