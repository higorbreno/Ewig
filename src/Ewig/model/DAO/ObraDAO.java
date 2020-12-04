package Ewig.model.DAO;

import Ewig.model.VO.AutorVO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.GerenteVO;
import Ewig.model.VO.ObraVO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

public class ObraDAO extends BaseDAO<ObraVO> implements ObraInterDAO{

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
			ptst.setInt(4, 0);
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
			ptst = conn.prepareStatement(sqlUpdate);
			ptst.setString(1, obra.getTitulo());
			ptst.setInt(2, obra.getAno());
			ptst.setString(3, obra.getGenero());
			ptst.setInt(4, 0);
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
		conn = getConnection();
		String sqlSelect = "select * from obra";
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
	public ObraVO buscarPorTitulo(ObraVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from obra where nome like ?";
		PreparedStatement ptst;
		ResultSet rs;
		ObraVO obra = new ObraVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setString(1, vo.getTitulo());
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
				
				AvaliadorVO av = new AvaliadorVO();
				AutorVO au = new AutorVO();
				GerenteVO ge = new GerenteVO();
				
				av.setId(rs.getLong("idavaliador"));
				au.setId(rs.getLong("idautor"));
				ge.setId(rs.getLong("idgerente"));
				
				obra.setAvaliador(avDao.buscarPorId(av));
				obra.setAutor(auDao.buscarPorId(au));
				obra.setGerente(gDao.buscarPorId(ge));
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
	public ObraVO buscarPorId(ObraVO vo) throws SQLException {
		conn = getConnection();
		String sqlSearch = "select * from obra where id = ?";
		PreparedStatement ptst;
		ResultSet rs;
		ObraVO obra = new ObraVO();
		try {
			ptst = conn.prepareStatement(sqlSearch);
			ptst.setLong(1, vo.getId());
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
				
				AvaliadorVO av = new AvaliadorVO();
				AutorVO au = new AutorVO();
				GerenteVO ge = new GerenteVO();
				
				av.setId(rs.getLong("idavaliador"));
				au.setId(rs.getLong("idautor"));
				ge.setId(rs.getLong("idgerente"));
				
				obra.setAvaliador(avDao.buscarPorId(av));
				obra.setAutor(auDao.buscarPorId(au));
				obra.setGerente(gDao.buscarPorId(ge));
			} else {
				System.out.println("Busca falhou, retornando nulo.");
				return null;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return obra;
	}
	
	public ResultSet listarPorDataAvaliacao(Calendar inicio, Calendar fim){
		conn = getConnection();
		String sqlSearchByDate = "select * from obra where dataavaliacao >= ? and dataavaliacao <= fim";
		PreparedStatement ptst;
		ResultSet rs = null;
		
		try {
			ptst = conn.prepareStatement(sqlSearchByDate);
			ptst.setDate(1, null, inicio);
			ptst.setDate(2, null, fim);
			rs = ptst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}

}
