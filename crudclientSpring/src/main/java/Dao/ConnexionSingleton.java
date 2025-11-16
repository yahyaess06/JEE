package Dao;

import java.sql.*;

public class ConnexionSingleton {
private static Connection connexion;
static {
	String url = "jdbc:mysql://localhost:3306/Clientsdb";
    String user = "root";
    String pwd = "yahya";
    try {
		Class.forName("com.mysql.jdbc.Driver");
		connexion = DriverManager.getConnection(url, user, pwd);  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
private ConnexionSingleton() {}
public static Connection getConnexion() {
	return connexion;
}

}
