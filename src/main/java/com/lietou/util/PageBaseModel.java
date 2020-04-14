package com.lietou.util;


/**
 * 分页基础类，默认查询第一页，一页10条
 * @author Administrator
 *
 */
public class PageBaseModel implements java.io.Serializable{
	
	private static final long serialVersionUID = -7178891478212827566L;

	private int currentPage = 1;
	
	private int pageSize = 10;
	
	private int totalNum;
	
	private int pageStartSize=-1;
	
	public int getTotalNum() {
		return totalNum;
	}


	public void setTotalNum(int totalNum) {
		if(totalNum>0){
			this.totalNum=totalNum;
		}
		if(pageSize<1){
			this.pageSize=10;
		}
		if(currentPage<1){
			this.currentPage=1;
		}
		if(this.pageStartSize < 0){
			this.pageStartSize=(this.currentPage-1)*this.pageSize;
			if(this.pageStartSize>totalNum){//当分页查询的开始条数大于总条数时，重新计算相关信息
				this.currentPage=totalNum/pageSize + 1;
				this.pageStartSize=(this.currentPage-1)*this.pageSize;
			}
		}
		
	}


	public int getCurrentPage() {
		return currentPage;
	}


	public int getPageSize() {
		return pageSize;
	}


	public int getPageStartSize() {
		return pageStartSize;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}


	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * 设置分页查询的相关信息
	 * @param currentPage 查询第几页数据
	 * @param pageSize  每页显示条数
	 * @param totalNum  分页查询总条数
	 */
	public void setPageBaseModel(Integer currentPage,Integer pageSize,Integer totalNum){
		if(currentPage !=null && currentPage>1){
			this.currentPage=currentPage;
		}
		if(pageSize !=null && pageSize>1){
			this.pageSize=pageSize;
		} 
		if(totalNum !=null && totalNum>1){
			this.totalNum=totalNum;
		}
		
		this.pageStartSize=(this.currentPage-1)*this.pageSize;
		
		if(this.pageStartSize>totalNum){//当分页查询的开始条数大于总条数时，重新计算相关信息
			this.currentPage=totalNum/pageSize + 1;
			this.pageStartSize=(this.currentPage-1)*this.pageSize;
		}
	}


	
}
