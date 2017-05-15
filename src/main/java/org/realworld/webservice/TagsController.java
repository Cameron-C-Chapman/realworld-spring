package org.realworld.webservice;


import org.realworld.webservice.manager.TagsTransactionManager;
import org.realworld.webservice.model.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tags")
public class TagsController {

    private final TagsTransactionManager tagsTransactionManager;

    @Autowired
    public TagsController(TagsTransactionManager tagsTransactionManager) {
        this.tagsTransactionManager = tagsTransactionManager;
    }

    @RequestMapping()
    public Tags getTags() {
        return tagsTransactionManager.getTags();
    }
}
