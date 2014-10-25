package dados;

import dados.exceptions.ObjetoNaoEncontrado;
import dados.generico.IDAOGenerico;
import dominio.Cliente;

public interface IClienteDAO extends IDAOGenerico<Cliente> {
	public Cliente pesquisarClientePorCPF(String cpf) throws ObjetoNaoEncontrado;
}
