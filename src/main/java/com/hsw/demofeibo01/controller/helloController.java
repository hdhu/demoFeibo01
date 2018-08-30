package com.hsw.demofeibo01.controller;

import com.hsw.demofeibo01.repository.UserReposity;
import com.hsw.demofeibo01.repository.stuRepository;
import com.hsw.demofeibo01.service.stuService;
import com.hsw.demofeibo01.domain.result;
import com.hsw.demofeibo01.domain.stu;
import com.hsw.demofeibo01.utils.resultUtil;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 *
 */
@RestController
@RequestMapping(value = "/say")



/*@RequestMapping(value = "/say")
public class helloController
{
    @Autowired
    private stuProperties stuProperties;

    @RequestMapping(value = {"/hi/{id}","/hello"},method = RequestMethod.GET)
    public String say(@PathVariable("id") Integer id ){
        return "id:"+id;
    }*/
//    @GetMapping(value = "/hi")
   /* @RequestMapping(value = {"/hh"},method = RequestMethod.GET)
    private String say1(@RequestParam(Value = "id", required = false, defaultValue = "0") Integer myid){
        return "sd"+myid;
    }*/

public class helloController {

    private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(helloController.class);
    @Autowired
    private stuRepository stuRepository;
    @Autowired
    private stuService stuService;


    @GetMapping(value = "/hi")
    public String say() {
        return "index";
//        return stuRepository.findByAge(10);
    }

    @GetMapping(value = "/")//这个只能返回json,配合页面用controller
    public String say1(Map<String,Object> map){
        map.put("hello","boot");
        return "aa";
    }

    /**
     * 查询所有学生列表
     *
     * @return
     */
    @GetMapping(value = "/stus")
    public List<stu> stulist() {
        return stuRepository.findAll();
    }

    /**
     * 添加学生
     *
     * @param stu
     * @return
     */
    @PostMapping(value = "/stus")
    public result<stu> stuAdd(@Valid stu stu, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
/*            result result=new result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);*/
            return resultUtil.error(1, bindingResult.getFieldError().getDefaultMessage());
        }else

       /* stu.setAge(stu.getAge());
        stu.setClazz(stu.getClazz());
        result result=new result();
        result.setCode(0);
        result.setMsg("SUSSESS");
        result.setData(stuRepository.save(stu));*/
        return resultUtil.success(stuRepository.save(stu));
    }

    @PostMapping(value = "stus/two")
    public void stuInsertTwo() {
        stuService.insertTwo();
    }


    //    查询
    @GetMapping(value = "/stus/{id}")
    public Optional<stu> stuFind(@PathVariable("id") Integer id) {
        stu stu = new stu();
        stu.setId(id);
        Example<stu> stuExample = Example.of(stu);
        return stuRepository.findOne(stuExample);
    }

    //    更新
    @PutMapping(value = "stus/{id}")
    public stu stuUpdate(@PathVariable("id") Integer id, @RequestParam("clazz") String clazz, @RequestParam("age") Integer age) {
        stu stu = new stu();
        stu.setId(id);
        stu.setClazz(clazz);
        stu.setAge(age);

        return stuRepository.save(stu);
    }

    //    删除
    @DeleteMapping(value = "stus/{id}")
    public void stuDelete(@PathVariable("id") Integer id) {
        stuRepository.deleteById(id);
    }

    //    查询 通过年龄
    @GetMapping(value = "stus/age/{id}")
    public List<stu> stuGetByAge(@PathVariable("age") Integer age) {
        return stuRepository.findByAge(age);

    }

    @GetMapping(value = "stus/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
        stuService.getAge(id);
    }



}

