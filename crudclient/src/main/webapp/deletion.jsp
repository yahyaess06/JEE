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
int id=Integer.parseInt(request.getParameter("id"));
String url = "jdbc:mysql://localhost:3306/Clientsdb";
String user = "root";
String pwd = "yahya";
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url, user, pwd);
PreparedStatement ps =con.prepareStatement("Delete from clients where id = ?");
ps.setInt(1,id);
if(ps.executeUpdate()>0){
	out.print("donnees ajouter avec succees");
	 response.sendRedirect("dashboard.jsp");
}else{
	out.print("erreur survenue");
}
ps.close();
con.close();

%>
</body>
</html>