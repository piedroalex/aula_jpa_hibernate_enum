package principal;

import dao.ContaDAO;
import entities.Conta;
import enums.Status;

public class Principal {
	
	public static void main(String[] args) {
		ContaDAO contaDAO = new ContaDAO();
		
		Conta conta = new Conta();
		conta.setLogin("meulogin");
		conta.setStatus(Status.ATIVO);
		
		contaDAO.salvar(conta);
		
	}
}
