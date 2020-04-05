package com.wangsong.system.dao;

import com.wangsong.system.model.Resources;

import java.util.List;

public interface ResourcesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Resources record);

    Resources selectByPrimaryKey(String id);

    List<Resources> selectAll();

    int updateByPrimaryKey(Resources record);

    void deleteBy(String[] id);

}