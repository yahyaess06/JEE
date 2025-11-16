<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/tailwindcss@2.2.19/dist/tailwind.min.css" rel="stylesheet">
</head>
<body>
<div align="center" class="mx-auto border-t-8 border-blue-500 w-sm px-4 py-12 rounded-xl mt-3 ml-28 mr-28">
<form method="POST" action="acceuil.wamp">
<div class="flex justify-around items-center mb-5">
<input type="text" name="like" placeholder="Entrer un nom " class="w-1/4
rounded ring-2 ring-blue-500 bg-gray-800 py-1.5 pr-3 pl-2 text-base text-white
 placeholder:text-zinc-200 focus:outline-none flex-center"/>
<button type="submit" class="flex-center bg-blue-500  w-1/4 py-3 px-3 
text-white font-bold rounded-xl" >
chercher
</button>
</form>
<a href="pageajoute.wamp" class="inline bg-yellow-500 w-1/4 py-3 px-3 rounded-xl">
<button class="inline-flex flex-center
text-white font-bold">
ajouter
</button>
</a>
</div>
<table class="w-full table-auto text-center">
  <thead >
    <tr>
      <th class="border-b border-blue-300 py-2">Nom :</th>
      <th class="border-b border-blue-300 py-2">Prenom :</th>
      <th class="border-b border-blue-300 py-2">Age :</th>
      <th class="border-b border-blue-300 py-2" colspan="2">Actions :</th>
    </tr>
  </thead>
  <tbody>

   <c:forEach items="${Clients}" var="cl">
   
    <tr class="hover:bg-blue-100">
      <td class="py-2">${cl.nom}</td>
      <td class="py-2">${cl.prenom}</td>
      <td class="py-2">${cl.age}</td>

      <td class="py-2">
        <a onclick="return suprimer()"
        href="del.wamp?id=${cl.id}"
           class="flex justify-center bg-red-500 hover:bg-red-600 
           w-24 py-2 rounded-xl text-white font-bold">
           Supprimer
        </a>
      </td>

      <td class="py-2">
        <a href="modifier.wamp?id=${cl.id}"
           class="flex justify-center bg-green-500 hover:bg-green-600 
           w-24 py-2 rounded-xl text-white font-bold">
           Modifier
        </a>
      </td>
    </tr>
</c:forEach>
  </tbody>
</table>
</div>
<script>
function suprimer(){
	alert('vouler vous supprimez vraiment ce clients??')
}
</script>
</body>
</html>