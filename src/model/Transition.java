package model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Transition {
	private String name;
	private String source;
	private String target;
	
	public Transition() {
		super();
	}
	
	public Transition(String name, String source, String target) {
		super();
		this.name = name;
		this.source = source;
		this.target = target;
	}

	public Transition(String source, String target) {
		super();
		this.source = source;
		this.target = target;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
}
