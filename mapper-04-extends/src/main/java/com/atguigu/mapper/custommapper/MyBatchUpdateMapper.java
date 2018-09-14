package com.atguigu.mapper.custommapper;

import java.util.List;

import org.apache.ibatis.annotations.UpdateProvider;

public interface MyBatchUpdateMapper<T> {

    @UpdateProvider(type = MyBatchUpdateProvider.class, method = "dynamicSQL")
    void batchUpdate(List<T> list);

}
