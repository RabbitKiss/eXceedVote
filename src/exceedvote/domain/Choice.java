package exceedvote.domain;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the choice database table.
 * 
 */
@Entity
public class Choice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int choice1;

	private int choice2;

	private int choice3;

	private int choice4;

	private int choice5;

	public Choice() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getChoice1() {
		return this.choice1;
	}

	public void setChoice1(int choice1) {
		this.choice1 = choice1;
	}

	public int getChoice2() {
		return this.choice2;
	}

	public void setChoice2(int choice2) {
		this.choice2 = choice2;
	}

	public int getChoice3() {
		return this.choice3;
	}

	public void setChoice3(int choice3) {
		this.choice3 = choice3;
	}

	public int getChoice4() {
		return this.choice4;
	}

	public void setChoice4(int choice4) {
		this.choice4 = choice4;
	}

	public int getChoice5() {
		return this.choice5;
	}

	public void setChoice5(int choice5) {
		this.choice5 = choice5;
	}

}