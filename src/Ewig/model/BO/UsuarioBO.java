package Ewig.model.BO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.UsuarioVO;

public class UsuarioBO implements UsuarioInterBO{
	
	public void cadastrar(UsuarioVO us) {
		//verificar se ja esta cadastrado 
		//mandar para o banco de dados
	}

	public void excluir(UsuarioVO us) {
		//ainda n�o implementado
	}
	
	public void editar(UsuarioVO us) {
		//ainda n�o implementado
	}
	
	public void visulaizarDados(UsuarioVO us) {
		//ainda n�o implementado
	}
	
	public UsuarioVO[] listar() {
		UsuarioVO usuario[] = new AvaliadorVO[2]; //n�mero aleat�rio, implementar de formar din�mica
		
		//ainda n�o implementado
		
		return usuario;
	}
	
	public UsuarioVO buscar(UsuarioVO us) {
		//buscar o avaliador numa lista de usuarios
		UsuarioVO usuario = new AvaliadorVO(); //Cria��o de avaliador vazio para retornar algo
		return usuario;
	}
}