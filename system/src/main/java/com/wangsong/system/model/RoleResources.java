package com.wangsong.system.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleResources implements Serializable {

    private String id;
    private String resourcesId;
    private String roleId;
}