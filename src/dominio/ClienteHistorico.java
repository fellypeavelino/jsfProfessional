package dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ClienteHistorico {

	@Id @GeneratedValue
	private Integer id;
	@ManyToOne
	private Cliente cliente;
	
	private String nome;
	private String cpf;
	private String telefone;
	private Situacao situacao;
	
	private Date dataAlteracao;	
	
	public ClienteHistorico(Cliente cliente) {
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
		this.situacao = cliente.getSituacao();
		this.cliente = cliente;
		this.dataAlteracao = new Date();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCpf() {
		return cpf;
	}


	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public Situacao getSituacao() {
		return situacao;
	}


	public void setSituacao(Situacao situacao) {
		this.situacao = situacao;
	}


	public Date getDataAlteracao() {
		return dataAlteracao;
	}
	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}
	@Override
	public String toString() {
		return "ClienteHistorico [cliente=" + super.toString() + ", dataAlteracao="
				+ dataAlteracao + "]";
	}


	public Cliente getCliente() {
		return cliente;
	}


	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
