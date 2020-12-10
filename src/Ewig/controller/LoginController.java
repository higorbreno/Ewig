package Ewig.controller;

import Ewig.exception.CampoInvalidoException;
import Ewig.exception.UsuarioInexistenteException;
import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private TextField campoLogin;
	@FXML private TextField campoSenha;
	@FXML private Label labelMensagem;
	
	private void mensagem(String m) {
		labelMensagem.setText(m);
		labelMensagem.setVisible(true);
	}
	
	public void autenticar() {
		try {
			mensagem("");
			if (campoLogin.getText().isEmpty()) {
				mensagem("Digite o login");
				throw new CampoInvalidoException("Campo invalido");
			}
			if (campoSenha.getText().isEmpty()) {
				mensagem("Digite a senha");
				throw new CampoInvalidoException("Campo invalido");
			}
			
			UsuarioVO vo = new UsuarioVO();
			vo.setLogin(campoLogin.getText());
			
			UsuarioBO<UsuarioVO> bo = new UsuarioBO<UsuarioVO>();
			
			UsuarioVO usuario = bo.buscar(vo,0);
			
			if(usuario == null) { /// VERIFICAR DEPOIS
				mensagem("Login inexistente.");
				throw new UsuarioInexistenteException("Campo invalido");
			}
			
			if (campoSenha.getText().equals(usuario.getSenha())) {
				if (usuario.getPermissaoAcesso()) {
					Telas.telaMenu();
				}
				else {
					System.out.println("Usuario não tem permissão de acesso");
					mensagem("Você ainda não tem permissão de acesso.");
				}
				
			}
			else {		
				mensagem("Senha incorreta");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
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
