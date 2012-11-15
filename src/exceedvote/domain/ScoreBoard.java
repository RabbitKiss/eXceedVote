package exceedvote.domain;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

/**
 * Point board like a semi database
 * 
 * @author Tachin
 */
public class ScoreBoard
{ 
	private static Logger log = Logger.getLogger( ScoreBoard.class );
    private static ScoreBoard instance = null;
    
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
    }
    
    /**
     * getScore
     * @param questionIndex
     * @return List<Integer>
     */
    public List<Integer> getScore(int questionIndex)
    {
        List<Integer> sc = new ArrayList<Integer>();
        return sc;
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
}
