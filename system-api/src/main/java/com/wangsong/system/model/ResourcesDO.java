package com.wangsong.system.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Resources", description = "权限")
public class ResourcesDO implements Serializable , GrantedAuthority {

    long serialVersionUID = -1390703452625033155L;


    @ApiModelProperty(value = "id")
    private String id;
    @ApiModelProperty(value = "父id")
    private String pid;
    @ApiModelProperty(value = "名称")
    private String name;
    @ApiModelProperty(value = "链接")
    private String url;
    @ApiModelProperty(value = "类型（菜单，按钮）")
    private String type;
    @ApiModelProperty(value = "排序")
    private String sort;
    @Override
    public String getAuthority() {
        return url;
    }

}