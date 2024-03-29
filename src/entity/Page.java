package entity;

import java.util.List;

public class Page<T> {
	/**
	 * 创建人: 项目名: entity 2018年9月16日-下午7:06:55
	 */
	private int currentPage=1; // 当前页
	private int pageCount=7; // 查询返回的行数 默认每页7行
	private int totalCount; // 总记录数
	private int totalPage; // 总页数
	private List<T> pageData; // 分页查询到的数据
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		if (totalCount % pageCount==0) {
			totalPage=totalCount/pageCount;
		}else {
			totalPage=totalCount/pageCount+1;
		}
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public List<T> getPageData() {
		return pageData;
	}
	public void setPageData(List<T> pageData) {
		this.pageData = pageData;
	}

}
