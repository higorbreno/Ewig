package Ewig.model.BO;

import java.util.List;

import Ewig.model.VO.ObraVO;

public interface ObraInterBO {
	public void cadastrar(ObraVO obra);
	
	public void editar(ObraVO obra);
	
	public void excluir(ObraVO obra);
	
	public void avaliar(ObraVO obra);
	
	public List<ObraVO> buscar(ObraVO obra);
}
