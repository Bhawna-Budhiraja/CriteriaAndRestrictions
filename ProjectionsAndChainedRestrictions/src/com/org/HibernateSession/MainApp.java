package com.org.HibernateSession;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SessionFactory sessionFactory=new AnnotationConfiguration().configure().buildSessionFactory();
		Session session=sessionFactory.openSession();

		session.beginTransaction();
		Criteria criteria=session.createCriteria(Student.class);
		criteria.add(Restrictions.or(Restrictions.between("id",2 ,5 ),Restrictions.between("id",7 ,12 )));
		List<Student> student=(List<Student>)criteria.list();
		session.getTransaction().commit();
		session.close();

		for(Student s:student)
		{
			System.out.println(s.getName());
		}
	}

}
