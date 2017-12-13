package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDAO;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);

	}

	@Override
	public void deleteUser(int idUser) {
		userDAO.deleteUser(idUser);

	}

	@Override
	public User findUser(int idUser) {

		return userDAO.findUser(idUser);
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public User findUserByLogin(String login) {

		return userDAO.findUserByLogin(login);
	}

	@Override
	public void updateUser(User user) {

		userDAO.updateUser(user);
	}

	@Override
	public List<User> getAllUser() {

		return userDAO.getAllUser();
	}

}
