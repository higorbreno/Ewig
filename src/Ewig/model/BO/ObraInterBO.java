package Ewig.model.BO;

import Ewig.model.VO.ObraVO;

public interface ObraInterBO {
	public void cadastrar(ObraVO obra);
	
	public void editar(ObraVO obra);
	
	public void excluir(ObraVO obra);
	
	public void avaliar(ObraVO obra);
	
	public ObraVO buscar(ObraVO obra);
	
	public void visualizarDados(ObraVO obra);
	
	public void visualizarObra(ObraVO obra);
}
