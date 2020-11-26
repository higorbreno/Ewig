package Ewig.model.BO;
import Ewig.model.VO.ObraVO;
//import java.util.Calendar;

public class ObraBO implements ObraInterBO{
		
	public void cadastrar(ObraVO obra) {
		//usar os gets e sets de ObraVO para mandar os dados para o BD
	}
	public void editar(ObraVO obra) {
		//verificar se obra existe
		//usar os gets e sets de ObraVO para alterar os dados no BD
	}
	public void excluir(ObraVO obra) {
		//excluir a obra do sistema, apagando no BD e no sistema local
	}
	public void avaliar(ObraVO obra) {
		//mudar o status da obra
	}
	public ObraVO buscar(ObraVO obra) {
		//buscar a obra numa lista no banco de dados
		ObraVO obra1 = new ObraVO(); //Criação de obra vazia para retornar algo
		return obra1;
	}
	public void visualizarDados(ObraVO obra) {
		//Apresentar os dados da obra na tela
	}
	public void visualizarObra(ObraVO obra) {
		//Apresentar a obra em si para ser lida de alguma forma, provavelmente pdf
	}
	
}