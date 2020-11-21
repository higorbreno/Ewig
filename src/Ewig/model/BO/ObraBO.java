package Ewig.model.BO;
import Ewig.model.VO.ObraVO;
//import java.util.Calendar;

public class ObraBO{
		
	public void cadastrar() {
		//usar os gets e sets de ObraVO para mandar os dados para o BD
	}
	public void editar() {
		//verificar se obra existe
		//usar os gets e sets de ObraVO para alterar os dados no BD
	}
	public void excluir() {
		//excluir a obra do sistema, apagando no BD e no sistema local
	}
	public void avaliar() {
		//mudar o status da obra
	}
	public ObraVO buscar() {
		//buscar a obra numa lista
		ObraVO obra = new ObraVO(); //Criação de obra vazia para retornar algo
		return obra;
	}
	public void visualizarDados() {
		//Apresentar os dados da obra na tela
	}
	public void visualizarObra() {
		//Apresentar a obra em si para ser lida de alguma forma, provavelmente pdf
	}
	
}