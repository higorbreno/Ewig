package Ewig.model.VO;

public class Gerente {
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		if(nome.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.nome = nome;
		}
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		if(cpf.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.cpf = cpf;
		}
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		if(endereco.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.endereco = endereco;
		}
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		if(telefone.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.telefone = telefone;
		}
	}
	
	
	public void cadastrar() {
		//ainda n�o implementado
	}
	public void excluir() {
		//ainda n�o implementado
	}
	public void editar() {
		//ainda n�o implementado
	}
	public void visualizarDados() {
		//ainda n�o implementado
	}
	
	
}