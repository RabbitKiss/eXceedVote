package testDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import exceedvote.domain.Question;

public class testDAO {
	private EntityManagerFactory emf;
	private static EntityManager em;
	
	public testDAO(){
		emf = Persistence.createEntityManagerFactory("exceedVote");
		em = emf.createEntityManager();		
	}
	
	public static void main(String[] args){
		 Query query = em.createQuery("SELECT t from BallotType t where t.type = 'BallotType'");
		 List<Question> questions = query.getResultList();
		 query = em.createQuery("SELECT t from ScoreType t where t.type = 'ScoreType'");
		 questions.addAll(query.getResultList());
		 for( Question q : questions){
			 System.out.println(q.getInstruction());
		 }
	}
}
