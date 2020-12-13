package Ewig.model.VO;
import java.util.Calendar;

import Ewig.exception.AtributoInvalidoException;

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
	public void setAno(int ano) throws AtributoInvalidoException{
		if (ano > 0) {
			if (ano <= Calendar.getInstance().get(Calendar.YEAR)) {
				this.ano = ano;
				return;
			}
			throw new AtributoInvalidoException("Ano invalido, insira um ano igual ou abaixo do atual");
		}
		throw new AtributoInvalidoException("Ano invalido, insira um valor maior que 0");
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
		if (dataAvaliacao != null) {
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