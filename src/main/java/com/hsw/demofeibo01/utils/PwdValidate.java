package com.hsw.demofeibo01.utils;

public class PwdValidate {
        /**
         * 正则表达式验证密码
         * @param input
         * @return
         */
        public static boolean rexCheckPassword(String input) {
            // 6-20 位，字母、数字、字符
            //String reg = "^([A-Z]|[a-z]|[0-9]|[`-=[];,./~!@#$%^*()_+}{:?]){6,20}$";
            String regStr = "^([A-Z]|[a-z]|[0-9]|[`~!@#$%^&*()+=|{}':;',\\\\[\\\\].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“'。，、？]){6,20}$";
            return input.matches(regStr);
        }

        public static void main(String[] args){
            System.out.println("rexCheckPassword is： "+ rexCheckPassword("14`~!@#$%^&*(\\)+=|{}"));
        }

}
