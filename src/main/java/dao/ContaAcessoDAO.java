package dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.ContaAcesso;
import util.HibernateUtil;

/**
 * @author Pedro Alex
 */
public class ContaAcessoDAO {

	public void salvar(ContaAcesso contaAcesso) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.persist(contaAcesso);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Conta de acesso salva com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao salvar a conta de acesso!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}
	
	public void atualizar(ContaAcesso contaAcesso) {
		EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	entityManager.getTransaction().begin();
	    	entityManager.merge(contaAcesso);
	    	entityManager.getTransaction().commit();
	    	System.out.println("Conta de acesso atualizada com sucesso!");
    	} catch (Exception e) {
        	entityManager.getTransaction().rollback();
	    	System.out.println("Erro ao atualizar a conta de acesso!");
            e.printStackTrace();
        } finally {
        	entityManager.close();			
		}
	}
	
	public ContaAcesso buscarPorLogin(String login) {
    	EntityManager entityManager = HibernateUtil.getEntityManager();
    	try {
	    	TypedQuery<ContaAcesso> query = entityManager.createQuery("SELECT ca FROM ContaAcesso ca WHERE ca.login = :login", ContaAcesso.class);
	    	query.setParameter("login", login);
	    	ContaAcesso contaAcesso = query.getSingleResult();
	        return contaAcesso;
    	} catch (Exception e) {
			System.out.println("Nenhuma conta de acesso encontrada para esse login!");
			e.printStackTrace();
			return null;
		}
    }
	
}
