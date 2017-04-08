<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inscription</title>
<script src="assets/js/jquery-1.8.3.min.js"></script>
<script type="text/javascript" src="assets/js/javascript.js"></script>
</head>
<body onload="onload()">
<h1>hello world!</h1>
${param.msg}

<h3>Inscription pour </h3> 
<select  id="typeIns" onchange="change()">
<option>Fournisseur</option>
<option selected>Employe</option>
</select>
<br></br>
<p >
<form:form id="employe"  method="POST"  action="InscriptionEmp.html" modelAttribute="Employe">
   <table >
    <tr>
        <td><form:label path="nom">nom</form:label></td>
        <td><form:input path="nom" /></td>
    </tr>
    <tr>
        <td><form:label path="prenom">prenom</form:label></td>
        <td><form:input path="prenom" /></td>
    </tr>
    <tr>
        <td><form:label path="telephone">telephone</form:label></td>
        <td><form:input path="telephone" /></td>
    </tr>
    <tr>
        <td><form:label path="adresse">adresse</form:label></td>
        <td><form:input path="adresse" /></td>
    </tr>
     <tr>
        <td><form:label path="matricule">matricule</form:label></td>
        <td><form:input path="matricule" /></td>
    </tr>
    <tr>
        <td><form:label path="grade">grade</form:label></td>
        <td><form:input path="grade" /></td>
    </tr>
    <tr>
        <td><form:label path="email">email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="password">password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</p>
<p id="fournisseur">
<form:form method="POST" id="fournisseur"  action="InscriptionFourn.html" modelAttribute="Fournisseur">
   <table >
    <tr>
        <td><form:label path="nom">nom</form:label></td>
        <td><form:input path="nom" /></td>
    </tr>
    <tr>
        <td><form:label path="prenom">prenom</form:label></td>
        <td><form:input path="prenom" /></td>
    </tr>
    <tr>
        <td><form:label path="telephone">telephone</form:label></td>
        <td><form:input path="telephone" /></td>
    </tr>
    <tr>
        <td><form:label path="adresse">adresse</form:label></td>
        <td><form:input path="adresse" /></td>
    </tr>
     <tr>
        <td><form:label path="nomSociete">nomSociete</form:label></td>
        <td><form:input path="nomSociete" /></td>
    </tr>
    <tr>
        <td><form:label path="adresseSoc">adresseSoc</form:label></td>
        <td><form:input path="adresseSoc" /></td>
    </tr>
     <tr>
        <td><form:label path="telSoc">telSoc</form:label></td>
        <td><form:input path="telSoc" /></td>
    </tr>
    <tr>
        <td><form:label path="emailSoc">emailSoc</form:label></td>
        <td><form:input path="emailSoc" /></td>
    </tr>
    <tr>
        <td><form:label path="email">email</form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="password">password</form:label></td>
        <td><form:input path="password" /></td>
    </tr>
   
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
</table>  
</form:form>
</p>
</body>
</html>