package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.IdClass;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;
















import model.Clause;
import model.Contrat;
import model.Employe;
import model.Fournisseur;
import model.Message;
import model.ModelContrat;
import model.Utilisateur;
import model.Validation;


public class DaoImp extends HibernateDaoSupport implements IDao {

	@Override
	@Transactional
	public void adduser(Utilisateur u) {
      		getHibernateTemplate().saveOrUpdate(u);

	}
	
	@Override
	@Transactional
	public void deconnexion(Object object) {
		
		getHibernateTemplate().get(Utilisateur.class, ((Utilisateur) object).getId_user());
		  ((Utilisateur) object).setActivated(false);
		  getHibernateTemplate().update(object);
		
	}

	@Override
	@Transactional
	public void addEmploye(Employe emp) {
		getHibernateTemplate().saveOrUpdate(emp);
		
	}

	@Override
	@Transactional
	public void addFournisseur(Fournisseur fourn) {
		getHibernateTemplate().saveOrUpdate(fourn);
		
	}
	@Override
	@Transactional
	public Utilisateur auth(String email, String pass) {
		
		
		List<Utilisateur> res = getHibernateTemplate().find("from Utilisateur where email='"+email+"' and password='"+pass+"'");
		
		if(res.size()==1)
		{ 
		Utilisateur u=res.get(0);
		getHibernateTemplate().get(Utilisateur.class, u.getId_user());
		  u.setActivated(true);
		  getHibernateTemplate().update(u);
		  return u;
		}else
         return null;
			
	}

	@Override
	@Transactional
	public Utilisateur getuser(int idu) {
		Utilisateur u =getHibernateTemplate().get(Utilisateur.class, idu);
		if (u!=null) {
			return u;
		}
		return null;
	}

	@Override
	@Transactional
	public ArrayList<Employe> getAllEmployes() {
		ArrayList<Employe> emps=(ArrayList<Employe>) getHibernateTemplate().find("from Employe");
		if(emps.size()>=1){
			return emps;
		}
		return null;
	}

	@Override
	@Transactional
	public ArrayList<Fournisseur> getAllFourn() {
		ArrayList<Fournisseur> fourns=(ArrayList<Fournisseur>) getHibernateTemplate().find("from Fournisseur order By email ");
		if(fourns.size()>=1){
			return fourns;
		}
		return null;
	}

	@Override
	@Transactional
	public void addContrat(Contrat c) throws DataIntegrityViolationException {
		getHibernateTemplate().saveOrUpdate(c);
		
	}

	@Override
	@Transactional
	public void removeContrat(int idC) {
		Contrat c= getHibernateTemplate().get(Contrat.class, idC);
		if(c!=null){
		getHibernateTemplate().delete(c);
		}
	}

	@Override
	@Transactional
	public void modifyContrat(int idC,Contrat c) {
		Contrat cm=getHibernateTemplate().get(Contrat.class, idC);
		
		getHibernateTemplate().update(cm);
		
	}

	@Override
	@Transactional
	public Contrat getContrat(int idC) {
		Contrat c=getHibernateTemplate().get(Contrat.class, idC);
		return c;
	}
	
	@Override
	@Transactional
	public Contrat getContratByName(String email) {
		ArrayList<Contrat> cons=(ArrayList<Contrat>) getHibernateTemplate().find("from Contrat contrat where contrat.nom_contrat='"+email+"'");
		if (cons.size()>=1) {
			return cons.get(0);
		}
		return null;
	}
	
    
	@Override
	@Transactional
	public ArrayList<Contrat> allContrat() {
		ArrayList<Contrat> cons=(ArrayList<Contrat>) getHibernateTemplate().find("from Contrat");
		return cons;
	}

	@Override
	@Transactional
	public ArrayList<Contrat> ContratOfEmp(int idE) {
		ArrayList<Contrat> cons=(ArrayList<Contrat>) getHibernateTemplate().find("from Contrat contrat where contrat.emp.id_user='"+idE+"' order by contrat.date_Creation");
		if (cons.size()>=1) {
			return cons;
		}
		return null;
	}

	@Override
	@Transactional
	public ArrayList<Contrat> ContratOfFourn(int idF) {
		ArrayList<Contrat> cons=(ArrayList<Contrat>) getHibernateTemplate().find("from Contrat contrat where contrat.fourn.id_user='"+idF+"' order by contrat.date_Creation");
		if (cons.size()>=1) {
			return cons;
		}
		return null;
	}
	
	   
		
		
	
	
	public Employe getEmpById(int id) {
		Employe e=getHibernateTemplate().get(Employe.class, id);	
		return e;
	}
	@Override
	@Transactional
	public Fournisseur getFournById(int id) {
		Fournisseur f=getHibernateTemplate().get(Fournisseur.class, id);
		return f;
	}
	@Override
	@Transactional
	public Utilisateur getUserByMail(String mail) {
		ArrayList<Utilisateur> users=(ArrayList<Utilisateur>) getHibernateTemplate().find("from Utilisateur user where user.email='"+mail+"'");
		if (users.size()>=1) {
			return users.get(0);
		}
		return null;
	}

	
	@Override
	@Transactional
	public void AddModel(ModelContrat m) throws DataIntegrityViolationException {
		getHibernateTemplate().saveOrUpdate(m);
		
	}
	
	@Override
	@Transactional
	public ArrayList<ModelContrat> AllModel() {
		
		return (ArrayList<ModelContrat>) getHibernateTemplate().find("from ModelContrat");
	}
	
	
	@Override
	@Transactional
	public ModelContrat ModelByTitre(String titre) {
		ArrayList<ModelContrat> m=(ArrayList<ModelContrat>) getHibernateTemplate().find("from ModelContrat m where m.titre='"+titre+"'");
		if (m.size()>=1) {
			return m.get(0);
		}
		return null;
	}
	
	@Override
	@Transactional
	public void addClause(Clause c) {
		getHibernateTemplate().saveOrUpdate(c);
		
	}

	@Override
	@Transactional
	public ArrayList<Clause> GetAllClauseByModel(int id) {
		ArrayList<Clause> m=(ArrayList<Clause>) getHibernateTemplate().find("from Clause c where c.model.id_model='"+id+"'");
		if (m.size()>=1) {
			return m;
		}
		return null;
		
	}
	
	@Override
	@Transactional
	public ArrayList<Clause> getAllClauseByContrat(int id) {
		ArrayList<Clause> m=(ArrayList<Clause>) getHibernateTemplate().find("from Clause c where c.contrat.id_contrat='"+id+"'");
		if (m.size()>=1) {
			return m;
		}
		return null;
	}
	
	@Override
	@Transactional
	public void removeModel(int id) {
		ModelContrat c = getHibernateTemplate().get(ModelContrat.class, id);
		getHibernateTemplate().delete(c);
		
	}
	
	@Override
	@Transactional
	public void modifyModel(int id,ModelContrat c) throws DataIntegrityViolationException {
         ModelContrat c1 = getHibernateTemplate().get(ModelContrat.class, id);
         c1.setDescription(c.getDescription());
         c1.setTitre(c.getTitre());
         getHibernateTemplate().update(c1);
		
	}
	
	@Override
	@Transactional
	public ModelContrat getModelById(int id) {
		ModelContrat c = getHibernateTemplate().get(ModelContrat.class, id);
		return c;
	}

	@Override
	@Transactional
	public void removeClause(int id) {
		Clause c=(Clause) getHibernateTemplate().get(Clause.class, id);
		getHibernateTemplate().delete(c);
		
	}

	@Override
	@Transactional
	public void modifyClause(int id, Clause c) {
		Clause c1=(Clause) getHibernateTemplate().get(Clause.class, id);
		c1.setDescription(c.getDescription());
		c1.setNom_Clause(c.getNom_Clause());
		c1.setModel(c.getModel());
		getHibernateTemplate().update(c1);
		
	}

	@Override
	@Transactional
	public Clause getClauseById(int id) {
		Clause c = (Clause) getHibernateTemplate().get(Clause.class, id);
		return c;
	}
	
	@Override
	@Transactional
	public void addValidation(Validation v) {
		getHibernateTemplate().saveOrUpdate(v);
		
	}
	
	@Override
	@Transactional
	public boolean getStatutContratClause(int idcl, int idC) {
		ArrayList<Validation> v= (ArrayList<Validation>) getHibernateTemplate().find("from Validation v where v.contrat.id_contrat='"+idC+"' and v.clause.id_clause='"+idcl+"'");
		if (v.size()>=1) {
			Validation v1=v.get(0);
			return v1.getStatutOfClause();
		}
		return false;
	}
	
	@Override
	@Transactional
	public void ValideClause(int id_clause, int id_contrat) {
		ArrayList<Validation> v= (ArrayList<Validation>) getHibernateTemplate().find("from Validation v where v.contrat.id_contrat='"+id_contrat+"' and v.clause.id_clause='"+id_clause+"'");	
		if (v.size()>=1) {
			Validation v1=v.get(0);
			v1.setStatutOfClause(true);
			getHibernateTemplate().update(v1);
		}
	}

	@Override
	@Transactional
	public int clauseNoValide(int id_contrat) {
		ArrayList<Clause> clauses=(ArrayList<Clause>) getHibernateTemplate().find("from Validation v where v.contrat.id_contrat='"+id_contrat+"' and v.statutOfClause="+false+"");
		return clauses.size();
	}

	@Override
	@Transactional
	public int ValideClause(int id_contrat) {
		ArrayList<Clause> clauses=(ArrayList<Clause>) getHibernateTemplate().find("from Validation v where v.contrat.id_contrat='"+id_contrat+"' and v.statutOfClause="+true+"");
		return clauses.size();
	}

	@Override
	@Transactional
	public void valideContrat(int id_contrat) {
		Contrat c=getHibernateTemplate().get(Contrat.class, id_contrat);
		c.setStatut(true);
		getHibernateTemplate().update(c);
		getHibernateTemplate().bulkUpdate("update Validation v set statutOfClause="+true+" where v.contrat.id_contrat='"+id_contrat+"'");
	}
	
	@Override
	@Transactional
	public void valideContratByClause() {
		ArrayList<Contrat> contrat=(ArrayList<Contrat>) getHibernateTemplate().find("from Contrat");
		for (Contrat c : contrat) {
			int nv=clauseNoValide(c.getId_contrat());
			if (nv==0) {
				c.setStatut(true);
				getHibernateTemplate().update(c);
			}
			else {
				c.setStatut(false);
				getHibernateTemplate().update(c);
			}
		}
		
	}
	
	@Override
	@Transactional
	public int ContratNoValideOfUser(int id) {
		ArrayList<Contrat> contrats=(ArrayList<Contrat>) getHibernateTemplate().find("from Contrat c where c.statut="+false+" and (c.emp.id_user='"+id+"' or c.fourn.id_user = '"+id+"')");

		return contrats.size();
	}
	
	@Override
	@Transactional
	public ArrayList<Contrat> getContratByModel(int id) {
		ArrayList<Contrat> contrats=(ArrayList<Contrat>) getHibernateTemplate().find("from Contrat c where c.model.id_model='"+id+"'");
		return contrats;
	}

	@Override
	public void addmessage(Message m) {
		getHibernateTemplate().flush();
    getHibernateTemplate().saveOrUpdate(m);
		
	}
}
