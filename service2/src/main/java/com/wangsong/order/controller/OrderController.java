package com.wangsong.order.controller;


import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangsong.system.api.SystemAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 定时任务 controller
 *
 * @author ty
 * @date 2015年1月14日
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private SystemAPI systemAPI;

    //http://127.0.0.1:1101/order/order/get?text=12
    @RequestMapping("/get")
    @ResponseBody
    public Object get(String text) {
        return systemAPI.getUser(text);
    }

    @HystrixCommand(fallbackMethod = "test")
    @RequestMapping(value = "/test")
    @ResponseBody
    public String list() {
        return "1";
    }


    public String test() {
        return "2";
    }


}
