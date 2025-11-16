<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Selection de couleur</title>
</head>
<body>
<div align="center">
<p>
<form action="selection.jsp" method="POST">
Choisissez une couleur
			<p>
				<input type="radio" name="color" value="rouge" />Rouge<br />
				<input type="radio" name="color" value="bleu" />Bleu<br />
				<input type="radio" name="color" value="vert" />Vert<br />
			</p>
			<input type="submit" value="Envoyer">
</form>
</p>

<%
String color = request.getParameter("color");
String method = request.getMethod();
if(color !=null){
    if(method.equals("POST")){
	out.println("<p align='center'>vous avez chosie la couleur :"+color+"</p> ");
    }
    else{
	out.println("<p>vous n'avez pas choisie la methode Post</p>");
    }}
else{
	out.println("<h2>Vous devez choisir une couleur !</h2>");
}
%>
</div>
</body>
</html>