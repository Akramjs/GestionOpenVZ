package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ContainerDAO;
import com.model.Container;

@Service
public class ContainerServiceImpl implements ContainerService {

	@Autowired
	private ContainerDAO containerDAO;

	@Override
	public void addContainer(Container container) {
		containerDAO.addContainer(container);
	}

	@Override
	public Container findContainerById(int id) {
		return containerDAO.findContainerById(id);
	}

	@Override
	public void updateContainer(Container container) {
		containerDAO.updateContainer(container);
	}

	@Override
	public List<Container> getAllContainers() {
		return containerDAO.getAllContainers();
	}

	@Override
	public void deleteContainer(Container container) {
		containerDAO.deleteContainer(container);
	}

}
