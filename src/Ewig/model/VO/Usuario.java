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
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getTipoAcesso() {
		return tipoAcesso;
	}
	public void setTipoAcesso(int tipoAcesso) {
		this.tipoAcesso = tipoAcesso;
	}
	public boolean isPermissaoAcesso() {
		return permissaoAcesso;
	}
	public void setPermissaoAcesso(boolean permissaoAcesso) {
		this.permissaoAcesso = permissaoAcesso;
	}
}