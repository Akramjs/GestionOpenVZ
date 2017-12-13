package com.dao;

import java.util.List;

import com.model.Container;

public interface ContainerDAO {

	void addContainer(Container container);

	Container findContainerById(int id);

	void updateContainer(Container container);

	void deleteContainer(Container container);

	List<Container> getAllContainers();

}
