package Ewig.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Ewig.model.VO.GerenteVO;
import Ewig.model.VO.UsuarioVO;

public class UsuarioDAO extends BaseDAO {
	
	public void cadastrar(UsuarioVO vo) {
		conn = getConnection();
		String sql = "insert into usuario (nome, cpf, endereco, telefone, login, senha, permissaodeacesso) "
				     + "values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setString(2, vo.getCpf());
			ptst.setString(3, vo.getEndereco());
			ptst.setString(4, vo.getTelefone());
			ptst.setString(5, vo.getLogin());
			ptst.setString(6, vo.getSenha());
			ptst.setBoolean(7, vo.getPermissaoAcesso());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(UsuarioVO vo) {
		conn = getConnection();
		String sql = "delete from usuario where cpf = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getCpf());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<UsuarioVO> listar() {
		conn = getConnection();
		String sql = "select * from usuario";
		Statement st;
		ResultSet rs;
		List<UsuarioVO> lista = new ArrayList<UsuarioVO>();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				UsuarioVO vo = new GerenteVO();
				vo.setNome(rs.getString("nome"));
				vo.setCpf(rs.getString("cpf"));
				vo.setEndereco(rs.getString("endereco"));
				vo.setTelefone(rs.getString("telefone"));
				vo.setLogin(rs.getString("login"));
				vo.setSenha(rs.getString("senha"));
				vo.setPermissaoAcesso(rs.getBoolean("permissaoacesso"));
				vo.setId(rs.getLong("id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	
	public void editar(UsuarioVO vo) {
		conn = getConnection();
		String sql = "update usuario set nome = ? where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sql);
			ptst.setString(1, vo.getNome());
			ptst.setLong(2, vo.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void buscar(UsuarioVO vo) {
		
	}
	
}
