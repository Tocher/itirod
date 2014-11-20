package com.sprhib.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Users;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Autowired
	SessionFactory sessionFactory;

	Session session = null;
	Transaction tx = null;

	@Override
	public Users findByUserName(String username) {
		session = sessionFactory.openSession();
		tx = session.getTransaction();
		session.beginTransaction();
		Users user = (Users) session.load(Users.class, new String(username));
		tx.commit();
		return user;
	}

}
