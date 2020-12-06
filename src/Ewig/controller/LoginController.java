package Ewig.controller;

import Ewig.view.Telas;
<<<<<<< HEAD
=======
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
>>>>>>> 07c6023c9c6d60418b28274d641ecfb78141fbac

public class LoginController {
	public void autenticar() {
		//Verifica se existe o login e se a senha corresponde
		
		try {
			Telas.telaMenu();//por enquanto, somente passa para a tela do menu principal
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
