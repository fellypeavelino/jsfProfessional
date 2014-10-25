package negocio;

import java.util.List;

import negocio.exceptions.CampoObrigatorio;
import dados.exceptions.ObjetoNaoEncontrado;
import dominio.Cliente;
import dominio.ClienteHistorico;

public interface IFachada {

	void inserirOuAtualizarCliente(Cliente cliente) throws CampoObrigatorio;
	
	void excluirCliente(Cliente cliente) throws CampoObrigatorio, ObjetoNaoEncontrado;

	public  List<ClienteHistorico> listarTodosHistoricos();
}
