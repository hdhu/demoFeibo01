package com.hsw.demofeibo01.controller;

import com.hsw.demofeibo01.domain.stu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class demoController  {
    @Autowired
    private demoController demoController;

    @GetMapping(value = "/findAll")
    public List<stu> findAll(){
        return demoController.findAll();
    }
}
