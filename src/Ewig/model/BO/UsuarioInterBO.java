package Ewig.model.BO;

import java.sql.SQLException;
import java.util.List;

import Ewig.model.VO.UsuarioVO;

public interface UsuarioInterBO<VO extends UsuarioVO> {
	public void cadastrar(VO us);
	public void excluir(VO us);
	public void editar(VO us);
	public List<UsuarioVO> listar(int tipoPesq);
	public UsuarioVO buscar(VO us, int tipoPesq) throws SQLException;
	public List<UsuarioVO> listarUsuariosSemPermissao();
}
