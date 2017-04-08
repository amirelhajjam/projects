package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ModelContrat {
	
	private int id_model;
	private String titre;
	private String description;
	private Date date_creation;
	private Set<Clause> clause=new HashSet<Clause>();
	private Set<Contrat> contrats=new HashSet<Contrat>();
	private Employe emp;
	
	public int getId_model() {
		return id_model;
	}
	public void setId_model(int id_model) {
		this.id_model = id_model;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Set<Clause> getClause() {
		return clause;
	}
	public void setClause(Set<Clause> clause) {
		this.clause = clause;
	}
	public Set<Contrat> getContrats() {
		return contrats;
	}
	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
	}
	public Employe getEmp() {
		return emp;
	}
	public void setEmp(Employe emp) {
		this.emp = emp;
	}
	public ModelContrat(String titre, String description) {
		super();
		this.titre = titre;
		this.description = description;
	}
	public ModelContrat() {
		// TODO Auto-generated constructor stub
	}
	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	
	

}
