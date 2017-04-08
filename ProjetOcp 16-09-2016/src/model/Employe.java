package model;


import java.util.HashSet;
import java.util.Set;



public class Employe extends Utilisateur {

	
	private String matricule;
	private String grade;
	private Set<ModelContrat> models=new HashSet<ModelContrat>();
	private Set<Contrat> contrats=new HashSet<Contrat>();
	private Set<Clause> clauses=new HashSet<Clause>();
	
		
	public Set<ModelContrat> getModels() {
		return models;
	}
	public void setModels(Set<ModelContrat> models) {
		this.models = models;
	}
	public Set<Contrat> getContrats() {
		return contrats;
	}
	public void setContrats(Set<Contrat> contrats) {
		this.contrats = contrats;
	}
	public Set<Clause> getClauses() {
		return clauses;
	}
	public void setClauses(Set<Clause> clauses) {
		this.clauses = clauses;
	}
	public Employe(String matricule, String grade) {
		super();
		this.matricule = matricule;
		this.grade = grade;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employe(String nom, String prenom, String email, String password,
			String telephone, String adresse) {
		super(nom, prenom, email, password, telephone, adresse);
		// TODO Auto-generated constructor stub
	}
	public Employe(String nom, String prenom, String email, String password,
			String telephone, String adresse, String matricule, String grade) {
		super(nom, prenom, email, password, telephone, adresse);
		// TODO Auto-generated constructor stub
		
		this.matricule = matricule;
		this.grade = grade;
	}
	
	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
	
	
}
