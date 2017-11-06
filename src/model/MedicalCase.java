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
	
	private String won_text = "CONGRATULATIONS: YOU WON! :)";
	private String lost_text = "GAME OVER: YOU LOST! :P";
	
//	Randomize the order in which answer buttons are presented to the user.
	private boolean randomize_actions;
	private boolean allow_negative_score;
	
//	Control the amount of time in the countdown timer. To turn it off set the value to zero.
	private int timeout;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = State.class)
    private List<State> states = new ArrayList<>();

	public MedicalCase() {
		super();
		this.setRandomize_actions(true);
		this.allow_negative_score = true;
		this.timeout = 0;
	}

	public boolean isAllow_negative_score() {
		return allow_negative_score;
	}

	public void setAllow_negative_score(boolean allow_negative_score) {
		this.allow_negative_score = allow_negative_score;
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

	public String getWon_text() {
		return won_text;
	}

	public void setWon_text(String won_text) {
		this.won_text = won_text;
	}

	public String getLost_text() {
		return lost_text;
	}

	public void setLost_text(String lost_text) {
		this.lost_text = lost_text;
	}

	public boolean isRandomize_actions() {
		return randomize_actions;
	}

	public void setRandomize_actions(boolean randomize_actions) {
		this.randomize_actions = randomize_actions;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	@Override
	public String toString() {
		return "MedicalCase [id=" + id + ", name=" + name + ", won_text=" + won_text + ", lost_text=" + lost_text
				+ ", randomize_actions=" + randomize_actions + ", allow_negative_score=" + allow_negative_score
				+ ", timeout=" + timeout + ", states=" + states + "]";
	}

	
}