package exceedvote.voteprocess;
import java.util.List;

import org.apache.log4j.helpers.QuietWriter;


/**
 *
 * @author User
 */
public class BallotType implements Question {
    
    private String question;
    private int questionIndex;
    private ScoreBoard scoreBoard;
    
    public BallotType(int questionIndex,String question)
    {
        this.question = question;
        this.questionIndex = questionIndex;
        scoreBoard = ScoreBoard.getInstance();
    }
    
    public BallotType(String question, int index)
    {
        this.question = question;
        questionIndex = index;
    }
    
    @Override
    public String getInstruction()
    {
        return question;
    }

    @Override
    public int getPoint(int teamIndex) 
    {
        return scoreBoard.getScore(questionIndex).get(teamIndex+1);
    }

    @Override
    public void vote(int question, List<Integer> point) 
    {
        scoreBoard.addScore(question, point);
    }

    @Override
    public List<Integer> getChoice(int questionIndex) 
    {
        return scoreBoard.getScore(questionIndex);
    }
    
}
