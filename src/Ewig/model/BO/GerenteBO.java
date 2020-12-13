package Ewig.model.BO;

import Ewig.model.VO.ObraVO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class GerenteBO implements GerenteInterBO{
	
	private final static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void gerarRelatorio(List<ObraVO> obras, String nomeArquivo, Calendar inicio, Calendar fim) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo + ".pdf"));
			
			document.open();
			Paragraph paragraph = new Paragraph();
			paragraph.add("Obras Avaliadas de: " + formatter.format(inicio.getTime()) + " até " + formatter.format(fim.getTime()) + "\n\n");
			for(ObraVO obra : obras) {
				paragraph.add(obra.getTitulo() + "\nGênero: " + obra.getGenero() 
				+ "\nAno: " +  obra.getAno() + "\nAutor: " + obra.getAutor().getNome() 
				+ "\nData de Avaliação: " + formatter.format(obra.getDataAvaliacao().getTime())
				+ "\nAvaliador: " +  obra.getAvaliador().getNome() + "\n\n");
			}
			document.add(paragraph);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			document.close();
		}
		System.out.println("Terminou");
	}
}