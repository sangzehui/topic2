package com.sang.topic.common.model;

import org.springframework.data.domain.PageRequest;

/**
 * 默认page为0,pageSize为20
 * 需设置count,才可以用maxPage,endPage,nextPage
 */
public class Page {
    private Integer page;
    private Integer pageSize;
    private Long count;

    private Integer maxPage;
    private Integer startPage;
    private Integer endPage;
    private Integer prePage;
    private Integer nextPage;
    private static Integer MAX_PAGE_SIZE = 20;
    private static Integer EXTEND_MAX_SIZE = 4;

    public PageRequest toPageable() {
        return new PageRequest(getPage() - 1, getPageSize());
    }

    public Integer getPrePage() {
        return getPage() - 1 > 0 ? getPage() - 1 : 1;
    }

    public Integer getNextPage() {
        return getPage() + 1 < maxPage ? getPage() + 1 : maxPage;
    }

    public Integer getStartPage() {
        return getPage() - EXTEND_MAX_SIZE > 0 ? getPage() - EXTEND_MAX_SIZE : 1;
    }

    public Integer getEndPage() {
        return getPage() + EXTEND_MAX_SIZE < maxPage ? getPage() + EXTEND_MAX_SIZE : maxPage;
    }

    public void setCount(Long count) {
        this.count = count;
        if(count == 0)
            maxPage = 1;
        else if(count % getPageSize() == 0)
            maxPage = Math.toIntExact(count / getPageSize());
        else maxPage = Math.toIntExact(count / getPageSize() + 1);
    }

    public Integer getPage() {
        return page == null ? 1 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return MAX_PAGE_SIZE;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
