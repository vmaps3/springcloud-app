package com.wangsong.system.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/system")
public class SystemController {

    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public String getUser(String user) {
        return user;
    }


}
