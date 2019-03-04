package com.jnshu.task4.service.interfaces;

import com.jnshu.task4.common.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class IUserServiceTest {
    @Autowired
    IUserService userService;
    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("jksds");
        user.setPassword("jshfsd");
        Long i = userService.insertUser(user);
        System.out.println(i);
    }

    @Test
    public void deleteUserById() {
    }

    @Test
    public void updateStudent() {
    }

    @Test
    public void queryUserByName() {
    }

    @Test
    public void queryUserById() {
    }

    @Test
    public void queryAllUsers() {
    }
}