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
@Table(name = "state")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class State {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
	
	private String title;
	private String description;
	
//	@XmlTransient
//	private int ident;
	
	@ManyToOne(targetEntity = MedicalCase.class)
	@XmlTransient
	private MedicalCase medicalCase;
	
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, targetEntity = Action.class)
	private List<Action> actions = new ArrayList<>();
	
	public State() {
		super();
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

//	public int getIdent() {
//		return ident;
//	}
//
//	public void setIdent(int ident) {
//		this.ident = ident;
//	}

}