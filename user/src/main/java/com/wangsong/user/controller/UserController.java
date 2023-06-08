package com.wangsong.user.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public String getUser(String user) {
        return user;
    }


}
