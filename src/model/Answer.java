package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Answer {
	public static final int INCORRECT = 0;
	public static final int SEMI_CORRECT = 1;
	public static final int CORRECT = 2;
	
	private String text;
	private String feedback_text;
	
	private int correctness;
	
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
}
