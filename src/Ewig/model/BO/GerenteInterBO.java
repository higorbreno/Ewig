package Ewig.model.BO;

import java.util.List;

import Ewig.model.VO.ObraVO;

public interface GerenteInterBO {
	public void gerarRelatorio(List<ObraVO> obras, String nomeArquivo);
}
