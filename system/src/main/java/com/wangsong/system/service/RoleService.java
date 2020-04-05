package com.wangsong.system.service;

import com.wangsong.common.model.GetEasyUIData;
import com.wangsong.system.model.*;
import com.wangsong.system.vo.RoleVO;

import java.util.List;

public interface RoleService {

    void insertRole(RoleAddModel role);

    void updateRole(RoleAddModel role);

    void deleteRole(String[] id);

    GetEasyUIData findTByPage(RolePage role);

    RoleVO selectByPrimaryKey(String id);

    List<Role> selectAll();

    void deleteByT(RoleResources[] r);

    List<Resources> findResourcesByT(Resources resources);

}
