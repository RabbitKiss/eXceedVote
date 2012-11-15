package exceedvote.dao;

public class ConcreteDaoFactory extends DaoFactory{
	
	private DAO dao;
	public ConcreteDaoFactory() {
	
	}

	@Override
	public DAO getDAO() {
		if(dao==null)
			dao = new ConcreteQuestionDAO(super.em);
		return dao;
	}
	
}
