package com.wangsong.user.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("user")
public interface UserAPI {


    @RequestMapping(value = "/user/getUser", method = RequestMethod.POST)
    String getUser(@RequestParam String user);


}