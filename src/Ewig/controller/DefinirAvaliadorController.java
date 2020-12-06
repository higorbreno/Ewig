package Ewig.controller;

import Ewig.model.VO.ObraVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class DefinirAvaliadorController {
	@FXML private ChoiceBox escolherObra;
	@FXML private ChoiceBox escolherAvaliador;
	@FXML private Label labelAutorObra;
	@FXML private Label labelAnoObra;
	@FXML private Label labelAvaliadas;
	@FXML private Label labelAvaliar;
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
			labelMensagem.setText("Erro en definir Avaliador.");
			labelMensagem.setVisible(true);
		}
	}
	
	public void dadosObra() {
		labelAutorObra.setText("Pegar do BD");
		labelAutorObra.setVisible(true);
		labelAnoObra.setText("Pegar do BD");
		labelAnoObra.setVisible(true);
	}
	
	public void dadosAvaliador() {
		labelAvaliadas.setText("Pegar do BD");
		labelAvaliadas.setVisible(true);
		labelAvaliar.setText("Pegar do BD");
		labelAvaliar.setVisible(true);
	}
	
	public void irMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
