package com.atguigu.mapper.test;

import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mapper.entity.Employee;
import com.atguigu.mapper.service.EmployeeService;

public class CacheTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");

        EmployeeService employeeService = context.getBean(EmployeeService.class);

        List<Employee> empList = employeeService.getAll();
        empList.forEach(System.out::println);

        empList = employeeService.getAll();
        empList.forEach(System.out::println);

        context.close();
    }

}
