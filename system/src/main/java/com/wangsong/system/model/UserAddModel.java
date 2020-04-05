package com.wangsong.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserAddModel", description = "用户角色")
public class UserAddModel extends User implements Serializable {
    @ApiModelProperty(value = "角色数组")
    private String[] roleId;
}