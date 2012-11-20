package exceedvote.domain;
import java.util.List;

/**
 * Interface of question
 * @author Vanich
 */

public interface Question {
    public String getInstruction();
    public String getType();
    public void setQuestion(String question);
    public void setType(String type);
}
