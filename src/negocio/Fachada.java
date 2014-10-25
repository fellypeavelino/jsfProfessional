package negocio;

import java.util.List;

import negocio.exceptions.CampoObrigatorio;
import dados.exceptions.ObjetoNaoEncontrado;
import dominio.Cliente;
import dominio.ClienteHistorico;

public class Fachada implements IFachada {

	private ClienteNegocio clienteNegocio;
	
	private static IFachada instancia;
	
	private Fachada(){
		clienteNegocio = new ClienteNegocio();
	}
	
	public static IFachada getInstancia(){
		if (instancia == null){
			instancia = new Fachada();
		} 
		return instancia;
	}
	@Override
	public void inserirOuAtualizarCliente(Cliente cliente)
			throws CampoObrigatorio {
		clienteNegocio.inserirOuAtualizar(cliente);
	}

	@Override
	public void excluirCliente(Cliente cliente) throws CampoObrigatorio,
			 ObjetoNaoEncontrado {
		clienteNegocio.excluirCliente(cliente);
	}

	@Override
	public List<ClienteHistorico> listarTodosHistoricos(){
		return this.clienteNegocio.listarTodosHistoricos();
	}
}
