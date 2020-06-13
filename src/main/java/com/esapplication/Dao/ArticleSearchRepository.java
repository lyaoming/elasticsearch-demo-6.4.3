package com.esapplication.Dao;

import com.esapplication.Document.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleSearchRepository extends ElasticsearchRepository<Article, Long> {
    Article queryArticleById(Long id);
}
