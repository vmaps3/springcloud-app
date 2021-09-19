package com.wangsong.system.vo;

import com.wangsong.system.entity.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "RoleAddModel", description = "角色权限")
public class RoleAddModel extends Role implements Serializable {
    @ApiModelProperty(value = "权限数组")
    private Long[] resourcesId;
}