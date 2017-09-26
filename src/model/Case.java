package model;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Case {
	private String conclusion_won_text = "Congratulations";
	private String conclusion_lost_text = "Sorry, you have lost the game";
	
	private List<Transition> transitions = new ArrayList<>();
	private List<State> states = new ArrayList<>();

	public List<Transition> getTransitions() {
		return transitions;
	}

	public void setTransitions(List<Transition> transitions) {
		this.transitions = transitions;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
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

}
