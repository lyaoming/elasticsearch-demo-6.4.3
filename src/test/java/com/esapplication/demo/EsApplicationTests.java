package com.esapplication.demo;

import com.esapplication.Dao.ArticleSearchRepository;
import com.esapplication.Document.Article;
import com.esapplication.Document.Author;
import com.esapplication.Document.Tutorial;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.InetAddress;
import java.util.Date;
import java.util.UUID;


@SpringBootTest
class EsApplicationTests {
    @Autowired
    private static ArticleSearchRepository articleSearchRepository;
    static TransportClient client;
    @Test
    public static void main(String[] arg) throws Exception {
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    }
    @Test
    public static void testAdd() {
        Long iL = 1L ;
        for(int i = 1; i <= 20; i++) {
            iL = iL + 1;

            Author author = new Author();
            //随机title
            String title ="linyaoming" + UUID.randomUUID().toString();
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
            try {
                articleSearchRepository.save(article);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
