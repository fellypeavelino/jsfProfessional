package dados;

import javax.persistence.EntityManager;

import dados.generico.DAOGenerico;
import dominio.ClienteHistorico;

public class ClienteHistoricoDAO extends DAOGenerico<ClienteHistorico> implements IClienteHistoricoDAO {

	public ClienteHistoricoDAO(EntityManager em) {
		super(em);
	}

}
