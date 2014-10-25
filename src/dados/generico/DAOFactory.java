package dados.generico;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dados.ClienteDAO;
import dados.ClienteHistoricoDAO;
import dados.IClienteDAO;
import dados.IClienteHistoricoDAO;

public abstract class DAOFactory {

	private static final EntityManagerFactory factory;
	private static IClienteDAO clienteDAO;
	private static IClienteHistoricoDAO clienteHistDAO;

	static {
		factory = Persistence.createEntityManagerFactory("unitPSC");
	}

	public static IClienteDAO getClienteDAO() {
		clienteDAO = new ClienteDAO(factory.createEntityManager());
		return clienteDAO;
	}

	public static IClienteHistoricoDAO getClienteHistoricoDAO() {
		clienteHistDAO = new ClienteHistoricoDAO(factory.createEntityManager());
		return clienteHistDAO;
	}

	public static void close() {
		if (factory != null && factory.isOpen()) {
			factory.close();
		}
	}

}
