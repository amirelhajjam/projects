package web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Clause;
import model.Contrat;
import model.Employe;
import model.Fournisseur;
import model.ModelContrat;
import model.Utilisateur;
import model.Validation;

import org.hibernate.Hibernate;
import org.hibernate.validator.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DaoImp;

@Controller
public class ContratController {
    
	@Autowired
	DaoImp dao;
	
	@RequestMapping(value="/AddContrat.html")
	public String AddContrat(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    if (!user.getClass().getSimpleName().equals("Employe")) {
					return "lock-page";
				}
			    model.addAttribute("Contrat", new Contrat());
			    model.addAttribute("modeles", dao.AllModel());
			    model.addAttribute("fourn", dao.getAllFourn());
			      return "AddContrat";
			   }
	@RequestMapping(value="/ModifyContrat.html")
	public String ModifContrat(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    if (!user.getClass().getSimpleName().equals("Employe")) {
					return "lock-page";
				}
			    model.addAttribute("Contrat", dao.getContrat(id));
			    model.addAttribute("modeles", dao.AllModel());
			    model.addAttribute("fourn", dao.getAllFourn());
			      return "ModifyContrat";
			   }
	
	@RequestMapping(value="/AddClauseForContrat.html")
	public String AddClauseForContrat(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    if (!user.getClass().getSimpleName().equals("Employe")) {
					return "lock-page";
				}
			    model.addAttribute("Clause", new Clause());
			    model.addAttribute("contrats", dao.allContrat());
			    
			      return "AddClauseForContrat";
			   }
	
	@RequestMapping(value="/ajouterContrat.html")
	public String ajoutercontrat(@ModelAttribute("Contrat")  Contrat contrat,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    String date_d=request.getParameter("date_d");
			    String date_f=request.getParameter("date_f");
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			    try {
					contrat.setDate_debut(format.parse(date_d));
					contrat.setDate_fin(format.parse(date_f));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    
			      ModelContrat m=dao.ModelByTitre(contrat.getModel().getTitre());
			      Fournisseur f=(Fournisseur) dao.getUserByMail(contrat.getFourn().getEmail());
			      contrat.setModel(m);
			      contrat.setFourn(f);
			      contrat.setEmp((Employe) dao.getuser(user.getId_user()));
			      contrat.setDate_Creation(new Date());
			      
			      try {
			    	  dao.addContrat(contrat);
			    	  ArrayList<Clause> clauses=dao.GetAllClauseByModel(m.getId_model());
			    	  if (clauses!=null) {
			    		  for (Clause c : clauses) {
				    		  Validation v=new Validation();
				    		  v.setClause(c);
				    		  v.setContrat(dao.getContratByName(contrat.getNom_contrat()));
				    		  v.setDate(new Date());
				    		  v.setStatutOfClause(false);
							dao.addValidation(v);
						}
					}
			    	 
			        	 model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>le contrat a ete bien ajouter tu peux ajouter des clause a votre contrat </div>");
					} catch (DataIntegrityViolationException e) {
						model.addAttribute("msg","<div class=\"alert alert-danger\"><b>Oops ! </b>changer le nom de contrat  </div>");
					}
			     
			      return "redirect:AddContrat.html";
			   }
	
	@RequestMapping(value="/ModifierContrat.html")
	public String modifiercontrat(@ModelAttribute("Contrat")  Contrat contrat,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    String date_d=request.getParameter("date_d");
			    String date_f=request.getParameter("date_f");
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			    try {
					contrat.setDate_debut(format.parse(date_d));
					contrat.setDate_fin(format.parse(date_f));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			    
			      ModelContrat m=dao.ModelByTitre(contrat.getModel().getTitre());
			      Fournisseur f=(Fournisseur) dao.getUserByMail(contrat.getFourn().getEmail());
			      contrat.setModel(m);
			      contrat.setFourn(f);
			      contrat.setEmp((Employe) dao.getuser(user.getId_user()));
			      contrat.setDate_Creation(new Date());
			      
			      try {
			    	  dao.modifyContrat(contrat.getId_contrat(), contrat);
			    	 
			    	 
			        	 model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>le contrat a ete bien ajouter tu peux ajouter des clause a votre contrat </div>");
					} catch (DataIntegrityViolationException e) {
						model.addAttribute("msg","<div class=\"alert alert-danger\"><b>Oops ! </b>changer le nom de contrat  </div>");
					}
			     
			      return "redirect:ModifyContrat.html";
			   }
	
	@RequestMapping(value="/ajouterClauseForContrat.html")
	public String ajouterClauseForContrat(@ModelAttribute("Clause")Clause c,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
			    c.setEmp(dao.getEmpById(u.getId_user()));
			   Contrat contrat=dao.getContratByName(c.getContrat().getNom_contrat());
			   if (contrat.getEmp().getId_user() != user.getId_user()) {
				   model.addAttribute("msg","<div class=\"alert alert-danger\"><b>succes </b>vous n'avez pas le droit d'ajouter une clause a ce contrat </div>");
				   return "redirect:AddClauseForContrat.html";
			   }
			   else{
			    c.setContrat(contrat);
			    c.setData_creation(new Date());
			    dao.addClause(c);
			    Validation v=new Validation();
	    		  v.setClause(c);
	    		  v.setContrat(contrat);
	    		  v.setDate(new Date());
	    		  v.setStatutOfClause(false);
	    		  dao.addValidation(v);
			    model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>la clause a ete bien ajouter </div>");
			   
			      return "redirect:AddClauseForContrat.html";
			}
			   }
	
	
	
	@RequestMapping(value="/AllMyContrat.html")
	
	public String AfficheAllContrat(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    
			    dao.valideContratByClause();
				if (user.getClass().getSimpleName().equals("Employe")) {
			    	
					model.addAttribute("contrats", dao.ContratOfEmp(user.getId_user()));
				} else {
	               model.addAttribute("contrats", dao.ContratOfFourn(user.getId_user()));
				}
			    
			    
			    
			      return "AfficheMyContrat";
			   }
	
	@RequestMapping(value="/OneContrat.html",method=RequestMethod.GET)
	public String AfficheOneModel(@RequestParam("p") int page,@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    Contrat contrat = dao.getContrat(id);
			    ArrayList<Clause> clauseM=dao.GetAllClauseByModel(contrat.getModel().getId_model());
			    ArrayList<Clause> clauseC=dao.getAllClauseByContrat(id);
			    ArrayList<Clause> clause=new ArrayList<Clause>();
			   System.out.println("this is the fucking shit "+clauseM);
			   
			    if (clauseM != null) {
					clause.addAll(clauseM);
				}
			    if (clauseC != null) {
			    	clause.addAll(clauseC);
				}
			    System.out.println("this is the size of clause"+clause .size());
			    
			    int size=clause.size();
			    int debut=page*10;
			    int fin=(size-debut > 10) ? (page*10+10) : size;
			    
			    
			     List<Clause> cl = clause.subList(debut, fin);
			    
			    model.addAttribute("contrat", contrat);
			    model.addAttribute("clause", cl);
			    model.addAttribute("size", clause.size());
			    
			    
			    
			      return "OneContrat";
			   }
	
	@RequestMapping(value="/RemoveContrat.html")
	public String RemoveContrat(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    dao.removeContrat(id);
			    
			    
			    
			      return "redirect:AllMyContrat.html";
			   }
	
	@RequestMapping(value="/valideContrat.html")
	public String ValideContrat(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    dao.valideContrat(id);
			    
			    
			    
			      return "redirect:AllMyContrat.html";
			   }
	
	
}
