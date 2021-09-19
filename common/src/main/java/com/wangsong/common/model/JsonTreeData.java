package com.wangsong.common.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JsonTreeData {

    public Long id;       //json id
    public Long pid;      //
    public String text;     //json 显示文本
    public String state;    //json 'open','closed'
    public Attributes attributes;
    public List<JsonTreeData> children;       //
}