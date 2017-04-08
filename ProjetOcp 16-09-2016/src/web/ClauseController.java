package web;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.Clause;
import model.Contrat;
import model.ModelContrat;
import model.Utilisateur;
import model.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DaoImp;


@Controller
public class ClauseController {

	@Autowired
	DaoImp dao;
	
	
	@RequestMapping(value="/AddClause.html")
	public String index(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    if (!user.getClass().getSimpleName().equals("Employe")) {
					return "lock-page";
				}
			    if (dao.AllModel()== null) {
					model.addAttribute("msg", "<div class=\"alert alert-danger\"><b>Oops </b>tu doit ajouter un modèle pour ajouter un clause </div>");
				   return "AddClause";
			    }
			    model.addAttribute("Clause", new Clause());
			    model.addAttribute("modeles", dao.AllModel());
			      return "AddClause";
			   }
	
	@RequestMapping(value="/ajouterClause.html")
	public String ajouterClause(@ModelAttribute("Clause")Clause c,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
			    c.setEmp(dao.getEmpById(u.getId_user()));
			    System.out.println(c.getModel().getTitre());
			    ModelContrat m=dao.ModelByTitre(c.getModel().getTitre());
			    c.setModel(m);
			    c.setData_creation(new Date());
			    dao.addClause(c);
			    ArrayList<Contrat> contrats=dao.getContratByModel(m.getId_model());
			    for (Contrat contrat : contrats) {
			    	Validation v=new Validation();
			    	v.setClause(c);
			    	v.setContrat(contrat);
			    	v.setDate(new Date());
			    	v.setStatutOfClause(false);
					dao.addValidation(v);
				}
			    model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>la clause a ete bien ajouter </div>");
			   
			      return "redirect:AddClause.html";
			   }
	
	@RequestMapping(value="/RemoveClause.html",method=RequestMethod.GET)
	public String removeModel(@RequestParam("id") int id,@RequestParam("id_model") int id_m,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    dao.removeClause(id);
			    model.addAttribute("id", id_m);
			    model.addAttribute("p", 0);
			    
		
			      return "redirect:OneModel.html";
			   }
	@RequestMapping(value="/RemoveClausefromContrat.html",method=RequestMethod.GET)
	public String removeclause(@RequestParam("id") int id,@RequestParam("contrat") int id_m,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    dao.removeClause(id);
			    model.addAttribute("id", id_m);
			    model.addAttribute("p", 0);
			    
		
			      return "redirect:OneContrat.html";
			   }
	
	@RequestMapping(value="/ModifyClause.html",method=RequestMethod.GET)
	public String modifModel(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    if (!user.getClass().getSimpleName().equals("Employe")) {
					return "lock-page";
				}
			    Clause c = dao.getClauseById(id);
			    model.addAttribute("Clause",c);
			    model.addAttribute("id", id);
			    model.addAttribute("modeles", dao.AllModel());
			    
			    
			      return "ModifyClause";
			   }
	
	@RequestMapping(value="/ModifyClauseForContrat.html",method=RequestMethod.GET)
	public String modifClauseForContrat(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    Clause c = dao.getClauseById(id);
			    model.addAttribute("Clause",c);
			    model.addAttribute("id", id);
			    
			    
			    
			      return "ModifyClauseForContrat";
			   }
	
	
	@RequestMapping(value="/OneClause.html",method=RequestMethod.GET)
	public String AfficheOneClause(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    ArrayList<Clause> clause=dao.GetAllClauseByModel(id);
			    ModelContrat c = dao.getModelById(id);
			    model.addAttribute("model", c);
			    model.addAttribute("clause", clause);
			    
			    
			    
			      return "oneClause";
			   }
	
	@RequestMapping(value="/ModifyClauseContr.html",method=RequestMethod.GET)
	public String modifymodelcontr(@ModelAttribute("Clause") Clause c,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    
			    model.addAttribute("id",c.getId_clause());
			    
			    	try {
			    		c.setModel(dao.ModelByTitre(c.getModel().getTitre()));
					} catch (NullPointerException e) {
						// TODO: handle exception
					 }
			    try {
			    	dao.modifyClause(c.getId_clause(),c);
		        	 model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>le clause a ete bien modifier </div>");
				} catch (DataIntegrityViolationException e) {
					model.addAttribute("msg","<div class=\"alert alert-danger\"><b>Oops ! </b>changer le nom de modele  </div>");
				}
			
			    
			      return "redirect:ModifyClause.html";
			   }
	
	@RequestMapping(value="/ModifyClauseForContratContr.html",method=RequestMethod.GET)
	public String modifyclauseForContrat(@ModelAttribute("Clause") Clause c,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    
			    model.addAttribute("id",c.getId_clause());
			    try {
			    	dao.modifyClause(c.getId_clause(),c);
		        	 model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>le clause a ete bien modifier </div>");
				} catch (DataIntegrityViolationException e) {
					model.addAttribute("msg","<div class=\"alert alert-danger\"><b>Oops ! </b>changer le nom de modele  </div>");
				}
			
			    
			      return "redirect:ModifyClauseForContrat.html";
			   }
	@RequestMapping(value="/validerClause.html",method=RequestMethod.GET)
	public String valideClause(@RequestParam("id") int id,@RequestParam("id_contrat") int id_c,@RequestParam("p") int p,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    
			    dao.ValideClause(id, id_c);
	        	 model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>le clause a ete bien modifier </div>");
                model.addAttribute("id", id_c);
                model.addAttribute("p", p);
			    
			    
			      return "redirect:OneContrat.html";
			   }
}
