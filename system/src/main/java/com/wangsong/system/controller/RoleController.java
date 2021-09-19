package com.wangsong.system.controller;


import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.Role;
import com.wangsong.system.service.IRoleService;
import com.wangsong.system.vo.RoleAddModel;
import com.wangsong.system.vo.RolePage;
import com.wangsong.system.vo.RoleVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wangsong.common.controller.BaseController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@Api(value = "角色管理")
@RestController
@RequestMapping("/system/role")
public class RoleController extends BaseController {
    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "列表", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/role/list')")
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result list(@ModelAttribute RolePage role) {
        GetEasyUIData tByPage = roleService.findTByPage(role);
        return new Result(CodeEnum.SUCCESS.getCode(), tByPage);
    }

    @ApiOperation(value = "增加", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/role/add')")
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result add(@ModelAttribute RoleAddModel role) {
        roleService.insertRole(role);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @PreAuthorize("hasAuthority('/system/role/delete')")
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(Long[] id) {
        roleService.deleteRole(id);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/role/update')")
    @RequestMapping(value = "/update")
    @ResponseBody
    public Result update(@ModelAttribute RoleAddModel mrole) {
        roleService.updateRole(mrole);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @ApiOperation(value = "复选框", httpMethod = "POST")
    @RequestMapping(value = "/listAll")
    @ResponseBody
    public Result listAll() {
        List<Role> roles = roleService.list();
        return new Result(CodeEnum.SUCCESS.getCode(), roles);
    }

    @ApiOperation(value = "单条", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @RequestMapping(value = "/selectByPrimaryKey")
    @ResponseBody
    public Result selectByPrimaryKey(Long id) {
        RoleVO roleVO = roleService.selectByPrimaryKey(id);
        return new Result(CodeEnum.SUCCESS.getCode(), roleVO);
    }

}
