package Ewig.model.BO;
import Ewig.model.VO.AutorVO;

public interface AutorInterBO {
	public AutorVO buscar(AutorVO autor);
	
	public void cadastrar(AutorVO autor);
	
	public void excluir(AutorVO autor);
	
	public void editar(AutorVO autor);
	
	public void visualizarDados(AutorVO autor);
}
