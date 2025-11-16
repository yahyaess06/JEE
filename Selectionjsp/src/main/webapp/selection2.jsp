<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="erreur.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="selection2.jsp" method="POST">
Choisissez une couleur
			<p>
				<input type="radio" name="color" value="rouge" />Rouge<br />
				<input type="radio" name="color" value="bleu" />Bleu<br />
				<input type="radio" name="color" value="vert" />Vert<br />
				<input type="radio" name="color" value="orange" />Orange<br />
			</p>
			<input type="submit" value="Envoyer">
</form>
</p>

<%
String color = request.getParameter("color");

String method = request.getMethod();
if(color !=null){
	if(color.equals("orange")){
		throw new Exception("Cette couleur n'est pas belle");
	}
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