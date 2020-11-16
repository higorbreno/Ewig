package Ewig.model.BO;
import Ewig.model.VO.AvaliadorVO;

public class AvaliadorBO{
	
	public AvaliadorVO buscar() {
		//buscar o avaliador numa lista de usuarios
		AvaliadorVO avaliador = new AvaliadorVO(); //Criação de avaliador vazio para retornar algo
		return avaliador;
	}
	
	public void cadastrar() {
		//usar os gets e sets de AvaliadorVO para mandar os dados para o BD
	}
	
	public void excluir() {
		//excluir o avaliador do sistema, apagando no BD e no sistema local
	}
	
	public void editar() {
		//verificar se avaliador existe
		//usar os gets e sets de AvaliadorVO para alterar os dados no BD
	}
	
	public void visualizarDados() {
		//apresentar os dados do avaliador na tela
	}
}