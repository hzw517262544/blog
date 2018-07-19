package com.hao.blog.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * 菜单 值对象.
 * 
 * @since 1.0.0 2017年3月30日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Entity
public class SysMenu implements Serializable{
 
	private static final long serialVersionUID = 1L;

	@Id // 主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增长策略
	private Long id;
	private String name;
	private String url;
	private String crtTime;
	private String crtUserId;
	private String crtUserName;
	private String updateTime;
	private String updateUserId;
	private String updateUserName;
	private Long parentId;
	private String level;
	private String type;
	private Long orderBy;

	public Long getOrder() {
		return orderBy;
	}

	public void setOrder(Long orderBy) {
		this.orderBy = orderBy;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getCrtTime() {
		return crtTime;
	}

	public void setCrtTime(String crtTime) {
		this.crtTime = crtTime;
	}

	public String getCrtUserId() {
		return crtUserId;
	}

	public void setCrtUserId(String crtUserId) {
		this.crtUserId = crtUserId;
	}

	public String getCrtUserName() {
		return crtUserName;
	}

	public void setCrtUserName(String crtUserName) {
		this.crtUserName = crtUserName;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(String updateUserId) {
		this.updateUserId = updateUserId;
	}

	public String getUpdateUserName() {
		return updateUserName;
	}

	public void setUpdateUserName(String updateUserName) {
		this.updateUserName = updateUserName;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "SysMenu{" +
				"id=" + id +
				", name='" + name + '\'' +
				", url='" + url + '\'' +
				", crtTime='" + crtTime + '\'' +
				", crtUserId='" + crtUserId + '\'' +
				", crtUserName='" + crtUserName + '\'' +
				", updateTime='" + updateTime + '\'' +
				", updateUserId='" + updateUserId + '\'' +
				", updateUserName='" + updateUserName + '\'' +
				", parentId=" + parentId +
				", level='" + level + '\'' +
				'}';
	}

	public SysMenu(long id, String name, String url, String crtTime, String crtUserId, String crtUserName, String updateTime, String updateUserId, String updateUserName, long parentId, String level) {
		this.id = id;
		this.name = name;
		this.url = url;
		this.crtTime = crtTime;
		this.crtUserId = crtUserId;
		this.crtUserName = crtUserName;
		this.updateTime = updateTime;
		this.updateUserId = updateUserId;
		this.updateUserName = updateUserName;
		this.parentId = parentId;
		this.level = level;
	}

	public SysMenu() {
	}
}
