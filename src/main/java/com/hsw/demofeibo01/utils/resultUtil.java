package com.hsw.demofeibo01.utils;

import com.hsw.demofeibo01.domain.result;

public class resultUtil {
    public static result success(Object o){
        result result=new result();
        result.setCode(0);
        result.setMsg("success");
        result.setData(o);
        return result;
    }

    /*public static result success(){
        result result=new result();
        result.setMsg("success");
        result.setCode(0);
        result.setData(null);
        return result;
    }
*/
    public static result success(){
        return success(null);
    }


    public static result error(Integer code, String msg){
        result result=new result();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }


}
