package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import Ewig.model.VO.AvaliadorVO;

public class AvaliadorDAO extends UsuarioDAO<AvaliadorVO> {

	public void cadastrar(AvaliadorVO avaliador) throws SQLException {
		super.cadastrar(avaliador, "avaliador");
	}

	public void excluir(AvaliadorVO avaliador) throws SQLException {
		super.excluir(avaliador, "avaliador");
	}

	public void atualizar(AvaliadorVO avaliador) throws SQLException {
		super.excluir(avaliador, "avaliador");
	}

	public ResultSet listar() throws SQLException {
		return super.listar("avaliador");
	}

	public ResultSet buscarPorNome(AvaliadorVO avaliador) throws SQLException {
		ResultSet rs = super.buscarPorNome(avaliador, "avaliador");
		return rs;
	}

	public ResultSet buscarPorId(AvaliadorVO avaliador) throws SQLException {
		ResultSet rs = super.buscarPorId(avaliador, "avaliador");
		return rs;
	}
	
	public ResultSet buscarPorLogin(AvaliadorVO avaliador) throws SQLException {
		ResultSet rs = super.buscarPorLogin(avaliador, "avaliador");
		return rs;
	}
}
