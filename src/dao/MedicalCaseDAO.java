package dao;

import java.io.Serializable;

import javax.persistence.Query;

import model.MedicalCase;

public class MedicalCaseDAO extends BaseDAO<MedicalCase> implements Serializable{

	private static final long serialVersionUID = -1795827612367951144L;

	
	
	public MedicalCase findByName(String name){
		String queryString = "SELECT medicalcase FROM " + MedicalCase.class.getName() +" AS medicalcase WHERE medicalcase.name = :name";
		Query query = getEntityManager().createQuery(queryString);
		query.setParameter("name", name);
		if (query.getResultList().size() != 0)
			return (MedicalCase) query.getSingleResult();
		else return null;
	}
	
}