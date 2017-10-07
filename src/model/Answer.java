package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlAccessType;

@Entity
@Table(name = "answer")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Answer {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	public static final int INCORRECT = 0;
	public static final int SEMI_CORRECT = 1;
	public static final int CORRECT = 2;
	
	private String text;
	private String feedback_text;
	
//	Indicate if thw question is correct, incorrect or semi-correct.
	private int correctness;
	
	@ManyToOne(targetEntity = Question.class)
	@XmlTransient
	private Question question;
	
	public Answer() {
		super();
	}

	public Answer(String text, String feedback_text) {
		super();
		this.text = text;
		this.feedback_text = feedback_text;
		this.correctness = INCORRECT;
	}

	public Answer(String text, String feedback_text, int correctness) {
		super();
		this.text = text;
		this.feedback_text = feedback_text;
		this.correctness = correctness;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getFeedback_text() {
		return feedback_text;
	}

	public void setFeedback_text(String feedback_text) {
		this.feedback_text = feedback_text;
	}

	public int getCorrectness() {
		return correctness;
	}

	public void setCorrectness(int correctness) {
		this.correctness = correctness;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
}
