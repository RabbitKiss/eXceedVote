package exceedvote.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the question database table.
 * 
 */
@Entity
@Table(name="question")
public class BallotType implements Serializable, Question {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String question;

	private int questionIndex;
	
	private String type;	

	@Transient
	private ScoreBoard scoreBoard;
	
	public BallotType() {
		scoreBoard = ScoreBoard.getInstance();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQuestionIndex() {
		return this.questionIndex;
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}
	
	public void setType(String type){
		this.type = type;
	}
	
	public String getType(){
		return this.type;
	}
    /**
     * 
     * @return question instruction
     */
    @Override
    public String getInstruction()
    {
        return question;
    }

    /**
     *@param int teams index 
     *@return point of the team at index 
     */
    @Override
    public int getPoint(int teamIndex) 
    {
        return scoreBoard.getScore(questionIndex).get(teamIndex+1);
    }
    
    /**
     * cast a vote
     * @param int question index
     * @param List<Integer> point all the question
     */
    @Override
    public void vote(int question, List<Integer> point) 
    {
        scoreBoard.addScore(question, point);
    }

    /**
     * @param int question index
     * @return  List<Integer> point of all team
     */
    @Override
    public List<Integer> getChoice(int questionIndex) 
    {
        return scoreBoard.getScore(questionIndex);
    }
}