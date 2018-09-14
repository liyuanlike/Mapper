package com.atguigu.shop.entity;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "table_emp")
public class Employee {

    @Id
    @Column(name = "emp_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer empId;
    @Column(name = "emp_name")
    private String empName;
    @Column(name = "emp_salary")
    private BigDecimal empSalary;
    @Column(name = "emp_age")
    private Integer empAge;

    public Employee() {
        super();
    }

    public Employee(Integer empId, String empName, BigDecimal empSalary, Integer empAge) {
        super();
        this.empId = empId;
        this.empName = empName;
        this.empSalary = empSalary;
        this.empAge = empAge;
    }

    /**
     * @return emp_id
     */
    public Integer getEmpId() {
        return empId;
    }

    /**
     * @param empId
     */
    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    /**
     * @return emp_name
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return emp_salary
     */
    public BigDecimal getEmpSalary() {
        return empSalary;
    }

    /**
     * @param empSalary
     */
    public void setEmpSalary(BigDecimal empSalary) {
        this.empSalary = empSalary;
    }

    /**
     * @return emp_age
     */
    public Integer getEmpAge() {
        return empAge;
    }

    /**
     * @param empAge
     */
    public void setEmpAge(Integer empAge) {
        this.empAge = empAge;
    }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", empAge=" + empAge + "]";
    }

}
