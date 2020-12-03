package Ewig.model.DAO;

import Ewig.model.VO.ObraVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ObraDAO extends BaseDAO<ObraVO> {

	@Override
	public void cadastrar(ObraVO obra) throws SQLException {
		conn = getConnection();
		String sqlInsert = "insert into Obra (titulo, ano, genero, status, idavaliador, idautor, idgerente) values (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sqlInsert, Statement.RETURN_GENERATED_KEYS);
			ptst.setString(1, obra.getTitulo());
			ptst.setInt(2, obra.getAno());
			ptst.setString(3,  obra.getGenero());
			ptst.setString(4, "Em avaliação");
			ptst.setLong(5, obra.getAvaliador().getId());
			ptst.setLong(6, obra.getAutor().getId());
			ptst.setLong(7, obra.getGerente().getId());
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
		conn = getConnection();
		String sqlDelete = "delete from obra where id = ?";
		PreparedStatement ptst;
		try {
			ptst = conn.prepareStatement(sqlDelete);
			ptst.setLong(1, obra.getId());
			ptst.executeUpdate();
		} catch (SQLException e) {
			 e.printStackTrace();
		}
		
	}

	@Override
	public void atualizar(ObraVO obra) throws SQLException {
		conn = getConnection();
		
		String sqlUpdate = "update autor set "
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
			ptst = conn.prepareStatement(sqlUpdate);
			ptst.setString(1, obra.getTitulo());
			ptst.setInt(2, obra.getAno());
			ptst.setString(3, obra.getGenero());
			ptst.setString(4, obra.getStatus());
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
	public List<ObraVO> listar() throws SQLException {
		conn = getConnection();
		String sqlSelect = "select * from obra";
		PreparedStatement ptst;
		ResultSet rs;
		List<ObraVO> obras = new ArrayList<ObraVO>();
		
		try {
			ptst = conn.prepareStatement(sqlSelect);
			rs = ptst.executeQuery();
			while(rs.next()) {
				ObraVO obra = new ObraVO();
				obra.setId(rs.getLong("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setGenero(rs.getString("genero"));
				obra.setStatus(rs.getString("status"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataavaliacao"));
				obra.setDataAvaliacao(cal);
				AvaliadorDAO avDao = new AvaliadorDAO();
				AutorDAO auDao = new AutorDAO();
				GerenteDAO gDao = new GerenteDAO();
				obra.setAvaliador(avDao.buscarPorId(rs.getLong("idavaliador")));
				obra.setAutor(auDao.buscarPorId(rs.getLong("idautor")));
				obra.setGerente(gDao.buscarPorId(rs.getLong("idgerente")));
				obras.add(obra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obras;
	}

	@Override
	public ObraVO buscarPorNome(String st) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from obra where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		ObraVO obra = new ObraVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, st + "%");
			rs = ptst.executeQuery();
			if(rs.next()) {
				obra.setId(rs.getLong("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setGenero(rs.getString("genero"));
				obra.setStatus(rs.getString("status"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataavaliacao"));
				obra.setDataAvaliacao(cal);
				AvaliadorDAO avDao = new AvaliadorDAO();
				AutorDAO auDao = new AutorDAO();
				GerenteDAO gDao = new GerenteDAO();
				obra.setAvaliador(avDao.buscarPorId(rs.getLong("idavaliador")));
				obra.setAutor(auDao.buscarPorId(rs.getLong("idautor")));
				obra.setGerente(gDao.buscarPorId(rs.getLong("idgerente")));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return obra;
	}

	@Override
	public ObraVO buscarPorId(Long id) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from obra where id = ?";
		PreparedStatement ptst;
		ResultSet rs;
		ObraVO obra = new ObraVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setLong(1, id);
			rs = ptst.executeQuery();
			if(rs.next()) {
				obra.setId(rs.getLong("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setGenero(rs.getString("genero"));
				obra.setStatus(rs.getString("status"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataavaliacao"));
				obra.setDataAvaliacao(cal);
				AvaliadorDAO avDao = new AvaliadorDAO();
				AutorDAO auDao = new AutorDAO();
				GerenteDAO gDao = new GerenteDAO();
				obra.setAvaliador(avDao.buscarPorId(rs.getLong("idavaliador")));
				obra.setAutor(auDao.buscarPorId(rs.getLong("idautor")));
				obra.setGerente(gDao.buscarPorId(rs.getLong("idgerente")));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return obra;
	}
	
	public List<ObraVO> listarPorDataAvaliacao(Calendar inicio, Calendar fim){
		conn = getConnection();
		String sqlSearchByDate = "select * from obra where dataavaliacao >= ? and dataavaliacao <= fim";
		PreparedStatement ptst;
		ResultSet rs;
		List<ObraVO> obras = new ArrayList<ObraVO>();
		
		try {
			ptst = conn.prepareStatement(sqlSearchByDate);
			rs = ptst.executeQuery();
			while(rs.next()) {
				ObraVO obra = new ObraVO();
				obra.setId(rs.getLong("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setGenero(rs.getString("genero"));
				obra.setStatus(rs.getString("status"));
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataavaliacao"));
				obra.setDataAvaliacao(cal);
				AvaliadorDAO avDao = new AvaliadorDAO();
				AutorDAO auDao = new AutorDAO();
				GerenteDAO gDao = new GerenteDAO();
				obra.setAvaliador(avDao.buscarPorId(rs.getLong("idavaliador")));
				obra.setAutor(auDao.buscarPorId(rs.getLong("idautor")));
				obra.setGerente(gDao.buscarPorId(rs.getLong("idgerente")));
				obras.add(obra);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return obras;
	}

}
