package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Case {
	private String conclusion_won_text = "CONGRATULATIONS: YOU WON! :)";
	private String conclusion_lost_text = "GAME OVER: YOU LOST! :P";
	
//	Randomize the order in which answer buttons are presented to the user.
	private boolean randomize_answer_order;
	private boolean allow_negative_score;
	
//	Randomize the order in which questions are presented to the user.
	private boolean randomize_question_order;
	
//	Control the amount of time in the countdown timer. To turn it off set the value to zero.
	private int timeout;
	
	private List<Question> questions = new ArrayList<>();

	public Case() {
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

}
