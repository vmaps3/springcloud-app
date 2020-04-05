package com.wangsong.system.api;

import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.Result;
import com.wangsong.system.model.UserDO;
import com.wangsong.system.service.ResourcesService;
import com.wangsong.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/api")
@Api(value = "SystemAPI")
public class SystemAPIImpl extends BaseController {


    @Autowired
    private UserService userService;

    @Autowired
    private ResourcesService resourcesService;

    @ApiOperation(value = "获取用户", httpMethod = "POST")
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    @ResponseBody
    public Result<UserDO> getUser(@RequestBody UserDO u) {
        return new Result(CodeEnum.SUCCESS.getCode(), u);
    }



}
