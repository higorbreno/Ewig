package Ewig.controller;

import Ewig.view.Telas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private Label erroLogin;
	@FXML private TextField campoLogin;
	@FXML private TextField campoSenha;
	
	public void autenticar() {
		//Verifica se existe o login e se a senha corresponde
		
		try {
			Telas.telaMenu();//por enquanto, somente passa para a tela do menu principal
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
