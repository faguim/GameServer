package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class State {
	
	private final String TRUE_FALSE = "t/f";
	private final String MULTIPLE_CHOICE = "default"; // 1 correct answer
	private final String MULTIPLE_ANSWER = "multiple"; // multiple correct answers

	private String id;
	private String title;
	private String description;
	
	private int right_score;
	private int wrong_score;
	
	private String type=MULTIPLE_CHOICE;
	
	private List<Answer> answers = new ArrayList<>();
	private int correct_answer;
	
	public State() {
		super();
	}

	public State(String id, String title, String description) {
		super();
		this.id = id;
		this.setTitle(title);
		this.description = description;
	}

	public State(String title, String description) {
		super();
		this.setTitle(title);
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getRight_score() {
		return right_score;
	}

	public void setRight_score(int right_score) {
		this.right_score = right_score;
	}

	public int getWrong_score() {
		return wrong_score;
	}

	public void setWrong_score(int wrong_score) {
		this.wrong_score = wrong_score;
	}

	public int getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(int correct_answer) {
		this.correct_answer = correct_answer;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
