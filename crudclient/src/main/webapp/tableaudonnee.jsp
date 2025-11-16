<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="w-full table-auto text-center">
  <thead >
    <tr>
      <th class="border-b border-blue-300 py-2">Numero :</th>
      <th class="border-b border-blue-300 py-2">Nom :</th>
      <th class="border-b border-blue-300 py-2">Prenom :</th>
      <th class="border-b border-blue-300 py-2">Age :</th>
      <th class="border-b border-blue-300 py-2" colspan="2">Actions :</th>
    </tr>
  </thead>
  <tbody>
    <%
      int i = 1;
      while (rs.next()) {
    %>
    <tr class="hover:bg-blue-100">
      <td class="py-2"><%= i++ %></td>
      <td class="py-2"><%= rs.getString("name") %></td>
      <td class="py-2"><%= rs.getString("prenom") %></td>
      <td class="py-2"><%= rs.getInt("age") %></td>

      <td class="py-2">
        <a onclick="return suprimer()"
        href="deletion.jsp?id=<%= rs.getInt("id") %>"
           class="flex justify-center bg-red-500 hover:bg-red-600 
           w-24 py-2 rounded-xl text-white font-bold">
           Supprimer
        </a>
      </td>

      <td class="py-2">
        <a href="modification.jsp?id=<%= rs.getInt("id") %>"
           class="flex justify-center bg-green-500 hover:bg-green-600 
           w-24 py-2 rounded-xl text-white font-bold">
           Modifier
        </a>
      </td>
    </tr>
    <%
      }
    %>
  </tbody>
</table>
<script>
function suprimer(){
	alert('vouler vous supprimez vraiment ce clients??')
}
</script>
</body>
</html>