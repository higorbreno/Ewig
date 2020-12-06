package Ewig.controller;

import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class CadastrarController {
	@FXML private Label labelMensagem;
	
	public void cadastrarObra() {
		try {
			//chama cadastrar de ObraVO
			labelMensagem.setText("O cadastro foi realizado com sucesso");
			labelMensagem.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			labelMensagem.setText("Não foi possivel realizar o cadastro");
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
