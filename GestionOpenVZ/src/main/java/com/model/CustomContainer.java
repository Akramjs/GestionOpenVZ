package com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Akram
 *
 */
@Table(name = "g_CustomContainer")
@Entity
public class CustomContainer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CUSTOM_CONTAINER")
	private int idCustomContainer;
	private String templateName;
	private String path;
	private String enabled;
	private String state;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ID_USER")
	private User user;

	public int getIdCustomContainer() {
		return idCustomContainer;
	}

	public void setIdCustomContainer(int idCustomContainer) {
		this.idCustomContainer = idCustomContainer;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
