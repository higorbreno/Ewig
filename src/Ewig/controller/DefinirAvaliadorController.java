package Ewig.controller;

import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class DefinirAvaliadorController {
	@FXML private ComboBox escolherObra;
	@FXML private ComboBox escolherAvaliador;
	@FXML private Label labelAutorObra;
	@FXML private Label labelAnoObra;
	@FXML private Label labelMensagem;
	
	public void definirAvaliador() {		
		try {
			//recebe a obra
			//recebe o avaliador
			//setAvaliador na obraVO
			labelMensagem.setText("Avaliador definido.");
			labelMensagem.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			labelMensagem.setText("Erro em definir Avaliador.");
			labelMensagem.setVisible(true);
		}
	}
	
	private void atualizarObras() {
		
	}
	
	private void atualizarAvaliadores() {
		
	}
	
	public void dadosObra() {
		labelAutorObra.setText("Pegar do BD");
		labelAutorObra.setVisible(true);
		labelAnoObra.setText("Pegar do BD");
		labelAnoObra.setVisible(true);
	}
	
	public void irMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
