package Ewig.model.BO;

import java.sql.SQLException;

import Ewig.model.DAO.ObraDAO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.ObraVO;
import Ewig.view.Telas;

public class AvaliadorBO extends UsuarioBO<AvaliadorVO>  implements AvaliadorInterBO{
	ObraDAO obDao = new ObraDAO();
	
	public void avaliar(ObraVO obra) {
		obra.setAvaliador(new AvaliadorVO(Telas.Mestre));
		try {
			obDao.atualizar(obra);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}