package Test;


import java.util.ArrayList;

import model.Clause;
import model.Contrat;
import model.Employe;
import model.Fournisseur;



import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dao.DaoImp;

public class Test {

	
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
	    DaoImp db=(DaoImp) ctx.getBean("dao");	
	    //Utilisateur u=new Utilisateur("elhajjam", "amir", "amir_941@live.fr", "06586", "0664818967", "adresse");
	    //db.adduser(u);
	    Employe emp=new Employe("elhajjam", "amir", "amir@gmial", "03215&&", "064818967", "adresse",  "matr545", "chef");
	    //db.addEmploye(emp);
	    Fournisseur fr=new Fournisseur("hamza", "faizi", "hamzafaizifr@gmail", "pass","064818967" , "adresse", "nomSociete", "adresseSoc", "telSoc", "email");
	    //db.addFournisseur(fr);
	   //db.ValideClause(13, 2);
	    //db.addType(t);
	    //System.out.println(db.getAllEmployes().get(0).getMatricule());
	    //System.out.println(db.getAllFourn().get(0).getNomSociete());
	   // System.out.println(db.getTypeByTitle("amirtypecontrat"));
//	    System.out.println(emp.getClass().getSimpleName());
//	    ArrayList<Contrat> c=db.ContratOfEmp(1);
//	    for (Contrat contrat : c) {
//			System.out.println(contrat.getEmp().getNom());
//		}
	    
//	    ArrayList<Clause> c = db.GetAllClauseByModel(2);
//	    System.out.println(c.size());
//	    for (Clause clause : c) {
//			System.out.println(clause.getNom_Clause());
//		}
	    
   // int nv=db.clauseNoValide(1);
   // int v=db.ValideClause(1);
   // System.out.println("les clause non valide est "+nv+" les clauses valide est "+v );
   // db.valideContrat(2);
    System.out.println(db.ValideClause(1));
	    

	}

}
