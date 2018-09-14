package com.atguigu.mapper.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "table_emp")//映射数据库中的表名
public class Employee {

    @Id//映射主键
    @GeneratedValue(strategy = GenerationType.IDENTITY)//让通用Mapper在执行insert操作之后将数据库自动生成的主键值回写到实体对象中
    private Integer empId;
    private String empName;
    @Column(name = "emp_salary")//映射数据库表中的字段；若不设置，则通用Mapper默认使用驼峰命名规则来映射属性字段
    private Double empSalary;
    private Integer empAge;

    public Employee() {
        super();
    }

    public Employee(Integer empId, String empName, Double empSalary, Integer empAge) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(Double empSalary) {
        this.empSalary = empSalary;
    }

    public Integer getEmpAge() {
        return empAge;
    }

    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge + "]";
    }

}
