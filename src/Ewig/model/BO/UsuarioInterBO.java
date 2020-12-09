package Ewig.model.BO;

import Ewig.model.VO.UsuarioVO;

public interface UsuarioInterBO<VO extends UsuarioVO> {
	public void cadastrar(VO vo);
	public void excluir(VO vo);
	public void editar(VO vo);
	public void visulaizarDados(VO vo);
	public UsuarioVO[] listar();
	public UsuarioVO buscar(VO vo, int tipo);
}
