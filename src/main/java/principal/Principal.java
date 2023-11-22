package principal;

import dao.ContaAcessoDAO;
import entities.ContaAcesso;
import enums.Status;

/**
 * @author Pedro Alex
 */
public class Principal {
	
	public static void main(String[] args) {
		ContaAcessoDAO contaAcessoDAO = new ContaAcessoDAO();
		
		ContaAcesso contaAcesso = new ContaAcesso();
		contaAcesso.setLogin("meulogin");
		contaAcesso.setStatus(Status.ATIVO);
		
		contaAcessoDAO.salvar(contaAcesso);
		
		contaAcesso = contaAcessoDAO.buscarPorLogin("meulogin");
		contaAcesso.setStatus(Status.INATIVO);

		contaAcessoDAO.atualizar(contaAcesso);
	}
}
