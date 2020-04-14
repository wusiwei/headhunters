package com.lietou.util;

import java.util.Collection;

public class Page implements java.io.Serializable {

    private static final long serialVersionUID = -4626674370691701653L;
    
    private static ThreadLocal<Page> context = new ThreadLocal<Page>();

    private int pageSize = 10;
    
    private int currentPage = 1;
    
    private int totalPage = 0;
    
    private int totalRows = 0;
    
    private int pageStartRow = 0;
    
    private int pageEndRow = 0;
    
    private Collection<?> data;

    public Page() {}
    
    public void init(int totalRows) {
        this.init(totalRows, this.pageSize, this.currentPage);
    }
    
    /**
     * 初始化分页参数:需要先设置totalRows
     * 
     */
     public void init(int rows, int pageSize,int currentPage ) {
        this.pageSize = pageSize;
        this.totalRows = rows;
        this.totalPage = (this.totalRows/this.pageSize)+(this.totalRows%this.pageSize>0?1:0);
        if(currentPage>0)gotoPage(currentPage);       
    }
    
    public static Page getContext(){
        Page cp = context.get();
        if(cp == null){
            cp = new Page();
            context.set(cp);
        }
        return cp;
    }
    
    public static void removeContext(){
        context.remove();
    }
    
    /**
     * 直接跳转到指定页数的页面
     * 
     * @param page
     */
    public void gotoPage(int page) {
        currentPage = page;
        calculatePage();
    }
    
    /**
     * 计算当前页的取值范围：pageStartRow和pageEndRow
     * 
     */
    private void calculatePage() {
        int pageStartRecord = currentPage * pageSize;
        boolean isLessThanTotalRows = pageStartRecord < totalRows;
        pageEndRow = isLessThanTotalRows?pageStartRecord:totalRows;
        pageStartRow = isLessThanTotalRows?pageEndRow - pageSize:pageSize * (totalPage - 1);
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

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(int totalRows) {
        this.totalRows = totalRows;
    }

    public int getPageStartRow() {
        return pageStartRow;
    }

    public void setPageStartRow(int pageStartRow) {
        this.pageStartRow = pageStartRow;
    }

    public int getPageEndRow() {
        return pageEndRow;
    }

    public void setPageEndRow(int pageEndRow) {
        this.pageEndRow = pageEndRow;
    }

    public Collection<?> getData() {
        return data;
    }

    public void setData(Collection<?> data) {
        this.data = data;
    }
}
