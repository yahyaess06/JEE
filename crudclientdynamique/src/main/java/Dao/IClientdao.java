package Dao;

import java.util.ArrayList;

import Entities.Client;


public interface IClientdao {
public ArrayList<Client> afficherClient(String like);
public void creerClient(String nom,String prenom,int age);
public Client voireClientAmodifier(int id);
public void ModClient(String nom,String prenom,int age,int id);
public void delClient(int id);
}
