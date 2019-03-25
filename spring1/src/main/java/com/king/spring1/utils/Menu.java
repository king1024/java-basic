package com.king.spring1.utils;

import java.util.List;

/**
 * @author duanyong
 * 2019年3月18日 下午3:32:34
 */
public class Menu {
	
	public Menu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Menu(String text, String iconCls, String state) {
		super();
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
	}

	public Menu(String menuNo,String text, String iconCls, String state, List<Menu> children) {
		super();
		this.menuNo = menuNo;
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
		this.children = children;
	}
	
	public Menu(String url,String menuNo,String text, String iconCls, String state, List<Menu> children) {
		super();
		this.url = url;
		this.menuNo = menuNo;
		this.text = text;
		this.iconCls = iconCls;
		this.state = state;
		this.children = children;
	}

	private String url;

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	private String menuNo;
	/**
	 * 标题
	 */
	private String text;
	/**
	 * 图标
	 */
	private String iconCls;
	/**
	 * 状态
	 */
	private String state;
	/**
	 * 子菜单
	 */
	private List<Menu> children;
	
	/**
	 * @return the menuNo
	 */
	public String getMenuNo() {
		return menuNo;
	}

	/**
	 * @param menuNo the menuNo to set
	 */
	public void setMenuNo(String menuNo) {
		this.menuNo = menuNo;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the iconCls
	 */
	public String getIconCls() {
		return iconCls;
	}
	/**
	 * @param iconCls the iconCls to set
	 */
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the children
	 */
	public List<Menu> getChildren() {
		return children;
	}
	/**
	 * @param children the children to set
	 */
	public void setChildren(List<Menu> children) {
		this.children = children;
	}
	
}
