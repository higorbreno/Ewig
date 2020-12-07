package Ewig.controller;

import Ewig.view.Telas;

public class AlterarController {
	
	public void alterar() {
		
	}
	
	public void irBuscar() {
		try {
			Telas.telaBuscar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
