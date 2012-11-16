package test;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Question
 *
 */
@Entity

@Table(name = "questionTest")
public class Question implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;   

//	@OneToOne
//	@JoinColumn(name = "id")
//	private ChoiceQuestion choiceQuestion;
	
	private String instructor;
	
	public Question() {
		super();
	}   
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}   
	public String getInstructor() {
		return this.instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
   
}
