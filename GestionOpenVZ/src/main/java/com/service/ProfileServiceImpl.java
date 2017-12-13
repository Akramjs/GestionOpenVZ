package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ProfileDAO;
import com.model.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	@Autowired
	private ProfileDAO profileDAO;

	@Override
	public void addProfile(Profile profile) {
		profileDAO.addProfile(profile);

	}

	@Override
	public Profile findProfileById(int id) {
		return profileDAO.findProfileById(id);
	}

	@Override
	public void updateProfile(Profile profile) {
		profileDAO.updateProfile(profile);
	}

}
