package Ewig.model.BO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import Ewig.exception.AtributoInvalidoException;
import Ewig.model.DAO.AutorDAO;
import Ewig.model.DAO.AvaliadorDAO;
import Ewig.model.DAO.ObraDAO;
import Ewig.model.VO.AutorVO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.ObraVO;


public class ObraBO implements ObraInterBO{
	ObraDAO obraDao = new ObraDAO();
		
	public void cadastrar(ObraVO obra) {
		try {
			obraDao.cadastrar(obra);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void editar(ObraVO obra) {
		try {
			obraDao.atualizar(obra);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void excluir(ObraVO obra) {
		try {
			obraDao.excluir(obra);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void avaliar(ObraVO obra) {
		try {
			obraDao.atualizar(obra);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<ObraVO> listar(){
		ResultSet rs;
		List<ObraVO> obras = new ArrayList<ObraVO>();
		try {
			rs = obraDao.listar();
//			while(rs.next()) {
//				ObraVO obra = new ObraVO();
//				obra.setId(rs.getLong("id"));
//				obra.setTitulo(rs.getString("titulo"));
//				obra.setAno(rs.getInt("ano"));
//				obra.setGenero(rs.getString("genero"));
//				switch(rs.getInt("status")) {
//				case 0:
//					obra.setStatus("Em Avalia��o");
//					break;
//				case 1:
//					obra.setStatus("Aprovado");
//					break;
//				case 2:
//					obra.setStatus("Rejeitado");
//					break;
//				default:
//					obra.setStatus("Em Avalia��o");
//					break;
//				}
//				Calendar cal = Calendar.getInstance();
//				if(rs.getDate("dataavaliacao") != null)
//					cal.setTime(rs.getDate("dataavaliacao"));
//				else
//					cal = null;
//				obra.setDataAvaliacao(cal);
//				
//				if(rs.getLong("idavaliador") != 0){
//					AvaliadorVO av = new AvaliadorVO();
//					av.setId(rs.getLong("idavaliador"));
//					AvaliadorDAO avDao = new AvaliadorDAO();
//					ResultSet avRs = avDao.buscarPorId(av);
//					if(avRs.next()) {
//						av.setNome(avRs.getString("nome"));
//						av.setCpf(avRs.getString("cpf"));
//						av.setEndereco(avRs.getString("endereco"));
//						av.setTelefone(avRs.getString("telefone"));
//					}
//					obra.setAvaliador(av);
//				}
//				
//				AutorVO au = new AutorVO();
//				au.setId(rs.getLong("idautor"));
//				AutorDAO auDao = new AutorDAO();
//				ResultSet auRs = auDao.buscarPorId(au);
//				if(auRs.next()) {
//					au.setNome(auRs.getString("nome"));
//					au.setCpf(auRs.getString("cpf"));
//					au.setEndereco(auRs.getString("endereco"));
//					au.setTelefone(auRs.getString("telefone"));
//				}
//				obra.setAutor(au);
//				obras.add(obra);
			while(rs.next()) {
				ObraVO obra = new ObraVO();
				obra.setId(rs.getLong("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setAno(rs.getInt("ano"));
				obra.setGenero(rs.getString("genero"));
				switch(rs.getInt("status")) {
				case 0:
					obra.setStatus("Em Avalia��o");
					break;
				case 1:
					obra.setStatus("Aprovado");
					break;
				case 2:
					obra.setStatus("Rejeitado");
					break;
				default:
					obra.setStatus("Em Avalia��o");
					break;
				}
				Calendar cal = Calendar.getInstance();
				if(rs.getDate("dataavaliacao") != null)
					cal.setTime(rs.getDate("dataavaliacao"));
				else
					cal = null;
				obra.setDataAvaliacao(cal);
				
				if(rs.getLong("idavaliador") != 0){
					AvaliadorVO av = new AvaliadorVO();
					av.setId(rs.getLong("idavaliador"));
					AvaliadorDAO avDao = new AvaliadorDAO();
					ResultSet avRs = avDao.buscarPorId(av);
					if(avRs.next()) {
						av.setNome(avRs.getString("nome"));
						av.setCpf(avRs.getString("cpf"));
						av.setEndereco(avRs.getString("endereco"));
						av.setTelefone(avRs.getString("telefone"));
					}
					obra.setAvaliador(av);
				}
				
				AutorVO au = new AutorVO();
				au.setId(rs.getLong("idautor"));
				AutorDAO auDao = new AutorDAO();
				ResultSet auRs = auDao.buscarPorId(au);
				if(auRs.next()) {
					au.setNome(auRs.getString("nome"));
					au.setCpf(auRs.getString("cpf"));
					au.setEndereco(auRs.getString("endereco"));
					au.setTelefone(auRs.getString("telefone"));
				}
				obra.setAutor(au);
				
				obras.add(obra);
			}
		} catch (SQLException | AtributoInvalidoException e) {
			e.printStackTrace();
		}
		return obras;
	}
	
	public List<ObraVO> buscar(ObraVO obra) {
		List<ObraVO> obras = new ArrayList<ObraVO>();
		obras = listar();
		ListIterator<ObraVO> iter = obras.listIterator();
		while(iter.hasNext()) {
			ObraVO obra1 = iter.next();
			if(obra.getTitulo() != null && !obra1.getTitulo().contains(obra.getTitulo())) {
				iter.remove();
				continue;
			} else if(obra.getGenero() != null && !obra1.getGenero().contains(obra.getGenero())) {
				iter.remove();
				continue;
			} else if(obra.getAno() != 0 && !(obra1.getAno() == obra.getAno())) {
				iter.remove();
				continue;
			} else if(obra.getAutor() != null && !(obra1.getAutor().getId() == obra.getAutor().getId())){               
				iter.remove();
				continue;
			}
		}
		return obras;
	}
	
	public List<ObraVO> buscarPorPeriodo(Calendar dataInicio, Calendar dataFim){
		List<ObraVO> obras = new ArrayList<ObraVO>();
		try {
			ResultSet rs = obraDao.listarPorDataAvaliacao(dataInicio, dataFim);
			while(rs.next()) {
				ObraVO obra = new ObraVO();
				obra.setId(rs.getLong("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setAno(rs.getInt("ano"));
				obra.setGenero(rs.getString("genero"));
				switch(rs.getInt("status")) {
				case 0:
					obra.setStatus("Em Avalia��o");
					break;
				case 1:
					obra.setStatus("Aprovado");
					break;
				case 2:
					obra.setStatus("Rejeitado");
					break;
				default:
					obra.setStatus("Em Avalia��o");
					break;
				}
				Calendar cal = Calendar.getInstance();
				if(rs.getDate("dataavaliacao") != null)
					cal.setTime(rs.getDate("dataavaliacao"));
				else
					cal = null;
				obra.setDataAvaliacao(cal);
				
				if(rs.getLong("idavaliador") != 0){
					AvaliadorVO av = new AvaliadorVO();
					av.setId(rs.getLong("idavaliador"));
					AvaliadorDAO avDao = new AvaliadorDAO();
					ResultSet avRs = avDao.buscarPorId(av);
					if(avRs.next()) {
						av.setNome(avRs.getString("nome"));
						av.setCpf(avRs.getString("cpf"));
						av.setEndereco(avRs.getString("endereco"));
						av.setTelefone(avRs.getString("telefone"));
					}
					obra.setAvaliador(av);
				}
				
				AutorVO au = new AutorVO();
				au.setId(rs.getLong("idautor"));
				AutorDAO auDao = new AutorDAO();
				ResultSet auRs = auDao.buscarPorId(au);
				if(auRs.next()) {
					au.setNome(auRs.getString("nome"));
					au.setCpf(auRs.getString("cpf"));
					au.setEndereco(auRs.getString("endereco"));
					au.setTelefone(auRs.getString("telefone"));
				}
				obra.setAutor(au);
				
				obras.add(obra);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obras;
	}
}