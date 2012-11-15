package exceedvote.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DaoFactory {
	private static DaoFactory df;
	public static ConcreteQuestionDAO concreteQuestionDAO;
	private EntityManagerFactory factory;
	protected EntityManager em;
	
	public DaoFactory(){
		factory = Persistence.createEntityManagerFactory("exceedVote");
		em = factory.createEntityManager();
	}
	
	public static DaoFactory getInstance(){
		if(df==null)
			df = new ConcreteDaoFactory();
		return df;
	}
	
	public abstract DAO getDAO();
}
