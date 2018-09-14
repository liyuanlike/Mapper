package com.atguigu.mapper.mapper;

import com.atguigu.mapper.entity.Employee;

import tk.mybatis.mapper.common.Mapper;

/**
 * 具体操作数据库的Mapper接口，需要继承通用Mapper提供的核心接口：Mapper<T>
 * 泛型指定为实体类的类型
 */
public interface EmployeeMapper extends Mapper<Employee> {
}
