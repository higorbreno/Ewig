package Ewig.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ewig.model.VO.UsuarioVO;

public class UsuarioDAO<VO extends UsuarioVO> extends BaseDAO<VO> implements UsuarioInterDAO{
	@Override
	public void cadastrar(UsuarioVO usuario, String nomeTabela) throws SQLException{
		conn = getConnection();
		
		String sqlVerifyLogin = "select login from " + nomeTabela + " union select login from avaliador union select login from gerente";
		PreparedStatement ptst;
		ResultSet rs;
		String login = usuario.getLogin();
		try {
			ptst = conn.prepareStatement(sqlVerifyLogin);
			rs = ptst.executeQuery();
			while(rs.next()) {
				if(login.equals(rs.getString("login"))){
					System.out.println("Login já cadastrado, não foi possível realizar o novo cadastro.");
					return;
				}
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		
		String sqlInsert = "insert into " + nomeTabela + " (nome, cpf, endereco, telefone, login, senha, permissaodeacesso) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst2;
		try {
			ptst2 = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
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
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void excluir(UsuarioVO usuario, String nomeTabela) throws SQLException {
		conn = getConnection();
		
		String sqlDelete = "delete from " + nomeTabela + " where id = ?";
		PreparedStatement ptst;
		try {
		ptst = conn.prepareStatement(sqlDelete);
		ptst.setLong(1, usuario.getId());
		ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Deleção executada com sucesso.");
	}

	@Override
	public void atualizar(UsuarioVO usuario, String nomeTabela) throws SQLException {
		conn = getConnection();
		
		String sqlUpdate = "update " + nomeTabela + " set "
				+ "nome = ?, "
				+ "telefone = ?, "
				+ "endereco = ? "
				+ " where id = ?;";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sqlUpdate);
			ptst.setString(1, usuario.getNome());
			ptst.setString(2, usuario.getTelefone());
			ptst.setString(3, usuario.getEndereco());
			ptst.setLong(4, usuario.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public ResultSet listar(String nomeTabela) throws SQLException {
		conn = getConnection();
		String sqlSelect = "select * from " + nomeTabela;
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = conn.prepareStatement(sqlSelect);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

	@Override
	public UsuarioVO buscarPorNome(UsuarioVO vo, String nomeTabela) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from " + nomeTabela + " where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		UsuarioVO usuario = new UsuarioVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getNome());
			rs = ptst.executeQuery();
			if(rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setPermissaoAcesso(rs.getBoolean("permissaodeacesso"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}

	@Override
	public UsuarioVO buscarPorId(UsuarioVO vo, String nomeTabela) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from " + nomeTabela + " where id = ?";
		PreparedStatement ptst;
		ResultSet rs;
		UsuarioVO usuario = new UsuarioVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setLong(1, vo.getId());
			rs = ptst.executeQuery();
			if(rs.next()) {
				usuario.setId(rs.getLong("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setLogin(rs.getString("login"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setPermissaoAcesso(rs.getBoolean("permissaodeacesso"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return usuario;
	}
}
