package Ewig.model.VO;

public class GerenteVO extends UsuarioVO {

	public GerenteVO() {
		
	}
	
	public GerenteVO(UsuarioVO usuario) {
		super(usuario.getLogin(), usuario.getSenha(), usuario.getTipoAcesso(), usuario.getNome(), usuario.getCpf(), usuario.getEndereco(), usuario.getTelefone());
	}
	
	public GerenteVO(String login, String senha, int tipoAcesso, String nome, String cpf, String endereco, String telefone) {
		super(login, senha, tipoAcesso, nome, cpf, endereco, telefone);
	}

}