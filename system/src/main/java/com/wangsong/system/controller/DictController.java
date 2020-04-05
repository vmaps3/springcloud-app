package com.wangsong.system.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.wangsong.common.controller.BaseController;
import com.wangsong.common.model.CodeEnum;
import com.wangsong.common.model.Result;
import com.wangsong.system.model.Dict;
import com.wangsong.system.model.DictPage;
import com.wangsong.system.service.DictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/system/dict")
@Api(value = "字典管理")
public class DictController extends BaseController {
    @Autowired
    private DictService dictService;

    @HystrixCommand(fallbackMethod = "test")
    @ApiOperation(value = "列表", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/dict/list')")
    @RequestMapping(value = "/list")
    @ResponseBody
    public Result list(@ModelAttribute DictPage dict) {
        return new Result(CodeEnum.SUCCESS.getCode(), dictService.findTByPage(dict));
    }

    public Result test(@ModelAttribute DictPage dict) {
        return new Result(CodeEnum.SUCCESS.getCode(), 2);
    }

    @ApiOperation(value = "增加", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/dict/add')")
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result add(@ModelAttribute Dict dict) {
        dictService.insertDict(dict);
        return new Result(CodeEnum.SUCCESS.getCode(), null);
    }

    @ApiOperation(value = "更新", httpMethod = "POST")
    @PreAuthorize("hasAuthority('/system/dict/update')")
    @RequestMapping(value = "/update")
    @ResponseBody
    public Result update(@ModelAttribute Dict dict) {
        Assert.notNull(dict.getId(), CodeEnum.NO_NULL.getCode());
        dictService.updateByPrimaryKeyDict(dict);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "删除", httpMethod = "POST")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @PreAuthorize("hasAuthority('/system/dict/delete')")
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Result delete(String[] id) {
        dictService.deleteByPrimaryKeyDict(id);
        return new Result(CodeEnum.SUCCESS.getCode(), null);

    }

    @ApiOperation(value = "复选框", httpMethod = "POST")
    @RequestMapping(value = "/findDictByDict")
    @ResponseBody
    public Result findDictByDict(@ModelAttribute Dict dict) {
        return new Result(CodeEnum.SUCCESS.getCode(), dictService.findTByT(dict));
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", paramType = "form"),
    })
    @ApiOperation(value = "单条", httpMethod = "POST")
    @RequestMapping(value = "/selectByPrimaryKey")
    @ResponseBody
    public Result selectByPrimaryKey(String id) {
        return new Result(CodeEnum.SUCCESS.getCode(), dictService.selectByPrimaryKey(id));
    }

}
