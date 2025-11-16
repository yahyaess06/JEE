<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<jsp:useBean id="etudiant" type="estn.Etudiant" scope="request"/>
<h2>Vos informations :</h2>
<table border="1">
<tr>
<td>Le Nom :</td>
<td><jsp:getProperty name="etudiant" property="nom"/></td>
</tr>
<tr>
<td>le Prenom :</td>
<td><jsp:getProperty name="etudiant" property="prenom"/></td>
</tr>
<tr>
<td>
La moyenne General :
</td>
<td><jsp:getProperty name="etudiant" property="note"/></td>
</tr>
</div>

</table>
</body>
</html>