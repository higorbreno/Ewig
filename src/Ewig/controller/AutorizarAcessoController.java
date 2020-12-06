package Ewig.controller;

import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;

public class AutorizarAcessoController {
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void autorizarAcesso(UsuarioVO usuario) {
		
	}
}
