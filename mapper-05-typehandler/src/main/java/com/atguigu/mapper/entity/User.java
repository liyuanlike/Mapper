package com.atguigu.mapper.entity;

import com.atguigu.mapper.handler.AddressTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import tk.mybatis.mapper.annotation.ColumnType;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "table_user")
public class User {

    @Id
    private Integer userId;
    private String userName;
    //@ColumnType(typeHandler = AddressTypeHandler.class)
    @Column
    private Address address;
    //@ColumnType(typeHandler = EnumTypeHandler.class)//在枚举类型这里无法使用@ColumnType注解注册MyBatis内置的枚举类型处理器
    @Column
    private SeasonEnum season;

    public User() {
        super();
    }

    public User(Integer userId, String userName, Address address, SeasonEnum season) {
        super();
        this.userId = userId;
        this.userName = userName;
        this.address = address;
        this.season = season;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public SeasonEnum getSeason() {
        return season;
    }

    public void setSeason(SeasonEnum season) {
        this.season = season;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", address=" + address + ", season=" + season + "]";
    }

}
