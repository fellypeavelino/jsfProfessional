package gui.cliente;

import javax.faces.bean.ManagedBean;

import negocio.Fachada;
import negocio.IFachada;
import negocio.exceptions.CampoObrigatorio;
import dominio.Cliente;

@ManagedBean
public class ClienteBean {

	private Cliente cliente = new Cliente();
	private String mensagem;
	private IFachada fachada = Fachada.getInstancia();
	
	public String salvarCliente(){
		try {
			fachada.inserirOuAtualizarCliente(cliente);
			setMensagem("Cliente salvo com sucesso");
		} catch (CampoObrigatorio e) {
			setMensagem(e.getMessage());	
		}
		
		return "";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public String enviarParaMenu(){
		return "tabelaCliente.xhtml";
	}
}
