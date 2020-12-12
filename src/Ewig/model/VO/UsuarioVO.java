package Ewig.model.VO;

import Ewig.exception.AtributoInvalidoException;

public class UsuarioVO{
	
	private Long id;
	private String login;
	private String senha;
	private int tipoUsuario; // 0 = Gerente; 1 = Avaliador; 2 = Autor;
	private boolean permissaoAcesso = false; 
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
	public void setLogin(String login) throws AtributoInvalidoException{
		if(login != null && (login.length() > 2) && (login.length() < 16)) {
				this.login = login;
				return;
		} else {
			System.out.println("Login invalido");
			throw new AtributoInvalidoException("Login invalido, tamanho entre 3 a 15 caracteres");
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
	
	
	public int getTipoUsuario() {
		return tipoUsuario;
	}
	public void setTipoUsuario(int tipoAcesso) {
		if(tipoAcesso < 3) {
			this.tipoUsuario = tipoAcesso;
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
	public void setNome(String nome) throws AtributoInvalidoException{
		if(nome != null && !nome.isEmpty()) {
			String nomeAux = new String("");
			for(int i = 0; i < nome.length(); ++i) {
				if(Character.isAlphabetic(nome.charAt(i)) || Character.isSpaceChar(nome.charAt(i)))
					nomeAux += nome.charAt(i);
			}
			if (nomeAux != "") {
				this.nome = nomeAux;
				return;
			}
		}
		System.out.println("Nome invalido");
		throw new AtributoInvalidoException("Nome invalido, digite um nome normal");
	}

	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) throws AtributoInvalidoException {
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
				(cpfAux.length() == 11)) {
					int ver1, ver2;
					ver1 = Integer.parseInt("" + cpfAux.charAt(9));
					ver2 = Integer.parseInt("" + cpfAux.charAt(10));
					
					int sm = 0;
					int resto = 0;
					int peso = 10;
					
					for(int i = 0; i < 9; ++i) {
						int num = Integer.parseInt("" + cpfAux.charAt(i));
						
						sm += num * peso;
						--peso;
					}
					resto = 11 - (sm % 11);
					if(resto == 10 || resto == 11)
						resto = 0;
					
					if(resto == ver1) {
						sm = 0;
						peso = 11;
						
						for(int i = 0; i < 10; ++i) {
							int num = Integer.parseInt("" + cpfAux.charAt(i));
							
							sm += num * peso;
							--peso;
						}
						resto = 11 - (sm % 11);
						if(resto == 10 || resto == 11)
							resto = 0;
						
						if(resto == ver2) {
							this.cpf = cpfAux;
							return;
						}
					}
					throw new AtributoInvalidoException("CPF invalido");
			}
		}
		System.out.println("Cpf invalido");
		throw new AtributoInvalidoException("CPF invalido, formato correto: 000 000 000 00");
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
	public void setTelefone(String telefone) throws AtributoInvalidoException{
		if(telefone != null && !telefone.isEmpty()) {
			String telefoneAux = new String("");
			for(int i = 0; i < telefone.length(); ++i) {
				if(Character.isDigit(telefone.charAt(i)))
					telefoneAux += telefone.charAt(i);
			}
			if (telefoneAux.length() == 11) {
				this.telefone = telefoneAux;
				return;
			}
		}
		System.out.println("Telefone invalido");
		throw new AtributoInvalidoException("Telefone invalido, formato correto: 00 0 0000 0000");
	}
	
	public UsuarioVO() {
		
	}
	
	public UsuarioVO(UsuarioVO usu) {
		try {
			setId(usu.getId());
			setLogin(usu.getLogin());
			setSenha(usu.getSenha());
			setTipoUsuario(usu.getTipoUsuario());
			setNome(usu.getNome());
			setCpf(usu.getCpf());
			setEndereco(usu.getEndereco());
			setTelefone(usu.getTelefone());
		} catch (AtributoInvalidoException e) {
			e.printStackTrace();
		}
	}
}