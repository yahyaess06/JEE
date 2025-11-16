package estn;

public class Etudiant {
private String nom;
private String prenom;
private int note;
public Etudiant() {
	
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPrenom() {
	return prenom;
}
public int getNote() {
	return note;
}
public void setNote(int note) {
	this.note = note;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}

}
