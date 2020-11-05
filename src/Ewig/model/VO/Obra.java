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
		if(titulo != null) {
			if(!titulo.isEmpty()){
				this.titulo = titulo;
			}
		}	
		else {
			System.out.println("Valor invalido");
		}
	}	
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		if(genero != null) {
			if(!genero.isEmpty()){
				this.genero = genero;
			}
		}
		else {
			System.out.println("Valor invalido");
		}	
	}
	public Calendar getAno() {
		return ano;
	}
	public void setAno(Calendar ano) {
		if(ano != null){
			this.ano = ano;
		}
		//falta adcionar regras de encapsulamento
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if (status != null) {
			if(!status.isEmpty()){
				this.status = status;
			}
		}	
		else {
			System.out.println("Valor invalido");
		}	
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		if (autor != null) {
			this.autor = autor;
		}	
		//falta adcionar regras de encapsulamento
	}
	public String getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(String avaliador) {
		if (avaliador != null) {
			if(!avaliador.isEmpty()){
				this.avaliador = avaliador;
			}
		}	
		else {
			System.out.println("Valor invalido");
		}	
	}
	
	
	public void cadastrar() {
		//ainda n�o implementado
	}
	public void alterar() {
		//ainda n�o implementado
	}
	public void excluir() {
		//ainda n�o implementado
	}
	public void avaliar() {
		//ainda n�o implementado
	}
	public void buscar() {
		//ainda n�o implementado
	}
	public void visualizarDados() {
		//ainda n�o implementado
	}
	public void visualizarObra() {
		//ainda n�o implementado
	}
	
}