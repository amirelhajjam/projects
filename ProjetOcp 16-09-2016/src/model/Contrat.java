package model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import org.hibernate.validator.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

public class Contrat {
	
	
	private int id_contrat;
	private String nom_contrat;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_Creation;
	private boolean statut=false;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_debut;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date_fin;
	private float montant;
	private String intitule_projet;
	private String mode_reglement;
	private Incoterm incoterm;
	private String objet_vente;
	private float penalties;
	private Employe emp;
	private ModelContrat model;
	private Fournisseur fourn;
	private Set<Clause> clauses=new HashSet<Clause>();
	private Set<Validation> val=new HashSet<Validation>();
	
	
	public Contrat(int id_contrat, String nom_contrat, Date date_Creation,
			boolean statut) {
		super();
		this.id_contrat = id_contrat;
		this.nom_contrat = nom_contrat;
		this.date_Creation = date_Creation;
		this.statut = statut;
	}
	public Contrat() {
		// TODO Auto-generated constructor stub
	}
	public int getId_contrat() {
		return id_contrat;
	}
	public void setId_contrat(int id_contrat) {
		this.id_contrat = id_contrat;
	}
	public String getNom_contrat() {
		return nom_contrat;
	}
	public void setNom_contrat(String nom_contrat) {
		this.nom_contrat = nom_contrat;
	}
	public Date getDate_Creation() {
		return date_Creation;
	}
	public void setDate_Creation(Date date_Creation) {
		this.date_Creation = date_Creation;
	}
	public boolean isStatut() {
		return statut;
	}
	public void setStatut(boolean statut) {
		this.statut = statut;
	}
	public Employe getEmp() {
		return emp;
	}
	public void setEmp(Employe emp) {
		this.emp = emp;
	}
	public ModelContrat getModel() {
		return model;
	}
	public void setModel(ModelContrat model) {
		this.model = model;
	}
	public Fournisseur getFourn() {
		return fourn;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public void setFourn(Fournisseur fourn) {
		this.fourn = fourn;
	}
	public Set<Clause> getClauses() {
		return clauses;
	}
	public void setClauses(Set<Clause> clauses) {
		this.clauses = clauses;
	}
	public Set<Validation> getVal() {
		return val;
	}
	public void setVal(Set<Validation> val) {
		this.val = val;
	}
	
	public float getMontant() {
		return this.montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getIntitule_projet() {
		return intitule_projet;
	}
	public void setIntitule_projet(String intitule_projet) {
		this.intitule_projet = intitule_projet;
	}
	public String getMode_reglement() {
		return mode_reglement;
	}
	public void setMode_reglement(String mode_reglement) {
		this.mode_reglement = mode_reglement;
	}
	
	public Incoterm getIncoterm() {
		return incoterm;
	}
	public void setIncoterm(Incoterm incoterm) {
		this.incoterm = incoterm;
	}
	public String getObjet_vente() {
		return objet_vente;
	}
	public void setObjet_vente(String objet_vente) {
		this.objet_vente = objet_vente;
	}
	
	public float getPenalties() {
		return penalties;
	}
	public void setPenalties(float penalties) {
		this.penalties = penalties;
	}
	
	

}
