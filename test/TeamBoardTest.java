package exceedvote.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import exceedvote.domain.TeamBoard;

public class TeamBoardTest {
	TeamBoard teamBoard;
	List<String> result = new ArrayList<String>();
	public TeamBoardTest(){
		teamBoard = new TeamBoard();		
		result = new ArrayList<String>();		
		result.add("Rabbit Kiss");
		result.add("LATE");
		result.add("Air");
		result.add("POS");
		result.add("JACS");
	}
	
	@Test
	public void testGetTeamName() {
		assert(teamBoard.getTeamName().toString().equals(result.toString()));
	}

}
