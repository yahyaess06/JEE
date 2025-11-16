package Dao;

import Entities.Employe;
import java.sql.*;

public class EmployeIMPL implements EmployeIDAO{
	Connection c=ConnexionSingleton.getConnexion();

	@Override
	public Employe employeparid(int id) {
		Employe emp = new Employe();
		try {
			PreparedStatement ps =c.prepareStatement("select * from employe where id=?");
			ps.setInt(1,id);
			ResultSet rs= ps.executeQuery();
			 while (rs.next()) {
				 emp.setNom(rs.getString("nom"));
				 emp.setPrenom(rs.getString("prenom"));
				 emp.setDate_embauche(rs.getDate("date_embauche"));
				 emp.setSalaire(rs.getInt("salaire"));
			 }
			 rs.close();
			 ps.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return emp;
	}

}
