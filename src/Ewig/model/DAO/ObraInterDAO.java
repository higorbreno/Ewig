package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

import Ewig.model.VO.ObraVO;

public interface ObraInterDAO {
	public abstract void cadastrar(ObraVO vo) throws SQLException;
	public abstract void excluir(ObraVO vo) throws SQLException;
	public abstract void atualizar(ObraVO vo) throws SQLException;
	public abstract ResultSet listar() throws SQLException;
	public abstract ObraVO buscarPorTitulo(ObraVO vo) throws SQLException;
	public abstract ObraVO buscarPorId(ObraVO vo) throws SQLException;
	public abstract ResultSet listarPorDataAvaliacao(Calendar inicio, Calendar fim) throws SQLException;
}
