package com.hsw.demofeibo01.controller;

import com.hsw.demofeibo01.domain.user1;
import com.hsw.demofeibo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "test1")
public class user1Controler {
@Autowired
    UserService userService;
//未选定Ctrl c光标所在行 复制进剪切板
    @RequestMapping(value = "login")
    public String login(@ModelAttribute(value = "user1")user1 user1, ModelMap map){
    map.addAttribute("name" ,user1.getName());
    map.addAttribute("pwd" ,user1.getPwd());
    map.addAttribute("user1",user1);
    return "login11";
}
@RequestMapping(value = "")
    public  String from(){
    return "";
}


}
