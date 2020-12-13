package Ewig.model.BO;

import java.util.Calendar;
import java.util.List;

import Ewig.model.VO.ObraVO;

public interface GerenteInterBO {
	public void gerarRelatorio(List<ObraVO> obras, Calendar inicio, Calendar fim);
	public void gerarRelatorio(List<ObraVO> obras);
}
