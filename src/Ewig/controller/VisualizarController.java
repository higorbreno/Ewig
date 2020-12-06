package Ewig.controller;

import Ewig.view.Telas;

public class VisualizarController {
	public void irVoltarBuscar() {
		try {
			Telas.telaBuscar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
