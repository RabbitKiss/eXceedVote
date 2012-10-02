package exceedvote.voteprocess;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.log4j.Level;
/**
 * Point board like a semi database
 * 
 * @author Tachin
 * @version 1.0.0.0.0.0.0.0.0.0.0.0.0.0.1a
 */


public class ScoreBoard
{ 
	private static Logger log = Logger.getLogger( ScoreBoard.class );
    private static ScoreBoard instance = null;
    
    public static ScoreBoard getInstance() 
    {
        if (instance == null) 
        {
            instance = new ScoreBoard();
        }
 
        return instance;
    }
    
    private ScoreBoard()
    {
    }
    
    public List<Integer> getScore(int questionIndex)
    {
        List<Integer> sc = new ArrayList<Integer>();
        return sc;
    }
    
    public void addScore(int questionIndex,List<Integer> point)
    {
        //log4j add
    	StringBuilder sb = new StringBuilder();
    	sb.append(Login.getId()+": "+questionIndex+" ");
    	for(int i=0;i<point.size();i++){
    		sb.append(point.get(i)+" ");
    	}
    	log.fatal(sb);
    	
//    	Iterator<Integer> myListIterator = point.iterator(); 
//    	while (myListIterator.hasNext())
//    	{
//    		Integer coord = myListIterator.next();
//    		log.fatal(questionIndex+");
//    		
//    	}
    	
    }
}