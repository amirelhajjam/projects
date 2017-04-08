package web;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;

import model.*;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.hibernate.Hibernate;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import dao.DaoImp;




@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	DaoImp dao;
	
	@RequestMapping(value="/index")
	public String index(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    
		
			      return "index";
			   }
	
	@RequestMapping(value="/AllEmploye.html")
	public String allemp(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    ArrayList<Employe> e=dao.getAllEmployes();
			    JSONArray employes=new JSONArray(e);
			    System.out.println(employes);
			    model.addAttribute("employes", employes);
	    
		
			      return "AllEmploye";
			   }
	
	@RequestMapping(value="/AllFournisseur.html")
	public String allfourn(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    ArrayList<Fournisseur> f=dao.getAllFourn();
			    JSONArray fourn=new JSONArray(f);
			    
			    model.addAttribute("fourn", fourn);
			    
		
			      return "AllFourn";
			   }
	
	
	
	
	
	@RequestMapping(value="/connexion")
	public String Connexion(Model model,HttpServletRequest request) {
		Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
	    if (user!=null) {
			return "redirect:index.html";
		}
		model.addAttribute("Utilisateur",new Utilisateur());
		
			      return "connexion";
			   }
	
	
	@RequestMapping(value="/Inscription")
	public String inscription(Model model) {
			    
		model.addAttribute("Employe",new Employe());
		model.addAttribute("Fournisseur",new Fournisseur());
			      return "Inscription";
			   }
	
	@RequestMapping(value="/connexionUser")
	public String connexionUser(@ModelAttribute("Utilisateur")Utilisateur user,Model model,HttpServletRequest request) {
		String msg;
		Utilisateur u=dao.auth(user.getEmail(), user.getPassword());
		
		if(u==null){
			
			return "redirect:connexion.html";
			
		}
		else{
			request.getSession().setAttribute("user", u);
			System.out.println("had siyad rah"+u.getId_user());
			request.getSession().setAttribute("dao", dao);
			dao.valideContratByClause();
			
			if (u.getClass().getSimpleName().equals("Employe")) {
		    	
				request.getSession().setAttribute("contrats", dao.ContratOfEmp(u.getId_user()));
			} else {
               request.getSession().setAttribute("contrats", dao.ContratOfFourn(u.getId_user()));
			}
			
			
			
			return "redirect:index.html";
		}
			      
			   }
	
	
	@RequestMapping(value="/InscriptionEmp")
	public String InscriptionEmp(@ModelAttribute("Employe")Employe emp,@ModelAttribute("Fournisseur")Fournisseur fourn,Model model) {
		  
		
		     dao.addEmploye(emp);
		     String msg="votre inscription ";
			 model.addAttribute("msg", msg);
			 model.addAttribute("Employe",new Employe());
				model.addAttribute("Fournisseur",new Fournisseur());
		
			      return "Inscription";
			   }
	@RequestMapping(value="/InscriptionFourn")
	public String InscriptionFourn(@ModelAttribute("Fournisseur")Fournisseur fourn,Model model) {	   
			dao.addFournisseur(fourn);
			String msg="votre inscription";
			model.addAttribute(msg, "msg");
			model.addAttribute("Employe",new Employe());
			model.addAttribute("Fournisseur",new Fournisseur());
			      return "Inscription";
			   }
  
	
	@RequestMapping(value="/logout.html")
   public String logout(HttpServletRequest request) {
	   dao.deconnexion(request.getSession().getAttribute("user"));
	   request.getSession().removeAttribute("user");
	   return "redirect:connexion.html";
   }

  
   
}
