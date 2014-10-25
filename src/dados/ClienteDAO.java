package dados;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import dados.exceptions.ObjetoNaoEncontrado;
import dados.generico.DAOGenerico;
import dominio.Cliente;

public class ClienteDAO extends DAOGenerico<Cliente> implements IClienteDAO {

	public ClienteDAO(EntityManager em) {
		super(em);
	}
	
	public Cliente pesquisarClientePorCPF(String cpf) throws ObjetoNaoEncontrado{
		TypedQuery<Cliente> query = getEntityManager().createNamedQuery("Cliente.findByCPF", Cliente.class);
		query.setParameter("cpf", cpf);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
			throw new ObjetoNaoEncontrado();
		}
	} 

}
