package exceedvote.voteprocess;

import java.util.ArrayList;
import java.util.List;

public class TeamBoard {
	private List<String> names;
	
	public TeamBoard(){
		names = new ArrayList<String>();		
		names.add("Rabbit Kiss");
		names.add("LATE");
		names.add("Air");
		names.add("POS");
		names.add("JACS");
	}
	
	public List<String> getTeamName(){ return names; }
}
