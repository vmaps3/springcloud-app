package com.wangsong.system.controller;


import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.User;
import com.wangsong.system.service.IUserService;
import com.wangsong.system.vo.UserAddModel;
import com.wangsong.system.vo.UserPage;
import com.wangsong.system.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wangsong.common.controller.BaseController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@Api(value = "用户管理")
@RestController
@RequestMapping("/system/user")
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;


    @ApiOperation(value = "列表", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/user/list')")
    @RequestMapping(value = "/list")
    public Result list(@ModelAttribute UserPage user) {
        GetEasyUIData list = userService.list(user);
        return new Result(CodeEnum.SUCCESS.getCode(), list);
    }

    @ApiOperation(value = "增加", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/user/add')")
    @RequestMapping(value = "/add")
    public Result add(@ModelAttribute UserAddModel user) {
        userService.add(user);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "单条", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @RequestMapping(value = "/selectByPrimaryKey")
    public Result selectByPrimaryKey(Long id) {
        UserVO userVO = userService.selectVOByPrimaryKey(id);
        return new Result(CodeEnum.SUCCESS.getCode(), userVO);
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/user/update')")
    @RequestMapping(value = "/update")
    public Result update(@ModelAttribute UserAddModel muser) {
        userService.updateUser(muser);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @PreAuthorize("hasAuthority('/system/user/delete')")
    @RequestMapping(value = "/delete")
    public Result delete(Long[] id) {
        userService.deleteUser(id);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "是否重复", httpMethod = "POST")
    @RequestMapping(value = "/findUserByUser")
    public Result findUserByUser(@ModelAttribute User user) {
        String r = userService.findTByT(user);
        return new Result(r, null);

    }

    @ApiOperation(value = "密码查询", httpMethod = "POST")
    @RequestMapping(value = "/toUpdatePassword")
    public Result toUpdatePassword() {
        String userDetails = (String) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        User tByUsername = userService.findTByUsername(userDetails);
        return new Result(CodeEnum.SUCCESS.getCode(), tByUsername);
    }

    @ApiOperation(value = "更改密码", httpMethod = "POST")
    @RequestMapping(value = "/updatePassword")
    public Result updatePassword(@ModelAttribute UserAddModel muser) {
        userService.updatePassword(muser);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }
}
