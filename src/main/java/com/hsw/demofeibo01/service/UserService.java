package com.hsw.demofeibo01.service;

import com.hsw.demofeibo01.domain.user;
import com.hsw.demofeibo01.enums.ResultEnum;
import com.hsw.demofeibo01.exception.StuException;
import com.hsw.demofeibo01.repository.UserReposity;
import com.hsw.demofeibo01.utils.PwdValidate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

@Service
public class UserService  {
    @Autowired
    private UserReposity userReposity;

    public String regist(user user) throws Exception{
       String pwd=user.getPassword();
        String uname=user.getUsername();

        if ( !  PwdValidate.rexCheckPassword(pwd)){
//            userReposity.save(user);
            throw new StuException(ResultEnum.PRIMARY_CODE );
        }else {
//            System.out.println("密码要求6-20 位，字母、数字、字符");
            userReposity.save(user);
       return   "login2";
        }

    }

    public String regist1(user user) {
        String p=user.getPassword();
        String name=user.getUsername();
        System.out.println("ppppp:"+p+"name:"+name);
        userReposity.save(user);
        return "1";
    }

    public String aa(@Valid user user) {
        return "index1";
    }
  public String login2(user user){
        List<String> p=userReposity.findByUsername(user.getUsername());
        String pwd=user.getPassword();
        for (String p2:p){
            if (p2==pwd){
                return "1";
            }
            else {
                System.out.println("密码错误");
                return "login2";
            }
        }
return null;
  }

    public String login(String uname, String Pwd){
       List<String> p=userReposity.findByUsername(uname);
       String pwd=Pwd;

            /**
             *
             * List 代表一个元素有序、且可重复的集合，集合中的每个元素都有其对应的顺序索引
             * List 允许使用重复元素，可以通过索引来访问指定位置的集合元素。
             * List 默认按元素的添加顺序设置元素的索引。
             * List 集合里添加了一些根据索引来操作集合元素的方法
             */
                List list= new ArrayList();
/*
                list.add(new Person("AA",21));
                list.add(new Person("BB",22));
                list.add(new Person("CC",23));
                list.add(new Person("DD",24));*/


            for (String p1:p){
                if (p1==pwd){
                    System.out.println("密码正确");
                    return "index1";
                }else {
                    System.out.println("密码错误");
//                   return "error";
                }

        }

                //1.迭代：迭代器iterator迭代
                Iterator it = list.iterator();
                while(it.hasNext()){
                    System.out.println(it.next()); }

                //2.迭代:增强for循环
                System.out.println("--------for----------");
                for(Object obj :list){
                    System.out.println(obj); }


                //3.迭代：通过元素的索引迭代
                System.out.println("--------get(int index)----------");
                for(int i=0 ;i<list.size();i++){
                    System.out.println(list.get(i)); }


                //4.迭代：通过ListIterator迭代，也可向前迭代的
                ListIterator listIt = list.listIterator();
                System.out.println("--------ListIterator正向迭代----------");
                while(listIt.hasNext()){
                    System.out.println(listIt.next());
                }//指针已经到末尾了

                System.out.println("--------ListIterator反向迭代----------");
                while(listIt.hasPrevious()){
                    System.out.println(listIt.previous());
                }

                

        return null;
    }

    }


