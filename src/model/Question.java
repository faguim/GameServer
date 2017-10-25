package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "question")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Question {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	public static final String TRUE_FALSE = "t/f";
	public static final String MULTIPLE_CHOICE = "default"; // 1 correct answer
	public static final String MULTIPLE_ANSWER = "multiple"; // multiple correct answers

	private String title;
	private String description;
	
	private int right_score;
	private int semi_right_score;
	private int wrong_score;
	
//	Feedback Information if question type is "multiple"
	private String incorrect_feedback_text;
	private String correct_feedback_text;
	
//	There are 3 question types to choose from on each question: T/F, multiple choice, and multiple answer:
//	  - T/F - Leave the "question type" as default. Then delete answer 3 and 4 and the question will automatically only display 2 buttons.
//	  - Multiple Choice (1 correct answer) - use the word "default" as the "question type".
//	  - Multiple Answer (multiple correct answers) - use the word "multiple" as the "question type".
	private String type=MULTIPLE_CHOICE;
	
	@ManyToOne(targetEntity = MedicalCase.class)
	@XmlTransient
	private MedicalCase medicalCase;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Answer.class)
	private List<Answer> answers = new ArrayList<>();
	
	public Question() {
		super();
	}

	public Question(String title, String description) {
		super();
		this.setTitle(title);
		this.description = description;
		this.setCorrect_feedback_text("<h1>This is correct</h1> Correct feedback text here..");
		this.setIncorrect_feedback_text("<h1>That is incorrect</h1> Incorrect feedback text here...");
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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

	public int getSemi_right_score() {
		return semi_right_score;
	}

	public void setSemi_right_score(int semi_right_score) {
		this.semi_right_score = semi_right_score;
	}

	public int getMax_score() {
		int max_score = 0;
		for (Answer answer : answers) {
			if (answer.getCorrectness() == 2) {
				max_score += right_score;
			}
			if (answer.getCorrectness() == 1) {
				max_score += semi_right_score;
			}		
		}
		return max_score;
	}

	public String getIncorrect_feedback_text() {
		return incorrect_feedback_text;
	}

	public void setIncorrect_feedback_text(String incorrect_feedback_text) {
		this.incorrect_feedback_text = incorrect_feedback_text;
	}

	public String getCorrect_feedback_text() {
		return correct_feedback_text;
	}

	public void setCorrect_feedback_text(String correct_feedback_text) {
		this.correct_feedback_text = correct_feedback_text;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MedicalCase getMedicalCase() {
		return medicalCase;
	}

	public void setMedicalCase(MedicalCase medicalCase) {
		this.medicalCase = medicalCase;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", title=" + title + ", description=" + description + ", right_score="
				+ right_score + ", semi_right_score=" + semi_right_score + ", wrong_score=" + wrong_score
				+ ", incorrect_feedback_text=" + incorrect_feedback_text + ", correct_feedback_text="
				+ correct_feedback_text + ", type=" + type + ", answers=" + answers + "]";
	}
}