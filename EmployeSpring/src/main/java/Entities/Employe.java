package Entities;

import java.util.Date;

public class Employe {
private String nom;
private String prenom;
private Date date_embauche;
private int salaire;
public Employe() {}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public Date getDate_embauche() {
	return date_embauche;
}
public void setDate_embauche(Date date_embauche) {
	this.date_embauche = date_embauche;
}
public int getSalaire() {
	return salaire;
}
public void setSalaire(int salaire) {
	this.salaire = salaire;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

}