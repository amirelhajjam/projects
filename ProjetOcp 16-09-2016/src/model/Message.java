package model;

import java.util.Date;

public class Message {
	
	private int id_Mesg;
	private String title;
	private String description;
	private Date date;
	private Utilisateur id_sendBy;
	private Utilisateur id_sendTo;
	
	
	
	public Message(String title, String description, Date date) {
		super();
		this.title = title;
		this.description = description;
		this.date = date;
	}
	public Message() {
		// TODO Auto-generated constructor stub
	}
	public int getId_Mesg() {
		return id_Mesg;
	}
	public void setId_Mesg(int id_Mesg) {
		this.id_Mesg = id_Mesg;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Utilisateur getId_sendBy() {
		return id_sendBy;
	}
	public void setId_sendBy(Utilisateur id_sendBy) {
		this.id_sendBy = id_sendBy;
	}
	public Utilisateur getId_sendTo() {
		return id_sendTo;
	}
	public void setId_sendTo(Utilisateur id_sendTo) {
		this.id_sendTo = id_sendTo;
	}
	
	
	
	

}
