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
@Table(name = "action")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Action {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String text;
	
	private boolean correct;
	private boolean proceed;
	
	@ManyToOne(targetEntity = State.class)
	@XmlTransient
	private State state;
	
	private Integer target;
	
	public Action() {
		super();
	}

	public Action(String text, String feedback_text) {
		super();
		this.text = text;
		this.setCorrect(false);
	}

	public Action(String text, boolean correct) {
		super();
		this.text = text;
		this.setCorrect(correct);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public boolean isProceed() {
		return proceed;
	}

	public void setProceed(boolean proceed) {
		this.proceed = proceed;
	}

	public Integer getTarget() {
		return target;
	}

	public void setTarget(Integer target) {
		this.target = target;
	}
}
