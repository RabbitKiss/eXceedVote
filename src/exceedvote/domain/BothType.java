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
public class BothType implements Serializable, Question {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String question;

	private String type;
	
	@Transient
	private ScoreBoard scoreBoard;

	public BothType() {
		scoreBoard = ScoreBoard.getInstance();
	}
	
	public BothType(String question,String type){
		this.question =question;
		this.type = type;
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

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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
}