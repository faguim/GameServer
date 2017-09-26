package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Answer {
	private String text;
	private String feedback_text;
	
	public Answer() {
		super();
	}

	public Answer(String text, String feedback_text) {
		super();
		this.text = text;
		this.feedback_text = feedback_text;
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
}
