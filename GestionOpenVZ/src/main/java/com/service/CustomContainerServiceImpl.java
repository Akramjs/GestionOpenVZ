package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomContainerDAO;
import com.model.CustomContainer;
import com.model.User;

@Service
public class CustomContainerServiceImpl implements CustomContainerService {

	@Autowired
	private CustomContainerDAO customContainerDao;

	@Override
	public void addCustomContainer(CustomContainer customContainer) {
		customContainerDao.addCustomContainer(customContainer);
	}

	@Override
	public CustomContainer findCustomContainerById(int id) {
		return customContainerDao.findCustomContainerById(id);
	}

	@Override
	public void updateCustomContainer(CustomContainer customContainer) {
		customContainerDao.updateCustomContainer(customContainer);

	}

	@Override
	public List<CustomContainer> getDistinctCustomContainers(User user) {
		return customContainerDao.getDistinctCustomContainers(user);
	}

	@Override
	public void deleteCustomContainer(CustomContainer customContainer) {
		customContainerDao.deleteCustomContainer(customContainer);
	}

}
