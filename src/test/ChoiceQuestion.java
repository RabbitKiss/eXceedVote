package test;

import java.io.Serializable;
import java.lang.Integer;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Choice
 *
 */

@Entity

public class ChoiceQuestion implements Serializable {

	private static final long serialVersionUID = 1L;	   
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private List<Integer> score;


	public ChoiceQuestion() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public List<Integer> getScore() {
		return this.score;
	}

	public void setScore(List<Integer> score) {
		this.score = score;
	}
   
}
