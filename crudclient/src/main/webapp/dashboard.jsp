<%
String url = "jdbc:mysql://localhost:3306/Clientsdb";
String user = "root";
String pwd = "yahya";
Class.forName("com.mysql.jdbc.Driver");
String like=request.getParameter("like");
if (like == null) {
    like = "";
}
Connection con = DriverManager.getConnection(url, user, pwd);
PreparedStatement ps =con.prepareStatement("Select * from clients where name LIKE ?");
ps.setString(1,"%"+like+"%");
ResultSet rs= ps.executeQuery();
%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div align="center" class="mx-auto border-t-8 border-blue-500 w-sm px-4 py-12 rounded-xl mt-3 ml-28 mr-28">
<form method="POST" action="dashboard.jsp">
<div class="flex justify-around items-center mb-5">
<input type="text" name="like" placeholder="Entrer un nom " class="w-1/4
rounded ring-2 ring-blue-500 bg-gray-800 py-1.5 pr-3 pl-2 text-base text-white
 placeholder:text-zinc-200 focus:outline-none flex-center"/>
<button type="submit" class="flex-center bg-blue-500  w-1/4 py-3 px-3 
text-white font-bold rounded-xl" >
chercher
</button>
</form>
<a href="ajouterclient.jsp" class="inline bg-yellow-500 w-1/4 py-3 px-3 rounded-xl">
<button class="inline-flex flex-center
text-white font-bold">
ajouter
</button>
</a>
</div>
<%@ include file="tableaudonnee.jsp" %>
</div>

</body>
</html>