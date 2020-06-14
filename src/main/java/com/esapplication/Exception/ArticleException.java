package com.esapplication.Exception;

import com.esapplication.Enum.ResultEnum;

public class ArticleException extends RuntimeException{

    private Integer code;

    public ArticleException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
