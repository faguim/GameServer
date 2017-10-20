package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "medicalcase")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalCase implements Serializable{
	private static final long serialVersionUID = 2020943116280714022L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String name;
	
	private String conclusion_won_text = "CONGRATULATIONS: YOU WON! :)";
	private String conclusion_lost_text = "GAME OVER: YOU LOST! :P";
	
//	Randomize the order in which answer buttons are presented to the user.
	private boolean randomize_answer_order;
	private boolean allow_negative_score;
	
//	Randomize the order in which questions are presented to the user.
	private boolean randomize_question_order;
	
//	Control the amount of time in the countdown timer. To turn it off set the value to zero.
	private int timeout;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Question.class)
    private List<Question> questions = new ArrayList<>();

	public MedicalCase() {
		super();
		this.randomize_answer_order = true;
		this.allow_negative_score = true;
		this.randomize_question_order = false;
		this.timeout = 0;
	}

	public String getConclusion_won_text() {
		return conclusion_won_text;
	}

	public void setConclusion_won_text(String conclusion_won_text) {
		this.conclusion_won_text = conclusion_won_text;
	}

	public String getConclusion_lost_text() {
		return conclusion_lost_text;
	}

	public void setConclusion_lost_text(String conclusion_lost_text) {
		this.conclusion_lost_text = conclusion_lost_text;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public boolean isRandomize_answer_order() {
		return randomize_answer_order;
	}

	public void setRandomize_answer_order(boolean randomize_answer_order) {
		this.randomize_answer_order = randomize_answer_order;
	}

	public boolean isAllow_negative_score() {
		return allow_negative_score;
	}

	public void setAllow_negative_score(boolean allow_negative_score) {
		this.allow_negative_score = allow_negative_score;
	}

	public boolean isRandomize_question_order() {
		return randomize_question_order;
	}

	public void setRandomize_question_order(boolean randomize_question_order) {
		this.randomize_question_order = randomize_question_order;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedicalCase other = (MedicalCase) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}