package com.atguigu.mybatis.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mybatis.entity.Department;
import com.atguigu.mybatis.service.DepartmentService;

public class MyBatisTest {

    private DepartmentService departmentService;

    {
        departmentService = new ClassPathXmlApplicationContext("spring-context.xml").getBean(DepartmentService.class);
    }

    @Test
    public void testGetAll() {
        List<Department> list = departmentService.getAll();
        list.forEach(System.out::println);
    }

}
