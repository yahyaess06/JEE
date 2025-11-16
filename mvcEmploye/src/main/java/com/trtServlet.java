package com;

import jakarta.servlet.ServletException;

import java.sql.*;
import java.time.LocalDate;
import java.time.Period;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class trtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public trtServlet() {
        super();

    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path=request.getServletPath();
		if("/accueil.do".equals(path)) {
			request.getRequestDispatcher("/index.html").forward(request, response);
		}
		else{
		int id=Integer.parseInt(request.getParameter("id"));
		Employe emp=new Employe();
		String url = "jdbc:mysql://localhost:3306/employedb";
		String user = "root";
		String pwd = "yahya";
		Date date = null;
		int Salaire=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Connection con = DriverManager.getConnection(url, user, pwd);
			PreparedStatement ps =con.prepareStatement("select * from employe where id=?");
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			 while (rs.next()) {
				 emp.setNom(rs.getString("nom"));
				 emp.setPrenom(rs.getString("prenom"));
				 date = rs.getDate("date_embauche");
				 Salaire= rs.getInt("salaire");
			 }
			 rs.close();ps.close();con.close();
			 int prime = 0;
			 Period p= Period.between(LocalDate.parse(date.toString()), LocalDate.now());
			 prime=Salaire +(p.getYears()*500);
			 emp.setPrime(prime);
			 request.setAttribute("emp",emp);
			 request.getRequestDispatcher("/rslt.jsp").forward(request, response);
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}}

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
