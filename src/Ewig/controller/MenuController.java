package Ewig.controller;

import Ewig.view.Telas;

public class MenuController {

	public void irBuscar() {
		try {
			Telas.telaBuscar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irCadastrar() {
		try {
			Telas.telaCadastrar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void irRelatorio() {
		try {
			Telas.telaRelatorio();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void irDefinirAvaliador() {
		try {
			Telas.telaDefinirAvaliador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irAvaliar() {
		try {
			Telas.telaAvaliar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irAutorizarAcesso() {
		try {
			Telas.telaAutorizarAcesso();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irSair() {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}