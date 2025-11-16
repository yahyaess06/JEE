package Metier;

import java.util.ArrayList;

import Entities.Client;

public interface IclientMetier {
   public ArrayList<Client> afficherdonnerClient(String like);
   public void creerClient(String nom,String prenom,int age);
   public Client afficherClientAmodifier(int id);
   public void modClient(String nom,String prenom,int age,int id);
   public void delClient(int id);
}
