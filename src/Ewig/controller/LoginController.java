package Ewig.controller;

import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.GerenteVO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private TextField campoLogin;
	@FXML private TextField campoSenha;
	@FXML private Label labelMensagem;
	
	public void autenticar() {
		try {
			UsuarioVO vo = new UsuarioVO();
			vo.setLogin(campoLogin.getText());
			
			UsuarioBO<UsuarioVO> bo = new UsuarioBO<UsuarioVO>();
			
			UsuarioVO usuario = bo.buscar(vo,0);
			//salvar usuario em algum lugar, para usar futuramente e dizer ao sistema o tipo de usuario						
			
			if (!campoSenha.getText().equals(usuario.getSenha())) {
				//dispara exceção de senha errada
				labelMensagem.setText("Senha incorreta.");
				labelMensagem.setVisible(true);
			}
			
			Telas.telaMenu();
			
		} catch (Exception e) {
			e.printStackTrace();
			labelMensagem.setText("O login não existe.");
			labelMensagem.setVisible(true);
		}
	}
	
	public void irRegistrar() {
		try {
			Telas.telaRegistrar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
