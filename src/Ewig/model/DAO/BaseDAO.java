package Ewig.model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDAO<VO> {
	Connection conn = null;
	String url = "jdbc:postgresql://localhost:5432/Ewig";
	String login = "postgres";
	String senha = "";
	
	public Connection getConnection() {
		if(conn == null) {
			try {
				conn = DriverManager.getConnection(url, login, senha);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		} 
		else return conn;
	}
	
	public void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e){
				e.printStackTrace();
			}
		}
	}
}
