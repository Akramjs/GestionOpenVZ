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

import com.model.Container;
import com.model.User;
import com.security.Session;
import com.service.ContainerService;
import com.service.UserService;

/**
 * @author Akram
 *
 */
@Component
@ManagedBean
@ViewScoped
public class ContainerController implements Serializable {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ContainerController.class);

	@Autowired
	private ContainerService containerService;
	@Autowired
	private UserService userService;

	private DataModel<Container> dataModelUserContainer = new ListDataModel<Container>();
	private DataModel<Container> dataModelAllContainer = new ListDataModel<Container>();
	private Container container = new Container();
	private Session session = new Session();
	private User user = new User();

	/**
	 * @see init method
	 */
	@PostConstruct
	public void init() {
		try {
			dataModelAllContainer.setWrappedData(containerService
					.getAllContainers());
		} catch (Exception exception) {
			logger.info("init method");
		}
	}

	/**
	 * @see create new Container
	 */
	public void createContainer() {
		try {
			user = userService.findUserByLogin(session.getCurrentUserName());
			container.setUser(user);
			containerService.addContainer(container);
			user.getContainers().add(container);
			userService.updateUser(user);
			container = new Container();
		} catch (Exception e) {
			logger.info("createContainer");
		}
	}

	/**
	 * @param Container
	 * @param action
	 * @see update Container
	 */
	public void updateContainer(Container container, String action) {
		try {
			switch (action) {
			case "Start":
				container.setState("Online");
				break;
			case "Stop":
				container.setState("Offline");
				break;
			default:
				break;
			}
			containerService.updateContainer(container);
		} catch (Exception e) {
			logger.info("updateContainer");
		}
	}

	/**
	 * @param Container
	 * @see delete Container
	 */
	public void deleteContainer(Container container) {
		try {
			containerService.deleteContainer(container);
		} catch (Exception e) {
			logger.info("deleteContainer");
		}
	}

	/**
	 * @see getter for Container
	 * @return {@link Container}
	 */
	public Container getContainer() {
		return container;
	}

	/**
	 * @param Container
	 * @see setter for Container
	 */
	public void setContainer(Container container) {
		this.container = container;
	}

	/**
	 * @see getter for user containers
	 * @return {@link DataModel}
	 */
	public DataModel<Container> getDataModelUserContainer() {
		try {
			user = userService.findUserByLogin(session.getCurrentUserName());
			dataModelUserContainer.setWrappedData(user.getContainers());
		} catch (Exception exception) {
			logger.info("getDataModelUserContainer");
		}
		return dataModelUserContainer;
	}

	/**
	 * @param DataModel
	 *            <Container>
	 * @see setter for user container
	 */
	public void setDataModelUserContainer(
			DataModel<Container> dataModelUserContainer) {
		this.dataModelUserContainer = dataModelUserContainer;
	}

	/**
	 * @see getter for all containers
	 * @return {@link DataModel}
	 */
	public DataModel<Container> getDataModelAllContainer() {
		return dataModelAllContainer;
	}

	/**
	 * @param DataModel
	 *            <Container>
	 * @see setter for all containers
	 */
	public void setDataModelAllContainer(
			DataModel<Container> dataModelAllContainer) {
		this.dataModelAllContainer = dataModelAllContainer;
	}

}
