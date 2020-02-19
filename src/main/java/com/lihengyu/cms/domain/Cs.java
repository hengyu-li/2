package com.lihengyu.cms.domain;

public class Cs {
	
	private Integer id;
	
	private String title;
	
	private String url;
	
	private Integer uid;
	
	private String created;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getCreated() {
		return created;
	}

	public void setCreated(String created) {
		this.created = created;
	}

	public Cs(Integer id, String title, String url, Integer uid, String created) {
		super();
		this.id = id;
		this.title = title;
		this.url = url;
		this.uid = uid;
		this.created = created;
	}

	@Override
	public String toString() {
		return "Cs [id=" + id + ", title=" + title + ", url=" + url + ", uid=" + uid + ", created=" + created + "]";
	}

	public Cs() {
		// TODO Auto-generated constructor stub
	}

}
