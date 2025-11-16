package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


import Entities.Client;


public class ClientImpl implements IClientdao{
	Connection c=ConnexionSingleton.getConnexion();

	public ArrayList<Client> afficherClient(String like) {
		ArrayList<Client> cls= new ArrayList<Client>();
		try {
		PreparedStatement ps =c.prepareStatement("Select * from clients where name LIKE ?");
		ps.setString(1,"%"+like+"%");
		ResultSet rs= ps.executeQuery();
		  while (rs.next()) {
			  Client cl =new Client();
			  cl.setId(rs.getInt("id"));
			  cl.setNom(rs.getString("name"));
			  cl.setPrenom(rs.getString("prenom"));
			  cl.setAge(rs.getInt("age"));
			  cls.add(cl);
		  }}
		catch(Exception e) {
			e.printStackTrace();
		}
		  return cls;
	}

	@Override
	public void creerClient(String nom, String prenom, int age) {
		try {
		    PreparedStatement ps = c.prepareStatement("INSERT INTO clients(name, prenom, age) VALUES (?, ?, ?)");
		    ps.setString(1, nom);
		    ps.setString(2, prenom);
		    ps.setInt(3, age);
		    ps.executeUpdate();
		    ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Client voireClientAmodifier(int id) {
		 Client cle =new Client();
		 try {
		PreparedStatement ps =c.prepareStatement("Select * from clients where id=?");
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		  while (rs.next()) {
			 
			  cle.setId(rs.getInt("id"));
			  cle.setNom(rs.getString("name"));
			  cle.setPrenom(rs.getString("prenom"));
			  cle.setAge(rs.getInt("age"));
		  }}catch(Exception e) {
			  e.printStackTrace();
		  }
		return cle;
	}

	@Override
	public void ModClient(String nom, String prenom, int age,int id) {
		try {
		PreparedStatement preps =c.prepareStatement("UPDATE clients SET name=?, prenom=?, age=? WHERE id=?");
		preps.setString(1,nom);
		preps.setString(2,prenom);
		preps.setInt(3,age);
		preps.setInt(4,id);
		preps.executeUpdate();
		preps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delClient(int id) {
		try {
		PreparedStatement ps =c.prepareStatement("Delete from clients where id = ?");
		ps.setInt(1,id);
		ps.executeUpdate();
		ps.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
