package com.sunyard.tms.utils;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:数据表格类
 * @author:zhangbo
 * @date:2017年7月12日 下午2:48:40
 */
public class DataGrid<T> implements Serializable{

	/**   
     * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
     */  
    private static final long serialVersionUID = 2295082701495609222L;

    /**
	 * @fields (int)total : 总数
	 */
	private int total;

	/**
	 * @fields (List<T>)rows : 展示列
	 */
	private List<T> rows;

	/**
	 * @title DataGrid
	 * @description 构造函数
	 */
	public DataGrid() {
	}

	/**
	 * @title DataGrid
	 * @description 构造函数，带参数
	 * @param total
	 * @param rows
	 */
	public DataGrid(int total, List<T> rows) {
		this.total = total;
		this.rows = rows;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "DataGrid [total=" + total + ", rows=" + rows + "]";
	}

}
