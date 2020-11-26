package Ewig.model.BO;
import Ewig.model.VO.AutorVO;

public class AutorBO implements AutorInterBO{
	
	public AutorVO buscar(AutorVO autor) {
		//buscar o autor numa lista de usuarios no banco de dados
		AutorVO autor1 = new AutorVO();
		return autor1;
	}
	
	public void cadastrar(AutorVO autor) {
		//usar os gets e sets de AutorVO para mandar os dados para o BD
	}
	
	public void excluir(AutorVO autor) {
		//excluir o autor do sistema, apagando no BD e no sistema local
	}
	
	public void editar(AutorVO autor) {
		//verificar se autor existe
		//usar os gets e sets de AutorVO para alterar os dados no BD
	}
	
	public void visualizarDados(AutorVO autor) {
		//apresentar os dados do autor na tela
	}
}