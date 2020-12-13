package Ewig.controller;

import Ewig.model.BO.GerenteBO;
import Ewig.model.BO.ObraBO;
import Ewig.view.Telas;

public class RelatorioController {
	GerenteBO geBo = new GerenteBO();
	ObraBO obBo = new ObraBO();
	
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void gerarRelatorio() {
		geBo.gerarRelatorio(obBo.listar(), "Relatorio001");
	}
}
