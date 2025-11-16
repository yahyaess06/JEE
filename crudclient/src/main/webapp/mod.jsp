<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
int idn=Integer.parseInt(request.getParameter("id"));
String nom =request.getParameter("nom");
String prenom =request.getParameter("prenom");
String ages = request.getParameter("age");
String method= request.getMethod();
if (method.equals("POST")){
	int age =0;
	if(ages == null || prenom == null || nom == null){
		out.print("remplire tout les champs");
	}else{
		age = Integer.parseInt(ages);
		String url = "jdbc:mysql://localhost:3306/Clientsdb";
		String user = "root";
		String pwd = "yahya";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url, user, pwd);
	PreparedStatement preps =con.prepareStatement("UPDATE clients SET name=?, prenom=?, age=? WHERE id=?");
	preps.setString(1,nom);
	preps.setString(2,prenom);
	preps.setInt(3,age);
	preps.setInt(4,idn);
	if(preps.executeUpdate()>0){
		out.print("donnees ajouter avec succees");
		 response.sendRedirect("dashboard.jsp");
	}else{
		out.print("erreur survenue");
	}
	preps.close();
	con.close();
	} 
}
%>
</body>
</html>