<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div align="center" class="w-1/2 mx-auto px-4 py-3 rounded-xl mt-4 border-t-8
border-blue-500 shadow-lg
">
<form method="POST" action="ajouterclient.jsp">
<label class=" text-gray-700 font-semibold">Le Nom :</label>
<input type="text" name="nom" class="w-full
rounded ring-2 ring-blue-500 bg-gray-800 py-2 px-3 text-base mb-6 mt-8 
 placeholder:text-zinc-200 focus:outline-none text-blue-100" placeholder="votre nom" required>
<label class="text-gray-700 font-semibold">le Prenom :</label>
<input type="text" name="prenom"class="w-full
rounded ring-2 ring-blue-500 bg-gray-800 py-2 px-3 text-base mb-6 mt-8
 placeholder:text-zinc-200 focus:outline-none text-blue-100" placeholder="votre prenom" required>
<label class="text-gray-700 font-semibold">l'age :</label>
<input type="number" name="age" class="w-full
rounded ring-2 ring-blue-500 bg-gray-800 py-2 px-3 text-base mb-6 mt-8
 placeholder:text-zinc-200 focus:outline-none text-blue-100" placeholder="votre age" required>
<button type="submit" class="bg-blue-500 text-white font-bold w-1/3 py-3 px-3  rounded-xl">envoyer</button>
</form> 
</div>
</body>
<%
String nom =request.getParameter("nom");
String prenom =request.getParameter("prenom");
String ages = request.getParameter("age");
int age =0;
if(ages == null || prenom == null || nom == null){
	
	out.print("<div class='bg-white w-1/2 mx-auto border-t-8 border-yellow-400 text-red-700 px-4 py-3 mt-4 text-center'>");
			out.print(" <strong class='font-bold text-yellow-600'>Attention !</strong>");
					out.print(" <span class='text-yellow-600'>Remplir tous les champs.</span></div>");

}else{
	age = Integer.parseInt(ages);
String url = "jdbc:mysql://localhost:3306/Clientsdb";
String user = "root";
String pwd = "yahya";
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection(url, user, pwd);
PreparedStatement ps =con.prepareStatement("insert into  clients(name,prenom,age) values(?,?,?)");
ps.setString(1,nom);
ps.setString(2,prenom);
ps.setInt(3,age);
if(ps.executeUpdate()>0){
	out.print("donnees ajouter avec succees");
	 response.sendRedirect("dashboard.jsp");
}else{
	out.print("erreur survenue");
}
ps.close();
con.close();
}
%>

</html>