package com.sang.topic.common.model;

import org.springframework.data.domain.PageRequest;

public class Page {
    private Integer page;
    private Integer pageSize;
    private static final Integer FIRST_PAGE = 0;
    private static final Integer MAX_SIZE = 20;

    public PageRequest toPageable() {
        return new PageRequest(getPage(), getPageSize());
    }

    public Integer getPage() {
        return page == null ? FIRST_PAGE : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return (pageSize == null || pageSize > MAX_SIZE) ? MAX_SIZE : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
