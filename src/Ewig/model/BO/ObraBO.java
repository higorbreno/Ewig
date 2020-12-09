package Ewig.model.BO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;

import Ewig.model.DAO.AutorDAO;
import Ewig.model.DAO.AvaliadorDAO;
import Ewig.model.DAO.GerenteDAO;
import Ewig.model.DAO.ObraDAO;
import Ewig.model.VO.AutorVO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.GerenteVO;
import Ewig.model.VO.ObraVO;
//import java.util.Calendar;

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
			while(rs.next()) {
				ObraVO obra = new ObraVO();
				obra.setId(rs.getLong("id"));
				obra.setTitulo(rs.getString("titulo"));
				obra.setAno(rs.getInt("ano"));
				obra.setGenero(rs.getString("genero"));
				switch(rs.getInt("status")) {
				case 0:
					obra.setStatus("Em avaliação");
					break;
				case 1:
					obra.setStatus("Aprovada");
					break;
				case 2:
					obra.setStatus("Rejeitada");
					break;
				default:
					obra.setStatus("Em avaliação");
					break;
				}
				Calendar cal = Calendar.getInstance();
				cal.setTime(rs.getDate("dataavaliacao"));
				obra.setDataAvaliacao(cal);
				
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
				
				GerenteVO ge = new GerenteVO();
				ge.setId(rs.getLong("idgerente"));
				GerenteDAO geDao = new GerenteDAO();
				ResultSet geRs = geDao.buscarPorId(ge);
				if(auRs.next()) {
					ge.setNome(geRs.getString("nome"));
					ge.setCpf(geRs.getString("cpf"));
					ge.setEndereco(geRs.getString("endereco"));
					ge.setTelefone(geRs.getString("telefone"));
				}
				obra.setGerente(ge);
				
				obras.add(obra);
			}
		} catch (SQLException e) {
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
			if(obra.getTitulo() != null && !obra1.getTitulo().equals(obra.getTitulo())) {
				iter.remove();
				continue;
			} else if(obra.getGenero() != null && !obra1.getGenero().equals(obra.getGenero())) {
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
}