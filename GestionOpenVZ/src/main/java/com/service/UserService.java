package com.service;

import java.util.List;

import com.model.User;

public interface UserService {

	void addUser(User user);

	void deleteUser(int idUser);

	User findUser(int idUser);

	User findUserByLogin(String login);

	void updateUser(User user);

	List<User> getAllUser();

}
