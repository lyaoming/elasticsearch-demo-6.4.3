package com.esapplication.Document;


import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "projectname",type="article",indexStoreType="fs",shards=5,replicas=1,refreshInterval="-1")
public class Author {
    @Id
    private Long id;

    private String authorName;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "{\"id\":\"" + id + "\", \"authorName\":\"" + authorName + "\", \"remark\":\"" + remark + "\"}";
    }
}
