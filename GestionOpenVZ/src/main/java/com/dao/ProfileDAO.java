package com.dao;

import com.model.Profile;

public interface ProfileDAO {

	void addProfile(Profile profile);

	Profile findProfileById(int id);

	void updateProfile(Profile profile);

}
