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
		// TODO Auto-generated method stub
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist((Score)o);
		tx.commit();
	}

	@Override
	public void update(Object o) {
		// TODO Auto-generated method stub
		Score score = (Score)o;
		
		String point = score.getPoint();
		int userId = score.getUserId();
		int questionIndex = score.getQuestionIndex();
		System.out.println("user : "+userId+" question : "+questionIndex+" point : "+point);
//		em.getTransaction().begin();
		Query query = em.createQuery("UPDATE Score s SET s.point = :point WHERE s.userId = :userId and s.questionIndex = :questionIndex");
		query.setParameter("point", point);
		query.setParameter("userId", userId);
		query.setParameter("questionIndex", questionIndex);
		em.getTransaction().begin();
//		em.merge(score);
		query.executeUpdate();
		em.getTransaction().commit();
		
		
		
//	    em.getTransaction().begin();
//	    Score sc = em.g
//	    sc.setPoint(point);
//	    em.getTransaction().commit();
	}

	@Override
	public void delete(Object o) {
		// TODO Auto-generated method stub		
	}

	public List<Score> find(int id){//,int questionIndex){
		
		Query query = em.createQuery("SELECT s FROM Score s WHERE s.userId = :id");// and s.questionIndex = :questionIndex");
		query.setParameter("id", id);
		List<Score> scores = query.getResultList();
		for(Score s : scores){
			List<Integer> tmp = s.getScorePoint();
			for(int i : tmp)
				System.out.print(i+" ");
			System.out.println("");
		}
		return scores;		
	}
	
}
