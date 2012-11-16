package exceedvote.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DaoFactory {
	public static DaoFactory df;
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
	
	public abstract  DAO createDAO(String type);
}
