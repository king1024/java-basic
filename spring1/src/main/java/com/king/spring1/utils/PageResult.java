package com.king.spring1.utils;

import java.util.List;

/**
 * @author duanyong
 * 2019年3月15日 上午11:04:21
 */
public class PageResult <T> {
    // 总条数
    private Long total;
    // 分页结果
    private List<T> rows;
	/**
	 * @return the total
	 */
	public Long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(Long total) {
		this.total = total;
	}
	/**
	 * @return the rows
	 */
	public List<T> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
    
    
}
