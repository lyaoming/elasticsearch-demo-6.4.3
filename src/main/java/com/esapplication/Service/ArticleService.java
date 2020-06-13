package com.esapplication.Service;
import com.esapplication.Document.Article;

import java.util.List;

public interface ArticleService {
    //新增
    public void save();

    //更新
    public void update(Article article);

    //删除
    public void deleteById(Long id);

    //信息
    public Article queryArticleById(Long id);

    //查询
    public List query(String keyword);

}
