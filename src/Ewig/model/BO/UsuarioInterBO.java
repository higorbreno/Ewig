package Ewig.model.BO;

import Ewig.model.VO.UsuarioVO;

public interface UsuarioInterBO {
	public void cadastrar(UsuarioVO us);

	public void excluir(UsuarioVO us);
	
	public void editar(UsuarioVO us);
	
	public void visulaizarDados(UsuarioVO us);
	
	public UsuarioVO[] listar();
	
	public UsuarioVO buscar(UsuarioVO us);
	
}
