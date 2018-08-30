package com.hsw.demofeibo01.repository;

import com.hsw.demofeibo01.domain.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserReposity extends JpaRepository<user,Integer> {

//    通过用户名查询密码
    public List<String>  findByUsername(String username);

}
