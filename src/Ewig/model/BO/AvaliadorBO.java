package Ewig.model.BO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.ObraVO;

public class AvaliadorBO implements AvaliadorInterBO{
	
	public AvaliadorVO buscar(AvaliadorVO avaliador) {
		//buscar o avaliador numa lista de usuarios no banco de dados
		AvaliadorVO avaliador1 = new AvaliadorVO(); //Criação de avaliador vazio para retornar algo
		return avaliador1;
	}
	
	public void cadastrar(AvaliadorVO avaliador) {
		//usar os gets e sets de AvaliadorVO para mandar os dados para o BD
	}
	
	public void excluir(AvaliadorVO avaliador) {
		//excluir o avaliador do sistema, apagando no BD e no sistema local
	}
	
	public void editar(AvaliadorVO avaliador) {
		//verificar se avaliador existe
		//usar os gets e sets de AvaliadorVO para alterar os dados no BD
	}
	
	public void visualizarDados(AvaliadorVO avaliador) {
		//apresentar os dados do avaliador na tela
	}
	
	public void avaliar(ObraVO obra) {
		//avalia uma obra
	}
}