package exceedvote.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import exceedvote.domain.BothType;
import exceedvote.domain.Question;
import exceedvote.domain.User;

public class ConcreteQuestionDAO implements DAO{
	
	private static EntityManager em;

	public ConcreteQuestionDAO(EntityManager em){
		this.em = em;
	}

	@Override
	public void save(Object o) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist((Question)o);
		tx.commit();
	}	

	@Override
	public void update(Object o) {
		BothType bothType = (BothType)o;
		Query query = em.createQuery("UPDATE BothType q SET q.question = :question , q.type = :type WHERE q.id = :id");
		query.setParameter("question", bothType.getQuestion());
		query.setParameter("type", bothType.getType());
		query.setParameter("id", bothType.getId());		
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();	
	}

	@Override
	public void delete(Object o) {
		BothType bothType = (BothType)o;
		BothType tmp = em.find(BothType.class,bothType.getId());
		em.getTransaction().begin();
		em.remove(tmp);
		em.getTransaction().commit();				
	}
	
	public List<Question> find() {
		 Query query = em.createQuery("SELECT t from BothType t where t.type = 'BallotType'");
		 List<Question> questions = query.getResultList();
		 query = em.createQuery("SELECT t from BothType t where t.type = 'ScoreType'");
		 questions.addAll(query.getResultList());	
		 return questions;
	}
	
	public int count(){
		Query query = em.createQuery("SELECT count(t) FROM BothType t");
		Number numQuestion = (Number) query.getSingleResult();
		return numQuestion.intValue();
	}
}