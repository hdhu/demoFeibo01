package com.hsw.demofeibo01.controller;

import com.hsw.demofeibo01.domain.user;
import com.hsw.demofeibo01.repository.UserReposity;
import com.hsw.demofeibo01.service.CourseService;
import com.hsw.demofeibo01.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

//import com.boot.demo02.service.HttpAPIService;

//@RestController  等于controller 加response body 返回json或其它 return里的内容
@Controller
//@RequestMapping(value = "/aa")
public class UserController {
private  final static Logger logger= LoggerFactory.getLogger(UserController.class);
@Autowired
    private UserReposity userReposity;
@Autowired
    private UserService userService;
@Autowired
    private CourseService courseService;
/*
@Autowired
    private HttpAPIService httpAPIService;
*/

@GetMapping(value = "hi")
    public String say(){
    return "index1";
}
/*
@PostMapping(value = "login1")
 public String login1(@ModelAttribute(value = "user") user user, ModelMap modelMap){
    return userService.login(user.getUsername(),user.getPassword());
}*/


@GetMapping(value = "login")
     public String login(@Valid user user, BindingResult result){
      if (result.hasErrors()){
//          return resultUtil.error(103,result.getFieldError().getDefaultMessage());
//          return "error";
      }

        return userService.login(user.getUsername(),user.getPassword());
//    return userService.aa(user);
}
@PostMapping(value = "reg")
    public String regist(@Valid user user) throws Exception {
     return  userService.regist(user);
}

@PostMapping(value = "/login1")
      public void login(@RequestParam("username") String uname, @RequestParam("password") String pwd){
      user user=new user();
      user.setUsername(uname);
      user.setPassword(pwd);
      userService.login(uname, pwd);
}

    @GetMapping(value = "login2")
    public String login1(@ModelAttribute(value = "user") user user, ModelMap model){
        model.addAttribute("name", user.getUsername());
        model.addAttribute("password", user.getPassword());
//return  userService.login2(user);
//        return userService.login(user.getUsername(),user.getPassword());
        return "login2";
    }

@PostMapping(value ="/reg1")
    public  void regist(@RequestParam("username") String uname, @RequestParam("password") String pwd) throws Exception {
    user user=new user();
    user.setUsername(uname);
    user.setPassword(pwd);
    userService.regist(user);
}

@PostMapping(value = "/q")
    public void fsaf(){

}
@GetMapping(value = "/courses")
    public String getCourse(){
    return      courseService.getCourse("http://wrap-cms.121learn.com/api/v2/out/courses","Token 0024782321eed8c0debc9635c121c83c27588mmf");
}

/*
@RequestMapping("httpclient")
public String test() throws Exception {
    String str = httpAPIService.doGet("http://www.baidu.com");
    System.out.println(str);
    return "hello";
}*/

}
