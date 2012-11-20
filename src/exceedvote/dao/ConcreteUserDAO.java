package exceedvote.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import exceedvote.domain.Question;
import exceedvote.domain.User;

public class ConcreteUserDAO implements DAO{

//	public static ConcreteUserDAO concreteUserDAO;
	private static EntityManager em;	
	
	public ConcreteUserDAO(EntityManager em){
		this.em = em;
	}
	
//	public static DAO getInstance(){
//		if(concreteUserDAO == null)
//			concreteUserDAO = new ConcreteUserDAO(em);
//		return concreteUserDAO;
//	}
	@Override
	public void save(Object o) {
		em.getTransaction().begin();
		em.persist((User)o);
		em.getTransaction().commit();
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		User user = (User)o;
		User tmp = em.find(User.class,user.getId());
		em.getTransaction().begin();
		em.remove(tmp);
		em.getTransaction().commit();				
	}

	public List<User> findAll(){
		Query query = em.createQuery("SELECT q FROM User q");
		List<User> users = query.getResultList();
		return users;
	}
	
	public User find(String id,String password){		
		Query query = em.createQuery("select u from User u where u.userId = :id and u.userPassword = :password");		
		query.setParameter("id", id);
		query.setParameter("password", password);		
		List<User> listUser = query.getResultList();
		if(listUser.size()!=0)
			return listUser.get(0);
		return null;
	}
}
