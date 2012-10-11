package exceedvote.voteprocess;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to receive the information of question.
 * Than, form the information, and send to the Controller class.
 * @author Jaktip Yordsri
 * 
 */

public class VoteChart {
	private List<Question> questions;
	
	/** constructor 
	 *	create the (temporary) questions.
	 */	
	public VoteChart(){
		String instructionQuestion;
		questions = new ArrayList<Question>();
		
		instructionQuestion = "Which team is the best technical team?";
		Question q = new BallotType(1,instructionQuestion);
		questions.add(q);
		
		instructionQuestion = "Which team is the best in coding?";
		q = new BallotType(2,instructionQuestion);
		questions.add(q);
		
		instructionQuestion = "Which team has the best user inteface?";
		q = new BallotType(3,instructionQuestion);
		questions.add(q);
		
		instructionQuestion = "Presentation score";
		q = new ScoreType(4,instructionQuestion);
		questions.add(q);
		
		instructionQuestion = "Beautifull user interface";
		q = new ScoreType(5,instructionQuestion);
		questions.add(q);
		
		instructionQuestion = "Team work";
		q = new ScoreType(6,instructionQuestion);
		questions.add(q);
	}
	
	/**
	 * Method that return the number of questions in VoteChart.
	 * @return Size of list.
	 */
	public int size(){ return questions.size(); }
	
	/**
	 * Method that return the list of string of the instruction of each question.
	 * @return List of instruction.
	 */
	public List<String> getInstruction(){
		List<String> instructions = new ArrayList<String>();
		for(int i=0; i< this.size(); i++)
			instructions.add(questions.get(i).getInstruction());
		return instructions; 
	}
	
	/**
	 * Method that return the string that indicate the type of question.
	 * @param questionIndex as the index of question.
	 * @return Type of question.
	 */
	public Class getQuestionType(int questionIndex){
		return questions.get(questionIndex).getClass();
	}
	
	/**
	 * Method that make a vote from the vote of voter. 
	 * @param questionIndex as the index of question.
	 * @param point as the list of point of this question.
	 */
	public void vote(int questionIndex, List<Integer> point){
		questions.get(questionIndex).vote(questionIndex,point);		
	}
	
	/**
	 * Method that return the list of integer of the old point of each question.
	 * @param questionIndex as the index of question.
	 * @return List of the old choice of this question.
	 */
	public List<Integer> getChoice(int questionIndex){
		return questions.get(questionIndex).getChoice(questionIndex);
	}
}
