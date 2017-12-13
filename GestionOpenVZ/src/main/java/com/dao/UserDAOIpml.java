package com.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

/**
 * @author Mohamed
 *
 */
@Repository
@Transactional
public class UserDAOIpml implements UserDAO, Serializable {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(UserDAOIpml.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addUser(User user) {
		try {
			sessionFactory.getCurrentSession().persist(user);

		} catch (Exception e) {
			logger.info("addUser");
		}

	}

	@Override
	public void deleteUser(int idUser) {
		try {
			sessionFactory.getCurrentSession().delete(findUser(idUser));

		} catch (Exception e) {
			logger.info("deleteUser");
		}

	}

	@Override
	public User findUser(int idUser) {
		User result = new User();
		try {

			result = (User) sessionFactory.getCurrentSession().get(User.class,
					idUser);

		} catch (Exception e) {
			logger.info("findUser");
		}
		return result;
	}

	@Override
	public User findUserByLogin(String login) {
		User user = null;
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"from User where login = :login ");
			query.setParameter("login", login);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			logger.info("findUserByLogin");
		}
		return user;
	}

	@Override
	public void updateUser(User user) {
		try {
			sessionFactory.getCurrentSession().update(user);

		} catch (Exception e) {
			logger.info("updateUser");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getAllUser() {
		List<User> list = null;
		try {
			list = (List<User>) sessionFactory.getCurrentSession()
					.createQuery("from User").list();
		} catch (Exception e) {
			logger.info("getAllUser");
		}
		return list;
	}

}
