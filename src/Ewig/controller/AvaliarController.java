package Ewig.controller;

import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;

public class AvaliarController {
	@FXML private ChoiceBox escolherObra;
	@FXML private RadioButton checkAceitar;
	@FXML private RadioButton checkRejeitar;
	@FXML private Label labelMensagem;
	
	public void avaliarObra() {
		try {
			//altera o estado de avaliação da obra
			labelMensagem.setText("A obra foi avaliada.");
			labelMensagem.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			labelMensagem.setText("Ocorreu um erro na avaliação.");
			labelMensagem.setVisible(true);
		}
	}
	
	public void irMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
