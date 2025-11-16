package mvcCrudclient;

import jakarta.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("*.wamp")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		System.out.print(path);
		String url = "jdbc:mysql://localhost:3306/Clientsdb";
		String user = "root";
		String pwd = "yahya";
		
		if("/acceuil.wamp".equals(path)) {
			ArrayList<Client> cls= new ArrayList<Client>();
			String like=request.getParameter("like");
			if (like == null) {
			    like = "";
			}try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement ps =con.prepareStatement("Select * from clients where name LIKE ?");
			ps.setString(1,"%"+like+"%");
			ResultSet rs= ps.executeQuery();
			  while (rs.next()) {
				  Client cl =new Client();
				  cl.setId(rs.getInt("id"));
				  cl.setNom(rs.getString("name"));
				  cl.setPrenom(rs.getString("prenom"));
				  cl.setAge(rs.getInt("age"));
				  cls.add(cl);
			  }
			  
			  request.setAttribute("Clients", cls);
			}
			 catch (ClassNotFoundException e) {
				    e.printStackTrace();
				}
			catch (SQLException e) {
			    e.printStackTrace();
			}
			request.getRequestDispatcher("/Dashboard.jsp").forward(request, response);;
			}
		else if("/pageajoute.wamp".equals(path)) {
			request.getRequestDispatcher("/ajouter.jsp").forward(request, response);
		}
		else if("/ajouter.wamp".equals(path)){
			PrintWriter out = response.getWriter();
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
				try {
				    Class.forName("com.mysql.cj.jdbc.Driver");
				    Connection con = DriverManager.getConnection(url, user, pwd);
				    String sql = "INSERT INTO clients(name, prenom, age) VALUES (?, ?, ?)";
				    PreparedStatement ps = con.prepareStatement(sql);
				    ps.setString(1, nom);
				    ps.setString(2, prenom);
				    ps.setInt(3, age);
				    ps.executeUpdate();
				    response.sendRedirect("acceuil.wamp");
				    ps.close();
				    con.close();

				} catch (ClassNotFoundException e) {
				    e.printStackTrace();
				} catch (SQLException e) {
				    e.printStackTrace();
				}
				}
			}else if("/modifier.wamp".equals(path)){
				int id=Integer.parseInt(request.getParameter("id"));
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement ps =con.prepareStatement("Select * from clients where id=?");
				ps.setInt(1, id);
				ResultSet rs= ps.executeQuery();
				  while (rs.next()) {
					  Client cle =new Client();
					  cle.setId(rs.getInt("id"));
					  cle.setNom(rs.getString("name"));
					  cle.setPrenom(rs.getString("prenom"));
					  cle.setAge(rs.getInt("age"));
					  request.setAttribute("cl",cle);
				  }
				} catch (ClassNotFoundException e) {
				    e.printStackTrace();
				} catch (SQLException e) {
				    e.printStackTrace();
				}
				request.getRequestDispatcher("/modifier.jsp").forward(request, response);
			}else if("/mod.wamp".equals(path)) {
				PrintWriter out = response.getWriter();
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
						try {
						Class.forName("com.mysql.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, user, pwd);
					PreparedStatement preps =con.prepareStatement("UPDATE clients SET name=?, prenom=?, age=? WHERE id=?");
					preps.setString(1,nom);
					preps.setString(2,prenom);
					preps.setInt(3,age);
					preps.setInt(4,idn);
					if(preps.executeUpdate()>0){
						out.print("donnees ajouter avec succees");
						 response.sendRedirect("acceuil.wamp");
					}else{
						out.print("erreur survenue");
					}
					preps.close();
					con.close();
					} catch (ClassNotFoundException e) {
					    e.printStackTrace();
					} catch (SQLException e) {
					    e.printStackTrace();
					} 
				}
			}}
			else if("/del.wamp".equals(path)) {
				PrintWriter out = response.getWriter();
				int id=Integer.parseInt(request.getParameter("id"));
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection(url, user, pwd);
				PreparedStatement ps =con.prepareStatement("Delete from clients where id = ?");
				ps.setInt(1,id);
				if(ps.executeUpdate()>0){
					out.print("donnees ajouter avec succees");
					 response.sendRedirect("acceuil.wamp");
				}else{
					out.print("erreur survenue");
				}
				ps.close();
				con.close();
				}catch (ClassNotFoundException e) {
				    e.printStackTrace();
				} catch (SQLException e) {
				    e.printStackTrace();
				} 
			}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
