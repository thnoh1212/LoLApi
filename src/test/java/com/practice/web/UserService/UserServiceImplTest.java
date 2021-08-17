package com.practice.web.UserService;

import com.practice.web.Utils;
import com.practice.web.service.UserServiceImpl;
import org.junit.jupiter.api.Test;

public class UserServiceImplTest {
    @Test
    public void test(){

        UserServiceImpl userService = new UserServiceImpl();

        String temp = userService.addData("가나라라라");
    }
}
