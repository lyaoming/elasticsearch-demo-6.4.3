package com.esapplication;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class EsApplication extends SpringBootServletInitializer {
    public static void main(String[] args){
        SpringApplication.run(EsApplication.class, args);
        System.out.println("**********************************application runing**********************************************");
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
    }
}
