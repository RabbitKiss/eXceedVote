package exceedvote.register;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.eclipse.persistence.internal.queries.EntityFetchGroup;

import exceedvote.dao.ConcreteScoreDAO;
import exceedvote.dao.ConcreteTeamDAO;
import exceedvote.dao.ConcreteUserDAO;
import exceedvote.dao.DaoFactory;
import exceedvote.domain.Score;
import exceedvote.domain.User;

public class Register {
	
	public static Register register;
	private ConcreteUserDAO userDAO;
	private ConcreteScoreDAO scoreDAO;
	private ConcreteTeamDAO teamDAO;
	
	public Register(){		
		userDAO = (ConcreteUserDAO) DaoFactory.getInstance().createDAO("userDAO");
		scoreDAO = (ConcreteScoreDAO) DaoFactory.getInstance().createDAO("scoreDAO");
		teamDAO = (ConcreteTeamDAO) DaoFactory.getInstance().createDAO("teamDAO");
	}

	public static Register getInstance(){
		if(register==null)
			register = new Register();
		return register;
	}
	
	public void createAccount(String id,String password,String type){
		User user = new User();
		user.setUserId(id);
		user.setUserPassword(password);
		user.setUserType(type);		
		userDAO.save(user);

		for(int i=1;i<=teamDAO.count();i++){
			Score score = new Score();
			score.setPoint(null);
			score.setUserId(user.getId());
			score.setQuestionIndex(i);
			scoreDAO.save(score);
		}
	}
}
