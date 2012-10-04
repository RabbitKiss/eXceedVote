package exceedvote.voteprocess;
import java.util.List;

import org.apache.log4j.helpers.QuietWriter;


/**
 * Ballot type question 
 * @author Vanich
 */
public class BallotType implements Question {
    
    private String question;
    private int questionIndex;
    private ScoreBoard scoreBoard;
    
    /**
     * constructor of class
     * @param questionIndex
     * @param question instruction
     */
    public BallotType(int questionIndex,String question)
    {
        this.question = question;
        this.questionIndex = questionIndex;
        scoreBoard = ScoreBoard.getInstance();
    }
    
    /**
     * constructor of class
     * @param question instruction
     * @param index questionIndex
     */
    public BallotType(String question, int index)
    {
        this.question = question;
        questionIndex = index;
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
