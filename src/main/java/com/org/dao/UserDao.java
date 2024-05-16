package com.org.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.org.dto.User;

public class UserDao {
	
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("ayush");
	
	EntityManager em = emf.createEntityManager();
	
	EntityTransaction et = em.getTransaction();
	
	public void saveAndUpdateUser(User user) {
		
		et.begin();
		em.merge(user);
		et.commit();
	}
	
	public User fetchUserById(int id){
		
		return  em.find(User.class, id);
		
	}
	
	public List<User> fetchAllUser(){
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("ayush");
		
		EntityManager em = emf.createEntityManager();
		
		Query query = em.createQuery("select users from user users");
		
		List<User> users=query.getResultList();
		
		for(User u: users) {
			u.getId();
			u.getAge();
			u.getEmail();
			u.getName();
			u.getMobile();
		
		}
		return users;
		
	}
	public User fetchUserByEmaildAndPassword(String email, String password) {
		
		Query query = em.createQuery("select users from user users where users.email=?1 and users.password=?2");
		
		query.setParameter(1, email);
		query.setParameter(2, password);
		
		List<User> list= query.getResultList();
		
		return null;
		
		
		
		
	}

}
