package com.sang.topic.common.model;

import org.springframework.data.domain.PageRequest;

/**
 * Created by sh on 2017/3/19.
 */
public class Page {
    private Integer page;
    private Integer pageSize;
    private Integer maxSize = 20;

    public PageRequest toPageReq() {
        return new PageRequest(getPage(), getPageSize());
    }

    public Integer getPage() {
        return page == null ? 0 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return (pageSize == null || pageSize > maxSize) ? maxSize : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
