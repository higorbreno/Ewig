package Ewig.model.VO;

public class UsuarioVO{
	private String login;
	private String senha;
	private int tipoAcesso;
	private boolean permissaoAcesso;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		if(login != null && !login.isEmpty()) {
				this.login = login;
				return;
		} else {
			System.out.println("Login vazio");
		}
	}
	
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		if(senha != null && !senha.isEmpty()) {
				this.senha = senha;
				return;
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
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome != null && !nome.isEmpty()) {
			this.nome = nome;
			return;
		} else {
			System.out.println("Nome vazio");
		}
	}

	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf != null && !cpf.isEmpty()) {
			this.cpf = cpf;
			return;
		} else {
			System.out.println("Cpf vazio");
		}
	}

	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco != null && !endereco.isEmpty()) {
			this.endereco = endereco;
			return;
		} else {
			System.out.println("Endereço vazio");
		}
	}

	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone != null && !telefone.isEmpty()) {
			this.telefone = telefone;
			return;
		} else {
			System.out.println("Telefone vazio");
		}
	}
	
	public UsuarioVO() {
		
	}
	
	public UsuarioVO (String login, String senha, int tipoAcesso, String nome, String cpf, String endereco, String telefone) {
		setLogin(login);
		setSenha(senha);
		setTipoAcesso(tipoAcesso);
		setNome(nome);
		setCpf(cpf);
		setEndereco(endereco);
		setTelefone(telefone);
	}
	
}