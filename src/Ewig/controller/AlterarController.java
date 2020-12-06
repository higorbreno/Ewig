package Ewig.controller;

import Ewig.view.Telas;

public class AlterarController {
	public void irMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
