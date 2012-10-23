package exceedvote.domain;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Score type question 
 * @author Vanich
 */
public class ScoreType implements Question{

    private String question;
    private int questionIndex;
    private ScoreBoard scoreBoard;
    
    /**
     * constructor of class
     * @param questionIndex
     * @param question instruction
     */
    public ScoreType(int questionIndex,String question)
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
    @Override
    public String getInstruction()
    {
        return question;
    }
    
    /**
     * 
     * @return question instruction
     */
    @Override
    public int getPoint(int teamIndex) 
    {
        return scoreBoard.getScore(questionIndex).get(teamIndex+1);
    }

    /**
     *@param int teams index 
     *@return point of the team at index 
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
