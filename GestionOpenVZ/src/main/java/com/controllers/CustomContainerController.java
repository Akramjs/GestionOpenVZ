package com.controllers;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.model.CustomContainer;
import com.model.User;
import com.security.Session;
import com.service.CustomContainerService;
import com.service.UserService;

/**
 * @author Mohamed
 * 
 */
@Component
@ManagedBean
@ViewScoped
public class CustomContainerController implements Serializable {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger
			.getLogger(CustomContainerController.class);

	@Autowired
	private CustomContainerService customContainerService;
	@Autowired
	private UserService userService;
	private User user = new User();
	private Session session = new Session();
	private CustomContainer customContainer = new CustomContainer();
	/* all Custom Containers except defined user Custom Containers */
	private DataModel<CustomContainer> dataModelUserCustomContainer = new ListDataModel<CustomContainer>();
	private DataModel<CustomContainer> dataModelDistinctCustomContainer = new ListDataModel<CustomContainer>();
	/* selected row from Data table distinct Custom Container */
	private CustomContainer selectedDisCusCon;

	/**
	 * @see init method
	 */
	@PostConstruct
	public void init() {
		try {

		} catch (Exception exception) {
			logger.info("init method");
		}
	}

	/**
	 * @see create new custom container
	 */
	public void createCustomContainer() {
		try {
			/* set to offline mode */
			customContainer.setState("Offline");
			/* set to not activated */
			customContainer.setEnabled("Not Yet");
			/* get current user */
			user = userService.findUserByLogin(session.getCurrentUserName());
			customContainer.setUser(user);
			customContainerService.addCustomContainer(customContainer);
			user.getCustomContainers().add(customContainer);
			userService.updateUser(user);
			customContainer = new CustomContainer();

		} catch (Exception e) {
			logger.info("createCustomContainer");
		}

	}

	/**
	 * @param customContainer
	 * @see delete custom container
	 */
	public void deleteCustomContainer(CustomContainer customContainer) {
		try {
			customContainerService.deleteCustomContainer(customContainer);
		} catch (Exception e) {
			logger.info("deleteCustomContainer");
		}

	}

	/**
	 * @param customContainer
	 * @param action
	 * @see update custom container
	 */
	public void updateCustomContainer(CustomContainer customContainer,
			String action) {
		try {
			switch (action) {
			case "Start":
				customContainer.setState("Online");
				break;
			case "Stop":
				customContainer.setState("Offline");
				break;
			case "Accept":
				customContainer.setEnabled("Accepted");
				break;
			case "Reject":
				customContainer.setEnabled("Rejected");
				break;
			default:
				break;
			}
			customContainerService.updateCustomContainer(customContainer);
		} catch (Exception e) {
			logger.info("updateCustomContainer");
		}

	}

	/**
	 * @see getter for {@link User}
	 * @return {@link User}
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param User
	 * @see setter for {@link User}
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @see getter for CustomContainer
	 * @return {@link CustomContainer}
	 */
	public CustomContainer getCustomContainer() {
		return customContainer;
	}

	/**
	 * @param CustomContainer
	 * @see setter for {@link CustomContainer}
	 */
	public void setCustomContainer(CustomContainer customContainer) {
		this.customContainer = customContainer;
	}

	/**
	 * @see get all user's CustomContainers
	 * @return {@link DataModel}
	 */
	public DataModel<CustomContainer> getDataModelUserCustomContainer() {
		try {
			user = userService.findUserByLogin(session.getCurrentUserName());
			dataModelUserCustomContainer.setWrappedData(user
					.getCustomContainers());
		} catch (Exception exception) {
			logger.info("getDataModelUserCustomContainer");
		}
		return dataModelUserCustomContainer;
	}

	/**
	 * @param DataModel
	 *            <CustomContainer>
	 * @see set all user CustomContainers
	 */
	public void setDataModelUserCustomContainer(
			DataModel<CustomContainer> dataModelUserCustomContainer) {
		this.dataModelUserCustomContainer = dataModelUserCustomContainer;
	}

	/**
	 * @see get all CustomContainers except current user
	 * @return {@link DataModel}
	 */
	public DataModel<CustomContainer> getDataModelDistinctCustomContainer() {
		try {
			dataModelDistinctCustomContainer
					.setWrappedData(customContainerService
							.getDistinctCustomContainers(user));
		} catch (Exception exception) {
			logger.info("getDataModelDistinctCustomContainer");
		}
		return dataModelDistinctCustomContainer;
	}

	/**
	 * @param DataModel
	 *            <CustomContainer>
	 * @see set all CustomContainers except current user
	 */
	public void setDataModelDistinctCustomContainer(
			DataModel<CustomContainer> dataModelDistinctCustomContainer) {
		this.dataModelDistinctCustomContainer = dataModelDistinctCustomContainer;
	}

	/**
	 * @see get selected Custom Container from data table
	 * @return {@link CustomContainer}
	 */
	public CustomContainer getSelectedDisCusCon() {
		return selectedDisCusCon;
	}

	/**
	 * @param CustomContainer
	 * @see set selected Custom Container from data table
	 */
	public void setSelectedDisCusCon(CustomContainer selectedDisCusCon) {
		this.selectedDisCusCon = selectedDisCusCon;
	}

}
