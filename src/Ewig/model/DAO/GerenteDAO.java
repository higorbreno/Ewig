package Ewig.model.DAO;

import Ewig.model.VO.GerenteVO;
import java.sql.ResultSet;
import java.sql.SQLException;

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

	public GerenteVO buscarPorNome(GerenteVO gerente) throws SQLException {
		GerenteVO g = new GerenteVO(super.buscarPorNome(gerente, "gerente"));
		return g;
	}

	public GerenteVO buscarPorId(GerenteVO gerente) throws SQLException {
		GerenteVO g = new GerenteVO(super.buscarPorId(gerente, "gerente"));
		return g;
	}
}
