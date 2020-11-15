package Ewig.model.BO;
import Ewig.model.VO.UsuarioVO;

public class UsuarioBO{
	
	public void cadastrar(String login, String senha, int tipoAcesso, String nome, String cpf, String endereco, String telefone) {
		UsuarioVO us = new UsuarioVO(login, senha, tipoAcesso, nome, cpf, endereco, telefone);
		us.setPermissaoAcesso(false); // usuario faz o cadastro mas o gerente precisa liberar o acesso
		
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
		UsuarioVO us[] = new UsuarioVO[2]; //número aleatório, implementar de formar dinâmica
		
		//ainda não implementado
		
		return us;
	}
	
	public void buscar(UsuarioVO us) {
		//ainda não implementado
	}
}