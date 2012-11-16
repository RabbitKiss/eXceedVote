package exceedvote.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.apache.derby.iapi.store.raw.Transaction;

import exceedvote.domain.Choice;
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
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist((User)o);
		tx.commit();
		//DaoFactory.getInstance().createDAO("loginDAO").save(o);
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
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
