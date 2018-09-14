package com.atguigu.mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigu.mybatis.entity.Department;
import com.atguigu.mybatis.mapper.DepartmentMapper;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getAll() {
        return departmentMapper.selectAll();
    }

}
