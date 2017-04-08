package web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import model.Clause;
import model.Employe;
import model.Fournisseur;
import model.ModelContrat;
import model.Utilisateur;

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

public class ModeleController {

	@Autowired
	DaoImp dao;
	
	@RequestMapping(value="/AddModel.html")
	public String AddModel(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    if (!user.getClass().getSimpleName().equals("Employe")) {
					return "lock-page";
				}
			    model.addAttribute("Type", new ModelContrat());
			    
		
			      return "AddModel";
			   }
	
	@RequestMapping(value="/AfficheAllModel.html")
	public String AfficheModel(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    model.addAttribute("modeles", dao.AllModel());
			    
		
			      return "AfficheAllModel";
			   }
	
	@RequestMapping(value="/ajoutertype.html")
	public String InscriptionEmp(@ModelAttribute("Type")ModelContrat modelC,@ModelAttribute("Fournisseur")Fournisseur fourn,Model model,
			HttpServletRequest request) {
		        Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
		         modelC.setDate_creation(new Date());		         modelC.setEmp(dao.getEmpById(u.getId_user()));
		         try {
		        	 dao.AddModel(modelC);
		        	 model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>le modele bien ajouter </div>");
				} catch (DataIntegrityViolationException e) {
					model.addAttribute("msg","<div class=\"alert alert-danger\"><b>Oops ! </b>changer le nom de modele  </div>");
				}
		         
		
			      return "redirect:AddModel.html";
			   }
	
	@RequestMapping(value="/RemoveModel.html",method=RequestMethod.GET)
	public String removeModel(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    dao.removeModel(id);
			    
		
			      return "redirect:AfficheAllModel.html";
			   }
	
	@RequestMapping(value="/ModifyModel.html",method=RequestMethod.GET)
	public String modifModel(@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    if (!user.getClass().getSimpleName().equals("Employe")) {
					return "lock-page";
				}
			    ModelContrat c = dao.getModelById(id);
			    model.addAttribute("model",c);
			    model.addAttribute("id", id);
			    
			    
			      return "ModifyModel";
			   }
	
	
	@RequestMapping(value="/OneModel.html",method=RequestMethod.GET)
	public String AfficheOneModel(@RequestParam("p") int page,@RequestParam("id") int id,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    ArrayList<Clause> clause=dao.GetAllClauseByModel(id);
			    int size=clause.size();
			    int debut=page*10;
			    int fin=(size-debut > 10) ? (page*10+10) : size;
			    
			    
			     List<Clause> cl = clause.subList(debut, fin);
			    ModelContrat c = dao.getModelById(id);
			    model.addAttribute("model", c);
			    model.addAttribute("clause", cl);
			    model.addAttribute("size", clause.size());
			    
			    
			    
			      return "oneModel";
			   }
	
	@RequestMapping(value="/ModifyModelContr.html",method=RequestMethod.GET)
	public String modifymodelcontr(@ModelAttribute("model") ModelContrat m,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    
			    model.addAttribute("id",m.getId_model());
			    try {
			    	dao.modifyModel(m.getId_model(),m);
		        	 model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>le modele a ete bien modifier </div>");
				} catch (DataIntegrityViolationException e) {
					model.addAttribute("msg","<div class=\"alert alert-danger\"><b>Oops ! </b>changer le nom de modele  </div>");
				}
			    
			      return "redirect:ModifyModel.html";
			   }
	
	
}
