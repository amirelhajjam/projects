<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
<section id="container" >

        <c:import url="Layouts/header.jsp"></c:import>
        <c:import url="Layouts/aside.jsp"></c:import>
        <fmt:formatDate value="${Contrat.date_fin}" var="dateString" pattern="mm/dd/yyyy" />
        <fmt:formatDate value="${Contrat.date_debut}" var="dateString1" pattern="mm/dd/yyyy" />
       <section id="main-content">
          <section class="wrapper site-min-height">
          	<h3>Nouveau contrat </h3>
          	<div class="row mt">
          		<div class="col-lg-9">
          		<br><br><br>
          		${param.msg}
          		    <form:form method="POST"  action="ajouterContrat.html" modelAttribute="Contrat">
                 
                       <div class="form-group">
                              <form:label path="model.titre"  class="col-sm-2 col-sm-2 control-label">Le modèle de contrat</form:label>
                              <div class="col-sm-10">
                                  <form:select path="model.titre" class="form-control">
                                      <c:forEach var="m" items="${modeles}">
                                          <form:option value="${m.titre}"></form:option>
                                      </c:forEach>
                                  
                                  </form:select>
                              </div>
                          </div>
                          <br><br><br><br>
                           <div class="form-group">
                              <form:label path="fourn.email"  class="col-sm-2 col-sm-2 control-label">Le fournisseur de contrat</form:label>
                              <div class="col-sm-10">
                                  <form:select path="fourn.email" class="form-control">
                                      <c:forEach var="f" items="${fourn}">
                                          <form:option value="${f.email}"></form:option>
                                      </c:forEach>
                                  
                                  </form:select>
                              </div>
                          </div>
                          <br><br><br><br>
                      <div class="form-group">
                              <form:label path="nom_contrat"  class="col-sm-2 col-sm-2 control-label">Nom de contrat</form:label>
                              <div class="col-sm-10">
                                  <form:input path="nom_contrat" required="true" class="form-control"  />
                              </div>
                      </div>
                      <br><br><br>
                       <div class="form-group">
                              <form:label path="date_debut"  class="col-sm-2 col-sm-2 control-label">Date debut(dd/MM/yyyy)</form:label>
                              <div class="col-sm-10">
                                  <input name="date_d" type="date" required="true"  class="form-control" value="${dateString1}" />
                              </div>
                      </div>
                      <br><br><br>
                       <div class="form-group">
                              <form:label path="date_fin"  class="col-sm-2 col-sm-2 control-label">Date fin(dd/MM/yyyy)</form:label>
                              <div class="col-sm-10">
                                  <input name="date_f" type="date" required="true" class="form-control"  />
                              </div>
                      </div>
                      <br><br><br>
                       <div class="form-group">
                              <form:label path="montant"  class="col-sm-2 col-sm-2 control-label">Montant</form:label>
                              <div class="col-sm-10">
                                  <form:input path="montant" required="true" class="form-control"  />
                              </div>
                      </div>
                      <br><br><br>
                       <div class="form-group">
                              <form:label path="intitule_projet"  class="col-sm-2 col-sm-2 control-label">Intitule</form:label>
                              <div class="col-sm-10">
                                  <form:input path="intitule_projet" required="true" class="form-control"  />
                              </div>
                      </div>
                      <br><br><br>
                       <div class="form-group">
                              <form:label path="mode_reglement"  class="col-sm-2 col-sm-2 control-label">Mode reglement</form:label>
                              <div class="col-sm-10">
                                  <form:input path="mode_reglement" required="true" class="form-control"  />
                              </div>
                      </div>
                      <br><br><br>
                      <div class="form-group">
                             <form:label path="incoterm"  class="col-sm-2 col-sm-2 control-label">incoterm</form:label>
                            <div class="col-sm-10">
                              <form:select path="incoterm" class="form-control" id="idDateField">
                                   <form:options items="${incoterm}"  />
                              </form:select>
                             </div>
                      </div>
                       
                       <br><br><br>
                       <div class="form-group">
                              <form:label path="objet_vente"  class="col-sm-2 col-sm-2 control-label">objet vente</form:label>
                              <div class="col-sm-10">
                                  <form:input path="objet_vente" required="true" class="form-control"  />
                              </div>
                      </div>
                      
                      <br><br><br>
                       <div class="form-group">
                              <form:label path="penalties"  class="col-sm-2 col-sm-2 control-label">penalties</form:label>
                              <div class="col-sm-10">
                                  <form:input path="penalties" required="true" class="form-control"  />
                              </div>
                      </div>
                      
                       
                          
                          <br><br><br>
                          <div class="form-group">
                              <div class="col-sm-10">
                                  <input type="submit" class="btn btn-success" value="Ajouter"> 
                              </div>
                          </div> 
                          
                          
                        
                          
                </form:form>
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
    <script type="text/javascript" src="assets/js/javascript.js"></script>


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    
  

</section>

</body>
</html>