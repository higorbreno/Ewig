package Ewig.model.VO;

public class GerenteVO extends UsuarioVO {

	public GerenteVO(String login, String senha, int tipoAcesso, String nome, String cpf, String endereco, String telefone) {
		super(login, senha, tipoAcesso, nome, cpf, endereco, telefone);
		
		if (existe algum gerente) { //se já existir algum gerente
			setPermissaoAcesso(false);
		} else {
			setPermissaoAcesso(true); //caso do primeiro acesso do primeiro gerente
		}
		
	}
		
}