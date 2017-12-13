package com.controllers;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.Profile;
import com.model.User;
import com.security.Session;
import com.service.ProfileService;
import com.service.UserService;

@Component
@ManagedBean(name = "profileController")
@ViewScoped
public class ProfileController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ProfileController.class);

	@Autowired
	private ProfileService profileService;
	@Autowired
	private UserService userService;

	private Profile currentProfile = new Profile();
	private Session session = new Session();
	private User user = new User();
	private String roleUser = "";

	/**
	 * @see init method
	 */
	public void init() {
		try {
			/* get user from session */
			roleUser = session.getCurrentUserRole();
			user = userService.findUserByLogin(session.getCurrentUserName());
			currentProfile = user.getProfile();
		} catch (Exception e) {
			logger.info("init method");
		}
	}

	/**
	 * @see update Profile
	 */
	public void updateProfile() {
		try {
			profileService.updateProfile(currentProfile);
		} catch (Exception e) {
			logger.info("updateProfile");
		}
	}

	/**
	 * @see getter for current Profile
	 * @return {@link Profile}
	 */
	public Profile getCurrentProfile() {
		return currentProfile;
	}

	/**
	 * @param Profile
	 * @see setter for current Profile
	 */
	public void setCurrentProfile(Profile currentProfile) {
		this.currentProfile = currentProfile;
	}

	/**
	 * @see getter for user
	 * @return {@link User}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param User
	 * @see setter for current User
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @see getter for role
	 * @return {@link String}
	 */
	public String getRoleUser() {
		return roleUser;
	}

	/**
	 * @param role
	 * @see setter for current User role
	 */
	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

}
