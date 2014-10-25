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
		testarInserirCliente("002211", "José Maria", "3423453");
		testarInserirCliente(null, "José Maria", "3423453");
		testarInserirCliente("002211", null, "3423453");
		testarInserirCliente("002211", "José Maria", null);
		testarInserirCliente("    ", "José Maria", "3423453");
		testarInserirCliente("002211", "         ", "   3423453");
		testarInserirCliente("002211", "José Maria", "      ");
		testarInserirCliente("002211", "Antônio José", "2452335");
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
			System.out.println("Inclusao.Erro de campo obrigatório: " + cliente);
		}
	}
	
	private static void testarExcluirCliente(String cpf){
		Cliente cliente = new Cliente();
		cliente.setCpf(cpf);
		try {
			fachada.excluirCliente(cliente);
			System.out.println("Cliente excluído com sucesso");
		} catch (CampoObrigatorio e) {
			System.out.println("Exclusao.Erro de campo obrigatório: " + cpf);
		} catch (ObjetoNaoEncontrado e) {
			System.out.println("Exclusao.Erro de objeto não encontrado: " + cpf);
		}
		
	}
	
	private static void imprimirTodosHistoricos(){
		List<ClienteHistorico> lista = fachada.listarTodosHistoricos();
		System.out.println("---- Histórico ---- ");
		for (ClienteHistorico clienteHistorico : lista) {
			System.out.println(clienteHistorico);
		}
	}
}
