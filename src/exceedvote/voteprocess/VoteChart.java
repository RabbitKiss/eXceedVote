package exceedvote.voteprocess;

import java.util.ArrayList;
import java.util.List;

public class VoteChart {
	List<Question> questions;
	
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
	
	public int size(){ return questions.size(); }
	
	public List<String> getInstruction(){
		List<String> instructions = new ArrayList<String>();
		for(int i=0; i< this.size(); i++)
			instructions.add(questions.get(i).getInstruction());
		return instructions; 
	}
	
	public String getQuestionType(int questionIndex){
		return questions.get(questionIndex).getClass().getName();
	}
	
	public void vote(int questionIndex, List<Integer> point){
		questions.get(questionIndex).vote(questionIndex,point);		
	}
	
	//change name of method from "getScore" to "getChoice"
	public List<Integer> getChoice(int questionIndex){
		return questions.get(questionIndex).getChoice(questionIndex);
	}
}
