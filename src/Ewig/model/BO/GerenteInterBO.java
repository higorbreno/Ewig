package Ewig.model.BO;

import java.util.Calendar;
import java.util.List;

import Ewig.model.VO.ObraVO;

public interface GerenteInterBO {
	public void gerarRelatorio(List<ObraVO> obras, String nomeArquivo, Calendar inicio, Calendar fim);
}
