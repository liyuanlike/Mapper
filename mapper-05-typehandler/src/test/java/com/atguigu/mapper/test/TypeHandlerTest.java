package com.atguigu.mapper.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.mapper.entity.Address;
import com.atguigu.mapper.entity.SeasonEnum;
import com.atguigu.mapper.entity.User;
import com.atguigu.mapper.service.UserService;

public class TypeHandlerTest {

    private UserService userService;

    {
        userService = new ClassPathXmlApplicationContext("spring-context.xml").getBean(UserService.class);
    }

    @Test
    public void testQueryUser() {
        Integer userId = 1;

        User user = userService.getUserById(userId);

        System.out.println(user);
    }

    @Test
    public void testSaveUser() {
        User user = new User(null, "tom08", new Address("AAA", "BBB", "CCC"), SeasonEnum.AUTUMN);

        userService.saveUser(user);
    }

}
