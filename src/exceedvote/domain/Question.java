package exceedvote.domain;
import java.util.List;

/**
 * Interface of question
 * @author Vanich
 */

public interface Question {
    public String getInstruction();
    public int getPoint(int teamIndex);
    public void vote(int question, List<Integer> point);
    public List<Integer> getChoice(int questionIndex);
}
