package Ewig.model.VO;
import java.util.Calendar;

public class ObraVO{
	//atributos
	private Long id;
	private String titulo;
	private String genero;
	private int ano;
	private String status;
	private Calendar dataAvaliacao;
	private AutorVO autor;
	private AvaliadorVO avaliador;
	
	public ObraVO() {
		
	}
	
	public ObraVO(String titulo, String genero, int ano, String status, AutorVO autor, AvaliadorVO avaliador, GerenteVO gerente) {
		setTitulo(titulo);
		setGenero(genero);
		setAno(ano);
		setStatus(status);
		setAutor(autor);
		setAvaliador(avaliador);
	}
	
	//metodos get e set
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
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
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
			this.ano = ano;
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
	
	public Calendar getDataAvaliacao() {
		return dataAvaliacao;
	}
	public void setDataAvaliacao(Calendar dataAvaliacao) {
		if (autor != null) {
			this.dataAvaliacao = dataAvaliacao;
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