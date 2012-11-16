package exceedvote.dao;

import exceedvote.domain.User;

public class ConcreteDaoFactory extends DaoFactory{
	
	private ConcreteQuestionDAO concreteQuestionDAO;
	private ConcreteUserDAO concreteUserDAO;
	private ConcreteScoreDAO concreteScoreDAO;
	
	public ConcreteDaoFactory() {
	
	}

	@Override
	public DAO createDAO(String type) {
		if(type.equals("questionDAO")){
			if(concreteQuestionDAO==null)
				concreteQuestionDAO = new ConcreteQuestionDAO(em);
			return concreteQuestionDAO;
		}
		else if(type.equals("loginDAO")){
			if(concreteUserDAO==null)
				concreteUserDAO = new ConcreteUserDAO(em);
			return concreteUserDAO;
		}
		else if(type.equals("scoreDAO")){
			if(concreteScoreDAO==null)
				concreteScoreDAO = new ConcreteScoreDAO(em);
			return concreteScoreDAO;
		}
		return null;
	}	
}
