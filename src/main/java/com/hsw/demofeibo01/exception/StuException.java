package com.hsw.demofeibo01.exception;


import com.hsw.demofeibo01.enums.ResultEnum;

public class StuException extends RuntimeException {
   Integer code;

    public StuException(ResultEnum resultEnum) {
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
