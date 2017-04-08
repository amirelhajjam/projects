package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Clause {
	
	
	private int id_clause;
	private String nom_Clause;
	private String 	description;
	private Date data_creation;
	private ModelContrat model;
	private Contrat contrat;
	private Employe emp;
	private Set<Validation> val=new HashSet<Validation>();
	
	
	public String getNom_Clause() {
		return nom_Clause;
	}
	public void setNom_Clause(String nom_Clause) {
		this.nom_Clause = nom_Clause;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getData_creation() {
		return data_creation;
	}
	public void setData_creation(Date data_creation) {
		this.data_creation = data_creation;
	}
	public int getId_clause() {
		return id_clause;
	}
	public void setId_clause(int id_clause) {
		this.id_clause = id_clause;
	}
	public ModelContrat getModel() {
		return model;
	}
	public void setModel(ModelContrat model) {
		this.model = model;
	}
	public Clause(String nom_Clause, String description, Date data_creation) {
		super();
		this.nom_Clause = nom_Clause;
		this.description = description;
		this.data_creation = data_creation;
	}
	public Clause() {
		// TODO Auto-generated constructor stub
	}
	public Employe getEmp() {
		return emp;
	}
	public void setEmp(Employe emp) {
		this.emp = emp;
	}
	public Set<Validation> getVal() {
		return val;
	}
	public void setVal(Set<Validation> val) {
		this.val = val;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	

}
