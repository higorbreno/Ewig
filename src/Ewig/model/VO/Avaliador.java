package Ewig.model.VO;

public class Avaliador{
	private String nome;
	private String cpf;
	private String endereco;
	private String telefone;
	private Obra[] obras;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Obra[] getObras() {
		return obras;
	}
	public void setObras(Obra[] obras) {
		this.obras = obras;
	}
}