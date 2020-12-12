package Ewig.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ewig.model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends BaseDAO<VO> implements UsuarioInterDAO<VO>{
	@Override
	public void cadastrar(UsuarioVO usuario, String nomeTabela) throws SQLException{		
		String sqlInsert = "insert into " + nomeTabela + " (nome, cpf, endereco, telefone, login, senha, permissaodeacesso) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst2;
			ptst2 = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst2.setString(1, usuario.getNome());
			ptst2.setString(2, usuario.getCpf());
			ptst2.setString(3, usuario.getEndereco());
			ptst2.setString(4, usuario.getTelefone());
			ptst2.setString(5, usuario.getLogin());
			ptst2.setString(6, usuario.getSenha());
			ptst2.setBoolean(7, usuario.getPermissaoAcesso());
			int affectedRolls = ptst2.executeUpdate();
			
			if(affectedRolls == 0) {
				System.out.println("Falha em cadastro, usuário não cadastrado.");
				return;
			}
			
			ResultSet genKey = ptst2.getGeneratedKeys();
			if(genKey.next()) {
				usuario.setId(genKey.getLong(1));
			} else {
				System.out.println("Falha ao obter Id de usuário cadastrado.");
			}
	}

	@Override
	public void excluir(UsuarioVO usuario, String nomeTabela) throws SQLException {
		String sqlDelete = "delete from " + nomeTabela + " where id = ?";
		PreparedStatement ptst;
		ptst = getConnection().prepareStatement(sqlDelete);
		ptst.setLong(1, usuario.getId());
		ptst.executeUpdate();
		System.out.println("Deleção executada com sucesso.");
	}

	@Override
	public void atualizar(UsuarioVO usuario, String nomeTabela) throws SQLException {
		String sqlUpdate = "update " + nomeTabela + " set "
				+ "nome = ?, "
				+ "telefone = ?, "
				+ "endereco = ?, "
				+ "permissaodeacesso = ?"
				+ " where id = ?;";
		PreparedStatement ptst;

			ptst = getConnection().prepareStatement(sqlUpdate);
			System.out.println(usuario.getNome());
			System.out.println(usuario.getTelefone());
			System.out.println(usuario.getEndereco());
			System.out.println(usuario.getPermissaoAcesso());
			System.out.println(usuario.getId());
			
			ptst.setString(1, usuario.getNome());
			ptst.setString(2, usuario.getTelefone());
			ptst.setString(3, usuario.getEndereco());
			ptst.setBoolean(4, usuario.getPermissaoAcesso());
			ptst.setLong(5, usuario.getId());
			ptst.executeUpdate();
	}

	@Override
	public ResultSet listar(String nomeTabela) throws SQLException {
		String sqlSelect = "select * from " + nomeTabela;
		PreparedStatement ptst;
		ResultSet rs = null;
		
		ptst = getConnection().prepareStatement(sqlSelect);
		rs = ptst.executeQuery();
		return rs;
	}

	@Override
	public ResultSet buscarPorNome(UsuarioVO vo, String nomeTabela) throws SQLException {
		String sqlSearch = "select * from " + nomeTabela + " where nome like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		ptst = getConnection().prepareStatement(sqlSearch);
		ptst.setString(1, vo.getNome() + "%");
		rs = ptst.executeQuery();
		return rs;
	}

	@Override
	public ResultSet buscarPorId(UsuarioVO vo, String nomeTabela) throws SQLException {
		String sqlSearch = "select * from " + nomeTabela + " where id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;

		ptst = getConnection().prepareStatement(sqlSearch);
		ptst.setLong(1, vo.getId());
		rs = ptst.executeQuery();
		return rs;
	}

	@Override
	public ResultSet buscarPorLogin(UsuarioVO vo,String nomeTabela) throws SQLException {
		String sqlSearch = "select * from " + nomeTabela + " where login like ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		ptst = getConnection().prepareStatement(sqlSearch);
		ptst.setString(1, vo.getLogin());
		rs = ptst.executeQuery();
		return rs;
	}
}	