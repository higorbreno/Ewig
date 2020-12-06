package Ewig.controller;

import Ewig.model.VO.AutorVO;
import Ewig.model.VO.AvaliadorVO;
import Ewig.model.VO.GerenteVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegistrarController {
	@FXML private TextField campoNome;
	@FXML private TextField campoCpf;
	@FXML private TextField campoEndereco;
	@FXML private TextField campoTelefone;
	@FXML private TextField escolherTipoAcesso;
	@FXML private TextField campoLogin;
	@FXML private TextField campoSenha;
	@FXML private TextField campoRepitaSenha;
	
	public void registrar() {
		try {
			if(campoSenha.getText().equals(campoRepitaSenha.getText())) {
				//excepition senha errada
			} 
			else {
				if(escolherTipoAcesso.getText().equals("Gerente")) {
					GerenteVO g = new GerenteVO();
					g.setNome(campoNome.getText());
					g.setCpf(campoCpf.getText());
					g.setEndereco(campoEndereco.getText());
					g.setTelefone(campoTelefone.getText());
					g.setLogin(campoLogin.getText());
					g.setSenha(campoSenha.getText());
					//passa o objeto para a classe BO
				} 
					else if(escolherTipoAcesso.getText().equals("Autor")) {
						AutorVO au = new AutorVO();
						au.setNome(campoNome.getText());
						au.setCpf(campoCpf.getText());
						au.setEndereco(campoEndereco.getText());
						au.setTelefone(campoTelefone.getText());
						au.setLogin(campoLogin.getText());
						au.setSenha(campoSenha.getText());
						//passa o objeto para a classe BO
					}	
						else if (escolherTipoAcesso.getText().equals("Avaliador")) {
							AvaliadorVO av = new AvaliadorVO();
							av.setNome(campoNome.getText());
							av.setCpf(campoCpf.getText());
							av.setEndereco(campoEndereco.getText());
							av.setTelefone(campoTelefone.getText());
							av.setLogin(campoLogin.getText());
							av.setSenha(campoSenha.getText());
							//passa o objeto para a classe BO
						}
		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void irSair() {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
