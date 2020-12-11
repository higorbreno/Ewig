package Ewig.model.DAO;

import Ewig.model.VO.ObraVO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Calendar;

public class ObraDAO extends BaseDAO<ObraVO> implements ObraInterDAO{

	@Override
	public void cadastrar(ObraVO obra) throws SQLException {
		String sqlInsert = "insert into Obra (titulo, ano, genero, status, idavaliador, idautor) values (?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, obra.getTitulo());
			ptst.setInt(2, obra.getAno());
			ptst.setString(3,  obra.getGenero());
			ptst.setInt(4, 0);
			if (obra.getAvaliador() == null) {
				ptst.setNull(5, Types.BIGINT);
			} else {
				ptst.setLong(5,obra.getAvaliador().getId());
			}
			ptst.setLong(6, obra.getAutor().getId());
			int affectedRolls = ptst.executeUpdate();
			
			if(affectedRolls == 0) {
				System.out.println("Cadastro de obra falhou, cadastro não realizado.");
				return;
			}
			
			ResultSet genKey = ptst.getGeneratedKeys();
			if(genKey.next()) {
				obra.setId(genKey.getLong(1));
			} else {
				System.out.println("Cadastro falhou, id não retornado.");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void excluir(ObraVO obra) throws SQLException {
		String sqlDelete = "delete from obra where id = ?";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlDelete);
			ptst.setLong(1, obra.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(ObraVO obra) throws SQLException {		
		String sqlUpdate = "update obra set "
				+ "titulo = ?, "
				+ "ano = ?, "
				+ "genero = ?, "
				+ "status = ?, "
				+ "idavaliador = ?, "
				+ "idautor = ?, "
				+ "idgerente = ?"
				+ " where id = ?;";
		PreparedStatement ptst;
		try {
			ptst = getConnection().prepareStatement(sqlUpdate);
			ptst.setString(1, obra.getTitulo());
			ptst.setInt(2, obra.getAno());
			ptst.setString(3, obra.getGenero());
			System.out.println(obra.getStatus());
			if(obra.getStatus().contentEquals("Em Avaliação"))
				ptst.setInt(4, 0);
			else if(obra.getStatus().contentEquals("Aprovado"))
				ptst.setInt(4, 1);
			else
				ptst.setInt(4, 2);
			ptst.setLong(5, obra.getAvaliador().getId());
			ptst.setLong(6, obra.getAutor().getId());
			ptst.setLong(7, obra.getGerente().getId());
			ptst.setLong(8, obra.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ResultSet listar() throws SQLException {
		String sqlSelect = "select * from obra";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSelect);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}

//	@Override
//	public ResultSet buscarPorTitulo(ObraVO vo) throws SQLException {
//		String sqlSearch = "select * from obra where nome like ?";
//		PreparedStatement ptst;
//		ResultSet rs = null;
//		try {
//			ptst = getConnection().prepareStatement(sqlSearch);
//			ptst.setString(1, vo.getTitulo() + "%");
//			rs = ptst.executeQuery();
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}
//	
//	public ResultSet buscarPorGenero(ObraVO vo) throws SQLException {
//		String sqlSearch = "select * from obra where genero like ?";
//		PreparedStatement ptst;
//		ResultSet rs = null;
//		try {
//			ptst = getConnection().prepareStatement(sqlSearch);
//			ptst.setString(1, vo.getGenero() + "%");
//			rs = ptst.executeQuery();
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}
//	
//	public ResultSet buscarPorAno(ObraVO vo) throws SQLException {
//		String sqlSearch = "select * from obra where ano like ?";
//		PreparedStatement ptst;
//		ResultSet rs = null;
//		try {
//			ptst = getConnection().prepareStatement(sqlSearch);
//			ptst.setInt(1, vo.getAno());
//			rs = ptst.executeQuery();
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}
//	
//	public ResultSet buscarPorAutor(ObraVO vo) throws SQLException {
//		String sqlSearch = "select * from obra where idautor like ?";
//		PreparedStatement ptst;
//		ResultSet rs = null;
//		try {
//			ptst = getConnection().prepareStatement(sqlSearch);
//			ptst.setLong(1, vo.getAutor().getId());
//			rs = ptst.executeQuery();
//			
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//		return rs;
//	}

	@Override
	public ResultSet buscarPorId(ObraVO vo) throws SQLException {
		String sqlSearch = "select * from obra where id = ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		try {
			ptst = getConnection().prepareStatement(sqlSearch);
			ptst.setLong(1, vo.getId());
			rs = ptst.executeQuery();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	public ResultSet listarPorDataAvaliacao(Calendar inicio, Calendar fim){
		String sqlSearchByDate = "select * from obra where dataavaliacao between ? and ?";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = getConnection().prepareStatement(sqlSearchByDate);
			ptst.setDate(1, new Date(inicio.getTimeInMillis()));
			ptst.setDate(2, new Date(fim.getTimeInMillis()));
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
