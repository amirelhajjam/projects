<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<header class="header black-bg">

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
              <div class="sidebar-toggle-box">
                  <div class="fa fa-bars tooltips" data-placement="right" data-original-title="Toggle Navigation"></div>
              </div>
            <!--logo start-->
            <a href="index.html" class="logo"><b>ContratOnline</b></a>
            <!--logo end-->
            <div class="nav notify-row" id="top_menu">
                <!--  notification start -->
                <ul class="nav top-menu">
                    <!-- settings start -->
                    <c:set var="NV" value="${dao.ContratNoValideOfUser(user.id_user)}"></c:set>
                    
                    <li class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" >
                            <i class="fa fa-tasks"></i>
                            <c:if test="${NV != 0}">
                            <span class="badge bg-theme">${NV}</span>
                            </c:if>
                        </a>
                        <ul class="dropdown-menu extended tasks-bar">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                               <c:if test="${NV != 0}">
                                <p class="green">vous avez ${NV} contrat non validé </p>
                                </c:if>
                                <c:if test="${NV == 0}">
                                <p class="green">il y'a pas de contrat non validé </p>
                                </c:if>
                            </li>
                            
                            <c:forEach var="c" items="${contrats}">
                            <li>
                                <a href="${contextPath}/OneContrat.html?id=${c.id_contrat}&p=0">
                                
                                    <div class="task-info">                
                                    <c:set var="NV_cl" value="${dao.clauseNoValide(c.id_contrat)}"></c:set>
                                    <c:set var="V" value="${dao.ValideClause(c.id_contrat)}"></c:set>
                                        <div class="desc">${c.nom_contrat }</div>
                                       
                                         <fmt:formatNumber var="number" value="0" maxFractionDigits="0"></fmt:formatNumber> 
                                         <c:if test="${V!=0 or NV_cl!=0 }">
                                           <fmt:formatNumber var="number" value="${V/(V+NV_cl)*100}" maxFractionDigits="0"></fmt:formatNumber>                                        
                                        </c:if>
                                        
                                        <div class="percent"><c:out value="${number}%"></c:out></div>
                                    </div>
                                   
                                    <div class="progress progress-striped">
                                        <c:if test="${number >= 80 }">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="${number}" aria-valuemin="0" aria-valuemax="100" style="width: ${number}%">
                                            <span class="sr-only">${number}% Complete </span>
                                        </div>
                                        </c:if>
                                         <c:if test="${number <= 50 }">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="${number}" aria-valuemin="0" aria-valuemax="100" style="width: ${number}%">
                                            <span class="sr-only">${number}% Complete </span>
                                        </div>
                                        </c:if>
                                         <c:if test="${number > 50 and number < 80 }">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="${number}" aria-valuemin="0" aria-valuemax="100" style="width: ${number}%">
                                            <span class="sr-only">${number}% Complete </span>
                                        </div>
                                        </c:if>
                                        
                                    </div>
                                    
                                </a>
                            </li>
                          </c:forEach>
                            <li class="external">
                                <a href="${contextPath}/AllMyContrat.html">Tous mes contrats</a>
                            </li>
                        </ul>
                    </li>
                    <!-- settings end -->
                    <!-- inbox dropdown start-->
                    <li id="header_inbox_bar" class="dropdown">
                        <a data-toggle="dropdown" class="dropdown-toggle" href="index.html#">
                            <i class="fa fa-envelope-o"></i>
                            <span class="badge bg-theme">5</span>
                        </a>
                        <ul class="dropdown-menu extended inbox">
                            <div class="notify-arrow notify-arrow-green"></div>
                            <li>
                                <p class="green">You have 5 new messages</p>
                            </li>
                            <li>
                                <a href="index.html#">
                                    <span class="photo"><img alt="avatar" src="assets/img/ui-zac.jpg"></span>
                                    <span class="subject">
                                    <span class="from">Zac Snider</span>
                                    <span class="time">Just now</span>
                                    </span>
                                    <span class="message">
                                        Hi mate, how is everything?
                                    </span>
                                </a>
                           
                            <li>
                                <a href="index.html#">See all messages</a>
                            </li>
                        </ul>
                    </li>
                    <!-- inbox dropdown end -->
                </ul>
                <!--  notification end -->
            </div>
            <div class="top-menu">
            	<ul class="nav pull-right top-menu">
                    <li><a class="logout" href="logout.html">Logout</a></li>
            	</ul>
            </div>
        </header>