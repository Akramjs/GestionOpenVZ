package com.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.Container;

@Repository
@Transactional
public class ContainerDAOImpl implements ContainerDAO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	final static Logger logger = Logger.getLogger(ContainerDAOImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addContainer(Container container) {
		try {
			sessionFactory.getCurrentSession().persist(container);
		} catch (Exception e) {
			logger.info("addContainer");
		}

	}

	@Override
	public Container findContainerById(int id) {
		Container container = null;
		try {
			container = (Container) sessionFactory.getCurrentSession().get(
					Container.class, id);
		} catch (Exception e) {
			logger.info("findContainerById");
		}
		return container;

	}

	@Override
	public void updateContainer(Container container) {
		try {
			sessionFactory.getCurrentSession().update(container);
		} catch (Exception e) {
			logger.info("updateContainer");
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Container> getAllContainers() {
		List<Container> list = null;
		try {
			list = (List<Container>) sessionFactory.getCurrentSession()
					.createQuery("from Container").list();
		} catch (Exception exception) {
			logger.info("getAllContainers");
		}
		return list;
	}

	@Override
	public void deleteContainer(Container container) {
		try {
			Query query = sessionFactory.getCurrentSession().createQuery(
					"delete Container where idContainer = :ID");
			query.setParameter("ID", container.getIdContainer())
					.executeUpdate();
		} catch (Exception exception) {
			logger.info("deleteContainer");
		}

	}

}
