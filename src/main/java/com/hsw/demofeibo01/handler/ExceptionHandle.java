package com.hsw.demofeibo01.handler;

import com.hsw.demofeibo01.domain.result;
import com.hsw.demofeibo01.exception.StuException;
import com.hsw.demofeibo01.utils.resultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHandle {
     private final static Logger logger= LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public result handle(Exception e){
        if (e instanceof StuException)
        {  StuException stuException=(StuException)e;
            return resultUtil.error(stuException.getCode(),stuException.getMessage());
        }else {
            logger.error("系统异常{}",e);
            return resultUtil.error(-1,"未知错误，请看日志、");
        }

    }
}
