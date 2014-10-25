package dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="Cliente.findByCPF", query="Select c from Cliente c where c.cpf = :cpf")
public class Cliente {

	@Id @GeneratedValue
	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private Situacao situacao;


	public Cliente() {
	}

	public Cliente(String nome, String cpf, String telefone, Situacao situacao) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.situacao = situacao;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Cliente [nome=" + nome + ", cpf=" + cpf + ", telefone="
				+ telefone + ", situacao=" + situacao + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
