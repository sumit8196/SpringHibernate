package com.commons;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.validator.internal.engine.constraintvalidation.HibernateConstraintValidatorInitializationContextImpl;

import com.commons.utils.SessionUtils;
import com.org.entity.Student;

public abstract class GenericDAO<Dto> {
	Logger log = Logger.getLogger(this.getClass());
	private Class<Dto> persistenceClass;

	public GenericDAO(Class<Dto> persistenceClass) {
		//super();
		this.persistenceClass = persistenceClass;
		//this.persistenceClass = Dto;
	}

	public Class<Dto> getPersistenceClass() {
		return persistenceClass;
	}

	public Dto save(Dto dto) {
		Session session = SessionUtils.getSession();

		System.out.println("Transaction start: for:.... " + dto);

		// start transaction
		session.beginTransaction();

		// save the dto object
		session.save(dto);

		// commit the transaction
		session.getTransaction().commit();
		System.out.println("Sucessfully saved the data for:....." + dto);

		SessionUtils.closeSession(session, true);
		return dto;

	}

	public Dto save(Dto dto, Session session) {
		boolean isLocalSesion = false;
		if (session == null || !session.isOpen()) {
			session = SessionUtils.getSession();
			isLocalSesion = true;
		}
		System.out.println("Transaction start: for:.... " + dto);

		// start transaction
		session.beginTransaction();

		// save the dto object
		session.save(dto);

		// commit the transaction
		session.getTransaction().commit();
		System.out.println("Sucessfully saved the data for:....." + dto);

		SessionUtils.closeSession(session, isLocalSesion);

		return dto;

	}
	public Dto findNow(int hId,Session session) {
		boolean isLocalSesion = false;
		Student student=null;
		Dto dto=null;
		if (session == null || !session.isOpen()) {
			session = SessionUtils.getSession();
			isLocalSesion = true;
		}
		log.debug("Method start for fetching data at findNow for id :"+hId);

		dto=(Dto) session.get(persistenceClass,hId);

		log.info("successfully fetched the data for id :"+hId);

		SessionUtils.closeSession(session, isLocalSesion);

		return dto;
	}
}
