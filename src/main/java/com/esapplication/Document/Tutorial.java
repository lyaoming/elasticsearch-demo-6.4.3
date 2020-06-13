package com.esapplication.Document;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "projectname",type="tutorial",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Tutorial {
    @Id
    private Long id;

    private String tutorialName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTutorialName() {
        return tutorialName;
    }

    public void setTutorialName(String tutorialName) {
        this.tutorialName = tutorialName;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\", \"tutorialName\":\"" + tutorialName + "\"}";
    }
}
