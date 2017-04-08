package model;


import java.util.HashSet;
import java.util.Set;



public class Fournisseur extends Utilisateur {
    
	
	private String nomSociete;
	private String adresseSoc;
	private String telSoc;
	private String emailSoc;
	private Set<Contrat> contrats=new HashSet<Contrat>();

	
	
	
	public Fournisseur(String nomSociete, String adresseSoc, String telSoc,
			String email) {
		super();
		this.nomSociete = nomSociete;
		this.adresseSoc = adresseSoc;
		this.telSoc = telSoc;
		this.setEmailSoc(email);
	}
	public Fournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Fournisseur(String nom, String prenom, String email,
			String password, String telephone, String adresse,String nomSociete, String adresseSoc, String telSoc,
			String email1) {
		super(nom, prenom, email, password, telephone, adresse);
		this.nomSociete = nomSociete;
		this.adresseSoc = adresseSoc;
		this.telSoc = telSoc;
		this.setEmailSoc(email1);
	}
	
	public String getNomSociete() {
		return nomSociete;
	}
	public void setNomSociete(String nomSociete) {
		this.nomSociete = nomSociete;
	}
	public String getAdresseSoc() {
		return adresseSoc;
	}
	public void setAdresseSoc(String adresseSoc) {
		this.adresseSoc = adresseSoc;
	}
	public String getTelSoc() {
		return telSoc;
	}
	public void setTelSoc(String telSoc) {
		this.telSoc = telSoc;
	}
	
	
	public String getEmailSoc() {
		return emailSoc;
	}
	public void setEmailSoc(String emailSoc) {
		this.emailSoc = emailSoc;
	}
	
	
	
	
	
	
}
