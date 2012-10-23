package exceedvote.controller;

import java.util.List;

import javax.security.sasl.AuthorizeCallback;

import exceedvote.domain.Login;
import exceedvote.domain.ScoreBoard;
import exceedvote.domain.TeamBoard;
import exceedvote.domain.VoteChart;
/**
 * This class is used to be like a medium between logical part and representative part.
 * @author Jaktip Yordsri
 * 
 */
public class VoteController {
	private VoteChart voteChart;
	private TeamBoard teamBoard;
	private Login login;
	private ScoreBoard scoreBoard;
	
	/** Constructor **/
	public VoteController(){
		voteChart = new VoteChart();
		login = new Login();
		teamBoard = new TeamBoard();
		scoreBoard = ScoreBoard.getInstance();
	}
	/**
	 * Method used to verify the authorization.
	 * @param id as the Identification of voter.
	 * @param password as the password of voter.
	 * @return true, if the authorization of voter is available, false if not.
	 */
	public boolean login(String id, String password){  return login.verify(id,password); }
	
	/**
	 * Method used to get the name of each team.
	 * @return list of name of the whole teams.
	 */
	public List<String> getTeam(){	return teamBoard.getTeamName(); }
	
	/**
	 * Method that return the list of string of the instruction of each question.
	 * @return List of instruction.
	 */
	public List<String> getInstruction() { return voteChart.getInstruction(); }
	
	/**
	 * Method that return the string that indicate the type of question.
	 * @param questionIndex as the index of question.
	 * @return Type of question.
	 */
	public Class getQuestionType(int questionIndex){ return voteChart.getQuestionType(questionIndex); }
	
	/**
	 * Method that return the list of integer of the old point of each question.
	 * @param questionIndex as the index of question.
	 * @return List of the old choice of this question.
	 */
	public List<Integer> getChoice(int questionIndex){ return voteChart.getChoice(questionIndex); }
	
	/**
	 * Method that make a vote from the vote of voter. 
	 * @param questionIndex as the index of question.
	 * @param point as the list of point of this question.
	 */
	public void vote(int questionIndex, List<Integer> point){ voteChart.vote(questionIndex,point); }
	
}
