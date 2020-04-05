package com.wangsong.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Page", description = "分页")
public class Page {
    @ApiModelProperty(value = "第几页")
    private int page;
    @ApiModelProperty(value = "条数")
    private int rows;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

}
