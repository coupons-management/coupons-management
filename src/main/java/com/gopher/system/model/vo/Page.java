package com.gopher.system.model.vo;

import java.util.List;

public class Page<T> {

	private List<T> list;

	private int pageSize;

	private int pageNumber;
	
	private int totalCount;

	private int totalPage;
    
	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getTotalPage() {
		totalPage = pageSize <= 0 ? 0 : (totalCount % pageSize == 0 ? totalCount / pageSize : totalCount / pageSize + 1);
		return totalPage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Page [list=");
		builder.append(list);
		builder.append(", pageSize=");
		builder.append(pageSize);
		builder.append(", pageNumber=");
		builder.append(pageNumber);
		builder.append(", totalCount=");
		builder.append(totalCount);
		builder.append(", totalPage=");
		builder.append(totalPage);
		builder.append("]");
		return builder.toString();
	}


}
