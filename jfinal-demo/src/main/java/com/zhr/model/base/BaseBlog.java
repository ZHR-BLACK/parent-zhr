package com.zhr.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseBlog<M extends BaseBlog<M>> extends Model<M> implements IBean {

	public M setId(Integer id) {
		set("id", id);
		return (M)this;
	}
	
	public Integer getId() {
		return getInt("id");
	}

	public M setTitle(String title) {
		set("title", title);
		return (M)this;
	}
	
	public String getTitle() {
		return getStr("title");
	}

	public M setContent(String content) {
		set("content", content);
		return (M)this;
	}
	
	public String getContent() {
		return getStr("content");
	}

}