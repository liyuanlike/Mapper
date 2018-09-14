package com.atguigu.mapper.mapper;

import org.apache.ibatis.annotations.CacheNamespace;

import com.atguigu.mapper.custommapper.MyMapper;
import com.atguigu.mapper.entity.Employee;

@CacheNamespace
public interface EmployeeMapper extends MyMapper<Employee> {
}