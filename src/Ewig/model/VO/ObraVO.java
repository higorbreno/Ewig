package Ewig.model.VO;
import java.util.Calendar;

public class ObraVO{
	//atributos
	private String titulo;
	private String genero;
	private Calendar ano;
	private String status;
	private AutorVO autor;
	private AvaliadorVO avaliador;
	
	public ObraVO() {
		
	}
	
	public ObraVO(String titulo, String genero, Calendar ano, String status, AutorVO autor, AvaliadorVO avaliador) {
		setTitulo(titulo);
		setGenero(genero);
		setAno(ano);
		setStatus(status);
		setAutor(autor);
		setAvaliador(avaliador);
	}
	
	//metodos get e set
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
	public AutorVO getAutor() {
		return autor;
	}
	public void setAutor(AutorVO autor) {
		if (autor != null) {
			this.autor = autor;
		}	
		//falta adcionar regras de encapsulamento
	}
	public AvaliadorVO getAvaliador() {
		return avaliador;
	}
	public void setAvaliador(AvaliadorVO avaliador) {
		if (avaliador != null) {
			this.avaliador = avaliador;
		}	
		else {
			System.out.println("Valor invalido");
		}	
	}

}