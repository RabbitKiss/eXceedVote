package exceedvote.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import exceedvote.domain.BallotType;
import exceedvote.domain.Choice;
import exceedvote.domain.Question;

public class ConcreteQuestionDAO implements DAO{
	
//	public static ConcreteQuestionDAO concreteQuestionDAO;
//	private EntityManagerFactory factory;
	private static EntityManager em;
//	EntityTransaction tx;//?

	public ConcreteQuestionDAO(EntityManager em){
		this.em = em;
//		factory = Persistence.createEntityManagerFactory("exceedVote");
//		em = factory.createEntityManager();
//		tx = em.getTransaction();//?
//		this.em = em;
	}

	// have to fix
//	public static ConcreteQuestionDAO getInstance(){
//		if(concreteQuestionDAO==null)
//			concreteQuestionDAO = new ConcreteQuestionDAO(em);
//		return concreteQuestionDAO;
//	}
	
//	public void setEntityManager(EntityManager em){
//		this.em  = em;
//	}

//	public List<Question> getQuestion(){
//		 Query query = em.createQuery("SELECT t from BallotType t where t.type = 'BallotType'");
//		 List<Question> questions = query.getResultList();
//		 query = em.createQuery("SELECT t from ScoreType t where t.type = 'ScoreType'");
//		 questions.addAll(query.getResultList());
//		 return questions;
//	}

	@Override
	public void save(Object o) {
 
	}

	

//	@Override
//	public Choice getChoice() {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub
		
	}
	
	public List<Question> find() {
		 Query query = em.createQuery("SELECT t from BallotType t where t.type = 'BallotType'");
		 List<Question> questions = query.getResultList();
		 query = em.createQuery("SELECT t from ScoreType t where t.type = 'ScoreType'");
		 questions.addAll(query.getResultList());
		 return questions;
	}
}