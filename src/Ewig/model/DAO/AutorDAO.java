package Ewig.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ewig.model.VO.AutorVO;

public class AutorDAO extends BaseDAO<AutorVO>{
	@Override
	public void cadastrar(AutorVO autor) throws SQLException{
		conn = getConnection();
		
		String sqlVerifyLogin = "select login from autor union select login from avaliador union select login from gerente";
		PreparedStatement ptst;
		ResultSet rs;
		String login = autor.getLogin();
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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		String sqlInsert = "insert into autor (nome, cpf, endereco, telefone, login, senha, permissaodeacesso) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst2;
		try {
			ptst2 = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst2.setString(1, autor.getNome());
			ptst2.setString(2, autor.getCpf());
			ptst2.setString(3, autor.getEndereco());
			ptst2.setString(4, autor.getTelefone());
			ptst2.setString(5, autor.getLogin());
			ptst2.setString(6, autor.getSenha());
			ptst2.setBoolean(7, autor.getPermissaoAcesso());
			int affectedRolls = ptst2.executeUpdate();
			
			if(affectedRolls == 0) {
				System.out.println("Falha em cadastro, usuário não cadastrado.");
				return;
			}
			
			ResultSet genKey = ptst2.getGeneratedKeys();
			if(genKey.next()) {
				autor.setId(genKey.getLong(1));
			} else {
				System.out.println("Falha ao obter Id de usuário cadastrado.");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void excluir(AutorVO autor) throws SQLException {
		conn = getConnection();
		
		String sqlDelete = "delete from autor where id = ?";
		PreparedStatement ptst;
		try {
		ptst = conn.prepareStatement(sqlDelete);
		ptst.setLong(1, autor.getId());
		ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Deleção executada com sucesso.");
	}

	@Override
	public void atualizar(AutorVO autor) throws SQLException {
		conn = getConnection();
		
		String sqlUpdate = "update autor set "
				+ "nome = ?, "
				+ "telefone = ?, "
				+ "endereco = ? "
				+ " where id = ?;";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sqlUpdate);
			ptst.setString(1, autor.getNome());
			ptst.setString(2, autor.getTelefone());
			ptst.setString(3, autor.getEndereco());
			ptst.setLong(4, autor.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<AutorVO> listar() throws SQLException {
		conn = getConnection();
		String sqlSelect = "select * from autor";
		PreparedStatement ptst;
		ResultSet rs;
		List<AutorVO> autores = new ArrayList<AutorVO>();
		
		try {
			ptst = conn.prepareStatement(sqlSelect);
			rs = ptst.executeQuery();
			while(rs.next()) {
				AutorVO autor = new AutorVO();
				autor.setId(rs.getLong("id"));
				autor.setNome(rs.getString("nome"));
				autor.setLogin(rs.getString("login"));
				autor.setSenha(rs.getString("senha"));
				autor.setCpf(rs.getString("cpf"));
				autor.setTelefone(rs.getString("telefone"));
				autor.setEndereco(rs.getString("endereco"));
				autor.setPermissaoAcesso(rs.getBoolean("permissaodeacesso"));
				autores.add(autor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return autores;
	}

	@Override
	public AutorVO buscarPorNome(String st) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from autor where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		AutorVO au = new AutorVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, st + "%");
			rs = ptst.executeQuery();
			if(rs.next()) {
				au.setId(rs.getLong("id"));
				au.setNome(rs.getString("nome"));
				au.setLogin(rs.getString("login"));
				au.setSenha(rs.getString("senha"));
				au.setCpf(rs.getString("cpf"));
				au.setTelefone(rs.getString("telefone"));
				au.setEndereco(rs.getString("endereco"));
				au.setPermissaoAcesso(rs.getBoolean("permissaodeacesso"));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return au;
	}
}
