package com.gopher.system.model.vo;

public class PageRequestBase {
	/**
	 * 最大页容
	 */
	public static final int MAX_PAGE_SIZE = 100; 
	/**
	 * 默认页容
	 */
	public static final int DEFAULT_PAGE_SIZE = 10;
	
	private int pageSize = DEFAULT_PAGE_SIZE;

	private int pageNumber = 1;
	
	/**
	 * 分页开始位置
	 */
	private int beginIndex;
	
	public int getBeginIndex() {
		this.beginIndex = (pageNumber-1)* pageSize;
		return beginIndex;
	}
    
	public int getPageSize() {
		return pageSize >0? pageSize:DEFAULT_PAGE_SIZE;
	}

	public void setPageSize(int pageSize) {
		pageSize = pageSize > MAX_PAGE_SIZE ? pageSize : pageSize;
		pageSize = pageSize <= 0 ? DEFAULT_PAGE_SIZE:pageSize;
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber > 0 ? pageNumber:1;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


}
