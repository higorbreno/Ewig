package Ewig.model.DAO;

import Ewig.model.VO.AutorVO;
import Ewig.model.VO.AvaliadorVO;

import java.sql.ResultSet;
import java.sql.SQLException;

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

	public AvaliadorVO buscarPorNome(AvaliadorVO avaliador) throws SQLException {
		AvaliadorVO a = new AvaliadorVO(super.buscarPorNome(avaliador, "avaliador"));
		return a;
	}

	public AvaliadorVO buscarPorId(AvaliadorVO avaliador) throws SQLException {
		AvaliadorVO a = new AvaliadorVO(super.buscarPorId(avaliador, "avaliador"));
		return a;
	}
	
}
