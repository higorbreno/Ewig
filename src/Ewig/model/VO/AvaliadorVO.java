package Ewig.model.VO;

public class AvaliadorVO extends UsuarioVO{
	private ObraVO[] obras;
	
	public AvaliadorVO() {
		
	}
	
	public AvaliadorVO(UsuarioVO usuario) {
		super(usuario.getLogin(), usuario.getSenha(), usuario.getTipoAcesso(), usuario.getNome(), usuario.getCpf(), usuario.getEndereco(), usuario.getTelefone());
	}
	
	public AvaliadorVO (String login, String senha, int tipoAcesso, String nome, String cpf, String endereco, String telefone) {
		super(login, senha, tipoAcesso, nome, cpf, endereco, telefone);
	}
}