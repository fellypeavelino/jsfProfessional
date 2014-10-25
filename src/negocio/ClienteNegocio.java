package negocio;

import java.util.Date;
import java.util.List;

import negocio.exceptions.CampoObrigatorio;
import util.Validators;
import dados.IClienteDAO;
import dados.IClienteHistoricoDAO;
import dados.exceptions.ObjetoNaoEncontrado;
import dados.generico.DAOFactory;
import dominio.Cliente;
import dominio.ClienteHistorico;
import dominio.Situacao;

public class ClienteNegocio {

	private IClienteDAO daoCliente;
	private IClienteHistoricoDAO daoClienteHistorico;

	public ClienteNegocio() {
		this.daoCliente = DAOFactory.getClienteDAO();
		this.daoClienteHistorico = DAOFactory.getClienteHistoricoDAO();
	}

	public void inserirOuAtualizar(Cliente cliente) throws CampoObrigatorio {
		this.validarCamposObrigatorios(cliente);
		cliente.setSituacao(Situacao.ATIVO);
		try {
			Cliente clientePesquisado = daoCliente.pesquisarClientePorCPF(cliente.getCpf());
			cliente.setId(clientePesquisado.getId());
			daoCliente.alterar(cliente);
		} catch (ObjetoNaoEncontrado e) {
			daoCliente.inserir(cliente);
		}
		this.registrarHistorico(cliente);
		
	}

	private void validarCamposObrigatorios(Cliente cliente) throws CampoObrigatorio{
		if (cliente == null 
			|| Validators.verificarStringVazia(cliente.getCpf())
			|| Validators.verificarStringVazia(cliente.getNome())
			|| Validators.verificarStringVazia(cliente.getTelefone())
			) {
			throw new CampoObrigatorio();
		}
	}
	
	public void excluirCliente(Cliente cliente) throws ObjetoNaoEncontrado{
		cliente = daoCliente.consultarPorId(cliente.getId());
		cliente.setSituacao(Situacao.INATIVO);
		daoCliente.alterar(cliente);
		this.registrarHistorico(cliente);
	}
	
	private void registrarHistorico(Cliente cliente){
		ClienteHistorico clienteHist = new ClienteHistorico(cliente);
		clienteHist.setDataAlteracao(new Date());
		daoClienteHistorico.inserir(clienteHist);
	}
	
	public List<ClienteHistorico> listarTodosHistoricos(){
		return daoClienteHistorico.consultarTodos();
	}
}
