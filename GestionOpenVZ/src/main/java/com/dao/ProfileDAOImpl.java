package com.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Profile;

/**
 * @author Mohamed
 *
 */
@Repository
@Transactional
public class ProfileDAOImpl implements ProfileDAO, Serializable {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ProfileDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProfile(Profile profile) {
		try {
			sessionFactory.getCurrentSession().persist(profile);
		} catch (Exception e) {
			logger.info("addProfile");
		}

	}

	@Override
	public Profile findProfileById(int id) {
		Profile profile = null;
		try {
			profile = (Profile) sessionFactory.getCurrentSession().get(
					Profile.class, id);
		} catch (Exception e) {
			logger.info("findProfileById");
		}
		return profile;

	}

	@Override
	public void updateProfile(Profile profile) {
		try {
			sessionFactory.getCurrentSession().update(profile);
		} catch (Exception e) {
			logger.info("updateProfile");
		}

	}

}
