package Ewig.model.BO;

import Ewig.model.VO.UsuarioVO;

public interface UsuarioInterBO<VO extends UsuarioVO> {
	public void cadastrar(VO us,String tipoUs);
	public void excluir(VO us);
	public void editar(VO us);
	public void visulaizarDados(VO us);
	public UsuarioVO[] listar();
	public UsuarioVO buscar(VO us, int tipo);
}
