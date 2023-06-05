package com.wangsong.system.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("system")
public interface SystemAPI{


    @RequestMapping(value = "/system/getUser", method = RequestMethod.POST)
    String getUser(@RequestParam String user);


}