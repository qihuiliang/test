package com.cheer.util;

// 分页
public class Page {

    // 每页显示条数
    private int pageSize;

    // 当前页面
    private int currentPage;

    // 起始行（当前页面的第一条数据）
    private int startRow;

    // 总页数
    private int totalPage;

    // 总条数
    private int totalCount;

    // 参数依次为：每页有几条记录，当前是第几页，总共有多少条记录
    public Page(int pageSize, int currentPage,int totalCount){
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.setStartRow(currentPage,pageSize);
        this.setTotalPage(totalCount,pageSize);
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getStartRow() {
        return startRow;
    }

    public void setStartRow(int currentPage,int pageSize) {
        this.startRow = (currentPage-1) * pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalCount,int pageSize) {
        this.totalPage = totalCount % pageSize == 0 ? totalCount/ pageSize : (totalCount/pageSize)+1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }
}
