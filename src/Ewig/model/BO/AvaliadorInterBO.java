package Ewig.model.BO;

import java.util.List;

import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.ObraVO;
import Ewig.model.VO.UsuarioVO;

public interface AvaliadorInterBO {
	
	public UsuarioVO buscar(VO us, int tipoPesq);
}
