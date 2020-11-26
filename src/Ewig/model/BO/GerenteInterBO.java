package Ewig.model.BO;

import Ewig.model.VO.GerenteVO;

public interface GerenteInterBO {
	public void cadastrar(GerenteVO gerente);
	
	public void excluir(GerenteVO gerente);
	
	public void editar(GerenteVO gerente);
	
	public void visualizarDados(GerenteVO gerente);

	public GerenteVO[] listar();
	
	public void buscar(GerenteVO gerente);
}
