package Ewig.model.BO;

import Ewig.model.VO.ObraVO;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

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
	public void gerarRelatorio(List<ObraVO> obras, Calendar inicio, Calendar fim) {
		
		Document document = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
		
		 if (file != null) {
			try {
				PdfWriter.getInstance(document, new FileOutputStream(file.getAbsolutePath()));
				
				document.open();
				Paragraph paragraph = new Paragraph();
				
				paragraph.add("Obras Avaliadas de: " + formatter.format(inicio.getTime()) + " até " + formatter.format(fim.getTime()) + "\n\n");		
				for(ObraVO obra : obras) {
					paragraph.add(obra.getTitulo() + "\nGênero: " + obra.getGenero() 
					+ "\nAno: " +  obra.getAno() + "\nAutor: " + obra.getAutor().getNome() 
					+ "\nData de Avaliação: " + formatter.format(obra.getDataAvaliacao().getTime())
					+ "\nAvaliador: " +  obra.getAvaliador().getNome() + "\nAvaliação: " +  obra.getStatus() + "\n\n");
				}
				document.add(paragraph);
				
				Alert a = new Alert(AlertType.INFORMATION);
				a.setHeaderText("Relatório gerado com sucesso");
				a.show();
				
			} catch (FileNotFoundException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText(e.getMessage());
				a.show();
			} catch (DocumentException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Não foi possível gerar o relatório");
				a.show();
			} finally {
				document.close();
			}
		} 
	}
	
	public void gerarRelatorio(List<ObraVO> obras) {
		
		Document document = new Document();
		FileChooser f = new FileChooser();
		f.getExtensionFilters().add(new ExtensionFilter("PDF","*.pdf"));
		java.io.File file = f.showSaveDialog(new Stage());
		
		 if (file != null) {
			try {
				PdfWriter.getInstance(document, new FileOutputStream(file.getAbsolutePath()));
				
				document.open();
				Paragraph paragraph = new Paragraph();
				
				paragraph.add("Todas as Obras Avaliadas\n\n");		
				for(ObraVO obra : obras) {
					paragraph.add(obra.getTitulo() + "\nGênero: " + obra.getGenero() 
					+ "\nAno: " +  obra.getAno() + "\nAutor: " + obra.getAutor().getNome() 
					+ "\nData de Avaliação: " + formatter.format(obra.getDataAvaliacao().getTime())
					+ "\nAvaliador: " +  obra.getAvaliador().getNome() + "\nAvaliação: " +  obra.getStatus() + "\n\n");
				}
				document.add(paragraph);
				
				Alert a = new Alert(AlertType.INFORMATION);
				a.setHeaderText("Relatório gerado com sucesso");
				a.show();
				
			} catch (FileNotFoundException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText(e.getMessage());
				a.show();
			} catch (DocumentException e) {
				Alert a = new Alert(AlertType.ERROR);
				a.setHeaderText("Não foi possível gerar o relatório");
				a.show();
			} finally {
				document.close();
			}
		 }
	}
}