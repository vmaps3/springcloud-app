package com.wangsong.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wangsong.common.model.Attributes;
import com.wangsong.common.model.JsonTreeData;
import com.wangsong.common.util.TreeNodeUtil;
import com.wangsong.system.entity.Resources;
import com.wangsong.system.entity.RoleResources;
import com.wangsong.system.entity.User;
import com.wangsong.system.entity.UserRole;
import com.wangsong.system.mapper.ResourcesMapper;
import com.wangsong.system.service.IResourcesService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wangsong.system.service.IRoleResourcesService;
import com.wangsong.system.service.IUserRoleService;
import com.wangsong.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jobob
 * @since 2021-09-19
 */
@Service
public class ResourcesServiceImpl extends ServiceImpl<ResourcesMapper, Resources> implements IResourcesService {
    @Autowired
    private IRoleResourcesService roleResourcesService;
    @Autowired
    private IUserService  userService;

    @Autowired
    private IUserRoleService userRoleService;
    @Override
    @Transactional
    public void deleteResources(Long[] ids) {
        for (Long id : ids) {
            if ("1".equals(id)) {
                continue;
            }
            removeById(id);
            UpdateWrapper updateWrapper = new UpdateWrapper();
            updateWrapper.eq("resources_id", id);
            roleResourcesService.remove(updateWrapper);
        }
    }

    @Override
    public void insertResources(Resources resources) {
        if ("".equals(resources.getUrl())) {
            resources.setUrl("/");
        }
        save(resources);
    }

    @Override
    public List<JsonTreeData> findResources() {
        List<Resources> resourcesList = list();
        return resourcesToJsonTreeData(resourcesList);
    }

    @Override
    public List<Resources> findResourcesEMUByResources(String username) {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("username",username);
        User user = userService.getOne(queryWrapper);
        QueryWrapper queryWrapper2 = new QueryWrapper();
        queryWrapper2.eq("user_id", user.getId());
        List<UserRole> userRoleList = userRoleService.list(queryWrapper2);
        List<Long> roleIds = new ArrayList<>();
        for (UserRole userRole : userRoleList) {
            roleIds.add(userRole.getRoleId());
        }
        QueryWrapper queryWrapper3 = new QueryWrapper();
        queryWrapper3.in("role_id", roleIds);
        List<RoleResources> roleResourcesList = roleResourcesService.list(queryWrapper3);
        List<Long> roleResourcesLists = new ArrayList<>();

        for (RoleResources roleResources : roleResourcesList) {
            roleResourcesLists.add(roleResources.getResourcesId());
        }
        QueryWrapper queryWrapper4 = new QueryWrapper();
        queryWrapper4.in("id", roleResourcesLists);
        queryWrapper4.orderByAsc("sort");
        List<Resources> resourcesList = list(queryWrapper4);
        return resourcesList;
    }

    @Override
    public void updateResources(Resources resources) {
        if ("".equals(resources.getUrl())) {
            resources.setUrl("/");
        }
        updateById(resources);
    }

    @Override
    public Resources selectByPrimaryKey(Long id) {
        return getById(id);
    }

    private List<JsonTreeData> resourcesToJsonTreeData(List<Resources> resourcesList) {
        List<JsonTreeData> treeDataList = new ArrayList<JsonTreeData>();
        /*为了整理成公用的方法，所以将查询结果进行二次转换。
         * 其中specid为主键ID，varchar类型UUID生成
         * parentid为父ID
         * specname为节点名称
         * */
        for (Resources htSpecifications : resourcesList) {
            JsonTreeData treeData = new JsonTreeData(htSpecifications.getId()
                    , htSpecifications.getPid(), htSpecifications.getName(), null
                    , new Attributes(htSpecifications.getUrl()), null);
            treeDataList.add(treeData);
        }
        //最后得到结果集,经过FirstJSON转换后就可得所需的json格式
        List<JsonTreeData> newTreeDataList = TreeNodeUtil.getfatherNode(treeDataList);
        return newTreeDataList;
    }
}
