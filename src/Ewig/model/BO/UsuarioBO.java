package Ewig.model.BO;
//import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.UsuarioVO;

public class UsuarioBO{
	
	public void cadastrar(String login, String senha, int tipoAcesso, String nome, String cpf, String endereco, String telefone) {
		UsuarioVO usuario = new UsuarioVO(login, senha, tipoAcesso, nome, cpf, endereco, telefone);
		usuario.setPermissaoAcesso(false); // usuario faz o cadastro mas o gerente precisa liberar o acesso
		
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
		UsuarioVO usuario[] = new UsuarioVO[2]; //n�mero aleat�rio, implementar de formar din�mica
		
		//ainda n�o implementado
		
		return usuario;
	}
	
	public UsuarioVO buscar(UsuarioVO us) {
		//buscar o avaliador numa lista de usuarios
		UsuarioVO usuario = new UsuarioVO(); //Cria��o de avaliador vazio para retornar algo
		return usuario;
	}
}