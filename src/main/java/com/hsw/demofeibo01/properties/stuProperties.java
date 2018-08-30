package com.hsw.demofeibo01.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "stu")
public class stuProperties {
    private  String clazz;
    private Integer age;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getClazz() {

        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }
}
