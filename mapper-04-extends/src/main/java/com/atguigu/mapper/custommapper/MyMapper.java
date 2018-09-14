package com.atguigu.mapper.custommapper;

import tk.mybatis.mapper.common.base.select.SelectAllMapper;
import tk.mybatis.mapper.common.example.SelectByExampleMapper;

public interface MyMapper<T> extends SelectAllMapper<T>, SelectByExampleMapper<T>, MyBatchUpdateMapper<T> {
}
