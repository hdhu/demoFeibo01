package com.hsw.demofeibo01.controller;


import com.hsw.demofeibo01.domain.stu;
import com.hsw.demofeibo01.domain.user;
import com.hsw.demofeibo01.domain.user1;
import com.hsw.demofeibo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/test")
public class TestController {
@Autowired
 UserService userService;
    @Value("name")
    private String name;
    @RequestMapping(value = "/a")
    public String Tohome(){
// 这个好像不能用
// return "forward：/jsp/index1.html";
//        return "forward:static/static.html";
        return "redirect:/login.html";
    }
    @RequestMapping(value = "/1")
    public String one(){
        return "1";
    }
    @RequestMapping(value = "/2")
    public String two(){
        return "2";
    }
    @RequestMapping(value = "/3")
    public String three(){
        return "index1";
    }
    @RequestMapping(value = "/4")
    public String four(){
        return "login";
    }

    @RequestMapping(value = "/test")
    public String test(ModelMap map){
    user user=new user();

  user.setUsername("1321");
//  user.setBirthday(Date.from(Instant.now()));
        user.setBirthday(new Date());
  map.addAttribute("user",user);
        return "test";
    }
    @RequestMapping(value = "form")
    public String form(user user){
        System.out.println(user.getUsername());
        return "redirect:/test/test";
    }
    @RequestMapping(value = "login11")
    public String login11(@ModelAttribute(value = "user") user user, ModelMap map ){
        map.addAttribute("name",user.getUsername());
        map.addAttribute("password",user.getPassword());
        map.addAttribute("user",user);
        return "login2";
//        return  "login4";//测试jpa
    }
    @RequestMapping(value = "loginform" ,method = RequestMethod.POST)
    public String loginform(user user)  {
        System.out.println(user.getUsername()+"user:   "+user+" password:    "+user.getPassword());
//        return "redirect:/test/login11";
//        return  userService.login(user.getUsername(),user.getPassword());
          return  userService.regist1(user);
//           return "login3";
    }

    @GetMapping(value = "/login")
    public String login1(@ModelAttribute(value = "user") user user, ModelMap model) throws Exception {
        model.addAttribute("name", user.getUsername());
        model.addAttribute("password", user.getPassword());
//return  userService.login2(user);
        return userService.login(user.getUsername(),user.getPassword());
//        return "login";
    }

    @GetMapping(value = "/loginold")
    public String login2(@ModelAttribute(value = "user") user user, ModelMap model){
        model.addAttribute("name", user.getUsername());
        model.addAttribute("password", user.getPassword());
        System.out.println(user.getUsername());
//return  userService.login2(user);
        return userService.login(user.getUsername(),user.getPassword());
//        return "login";
    }


    @RequestMapping(value = "/aaa")
    public String say(Map<String,Object> map){
        map.put("hello","safsfs");
        return "index";
    }
    @RequestMapping(value = "/faa")//freemaker 有问题不能同时和上一个使用
    public String sayfreenaker(Map<String,Object> M){
        M.put("name","xiaoming");
        return "faa";
     }
     @RequestMapping(value= "/webapp/jsp")
    public String sayFreemaker1(ModelMap map){
        map.addAttribute("name",name);
        return "faa";
     }
     @RequestMapping(value = "/")
     public String homePage(Model model){
        stu single=new stu("e",18);
         List<stu> list=new ArrayList<>();
         stu stu=new stu("c",19);
         stu stu1=new stu("d",20);
         list.add(stu);
         list.add(stu1);
         model.addAttribute("singlePerson",single);
         model.addAttribute("people",list);

        return "index";
     }
     @RequestMapping(value = "/static")
    public String navigatorToStatic(){
        return "redirect:/static.html";
     }

}
