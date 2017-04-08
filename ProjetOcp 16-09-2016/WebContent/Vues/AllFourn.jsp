<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="Dashboard">
    <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">

    <title>Contrat-Index</title>

    <!-- Bootstrap core CSS -->
    <link href="assets/css/bootstrap.css" rel="stylesheet">
    <!--external css-->
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
        
    <!-- Custom styles for this template -->
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    
    

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body ng-app="myApp">
<section id="container" >
  <c:import url="Layouts/header.jsp"></c:import>
        <c:import url="Layouts/aside.jsp"></c:import>
        
       <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3>Gestion de Contrat</h3>
          	<div class="row mt">
          		<div class="col-lg-12" ng-controller="fournctrl">
          		{{loadData('${fourn}')}}
          		<div class="col-lg-4">
          		
          		<label>Nom</label><input type="text" ng-model="nom" class="form-control"/>
          		</div>
          		<div class="col-lg-4">
          		<label class="col-sm-2 col-sm-2 control-label">Email</label>
          		<input type="text" ng-model="email" class="form-control"/>
          		</div>
          		<br><br><br><br><br><br>
          		<table class="table table-striped table-advance table-hover">
	                  	  	  
          		   <thead>
                              <tr>
                                  <th><i class="fa fa-bullhorn"></i> Nom et prenom</th>
                                  <th><i class="hidden-phone"></i> email</th>
                                  <th><i class="glyphicon glyphicon-calendar"></i> telephone </th>
                                  <th><i class="fa fa-bookmark"></i> adresse </th>
                                  <th><i class="fa fa-bookmark"></i> nom Societe </th>
                                  <th><i class="glyphicon glyphicon-calendar"></i>adresse Societe</th>
                                  <th><i class="glyphicon glyphicon-calendar"></i>telephone Societe</th>
                                  <th><i class="glyphicon glyphicon-calendar"></i>email Societe</th>
                                
                              </tr>
                   </thead>
                   <tbody >
                             
                              <tr  ng-repeat="fourn in fournisseurs | filter : {nom:nom} | filter : {email:email} ">
                                 <td>{{fourn.nom}} </td>
                                  <td>{{fourn.email}} </td>
                                   <td>{{fourn.telephone}} </td>
                                    <td>{{fourn.adresse}} </td>
                                     <td>{{fourn.nomSociete}} </td>
                                      <td>{{fourn.adresseSoc}} </td> 
                                      <td>{{fourn.telSoc}} </td> 
                                      <td>{{fourn.emailSoc}} </td> 
                              </tr>
                   </tbody>
              </table>

 
          		</div>
          	</div>
			
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
      <!--footer start-->
     <c:import url="Layouts/footer.jsp"></c:import>
      <!--footer end-->
  </section>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/jquery-ui-1.9.2.custom.min.js"></script>
    <script src="assets/js/jquery.ui.touch-punch.min.js"></script>
    <script class="include" type="text/javascript" src="assets/js/jquery.dcjqaccordion.2.7.js"></script>
    <script src="assets/js/jquery.scrollTo.min.js"></script>
    <script src="assets/js/jquery.nicescroll.js" type="text/javascript"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    <script type="text/javascript" src="assets/angular/app.js"></script>    


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    
  

</section>

</body>
</html>