package web;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import model.Message;
import model.Utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dao.DaoImp;


@Controller
public class MessageController {
    
	@Autowired
	DaoImp dao;
	@Autowired
	JavaMailSenderImpl mailSender;
	
	
	@RequestMapping(value="/SendMail.html")
	public String SendMail(Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    
			    model.addAttribute("message", new Message());
			    
			    
			      return "SendMail";
			   }
	
	@RequestMapping(value="/envoyerMsg.html")
	public String EnvoyerMsg(@ModelAttribute("message") Message m,Model model,HttpServletRequest request) {
			    Utilisateur user=(Utilisateur) request.getSession().getAttribute("user");
			    if (user==null) {
					return "redirect:connexion.html";
				}
			    SimpleMailMessage email = new SimpleMailMessage();
			    try {
			    	 String mail=dao.getUserByMail(m.getId_sendTo().getEmail()).getEmail();
					    email.setTo(mail);
					    email.setSubject(m.getTitle());
					    email.setText(m.getDescription());
					    
				} catch (NullPointerException e) {
				    model.addAttribute("msg","<div class=\"alert alert-danger\"><b>Oops !  </b>votre message n'est pas envoyer car l'email"+m.getId_sendTo().getEmail()+" </div>");

				}
			    try {
			    	mailSender.send(email); 
			    	m.setId_sendBy(user);
			    	m.setDate(new Date());
			    	dao.addmessage(m);
				    model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>votre message est bien envoyer </div>");
				    
				} catch (MailException e) {
					System.out.println(e.getMessage());
				}
			    mailSender.send(email);   
			    model.addAttribute("msg","<div class=\"alert alert-success\"><b>succes </b>votre message est bien envoyer </div>");
			    
			   
			    
			      return "SendMail";
			   }
}
