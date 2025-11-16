<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="Etudiant" class="estn.Etudiant" scope="request">
<jsp:setProperty name="Etudiant" property="*"/> 
<%
    request.setAttribute("etudiant", Etudiant);
    RequestDispatcher dispatcher = request.getRequestDispatcher("TraitementSevlet");
    dispatcher.forward(request, response);
    
%>
</jsp:useBean>
</body>
</html>