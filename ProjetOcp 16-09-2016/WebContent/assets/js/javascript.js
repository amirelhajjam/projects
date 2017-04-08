

function noBack(){window.history.forward()} 
noBack(); 
window.onload=noBack; 
window.onpageshow=function(evt){if(evt.persisted)noBack()} 
window.onunload=function(){void(0)} 

function onload(){
	var emp=document.getElementById("employe");
	var fourn=document.getElementById("fournisseur");
	emp.setAttribute("style", "visibility:hidden");
	fourn.setAttribute("style", "visibility:hidden");
}
function change(){
	var emp=document.getElementById("employe");
	var fourn=document.getElementById("fournisseur");
	console.log(fourn)
	
	  if ($("#typeIns").val()=="Employe") {
      	console.log($("#typeIns").val());
      	emp.setAttribute("style", "visibility:none");
      	fourn.setAttribute("style", "visibility:hidden");
		}
      if ($("#typeIns").val()=="Fournisseur") {
      	console.log($("#typeIns").val());
      	fourn.setAttribute("style", "visibility:none");
      	emp.setAttribute("style", "visibility:hidden");
		}
	
	
};
//
function confirmSupp(url)
{
	bootbox.dialog({
		  message: "Voulez vous supprimer ce modele ??",
		  title: "Suppression du modele",
		  buttons: {
		    success: {
		      label: "Annule!",
		      className: "btn-success",
		      callback: function() {
		        
		      }
		    },
		    danger: {
		      label: "Supprimer!",
		      className: "btn-danger",
		      callback: function() {
		    	  window.location.href=url;
		    	  bootbox.prompt("le modele a ete supprimer");
		      }
		    }
		    
		  }
		});


 
}

function confirmvalid(url){
	bootbox.dialog({
		  message: "Voulez vous validez cette clause",
		  title: "Validation du clause",
		  buttons: {
		    success: {
		      label: "Valider!",
		      className: "btn-success",
		      callback: function() {
		    	  window.location.href=url;
		      }
		    },
		    danger: {
		      label: "Annuler!",
		      className: "btn-danger",
		      callback: function() {
		    	  
		    	  
		      }
		    }
		    
		  }
		});
	
}

function confirmvalidContrat(url){
	bootbox.dialog({
		  message: "Voulez vous validez ce contrat",
		  title: "Validation du contrat",
		  buttons: {
		    success: {
		      label: "Valider!",
		      className: "btn-success",
		      callback: function() {
		    	  window.location.href=url;
		      }
		    },
		    danger: {
		      label: "Annuler!",
		      className: "btn-danger",
		      callback: function() {
		    	  
		    	  
		      }
		    }
		    
		  }
		});
	
}