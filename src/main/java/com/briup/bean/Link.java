package com.briup.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
@Entity
@Table(name="cms_link")

public class Link {
	@ApiModelProperty(value = "链接Id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ApiModelProperty(value = "链接名字",required = true)
	private String name;
	@ApiModelProperty(value = "链接url",required = true)
	private String url;
	public Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Link(Integer id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Link [id=" + id + ", name=" + name + ", url=" + url + "]";
	}
	
}
