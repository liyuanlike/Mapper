package com.atguigu.mapper.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mapper.entity.Employee;
import com.atguigu.mapper.service.EmployeeService;

public class MyBatchUpdateTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext iocContainer = new ClassPathXmlApplicationContext("spring-context.xml");

        EmployeeService employeeService = iocContainer.getBean(EmployeeService.class);

        List<Employee> empList = new ArrayList<>();

        empList.add(new Employee(1, "newName01", 111.11, 10));
        empList.add(new Employee(2, "newName02", 222.22, 20));
        empList.add(new Employee(3, "newName03", 333.33, 30));

        employeeService.batchUpdateEmp(empList);

        iocContainer.close();
    }

}
