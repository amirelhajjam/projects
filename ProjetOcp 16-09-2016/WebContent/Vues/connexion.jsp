<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Connexion</title>
 <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
     <script language="JavaScript">
    javascript: window.history.forward(1);
     </script>
</head>
<body>
<div id="login-page">
	  	<div class="container">
	  	    
	  	<form:form method="POST"  class="form-login" action="connexionUser.html" modelAttribute="Utilisateur">
    <h2 class="form-login-heading">sign in now</h2>
		        <div class="login-wrap">
		        <p>
		        <form:input path="email" class="form-control" placeholder="email" />
        
               </p><p> 
        <form:password path="password" class="form-control" placeholder="password" />
              </p>
              <p class="has-error" style="color:red;">${param.message}</p>
              <p>
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> Forgot Password?</a>
		
		                </span>
		          </p>
		          <p>
		              <input class="btn btn-theme btn-block" value="SIGN IN" type="submit" /> 
		            <hr>
		            
		           
		            <div class="registration">
		                Don't have an account yet?<br/>
		                <a class="" href="Inscription.html">
		                    Create an account
		                </a>
		            </div>
		           </div>
		           </form:form> 
		     </div>
		     <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">Forgot Password ?</h4>
		                      </div>
		                   <form method="post" action="resetpassword.html">   
		                      <div class="modal-body">
		                          <p>Enter your e-mail address below to reset your password.</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		                          <input type="submit" class="btn btn-default" value="submit"/>
		                      </div>
		                      </form>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">Cancel</button>
		                          <button class="btn btn-theme" type="button">Submit</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		         
   
		       	
	  	
	  	</div>
	 

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
    </script>


</body>
</html>