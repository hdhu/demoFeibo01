package com.hsw.demofeibo01.enums;

public enum ResultEnum {
    UNKNOW_ERROR(-1,"未知错误"),
    SUCCESS(0,"success"),
    PRIMARY_SCHOOL(100,"primary"),
    MIDDLE_SCHOOLE(101,"MIDDLE"),
    PRIMARY_CODE(102,"密码强度低"),
    ERROR_PWD_NAME(103,"用户名或密码错误")
    ;

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
