package model;

import java.util.Date;

public class Validation {
	
	
	private int id_val;
	private boolean statutOfClause=false;
	private Date date;
	private Clause clause;
	private Contrat contrat;
	public int getId_val() {
		return id_val;
	}
	public void setId_val(int id_val) {
		this.id_val = id_val;
	}
	public boolean getStatutOfClause() {
		return statutOfClause;
	}
	public void setStatutOfClause(boolean statutOfClause) {
		this.statutOfClause = statutOfClause;
	}
	public Clause getClause() {
		return clause;
	}
	public void setClause(Clause clause) {
		this.clause = clause;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
