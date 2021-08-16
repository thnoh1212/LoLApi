package com.practice.web.controller;

import org.junit.jupiter.api.Test;

public class userControllerTest {

    @Test
    public void test(){
        UserController userController = new UserController();
        String temp = userController.signUp("가나라라라");
        System.out.println("temp = " + temp);
    }
}
