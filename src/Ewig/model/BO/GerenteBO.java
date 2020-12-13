package Ewig.model.BO;

import Ewig.model.VO.ObraVO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;



public class GerenteBO implements GerenteInterBO{

	@Override
	public void gerarRelatorio(List<ObraVO> obras, String nomeArquivo) {
		Document document = new Document();
		try {
			PdfWriter.getInstance(document, new FileOutputStream(nomeArquivo + ".pdf"));
			
			document.open();
			Paragraph paragraph = new Paragraph();
			for(ObraVO obra : obras) {
				paragraph.add(obra.getTitulo() + "\n" + obra.getGenero() + "\n" + obra.getAno() + "\n" + obra.getAutor().getNome() + "\n");
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