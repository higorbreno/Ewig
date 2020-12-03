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

	public AutorVO buscarPorNome(AutorVO autor) throws SQLException {
		AutorVO a = new AutorVO(super.buscarPorNome(autor, "autor"));
		return a;
	}

	public AutorVO buscarPorId(AutorVO autor) throws SQLException {
		AutorVO a = new AutorVO(super.buscarPorId(autor, "autor"));
		return a;
	}
}
