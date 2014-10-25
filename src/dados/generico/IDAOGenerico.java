package dados.generico;

import java.util.List;

import dados.exceptions.ObjetoNaoEncontrado;

public interface IDAOGenerico<Entidade> {

	public void inserir(Entidade entidade);
	
	public void alterar(Entidade entidade);
	
	public void remover(Entidade entidade);
	
	public Entidade consultarPorId(Integer id) throws ObjetoNaoEncontrado;
	
	public List<Entidade> consultarTodos();
	
	public List<Entidade> consultarTodos(Integer indiceInicial,	Integer quantidade);
	

}
