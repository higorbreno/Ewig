package Ewig.model.VO;

public class UsuarioVO{
	private Long id;
	private String login;
	private String senha;
	private int tipoAcesso;
	private boolean permissaoAcesso;
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
			String cpfAux = new String("");
			for(int i = 0; i < cpf.length(); ++i) {
				if(Character.isDigit(cpf.charAt(i)))
					cpfAux += cpf.charAt(i);
			}
			if (!cpfAux.equals("00000000000") && !cpfAux.equals("11111111111") &&
				!cpfAux.equals("22222222222") && !cpfAux.equals("33333333333") &&
				!cpfAux.equals("44444444444") && !cpfAux.equals("55555555555") &&
				!cpfAux.equals("66666666666") && !cpfAux.equals("77777777777") &&
				!cpfAux.equals("88888888888") && !cpfAux.equals("99999999999") && 
				!(cpfAux.length() != 11)) {
					int ver1, ver2;
					ver1 = Integer.parseInt("" + cpfAux.charAt(9));
					ver2 = Integer.parseInt("" + cpfAux.charAt(10));
					
					int numVer = 0;
					int resto = 0;
					int peso = 10;
					
					for(int i = 0; i < 9; ++i) {
						int num = Integer.parseInt("" + cpfAux.charAt(i));
						
						numVer += num * peso;
						--peso;
					}
					resto = (numVer*10) % 11;
					if(resto == 10)
						resto = 0;
					
					if(resto != ver1) {
						System.out.println("Cpf inválido");
						return;
					}
					
					numVer = 0;
					resto = 0;
					peso = 11;
					
					for(int i = 0; i < 10; ++i) {
						int num = Integer.parseInt("" + cpfAux.charAt(i));
						
						numVer += num * peso;
						--peso;
					}
					resto = (numVer*10) % 11;
					if(resto == 10)
						resto = 0;
					
					if(resto != ver2) {
						System.out.println("Cpf inválido");
						return;
					}
			}
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