package com.wangsong.system.service.impl;

import com.wangsong.common.model.Attributes;
import com.wangsong.common.model.JsonTreeData;
import com.wangsong.common.util.TreeNodeUtil;
import com.wangsong.system.dao.ResourcesMapper;
import com.wangsong.system.model.Resources;
import com.wangsong.system.model.RoleResources;
import com.wangsong.system.service.ResourcesService;
import com.wangsong.system.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class ResourcesServiceImpl implements ResourcesService {
    @Autowired
    private ResourcesMapper resourcesMapper;
    @Autowired
    private RoleService roleService;

    @Override
    @Transactional
    public void deleteResources(String[] id) {
        int j = 0;
        for (int i = 0; i < id.length; i++) {
            if ("1".equals(id[i])) {
                continue;
            }
            j++;
        }
        RoleResources[] r = new RoleResources[j];
        for (int i = 0; i < id.length; i++) {
            if ("1".equals(id[i])) {
                continue;
            }
            r[i] = new RoleResources(null, id[i], null);
        }
        if (j == 0) {
            return;
        }
        roleService.deleteByT(r);
        resourcesMapper.deleteBy(id);
    }

    @Override
    @Transactional
    public void insertResources(Resources resources) {
        if ("".equals(resources.getUrl())) {
            resources.setUrl("/");
        }
        resources.setId(UUID.randomUUID().toString());
        resourcesMapper.insert(resources);
    }

    @Override
    @Transactional
    public void updateResources(Resources resources) {
        if ("".equals(resources.getUrl())) {
            resources.setUrl("/");
        }
        resourcesMapper.updateByPrimaryKey(resources);
    }

    @Override
    public List<JsonTreeData> findResources() {
        List<Resources> resourcesList = resourcesMapper.selectAll();
        return resourcesToJsonTreeData(resourcesList);
    }

    @Override
    public List<Resources> findResourcesEMUByResources(String id) {
        return findTByT(new Resources(id, null, null, null, null, null));
    }

    @Override
    public List<Resources> findTByT(Resources resources) {
        List<Resources> resourcesList = roleService.findResourcesByT(resources);
        return resourcesList;
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

    @Override
    public Resources selectByPrimaryKey(String id) {
        return resourcesMapper.selectByPrimaryKey(id);
    }


}
