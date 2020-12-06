package Ewig.controller;

import Ewig.view.Telas;

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
