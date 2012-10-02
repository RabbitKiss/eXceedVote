package exceedvote.voteprocess;

import java.util.List;

public class Controller {
	private VoteChart voteChart;
	private TeamBoard teamBoard;
	private Login login;
	private ScoreBoard scoreBoard;
	
	public Controller(){
		voteChart = new VoteChart();
		login = new Login();
		teamBoard = new TeamBoard();
		scoreBoard = ScoreBoard.getInstance();
	}
	
	public boolean login(String id, String password){  return login.verify(id,password); }
	
	public List<String> getTeam(){	return teamBoard.getTeamName(); }
	
	//change the name of method from "getQuestion" to "getInstruction"
	public List<String> getInstruction() { return voteChart.getInstruction(); }
	
	public String getQuestionType(int questionIndex){ return voteChart.getQuestionType(questionIndex); }
	
	// change name of method from "getScore" to "getChoice"
	public List<Integer> getChoice(int questionIndex){ return voteChart.getChoice(questionIndex); }
	
	public void vote(int questionIndex, List<Integer> point){ voteChart.vote(questionIndex,point); }
	
}
