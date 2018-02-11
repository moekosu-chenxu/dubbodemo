package com.moekosu.dubbo.api.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 模块
 * Created by Administrator on 2018/1/21.
 */
public class Modules implements Serializable{

	private static final long serialVersionUID = 5316814464434198378L;

	private Integer mid;
	private String name;
	private String url;
	private Date createDate;
	private String status;

	public Integer getMid() {
		return mid;
	}

	public void setMid(Integer mid) {
		this.mid = mid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
