package Metier;

import java.util.ArrayList;
import Dao.IClientdao;
import Entities.Client;

public class ClientMetierImp implements IclientMetier{
  
	private IClientdao dao;
    public void setDao(IClientdao dao) {
		this.dao = dao;
	}
	@Override
	public ArrayList<Client> afficherdonnerClient(String like) {
		if (like == null) {
		    like = "";
		}
		ArrayList<Client> cls=dao.afficherClient(like);
		return cls;
	}
	@Override
	public void creerClient(String nom, String prenom, int age) {
	
		dao.creerClient(nom, prenom, age);
		
	}
	@Override
	public Client afficherClientAmodifier(int id) {
		Client cl=dao.voireClientAmodifier(id);
		return cl;
	}
	@Override
	public void modClient(String nom, String prenom, int age, int id) {
		dao.ModClient(nom, prenom, age, id);
		
	}
	@Override
	public void delClient(int id) {
		dao.delClient(id);
	}

}
