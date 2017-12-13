package com.dao;

import java.util.List;

import com.model.CustomContainer;
import com.model.User;

public interface CustomContainerDAO {

	void addCustomContainer(CustomContainer customContainer);

	CustomContainer findCustomContainerById(int id);

	void updateCustomContainer(CustomContainer customContainer);

	void deleteCustomContainer(CustomContainer customContainer);

	List<CustomContainer> getDistinctCustomContainers(User user);

}
