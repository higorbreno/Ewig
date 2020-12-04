package Ewig.model.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import Ewig.model.VO.AutorVO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.GerenteVO;
import Ewig.model.VO.ObraVO;

public class Teste {
	public static void main(String args[]) {
		GerenteVO gerente = new GerenteVO("higorbreno", "Abacaxi", 0, "Higor Breno", "86894328099", "Rua Gerlene Saraiva", "84987654321");
		AutorVO autor = new AutorVO("felpsribs", "Leite", 1, "Felipe Ribeiro", "85130217098", "Rua Guaribara da Pitanga", "84912345678");
		AvaliadorVO avaliador = new AvaliadorVO("erickkacik", "Queijinho", 2, "Erick Henrique", "87641213057", "Rua Jorgina Kalarrara", "84981726354");
		ObraVO obra = new ObraVO("The Dandelion Knight", "Fantasia", 1996, "Em avaliação", autor, avaliador, gerente);
		
		GerenteDAO gDAO = new GerenteDAO();
		AutorDAO auDAO = new AutorDAO();
		AvaliadorDAO avDAO = new AvaliadorDAO();
		ObraDAO oDAO = new ObraDAO();
		
		try {
			gDAO.cadastrar(gerente);
			auDAO.cadastrar(autor);
			avDAO.cadastrar(avaliador);
			oDAO.cadastrar(obra);
			
			ResultSet rs = gDAO.listar();
			if(rs.next()) {
				gerente.setId(rs.getLong("id"));
			}
			rs = auDAO.listar();
			if(rs.next()) {
				autor.setId(rs.getLong("id"));
			}
			rs = avDAO.listar();
			if(rs.next()) {
				avaliador.setId(rs.getLong("id"));
			}
			rs = oDAO.listar();
			if(rs.next()) {
				obra.setId(rs.getLong("id"));
			}
			
			//oDAO.excluir(obra);
			//gDAO.excluir(gerente);
			//auDAO.excluir(autor);
			//avDAO.excluir(avaliador);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
