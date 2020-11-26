package Ewig.model.BO;

import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.ObraVO;

public interface AvaliadorInterBO {
	public AvaliadorVO buscar(AvaliadorVO avaliador);
	
	public void cadastrar(AvaliadorVO avaliador);
	
	public void excluir(AvaliadorVO avaliador);
	
	public void editar(AvaliadorVO avaliador);
	
	public void visualizarDados(AvaliadorVO avaliador);
	
	public void avaliar(ObraVO obra);
}
