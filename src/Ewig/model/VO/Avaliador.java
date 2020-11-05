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
		if(nome != null) {
			if(!nome.isEmpty()){
				this.nome = nome;
				return;
			}
		} else {
			System.out.println("Nome vazio");
		}
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		if(cpf != null) {
			if(!cpf.isEmpty() || cpf.length() < 11){
				this.cpf = cpf;
				return;
			}
		} else {
			System.out.println("Cpf insuficiente");
		}
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		if(endereco != null) {
			if(!endereco.isEmpty()){
				this.endereco = endereco;
				return;
			}
		} else {
			System.out.println("Endere�o vazio");
		}
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		if(telefone != null) {
			if(!telefone.isEmpty()){
				this.telefone = telefone;
				return;
			}
		} else {
			System.out.println("Telefone vazio");
		}
	}
	
	public Obra[] getObras() {
		return obras;
	}
	
	public void setObras(Obra[] obras) {
		if(obras != null){
			this.obras = obras;
		} else {
			System.out.println("Vetor de obras nulo");
		}	
	}
	
	public Avaliador buscar() {
		//ainda n�o implementado
		Avaliador avaliador = new Avaliador();
		return avaliador;
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