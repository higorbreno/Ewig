package Ewig.model.VO;
import java.util.Calendar;

public class Obra{
	private String titulo;
	private String genero;
	private Calendar ano;
	private String status;
	private Autor autor;
	private String avaliador;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if(titulo.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.titulo = titulo;
		}			
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		if(genero.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.genero = genero;
		}	
	}
	public Calendar getAno() {
		return ano;
	}
	public void setAno(Calendar ano) {
		this.ano = ano;
		//falta adcionar regras de encapsulamento
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.status = status;
		}	
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
		//falta adcionar regras de encapsulamento
	}
	public String getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(String avaliador) {
		if(avaliador.isEmpty()){
			System.out.println("Valor invalido");
		}	
		else {
			this.avaliador = avaliador;
		}	
	}
	
	
	void cadastrar() {
		//ainda n�o implementado
	}
	void alterar() {
		//ainda n�o implementado
	}
	void excluir() {
		//ainda n�o implementado
	}
	void avaliar() {
		//ainda n�o implementado
	}
	void buscar() {
		//ainda n�o implementado
	}
	void visualizarDados() {
		//ainda n�o implementado
	}
	void visualizarObra() {
		//ainda n�o implementado
	}
	
}