package com.hcl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AnnotationConfiguration configuration = new AnnotationConfiguration().configure();

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Session session = sessionFactory.openSession();

		Transaction transaction = session.beginTransaction();
		Student s1 = new Student();
		s1.setName("prassu");
        s1.setAge(345);
        session.persist(s1);
        transaction.commit();
        session.close();
	}

}
