package exceedvote.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


/**
 * The persistent class for the score database table.
 * 
 */
@Entity
public class Score implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String point;

	@Column(name="question_index")
	private int questionIndex;

	@Column(name="user_id")
	private int userId;

	public Score() {
	}
	
	public Score(int userId,int questionIndex,String point){
		this.userId = userId;
		this.questionIndex = questionIndex;
		this.point = point;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPoint() {
		return this.point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public int getQuestionIndex() {
		return this.questionIndex;
	}

	public void setQuestionIndex(int questionIndex) {
		this.questionIndex = questionIndex;
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Integer> getScorePoint(){
		if(point==null)
			return null;
		String[] tmp = this.point.split(",");
		List<Integer> score = new ArrayList<Integer>();
		for(String s : tmp)
			score.add(Integer.valueOf(s));
		return score;
	}

	public void setScorePoint(List<Integer> score){
		StringBuffer s = new StringBuffer("");
		for(int tmp : score)
			s.append(tmp+",");
		this.point = s.toString().substring(0,s.length()-1);
	}
}