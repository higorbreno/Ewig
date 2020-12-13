package Ewig.controller;

import java.util.List;
import Ewig.exception.AtributoInvalidoException;
import Ewig.exception.CampoVazioException;
import Ewig.exception.UsuarioInexistenteException;
import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {
	@FXML private TextField campoLogin;
	@FXML private TextField campoSenha;
	
	public void autenticar() {
		try {
			if (campoLogin.getText().isEmpty()) {
				throw new CampoVazioException("Campo login vazio");
			}
			if (campoSenha.getText().isEmpty()) {
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
				Telas.mensagemErro("Login inexistente.");
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
						Telas.mensagemInfo("Você ainda não tem permissão de acesso.");
					}
				}
				else Telas.mensagemErro("Senha incorreta");
			}
		} catch (CampoVazioException | AtributoInvalidoException | UsuarioInexistenteException e){
			Telas.mensagemErro(e.getMessage());
		} catch (NullPointerException e) {
			Telas.mensagemErro("Problema na conexão com BD");
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
