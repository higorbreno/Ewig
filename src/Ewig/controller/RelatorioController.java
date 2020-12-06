package Ewig.controller;

import Ewig.view.Telas;

public class RelatorioController {
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gerarRelatorio() {
		
	}
}
