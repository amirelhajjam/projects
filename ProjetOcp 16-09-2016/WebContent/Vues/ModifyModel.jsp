<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
      <c:set var="id" value="${id}" scope="request"/>
       <section id="main-content">
          <section class="wrapper site-min-height">
          	
          	<div class="row mt">
          		<div class="col-lg-9">
          		<h4>Ajouter un type de contrat.</h4>
          		   
          		<br>
          		${param.msg}
          		
          		<br><br>
          			<div class="">
          		<form:form method="GET"  action="ModifyModelContr.html" modelAttribute="model">
                      
                      <div class="form-group" hidden>
                              <form:label path="id_model"  class="col-sm-2 col-sm-2 control-label">le nom de modèle</form:label>
                              <div class="col-sm-10">
                                  <form:input path="id_model" class="form-control"  />
                              </div>
                      </div>
                      <div class="form-group">
                              <form:label path="titre"  class="col-sm-2 col-sm-2 control-label">le nom de modèle</form:label>
                              <div class="col-sm-10">
                                  <form:input path="titre" class="form-control"  />
                              </div>
                      </div>
                          <br><br><br>
                          <div class="form-group">
                              <form:label path="description"  class="col-sm-2 col-sm-2 control-label">La description de modèle</form:label>
                              <div class="col-sm-10">
                                  <form:textarea  path="description" class="form-control"  />
                              </div>
                          </div> 
                          
                          
                          <div class="form-group">
                              <div class="col-sm-10">
                                  <input type="submit" class="btn btn-success" value="Modifier"> 
                              </div>
                          </div> 
                          
                          
                        
                          
                </form:form>
          		</div>
          			
          	</div>
          	</div>
          
			
		</section><! --/wrapper -->
      </section><!-- /MAIN CONTENT -->

      <!--main content end-->
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


    <!--common script for all pages-->
    <script src="assets/js/common-scripts.js"></script>

    <!--script for this page-->
    
  

</section>

</body>
</html>