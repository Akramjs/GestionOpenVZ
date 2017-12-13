package com.service;

import com.model.Profile;

public interface ProfileService {

	void addProfile(Profile profile);

	Profile findProfileById(int id);
	
	void updateProfile(Profile profile);

}
