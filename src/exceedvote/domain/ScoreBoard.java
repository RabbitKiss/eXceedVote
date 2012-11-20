package exceedvote.domain;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

import exceedvote.dao.ConcreteQuestionDAO;
import exceedvote.dao.ConcreteScoreDAO;
import exceedvote.dao.ConcreteTeamDAO;
import exceedvote.dao.ConcreteUserDAO;
import exceedvote.dao.DaoFactory;

/**
 * Point board like a semi database
 * 
 * @author Tachin
 */
public class ScoreBoard
{ 
	private static Logger log = Logger.getLogger( ScoreBoard.class );
    private static ScoreBoard instance = null;
    
    //add
    private ConcreteQuestionDAO questionDAO;
    private ConcreteScoreDAO scoreDAO;
//    private ConcreteTeamDAO teamDAO;
//    private ConcreteUserDAO userDAO;
    
    /**
     *  
     * @return ScoreBoard
     */
    public static ScoreBoard getInstance() 
    {
        if (instance == null) 
        {
            instance = new ScoreBoard();
        }
 
        return instance;
    }
    
    /**
     * private Constructor to make singleton 
     */
    private ScoreBoard()
    {
    	questionDAO = (ConcreteQuestionDAO) DaoFactory.getInstance().createDAO("questionDAO");
    	scoreDAO = (ConcreteScoreDAO) DaoFactory.getInstance().createDAO("scoreDAO");
//    	teamDAO = (ConcreteTeamDAO) DaoFactory.getInstance().createDAO("teamDAO");
//    	userDAO = (ConcreteUserDAO) DaoFactory.getInstance().createDAO("userDAO");
    }
    
    /**
     * getScore
     * @param questionIndex
     * @return List<Integer>
     */
    public List<Integer> getScore(int questionIndex)
    {
    	//TODO
//        List<Integer> sc = scoreDAO.
        return null;
    }
    
    
    /**
     * addScore
     * @param questionIndex
     * @param point
     */
    public void addScore(int questionIndex,List<Integer> point)
    {
        //log4j add
    	StringBuilder sb = new StringBuilder();
    	sb.append(Login.getId()+": "+questionIndex+" ");
    	for(int i=0;i<point.size();i++){
    		sb.append(point.get(i)+" ");
    	}
    	log.fatal(sb);
    }
    
    //add
//    public void update(int questionIndex,List<Integer> point){
//    	DaoFactory.getInstance().createDAO("scoreDAO").update(o);
//    }    
    
    public List<Score> getChoice(int userId){
    	return scoreDAO.find(userId);
    }
    
    public void vote(Score score){
    	scoreDAO.update(score);
    }
}
