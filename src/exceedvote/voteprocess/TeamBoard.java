package exceedvote.voteprocess;

import java.util.ArrayList;
import java.util.List;

/**
 * This JUnit test for class TeamBoard.
 * @author Jaktip Yordsri
 * 
 */
public class TeamBoard {
	private List<String> names;
	
	/** constuctor */
	public TeamBoard(){
		names = new ArrayList<String>();		
		names.add("Rabbit Kiss");
		names.add("LATE");
		names.add("Air");
		names.add("POS");
		names.add("JACS");
	}
	/**
	 * Method used to return all of the team's name.
	 * @return list of team's name.
	 */
	public List<String> getTeamName(){ return names; }
}
