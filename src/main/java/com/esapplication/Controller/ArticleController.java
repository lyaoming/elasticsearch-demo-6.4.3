package com.esapplication.Controller;
import com.esapplication.Document.Article;
import com.esapplication.Entity.SearchEntity;
import com.esapplication.Service.ArticleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.esapplication.Utils.Result;

/**
 * Article Controller
 */


@RequestMapping("/article")
@RestController
@Api(tags = "文章管理接口")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    //新增信息
    @PostMapping("/add")
    @ApiOperation("新增文章接口")
    public Result saveArticle() {
        try {
            articleService.save();
        } catch (Exception e) {
            System.out.println(e);
            Result.error();
        }
        return Result.ok();
    }

    @PostMapping("/update")
    @ApiOperation("更新文章接口")
    public Result updateArticle(@RequestBody Article article) {
        try {
            articleService.update(article);
        } catch (Exception e) {
            return Result.error();
        }
        return Result.ok();
    }

    //获取信息
    @GetMapping("/info")
    @ApiOperation("获取文章信息接口")
    public Result getArticleById(Long id) {
        Article article = null;
        try {
            article = articleService.queryArticleById(id);
        } catch (Exception e) {
            return Result.error();
        }
        return Result.ok().put("Article",article);
    }

    //删除信息
    @GetMapping("/delete")
    @ApiOperation("删除文章接口")
    public Result deleteArticle(Long id) {
        try{
            articleService.deleteById(id);
        } catch (Exception e) {
            System.out.println(e);
            return Result.error();
        }
        return Result.ok();
    }

    //查询信息
    @PostMapping("/query")
    @ApiOperation("查询文章接口")
    public Result searchArticle(@RequestBody SearchEntity searchEntity) {
        try {
            return Result.ok().put("data",articleService.query(searchEntity.getKeyword()));
        } catch (Exception e) {
            System.out.println(e);
        }
        return Result.error();
    }
}
