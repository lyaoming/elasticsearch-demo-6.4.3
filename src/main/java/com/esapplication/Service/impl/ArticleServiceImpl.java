package com.esapplication.Service.impl;
import com.esapplication.Dao.ArticleSearchRepository;
import com.esapplication.Document.Article;
import com.esapplication.Document.Author;
import com.esapplication.Document.Tutorial;
import com.esapplication.Service.ArticleService;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSON;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("ArticleService")
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleSearchRepository articleSearchRepository;


    @Override
    public void save() {
        Long iL = 21L;
        for (int i =1; i <= 20; i++) {
            iL = iL + 1;

            Author author = new Author();
            //随机title
            String title = "linyaoming" + UUID.randomUUID().toString();
            author.setId(iL);
            author.setAuthorName("tianshouzhi");
            author.setRemark("java developer");

            Tutorial tutorial = new Tutorial();
            tutorial.setId(iL);
            tutorial.setTutorialName("elastic search");

            Article article = new Article();
            article.setId(iL);
            article.setTitle(title);
            article.setAbstracts("springboot integreate elasticsearch is very easy");
            article.setTutorial(tutorial);
            article.setAuthor(author);
            article.setContent("elasticsearch based on lucene,"
                    + "spring-data-elastichsearch based on elaticsearch"
                    + ",this tutorial tell you how to integrete springboot with spring-data-elasticsearch");
            article.setPostTime(new Date());
            article.setClickCount(1L);
            System.out.println(article);
            articleSearchRepository.save(article);
        }

    }
    @Override
    public  void update(Article article) {
        articleSearchRepository.save(article);
    }

    @Override
    public Article queryArticleById(Long id) {
        return articleSearchRepository.queryArticleById(id);
    }

    @Override
    public void deleteById(Long id) {
        articleSearchRepository.deleteById(id);
    }

    @Override
    public List query(String keyword) {
        List result = new ArrayList<>();
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(keyword);
        builder.field("title").defaultOperator(Operator.AND)
        .field("content").defaultOperator(Operator.AND)
        .field("abstracts").defaultOperator(Operator.AND);
        Iterable<Article> searchResult = articleSearchRepository.search(builder);
        Iterator<Article> iterator = searchResult.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject =  JSON.parseObject(iterator.next().toString());
            System.out.println(jsonObject);
            result.add(jsonObject);
        }
        return result;
    }
}
