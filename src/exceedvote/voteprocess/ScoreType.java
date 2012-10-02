package exceedvote.voteprocess;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class ScoreType implements Question{

    private String question;
    private int questionIndex;
    private ScoreBoard scoreBoard;
    
    public ScoreType(int questionIndex,String question)
    {
        this.question = question;
        this.questionIndex = questionIndex;
        scoreBoard = ScoreBoard.getInstance();
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