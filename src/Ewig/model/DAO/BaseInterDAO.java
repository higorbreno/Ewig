package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BaseInterDAO <VO>{
	public void cadastrar(VO entity) throws SQLException;
	public void excluir(VO entity) throws SQLException;
	public void atualizar(VO entity) throws SQLException;
	public ResultSet listar() throws SQLException;
	public ResultSet buscarPorNome(VO entity) throws SQLException;
	public ResultSet buscarPorId(VO entity) throws SQLException;
}