package dao;

import javax.persistence.EntityManager;

import entities.Conta;
import util.HibernateUtil;

public class ContaDAO {

	public void salvar(Conta entidadeTeste) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();

    	entityManager.getTransaction().begin();
    	entityManager.persist(entidadeTeste);
    	entityManager.getTransaction().commit();

    	entityManager.close();
	}
	
}
