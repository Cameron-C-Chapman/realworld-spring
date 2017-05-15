package org.realworld.webservice.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tags {

    private List<String> tags;

    public Tags() {
        this.tags = new ArrayList<>();
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void addTag(String tag) {
        this.tags.add(tag);
    }

}
