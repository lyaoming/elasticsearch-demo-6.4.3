package com.esapplication.Enum;

public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知异常"),
    SUCCESS(0, "成功"),
    GET_INFO_ERROR(1, "获取信息异常!"),
    SAVE_INFO_ERROR(2, "保存信息异常！"),
    DELETE_INFO_ERROR(3, "删除信息异常！"),
    UPDATE_INFO_ERROR(4, "更新信息异常！"),
    QUERY_INFO_ERROR(5, "查询信息错误！");

    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
