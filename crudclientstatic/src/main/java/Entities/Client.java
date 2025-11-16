package Entities;

public class Client {
private int id;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
private String name;
private String prenom;
private int age;
public Client() {

}
public String getNom() {
	return name;
}
public void setNom(String name) {
	this.name = name;
}
public String getPrenom() {
	return prenom;
}
public void setPrenom(String prenom) {
	this.prenom = prenom;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
