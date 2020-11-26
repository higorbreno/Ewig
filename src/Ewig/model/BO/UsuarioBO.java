package Ewig.model.BO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.UsuarioVO;

public class UsuarioBO implements UsuarioInterBO{
	
	public void cadastrar(UsuarioVO us) {
		//verificar se ja esta cadastrado 
		//mandar para o banco de dados
	}

	public void excluir(UsuarioVO us) {
		//ainda não implementado
	}
	
	public void editar(UsuarioVO us) {
		//ainda não implementado
	}
	
	public void visulaizarDados(UsuarioVO us) {
		//ainda não implementado
	}
	
	public UsuarioVO[] listar() {
		UsuarioVO usuario[] = new AvaliadorVO[2]; //número aleatório, implementar de formar dinâmica
		
		//ainda não implementado
		
		return usuario;
	}
	
	public UsuarioVO buscar(UsuarioVO us) {
		//buscar o avaliador numa lista de usuarios
		UsuarioVO usuario = new AvaliadorVO(); //Criação de avaliador vazio para retornar algo
		return usuario;
	}
}