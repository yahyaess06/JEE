package Metier;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import Dao.EmployeIDAO;
import Entities.Employe;
import Model.EmployeModel;



public class EmpMetier implements IEmpMetier{
	private EmployeIDAO dao;
	public void setDao(EmployeIDAO dao) {
		this.dao = dao;
	}
	@Override
	public EmployeModel calculerPrime(int id) {
		Employe emp=dao.employeparid(id);
		Date date=emp.getDate_embauche();
		
		Period p= Period.between(LocalDate.parse(date.toString()), LocalDate.now());
		int prime=emp.getSalaire() +(p.getYears()*500);
		
		EmployeModel empmod = new EmployeModel();
		empmod.setNom(emp.getNom());
		empmod.setPrenom(emp.getPrenom());
		empmod.setPrime(prime);
		 return empmod;
	}

}
