package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Ewig.model.VO.UsuarioVO;

public interface UsuarioInterDAO {
	public abstract void cadastrar(UsuarioVO vo, String nomeTabela) throws SQLException;
	public abstract void excluir(UsuarioVO vo, String nomeTabela) throws SQLException;
	public abstract void atualizar(UsuarioVO vo, String nomeTabela) throws SQLException;
	public abstract ResultSet listar(String nomeTabela) throws SQLException;
	public abstract ResultSet buscarPorNome(UsuarioVO vo, String nomeTabela) throws SQLException;
	public abstract ResultSet buscarPorId(UsuarioVO vo, String nomeTabela) throws SQLException;
	public abstract ResultSet buscarPorLogin(UsuarioVO vo, String nomeTabela) throws SQLException;
}
