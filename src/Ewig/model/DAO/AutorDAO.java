package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import Ewig.model.VO.AutorVO;

public class AutorDAO extends UsuarioDAO<AutorVO>{
	
	public void cadastrar(AutorVO autor) throws SQLException {
		super.cadastrar(autor, "autor");
	}

	public void excluir(AutorVO autor) throws SQLException {
		super.excluir(autor, "autor");
	}

	public void atualizar(AutorVO autor) throws SQLException {
		super.excluir(autor, "autor");
	}

	public ResultSet listar() throws SQLException {
		return super.listar("autor");
	}

	public ResultSet buscarPorNome(AutorVO autor) throws SQLException {
		ResultSet rs = super.buscarPorNome(autor, "autor");
		return rs;
	}

	public ResultSet buscarPorId(AutorVO autor) throws SQLException {
		ResultSet rs = super.buscarPorId(autor, "autor");
		return rs;
	}
	
	public ResultSet buscarPorLogin(AutorVO autor) throws SQLException {
		ResultSet rs = super.buscarPorLogin(autor, "autor");
		return rs;
	}
}
