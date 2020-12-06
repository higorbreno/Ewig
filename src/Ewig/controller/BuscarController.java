package Ewig.controller;

import Ewig.view.Telas;

public class BuscarController {
	public void buscar() {
		
	}
	
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inutilizavel enquanto não houver objetos na lista de busca
	public void irVisualizar() {
		try {
			Telas.telaVisualizar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inutilizavel enquanto não houver objetos na lista de busca
	public void irAlterar() {
		try {
			Telas.telaAlterar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
