<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
        <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
       <section id="main-content">
          <section class="wrapper site-min-height">
          	
          	<div class="row mt">
          		<div class="col-lg-12">
          		<div class="showback">
          		  <h3>
          		     <i class="fa fa-angle-right"></i>
          		      Le Nom de modèle est : ${model.titre}
          		  </h3>
          		  <br>
          		  <h4 style="text-indent: 1em;">
          		     <i class="fa fa-angle-right"></i>
          		     Une description sur le modèle :
          		  </h4>
          		  <br>
          		  <p style="text-indent: 3em;">${model.description} </p>
          		  </div>
          		  
          		   <table class="table table-striped table-advance table-hover">
	                  	  	  <h4><i class="fa fa-angle-right"></i>Tous les clauses</h4>
	                  	  	  <hr>
                              <thead>
                              <tr>
                                  <th><i class="fa fa-bullhorn"></i> Nom de clause</th>
                                  <th><i class="hidden-phone"></i>Description</th>
                                  <th><i class="glyphicon glyphicon-calendar"></i> La date de creation du clause</th>
                                  <th><i class="btn btn-default btn-sm"></i>Employe </th>
                                  <th>Reaction</th>
                              </tr>
                              </thead>
                              <tbody>
                       <c:forEach var="m" items="${clause}">       
                              <tr>
                                  <td><a>${m.nom_Clause}</a></td>
                                  <td>${m.description}</td>
                                  <td>${m.data_creation}</td>
                                  <td>${m.emp.nom} ${m.emp.prenom}</td>                                                              
                                  <td>
                                      <c:if test="${m.emp.id_user == user.id_user }"> 
                                      <a class="btn btn-primary btn-xs" href="${contextPath}/ModifyClause.html?id=${m.id_clause}"><i class="fa fa-pencil"></i></a>
                                      <a class="btn btn-danger btn-xs" onclick="confirmSupp('${contextPath}/RemoveClause.html?id=${m.id_clause}&id_model=${param.id}')"><i class="fa fa-trash-o "></i></a>
                                  </c:if>
                                  </td>
                                  
                              </tr>
                       </c:forEach>       
                              </tbody>
                           </table>
            <div class="text-center">
          		   <ul class="pagination">
          		    <fmt:parseNumber var="i" integerOnly="true" 
                       type="number" value="${size/10}" />
                    <li>
                         <a  href="${contextPath}/OneModel.html?id=${param.id}&p=<c:if test="${param.p == 0}">${i}</c:if><c:if test="${param.p != 0}">${param.p - 1}</c:if>">
                             precedent
                         </a>
                    </li>
                   <c:forEach begin="0" end="${size/10}" step="1" var="s">
                    <li <c:if test="${param.p == s}">class="active"</c:if>>
                        <a href="${contextPath}/OneModel.html?id=${param.id}&p=${s}">${s}</a>
                    </li>
                   </c:forEach>
                    <li>
                         <a href="${contextPath}/OneModel.html?id=${param.id}&p=<c:if test="${param.p == i}">0</c:if><c:if test="${param.p != i}">${param.p + 1}</c:if>">
                            suivant
                          </a>
                     </li>
                  </ul>
          		</div>                
          		 
          		  
          		  
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