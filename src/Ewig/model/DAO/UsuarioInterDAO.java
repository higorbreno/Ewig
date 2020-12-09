package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Ewig.model.VO.UsuarioVO;

public interface UsuarioInterDAO<VO extends UsuarioVO> {
	public abstract void cadastrar(VO vo, String nomeTabela) throws SQLException;
	public abstract void excluir(VO vo, String nomeTabela) throws SQLException;
	public abstract void atualizar(VO vo, String nomeTabela) throws SQLException;
	public abstract ResultSet listar(String nomeTabela) throws SQLException;
	public abstract ResultSet buscarPorNome(VO vo, String nomeTabela) throws SQLException;
	public abstract ResultSet buscarPorId(VO vo, String nomeTabela) throws SQLException;
	public abstract ResultSet buscarPorLogin(VO vo, String nomeTabela) throws SQLException;
	public abstract ResultSet listarUsuariosSemPermissao() throws SQLException;
}
