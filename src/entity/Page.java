package entity;

import java.util.List;

public class Page<T> {
	/**
	 * ������: ��Ŀ��: entity 2018��9��16��-����7:06:55
	 */
	private int currentPage=1; // ��ǰҳ
	private int pageCount=7; // ��ѯ���ص����� Ĭ��ÿҳ7��
	private int totalCount; // �ܼ�¼��
	private int totalPage; // ��ҳ��
	private List<T> pageData; // ��ҳ��ѯ��������
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
