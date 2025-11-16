<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String url="jdbc:mysql://localhost:3306/ilcs_db";
 String user="root";
 String pwd="";
Class.forName("com.mysql.cj.jdbc.Driver");
Connection con= DriverManager.getConnection(url,user,pwd);
PreparedStatement ps =con.prepareStatement("insert into  etudiant(NOM,AGE) values(?,?)");
ps.setString(1,etudiant.getNom());
ps.setInt(2,etudiant.getAge());
ps.executeUpdate();
ps.close();
con.close();
return true;
%>
</body>
</html>