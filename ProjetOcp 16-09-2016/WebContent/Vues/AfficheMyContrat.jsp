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
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<section id="container" >
  <c:import url="Layouts/header.jsp"></c:import>
        <c:import url="Layouts/aside.jsp"></c:import>
        
       <section id="main-content">
          <section class="wrapper site-min-height">
          	
          	<div class="row mt">
          		<div class="col-lg-12">
          		 <table class="table table-striped table-advance table-hover">
	                  	  	  <h4><i class="fa fa-angle-right"></i>Tous mes contrats</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th><i class="fa fa-bullhorn"></i> Nom de contrat</th>
                                  <th><i class="hidden-phone"></i> modele de contrat</th>
                                  <th><i class="glyphicon glyphicon-calendar"></i> Date creation </th>
                                  <th><i class="fa fa-bookmark"></i> Employe </th>
                                  <th><i class="fa fa-bookmark"></i> Fournisseur </th>
                                  <th><i class="glyphicon glyphicon-calendar"></i> Date debut</th>
                                  <th><i class="glyphicon glyphicon-calendar"></i> Date fin</th>
                                  <th><i class="fa fa-bullhorn"></i> intitule</th>
                                  <th><i class="fa fa-bullhorn"></i>incoterm</th>
                                  <th><i class="fa fa-bullhorn"></i>penalties</th>
                                  <th><i class="fa fa-edit"></i> Statut </th>
                                  <th>Reaction</th>
                              </tr>
                              </thead>
                              <tbody>
                       <c:forEach var="c" items="${contrats}">       
                              <tr>
                                  <td><a href="${contextPath}/OneContrat.html?id=${c.id_contrat}&p=0">${c.nom_contrat}</a></td>
                                  <td>${dao.getModelById(c.model.id_model).titre}</td>
                                  <td>${c.date_Creation}</td>
                                   <td>${c.emp.nom} ${c.emp.prenom}</td> 
                                   <td>${c.fourn.nom} ${c.fourn.nom}</td>
                                   <td>${c.date_debut}</td>
                                   <td>${c.date_fin}</td>
                                   <td>${c.intitule_projet}</td>
                                   <td>${c.penalties}</td>
                                   <td>${c.intitule_projet}</td>
                                   <c:if test="${c.statut == true}"><td><span class="label label-success label-mini">Valide</span></td></c:if>
                                   <c:if test="${c.statut == false}"><td><span class="label label-warning label-mini">Non Valide</span></td></c:if>                             
                                  <td>
                                      
                                      <c:if test="${user.id_user == c.emp.id_user}">
                                      <a class="btn btn-danger btn-xs" onclick="confirmSupp('${contextPath}/RemoveContrat.html?id=${c.id_contrat}')"><i class="fa fa-trash-o "></i></a>
                                      </c:if>
                                      <c:if test="${user.id_user == c.fourn.id_user}">
                                       <a class="btn btn-success btn-xs" onclick="confirmvalidContrat('${contextPath}/valideContrat.html?id=${c.id_contrat}')"><i class="fa fa-check"></i></a>
                                      </c:if>
                                  </td>
                                  
                              </tr>
                       </c:forEach>       
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
    <script type="text/javascript" src="assets/js/bootbox.min.js"></script>
    <script type="text/javascript" src="assets/js/javascript.js"></script>
    


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    
  

</section>

</body>
</html>