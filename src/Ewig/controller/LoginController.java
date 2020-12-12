package Ewig.controller;

import java.util.List;

import Ewig.exception.CampoVazioException;
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
			if (campoLogin.getText().isEmpty()) {
				mensagem("Digite o login");
				throw new CampoVazioException("Campo login vazio");
			}
			if (campoSenha.getText().isEmpty()) {
				mensagem("Digite a senha");
				throw new CampoVazioException("Campo senha vazio");
			}
			
			UsuarioVO vo = new UsuarioVO();
			vo.setLogin(campoLogin.getText());
			
			UsuarioBO<UsuarioVO> bo = new UsuarioBO<UsuarioVO>();
			
			List<UsuarioVO> usuarioList = bo.buscar(vo,0);
			UsuarioVO usuario = null;
			if(usuarioList.size() > 0)
				usuario = usuarioList.get(0);
			Telas.Mestre = usuario;
			
			if(usuario == null) {
				mensagem("Login inexistente.");
				throw new UsuarioInexistenteException("Login inexistente");
			}
			else {
				if (campoSenha.getText().equals(usuario.getSenha())) {
					if (usuario.getPermissaoAcesso()) {
						Telas.Mestre = usuario;
						Telas.telaMenu();
					}
					else {
						System.out.println("Usuario não tem permissão de acesso");
						mensagem("Você ainda não tem permissão de acesso.");
					}
				}
				else mensagem("Senha incorreta");
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
