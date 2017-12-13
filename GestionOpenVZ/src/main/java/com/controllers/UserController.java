package com.controllers;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.model.Profile;
import com.model.Role;
import com.model.User;
import com.service.ProfileService;
import com.service.RoleService;
import com.service.UserService;

/**
 * @author Akram
 *
 */
@Component
@ViewScoped
@ManagedBean(name = "userController")
public class UserController implements Serializable {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(UserController.class);

	private static final String codeRole = "ROLE_AGENT";
	private static final String DescRole = "ROLE FOR SIMPLE AGENT";

	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private ProfileService profileService;
	private String roleUser = "";

	private User user = new User();
	private DataModel<User> dataModelAllUser = new ListDataModel<User>();

	/**
	 * @see this method was implemented to save a new user
	 */
	public void register() {
		try {
			Role role = new Role();
			Profile profile = new Profile();
			/* save profile */
			profileService.addProfile(profile);
			user.setProfile(profile);
			profile.setUser(user);
			/* set user to enabled */
			user.setEnabled(1);
			/*
			 * in case of ADMIN want to save a new user with predefined Role
			 */
			if (roleUser.length() == 0) {
				role.setCode(codeRole);
				role.setLabel(DescRole);
			} else {
				role.setCode(roleUser);
			}
			/* save user */
			userService.addUser(user);
			List<Role> roles = new ArrayList<Role>();
			roles.add(role);
			user.setRoles(roles);
			role.setUser(user);
			/* save role */
			roleService.addRole(role);
			user = new User();
			role = new Role();
		} catch (Exception e) {
			logger.info("user register");
		}

	}

	/**
	 * @see Authentication using the spring Security
	 * @return String
	 */
	public String doLogin() throws IOException, ServletException {
		ExternalContext context = FacesContext.getCurrentInstance()
				.getExternalContext();
		RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
				.getRequestDispatcher("/j_spring_security_check");
		dispatcher.forward((ServletRequest) context.getRequest(),
				(ServletResponse) context.getResponse());
		FacesContext.getCurrentInstance().responseComplete();
		user = new User();
		return null;
	}

	/**
	 * @see getter for user
	 * @return user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user
	 * @see setter for user
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @see getter for role
	 * @return string
	 */
	public String getRoleUser() {
		return roleUser;
	}

	/**
	 * @param role
	 * @see setter for role
	 */
	public void setRoleUser(String roleUser) {
		this.roleUser = roleUser;
	}

	/**
	 * @see getter for all user list
	 * @return DataModel<User>
	 */
	public DataModel<User> getDataModelAllUser() {
		try {
			dataModelAllUser.setWrappedData(userService.getAllUser());
		} catch (Exception exception) {
			logger.info("getDataModelAllUser");
		}
		return dataModelAllUser;
	}

	/**
	 * @param DataModel
	 *            <User>
	 * @see setter for all user list
	 */
	public void setDataModelAllUser(DataModel<User> dataModelAllUser) {
		this.dataModelAllUser = dataModelAllUser;
	}

}
