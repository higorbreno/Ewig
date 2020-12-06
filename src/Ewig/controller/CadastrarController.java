package Ewig.controller;

import Ewig.model.VO.ObraVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class CadastrarController {
	@FXML private TextField campoTitulo;
	@FXML private TextField campoGenero;
	@FXML private TextField campoAno;
	@FXML private ChoiceBox campoAutor;
	@FXML private Label labelMensagem;
	
	public void cadastrarObra() {
		ObraVO o = new ObraVO();
		o.setTitulo(campoTitulo.getText());
		o.setGenero(campoGenero.getText());
		//o.setAno(Integer.parseInt(campoAno.getText()));
		//o.setAutor(); recebe o valor de campoAutor
		
		try {
			//chama cadastrar() de ObraVO
			labelMensagem.setText("O cadastro foi realizado com sucesso");
			//mudar a cor do texto para verde
			labelMensagem.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
			labelMensagem.setText("Não foi possivel realizar o cadastro");
			//mudar a cor do texto para vermelho
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
