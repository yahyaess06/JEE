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
<%
int id=Integer.parseInt(request.getParameter("id"));
String url = "jdbc:mysql://localhost:3306/Clientsdb";
String user = "root";
String pwd = "yahya";
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url, user, pwd);
PreparedStatement ps =con.prepareStatement("Select * from clients where id=?");
ps.setInt(1, id);
ResultSet rs= ps.executeQuery();
%>
<div align="center" class="w-1/2 mx-auto px-4 py-3 rounded-xl mt-4 border-t-8
border-blue-500 shadow-lg
">
<form method="POST" action="mod.jsp?id=<%= id %>">
<label class=" text-gray-700 font-semibold">Le Nom :</label>
<%
while(rs.next()){
%>
<input type="text" name="nom" class="w-full
rounded ring-2 ring-blue-500 bg-gray-800 py-2 px-3 text-base mb-6 mt-8 
 placeholder:text-zinc-200 focus:outline-none text-blue-100" placeholder="votre nom" required value="<% out.print(rs.getString("name") ); %>">
<label class="text-gray-700 font-semibold">le Prenom :</label>
<input type="text" name="prenom"class="w-full
rounded ring-2 ring-blue-500 bg-gray-800 py-2 px-3 text-base mb-6 mt-8
 placeholder:text-zinc-200 focus:outline-none text-blue-100" placeholder="votre prenom" value="<% out.print(rs.getString("prenom") ); %>" required>
<label class="text-gray-700 font-semibold">l'age :</label>
<input type="number" name="age" class="w-full
rounded ring-2 ring-blue-500 bg-gray-800 py-2 px-3 text-base mb-6 mt-8
 placeholder:text-zinc-200 focus:outline-none text-blue-100" placeholder="votre age" value="<% out.print(rs.getInt("age") ); %>" required>
<button type="submit" class="bg-blue-500  w-1/3 py-3 px-3 text-white font-bold rounded-xl">envoyer</button>
</form> 
</div>
<%
}
%>


</body>
</html>