package Ewig.model.BO;
import Ewig.model.VO.AutorVO;

public class AutorBO{
	
	public AutorVO buscar() {
		//buscar o autor numa lista de usuarios
		AutorVO autor = new AutorVO();
		return autor;
	}
	
	public void cadastrar() {
		//usar os gets e sets de AutorVO para mandar os dados para o BD
	}
	
	public void excluir() {
		//excluir o autor do sistema, apagando no BD e no sistema local
	}
	
	public void editar() {
		//verificar se autor existe
		//usar os gets e sets de AutorVO para alterar os dados no BD
	}
	
	public void visualizarDados() {
		//apresentar os dados do autor na tela
	}
}