package com.atguigu.mapper.test;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mapper.entity.Employee;
import com.atguigu.mapper.service.EmployeeService;

import tk.mybatis.mapper.entity.Example;
import tk.mybatis.mapper.entity.Example.Criteria;

public class EmployeeMapperTest {

    private ApplicationContext iocContainer = new ClassPathXmlApplicationContext("spring-context.xml");
    private EmployeeService employeeService = iocContainer.getBean(EmployeeService.class);

    @Test
    public void testSelectOne() {
        //1.创建实体类对象，封装查询条件
        Employee employeeQueryCondition = new Employee(null, "bob", 5560.11, null);
        //2.执行查询
        Employee employeeQueryResult = employeeService.getOne(employeeQueryCondition);
        //3.打印结果
        System.out.println(employeeQueryResult);
    }

    @Test
    public void testSelect() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectAll() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectCount() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectByPrimaryKey() {
        //1.提供主键值
        Integer empId = 3;
        //2.执行根据主键进行的查询
        Employee employee = employeeService.getEmployeeById(empId);
        //3.打印结果
        System.out.println(employee);
    }

    @Test
    public void testExistsWithPrimaryKey() {
        //1.提供主键值
        Integer empId = 33;
        //2.执行查询
        boolean exists = employeeService.isExists(empId);
        //3.打印结果
        System.out.println(exists);
    }

    @Test
    public void testInsert() {
        //1.创建实体类对象，封装要插入到数据库的数据
        Employee employee = new Employee(null, "emp03", 3000.00, 23);
        //2.执行插入
        employeeService.saveEmployee(employee);
        //3.获取Employee对象的主键字段值
        Integer empId = employee.getEmpId();
        System.out.println("empId = " + empId);
    }

    @Test
    public void testInsertSelective() {
        //1.创建实体类对象，封装要插入到数据库的数据
        Employee employee = new Employee(null, "emp04", null, 23);
        //2.执行插入
        employeeService.saveEmployeeSelective(employee);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByPrimaryKeySelective() {
        //1.创建实体类对象，封装要更新到数据库的数据
        Employee employee = new Employee(7, "empNewName", null, null);
        //2.执行更新
        employeeService.updateEmployeeSelective(employee);
    }

    @Test
    public void testDelete() {
        //1.创建实体类对象，封装要从数据库删除的数据
        Employee employee = null;//注意：查询条件为null时，整个表所有记录都会被删除
        //2.执行删除
        employeeService.removeEmployee(employee);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        //1.提供主键值
        Integer empId = 8;
        //2.执行删除
        employeeService.removeEmployeeById(empId);
    }

    @Test
    public void testSelectByExample() {
        //目标：where (emp_salary > ? and emp_age < ?) or (emp_salary < ? and emp_age > ?)

        //1.创建Example对象
        Example example = new Example(Employee.class);

        //==============================
        //1).设置排序信息
        example.orderBy("empSalary").asc().orderBy("empAge").desc();
        //2).设置去重
        example.setDistinct(true);
        //3).设置查询字段
        example.selectProperties("empName", "empSalary");
        //==============================

        //2.通过Example对象创建Criteria对象
        Criteria criteria01 = example.createCriteria();
        Criteria criteria02 = example.createCriteria();

        //3.在两个Criteria对象中分别设置查询条件
        //property参数：实体类的属性名；value参数：实体类的属性值
        criteria01.andGreaterThan("empSalary", 3000).andLessThan("empAge", 25);

        criteria02.andLessThan("empSalary", 5000).andGreaterThan("empAge", 30);

        //4.使用or关键词组装两个Criteria对象
        example.or(criteria02);

        //5.执行查询
        List<Employee> empList = employeeService.getEmpListByExample(example);

        //6.打印结果
        empList.forEach(System.out::println);
    }

    @Test
    public void testSelectOneByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectCountByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testDeleteByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByExample() {
        fail("Not yet implemented");
    }

    @Test
    public void testUpdateByExampleSelective() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectByExampleAndRowBounds() {
        fail("Not yet implemented");
    }

    @Test
    public void testSelectByRowBounds() {
        int pageNo = 3;
        int pageSize = 5;

        int index = (pageNo - 1) * pageSize;

        RowBounds rowBounds = new RowBounds(index, pageSize);

        List<Employee> empList = employeeService.getEmpListByRowBounds(rowBounds);
        empList.forEach(System.out::println);
    }

}
