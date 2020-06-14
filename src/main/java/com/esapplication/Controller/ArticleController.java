package com.esapplication.Controller;
import com.esapplication.Document.Article;
import com.esapplication.Entity.SearchEntity;
import com.esapplication.Enum.ResultEnum;
import com.esapplication.Exception.ArticleException;
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
    public Result saveArticle(){
        try {
            articleService.save();
        }
        catch (Exception e) {
            throw new ArticleException(ResultEnum.SAVE_INFO_ERROR);
        }
        return Result.ok();
    }

    @PostMapping("/update")
    @ApiOperation("更新文章接口")
    public Result updateArticle(@RequestBody Article article) {
        try {
            articleService.update(article);
        } catch (Exception e) {

            throw new ArticleException(ResultEnum.UPDATE_INFO_ERROR);
        }
        return Result.ok();
    }

    //获取信息
    @GetMapping("/info")
    @ApiOperation("获取文章信息接口")
    public Result getArticleById(Long id){
        try {
            return Result.ok().put("data",articleService.queryArticleById(id));

        } catch (Exception e) {

            throw new ArticleException(ResultEnum.GET_INFO_ERROR);
        }
    }

    //删除信息
    @GetMapping("/delete")
    @ApiOperation("删除文章接口")
    public Result deleteArticle(Long id) {

        try{
            articleService.deleteById(id);

        } catch (Exception e) {

            throw new ArticleException(ResultEnum.DELETE_INFO_ERROR);
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
            throw new ArticleException(ResultEnum.QUERY_INFO_ERROR);
        }
    }
}
