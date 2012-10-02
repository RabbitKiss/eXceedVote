package exceedvote.voteprocess;
import java.util.List;
/**
 *
 * @author Teddy
 */
public interface Question {
    public String getInstruction();
    public int getPoint(int teamIndex);
    public void vote(int question, List<Integer> point);
    public List<Integer> getChoice(int questionIndex);
}
