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
		if(login != null) {
			if(!login.isEmpty()){
				this.login = login;
				return;
			}
		} else {
			System.out.println("Login vazio");
		}
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		if(senha != null) {
			if(!senha.isEmpty()){
				this.senha = senha;
				return;
			}
		} else {
			System.out.println("Senha vazio");
		}
	}
	
	public int getTipoAcesso() {
		return tipoAcesso;
	}
	
	public void setTipoAcesso(int tipoAcesso) {
		if(tipoAcesso > 3) {
			this.tipoAcesso = tipoAcesso;
		} else {
			System.out.println("Tipo de Acesso inválido");
		}
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