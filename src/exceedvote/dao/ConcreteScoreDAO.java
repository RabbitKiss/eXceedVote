package exceedvote.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import exceedvote.domain.Score;

public class ConcreteScoreDAO implements DAO{
	EntityManager em;
	
	public ConcreteScoreDAO(EntityManager em){
		this.em = em;
	}

	@Override
	public void save(Object o) {
		//TODO
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist((Score)o);
		tx.commit();
	}

	@Override
	public void update(Object o) {
		Score score = (Score)o;		
//		System.out.println("user : "+userId+" question : "+questionIndex+" point : "+point);
		Query query = em.createQuery("UPDATE Score s SET s.point = :point WHERE s.userId = :userId and s.questionIndex = :questionIndex");
		query.setParameter("point", score.getPoint());
		query.setParameter("userId", score.getUserId());
		query.setParameter("questionIndex", score.getQuestionIndex());
		em.getTransaction().begin();
		query.executeUpdate();
		em.getTransaction().commit();
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub		
	}

	public List<Score> find(int id){
		
		Query query = em.createQuery("SELECT s FROM Score s WHERE s.userId = :id");
		query.setParameter("id", id);
		List<Score> scores = query.getResultList();
		return scores;		
	}	
}
