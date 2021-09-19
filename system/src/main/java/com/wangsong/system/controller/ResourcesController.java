package com.wangsong.system.controller;


import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.Result;
import com.wangsong.system.entity.Resources;
import com.wangsong.system.service.IResourcesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.wangsong.common.controller.BaseController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@Api(value = "权限管理")
@RestController
@RequestMapping("/system/resources")
public class ResourcesController extends BaseController {
    @Autowired
    private IResourcesService resourcesService;

    @ApiOperation(value = "增加", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/resources/add')")
    @RequestMapping(value = "/add")
    public Result add(@ModelAttribute Resources resources) {
        resourcesService.insertResources(resources);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @PreAuthorize("hasAuthority('/system/resources/delete')")
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(Long[] id) {
        resourcesService.deleteResources(id);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/resources/update')")
    @RequestMapping(value = "/update")
    @ResponseBody
    public Result update(@ModelAttribute Resources resources) {
        resourcesService.updateResources(resources);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "列表", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/resources/list')")
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result list() {
        return new Result(CodeEnum.SUCCESS.getCode(), resourcesService.findResources());
    }


    @ApiOperation(value = "权限码列表", httpMethod = "POST")
    @RequestMapping(value = "/findResourcesEMUByResources")
    @ResponseBody
    public Result findResourcesEMUByResources() {
        String userDetails = (String) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return new Result(CodeEnum.SUCCESS.getCode(), resourcesService.findResourcesEMUByResources(userDetails));
    }

    @ApiOperation(value = "单条", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @RequestMapping(value = "/selectByPrimaryKey")
    @ResponseBody
    public Result selectByPrimaryKey(Long id) {
        return new Result(CodeEnum.SUCCESS.getCode(), resourcesService.selectByPrimaryKey(id));
    }
}
