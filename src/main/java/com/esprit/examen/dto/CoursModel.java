package com.esprit.examen.dto;

import java.util.Set;


import com.esprit.examen.entities.Session;
import com.esprit.examen.entities.TypeCours;

public class CoursModel {
	
	private Long id;
	private String description;
	private TypeCours typeCours;
	private String intitule;
	private Set<Session> sessions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public TypeCours getTypeCours() {
		return typeCours;
	}
	public void setTypeCours(TypeCours typeCours) {
		this.typeCours = typeCours;
	}
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	
	public Set<Session> getSessions() {
		return sessions;
	}
	public void setSessions(Set<Session> sessions) {
		this.sessions = sessions;
	}
	@Override
	public String toString() {
		return "Cours [id=" + id + ", description=" + description + ", typeCours=" + typeCours + ", intitule="
				+ intitule + "]";
	}
	public CoursModel(Long id, String description, TypeCours typeCours, String intitule) {
		super();
		this.id = id;
		this.description = description;
		this.typeCours = typeCours;
		this.intitule = intitule;
	}

}
