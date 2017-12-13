package com.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.CustomContainer;
import com.model.User;

/**
 * @author Mohamed
 *
 */
@Repository
@Transactional
public class CustomContainerDAOImpl implements CustomContainerDAO, Serializable {

	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(CustomContainerDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addCustomContainer(CustomContainer customContainer) {
		try {
			sessionFactory.getCurrentSession().persist(customContainer);
		} catch (Exception e) {
			logger.info("addCustomContainer");
		}

	}

	@Override
	public CustomContainer findCustomContainerById(int id) {
		CustomContainer customContainer = null;
		try {
			customContainer = (CustomContainer) sessionFactory
					.getCurrentSession().get(CustomContainer.class, id);
		} catch (Exception e) {
			logger.info("findCustomContainerById");
		}
		return customContainer;
	}

	@Override
	public void updateCustomContainer(CustomContainer customContainer) {
		try {
			sessionFactory.getCurrentSession().update(customContainer);
		} catch (Exception e) {
			logger.info("updateCustomContainer");
		}

	}

	/* get all Custom Containers except defined user Custom Containers */
	@SuppressWarnings("unchecked")
	@Override
	public List<CustomContainer> getDistinctCustomContainers(User user) {
		List<CustomContainer> result = null;
		try {
			result = sessionFactory.getCurrentSession()
					.createQuery("from CustomContainer where user!=:user")
					.setParameter("user", user).list();

		} catch (Exception exception) {
			logger.info("getDistinctCustomContainers");
		}
		return result;
	}

	@Override
	public void deleteCustomContainer(CustomContainer customContainer) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"delete CustomContainer where idCustomContainer = :ID");
			query.setParameter("ID", customContainer.getIdCustomContainer())
					.executeUpdate();
		} catch (Exception exception) {
			logger.info("deleteCustomContainer");
		}
	}

}
