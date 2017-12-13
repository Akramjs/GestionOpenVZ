package com.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 * @author Mohamed
 *
 */
@Table(name = "g_user")
@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_USER")
	private Integer idUser;
	private String login;
	@Column(name = "pwd")
	private String password;
	private int enabled;
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private List<Role> roles;
	@OneToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	/* because we have many fetch type eager */
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Container> containers;
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	/* because we have many fetch type eager */
	@Fetch(value = FetchMode.SUBSELECT)
	private List<CustomContainer> customContainers;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Container> getContainers() {
		return containers;
	}

	public void setContainers(List<Container> containers) {
		this.containers = containers;
	}

	public List<CustomContainer> getCustomContainers() {
		return customContainers;
	}

	public void setCustomContainers(List<CustomContainer> customContainers) {
		this.customContainers = customContainers;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", login=" + login + ", password="
				+ password + ", enabled=" + enabled;
	}

}
