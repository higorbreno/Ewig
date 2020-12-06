package Ewig.controller;

import Ewig.view.Telas;

public class MenuController {

	public void irBuscar() {
		try {
			Telas.telaBuscar();//por enquanto, somente passa para a tela do menu principal
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irCadastrar() {
		try {
			Telas.telaCadastrar();//por enquanto, somente passa para a tela do menu principal
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void irRelatorio() {
		try {
			Telas.telaRelatorio();//por enquanto, somente passa para a tela do menu principal
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void irDefinirAvaliador() {
		try {
			Telas.telaDefinirAvaliador();//por enquanto, somente passa para a tela do menu principal
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irSair() {
		try {
			Telas.telaLogin();//por enquanto, somente passa para a tela do menu principal
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}