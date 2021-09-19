package com.wangsong.system.vo;

import com.wangsong.common.model.Page;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "UserPage", description = "用户分页")
public class UserPage extends Page implements Serializable {
    @ApiModelProperty(value = "id")
    private Long id;
    @ApiModelProperty(value = "账户名")
    private String username;
    @ApiModelProperty(value = "密码")
    private String password;
}