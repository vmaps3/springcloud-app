package com.wangsong.system.service;

import com.wangsong.common.model.JsonTreeData;
import com.wangsong.system.entity.Resources;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jobob
 * @since 2021-09-18
 */
public interface IResourcesService extends IService<Resources> {
    void deleteResources(Long[] id);

    void insertResources(Resources resources);

    List<JsonTreeData> findResources();

    List<Resources> findResourcesEMUByResources(String username);

    void updateResources(Resources resources);

    Resources selectByPrimaryKey(Long id);

}
