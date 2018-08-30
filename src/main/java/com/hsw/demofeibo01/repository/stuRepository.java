package com.hsw.demofeibo01.repository;

import com.hsw.demofeibo01.domain.stu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface stuRepository extends JpaRepository<stu,Integer> {
//    按年龄查询
    public List<stu> findByAge(Integer age);

}
