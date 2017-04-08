package dao;


import java.util.ArrayList;



import org.springframework.dao.DataIntegrityViolationException;

import model.*;

public interface IDao {
	public void adduser(Utilisateur u);
	
	public Utilisateur auth(String log, String pass);
	
	public Utilisateur getuser(int idu);
	
	public void deconnexion(Object user);
	
	public void addEmploye(Employe emp);
	
	public ArrayList<Employe> getAllEmployes();
	
	public Employe getEmpById(int id);
	
	public Utilisateur getUserByMail(String mail);
	
	public void addFournisseur(Fournisseur fourn);
	
	public ArrayList<Fournisseur> getAllFourn();
	
	public Fournisseur getFournById(int id);
	
	public void addContrat(Contrat c)throws DataIntegrityViolationException;
	
	public void removeContrat(int idC);
	
	public void modifyContrat(int idC,Contrat c);
	
	public Contrat getContrat(int idC);
	
	public ArrayList<Contrat> getContratByModel(int id);
	
	public Contrat getContratByName(String email);
	
	public ArrayList<Contrat> allContrat();
	
	public ArrayList<Contrat> ContratOfEmp(int idE);
	
	public ArrayList<Contrat> ContratOfFourn(int idF);
	
	
	public void AddModel(ModelContrat m) throws DataIntegrityViolationException;
	
	public ArrayList<ModelContrat> AllModel();
	
	public ArrayList<Clause> getAllClauseByContrat(int id);
	
	public ModelContrat getModelById(int id);
	
	public void removeModel(int id);
	
	public void modifyModel(int id,ModelContrat c) throws DataIntegrityViolationException ;
	
	public ModelContrat ModelByTitre(String titre);
	
	public void addClause(Clause c);
	
	public ArrayList<Clause> GetAllClauseByModel(int id);
	
	public void removeClause(int id);
	
	public void modifyClause(int id , Clause c);
	
	public Clause getClauseById(int id);
	
	public void addValidation(Validation v);
	
	public boolean getStatutContratClause(int idcl,int idC);
	
	public void ValideClause(int id_clause,int id_contrat);
	
	public int clauseNoValide(int id_contrat);
	
	public int ValideClause(int id_contrat);
	
	public void valideContrat(int id_contrat);
	
	public void valideContratByClause();
	
	public int ContratNoValideOfUser(int id_user);
	
	public void addmessage(Message m);
	
	
	
	
	
	
    
}
