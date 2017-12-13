package com.dao;

import java.io.Serializable;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Role;

/**
 * @author Akram
 *
 */
@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO, Serializable {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(RoleDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addRole(Role role) {
		try {
			sessionFactory.getCurrentSession().persist(role);
		} catch (Exception e) {
			logger.info("addRole");
		}

	}

}
