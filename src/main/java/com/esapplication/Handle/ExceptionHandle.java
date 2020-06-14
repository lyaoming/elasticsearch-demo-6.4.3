package com.esapplication.Handle;

import com.esapplication.Exception.ArticleException;
import com.esapplication.Utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e) {

        if(e instanceof ArticleException) {
            ArticleException articleException = (ArticleException) e;
            return Result.error(articleException.getCode(), articleException.getMessage());
        }
        return Result.error(-1, e.getMessage());
    }
}
