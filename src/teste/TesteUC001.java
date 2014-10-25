package teste;

import java.util.List;

import dados.exceptions.ObjetoNaoEncontrado;
import dados.generico.DAOFactory;
import dominio.Cliente;
import dominio.ClienteHistorico;
import negocio.Fachada;
import negocio.IFachada;
import negocio.exceptions.CampoObrigatorio;

public class TesteUC001 {

	private static IFachada fachada = Fachada.getInstancia();
	
	public static void main(String[] args) {
		testarInserirCliente("002211", "Jos� Maria", "3423453");
		testarInserirCliente(null, "Jos� Maria", "3423453");
		testarInserirCliente("002211", null, "3423453");
		testarInserirCliente("002211", "Jos� Maria", null);
		testarInserirCliente("    ", "Jos� Maria", "3423453");
		testarInserirCliente("002211", "         ", "   3423453");
		testarInserirCliente("002211", "Jos� Maria", "      ");
		testarInserirCliente("002211", "Ant�nio Jos�", "2452335");
		testarInserirCliente("124095", "Gabriela Muniz", "38894342");
		testarInserirCliente("589332", "Paulo Joaquim", "5893-23");
		
		testarExcluirCliente("002211");
		testarExcluirCliente("4444");
		
		imprimirTodosHistoricos();
		DAOFactory.close();
		System.out.println("fim");
	}
	
	private static void testarInserirCliente(String cpf, String nome, String telefone){
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		cliente.setNome(nome);
		cliente.setTelefone(telefone);
		try {
			fachada.inserirOuAtualizarCliente(cliente);
			System.out.println("Cliente atualizado: " + cliente);
		} catch (CampoObrigatorio e) {
//			e.printStackTrace();
			System.out.println("Inclusao.Erro de campo obrigat�rio: " + cliente);
		}
	}
	
	private static void testarExcluirCliente(String cpf){
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		try {
			fachada.excluirCliente(cliente);
			System.out.println("Cliente exclu�do com sucesso");
		} catch (CampoObrigatorio e) {
			System.out.println("Exclusao.Erro de campo obrigat�rio: " + cpf);
		} catch (ObjetoNaoEncontrado e) {
			System.out.println("Exclusao.Erro de objeto n�o encontrado: " + cpf);
		}
		
	}
	
	private static void imprimirTodosHistoricos(){
		List<ClienteHistorico> lista = fachada.listarTodosHistoricos();
		System.out.println("---- Hist�rico ---- ");
		for (ClienteHistorico clienteHistorico : lista) {
			System.out.println(clienteHistorico);
		}
	}
}
