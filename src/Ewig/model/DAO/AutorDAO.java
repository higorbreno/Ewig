package Ewig.model.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Ewig.model.VO.AutorVO;

public class AutorDAO extends BaseDAO{
	public void cadastrar(AutorVO autor) {
		conn = getConnection();
		
		String sqlVerifyLogin = "select login from autor union select login from avaliador union select login from gerente";
		Statement st;
		ResultSet rs;
		String login = autor.getLogin();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sqlVerifyLogin);
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
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sqlInsert);
			ptst.setString(1, autor.getNome());
			ptst.setString(2, autor.getCpf());
			ptst.setString(3, autor.getEndereco());
			ptst.setString(4, autor.getTelefone());
			ptst.setString(5, autor.getLogin());
			ptst.setString(6, autor.getSenha());
			ptst.setBoolean(7, autor.getPermissaoAcesso());
			ptst.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
