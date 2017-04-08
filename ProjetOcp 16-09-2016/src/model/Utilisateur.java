package model;

import java.util.HashSet;
import java.util.Set;



public class Utilisateur {
	
	private int id_user;
	private String nom;
	private String prenom;
	private String email;
	private String password;
	private String telephone;
	private String adresse;
	private Boolean activated=false;
	private Set<Message> msg= new HashSet<Message>();
	
	
	public Utilisateur() {
		super();
	}
	public Utilisateur(String nom, String prenom, String email,
			String password, String telephone, String adresse) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.adresse = adresse;
	}
	public int getId_user() {
		return id_user;
	}
	public void setId_user(int id_user) {
		this.id_user = id_user;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Boolean getActivated() {
		return activated;
	}
	public void setActivated(Boolean activated) {
		this.activated = activated;
	}
	public Set<Message> getMsg() {
		return msg;
	}
	public void setMsg(Set<Message> msg) {
		this.msg = msg;
	}
	
	

}
