package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import Ewig.model.VO.GerenteVO;

public class GerenteDAO extends UsuarioDAO<GerenteVO> {

	public void cadastrar(GerenteVO gerente) throws SQLException {
		super.cadastrar(gerente, "gerente");
	}

	public void excluir(GerenteVO gerente) throws SQLException {
		super.excluir(gerente, "gerente");
	}

	public void atualizar(GerenteVO gerente) throws SQLException {
		super.atualizar(gerente, "gerente");
	}

	public ResultSet listar() throws SQLException {
		return super.listar("gerente");
	}

	public ResultSet buscarPorNome(GerenteVO gerente) throws SQLException {
		ResultSet rs = super.buscarPorNome(gerente, "gerente");
		return rs;
	}

	public ResultSet buscarPorId(GerenteVO gerente) throws SQLException {
		ResultSet rs = super.buscarPorId(gerente, "gerente");
		return rs;
	}
	
	public ResultSet buscarPorLogin(GerenteVO gerente) throws SQLException {
		ResultSet rs = super.buscarPorLogin(gerente, "gerente");
		return rs;
	}
}
