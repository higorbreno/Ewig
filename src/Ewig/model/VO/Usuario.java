package Ewig.model.VO;

public class Usuario{
	private String login;
	private String senha;
	private int tipoAcesso;
	private boolean permissaoAcesso;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.login = login;
		}
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.senha = senha;
		}
	}
	public int getTipoAcesso() {
		return tipoAcesso;
	}
	public void setTipoAcesso(int tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
	public boolean getPermissaoAcesso() {
		return permissaoAcesso;
	}
	public void setPermissaoAcesso(boolean permissaoAcesso) {
		this.permissaoAcesso = permissaoAcesso;
	}
	
	public void cadastrar() {
		//ainda não implementado
	}
	public void excluir() {
		//ainda não implementado
	}
	public void editar() {
		//ainda não implementado
	}
	public void autenticar() {
		//ainda não implementado
	}
}