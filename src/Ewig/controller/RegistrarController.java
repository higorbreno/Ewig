package Ewig.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Ewig.exception.AtributoInvalidoException;
import Ewig.exception.CampoVazioException;
import Ewig.exception.LoginExistenteException;
import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class RegistrarController implements Initializable {
	
	private List<String> stringList = new ArrayList<>();
	private ObservableList<String> obsListVO;
	
	@FXML private TextField campoNome;
	@FXML private TextField campoCpf;
	@FXML private TextField campoEndereco;
	@FXML private TextField campoTelefone;
	@FXML private ChoiceBox<String> escolherTipoAcesso;
	@FXML private TextField campoLogin;
	@FXML private TextField campoSenha;
	@FXML private TextField campoRepitaSenha;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {;
		atualizarLista();
	}
	
	public void atualizarLista() {
		stringList.add("Gerente");
		stringList.add("Avaliador");
		stringList.add("Autor");
	
		obsListVO = FXCollections.observableArrayList(stringList);
		escolherTipoAcesso.setItems(obsListVO);
	}
	
	private void verificarCampo(TextField a) throws CampoVazioException{
		if (a.getText().isEmpty()) {
			throw new CampoVazioException("Complete todos os campos.");
		}
		else return;
	}
	
	public void registrar() {
		try {
			verificarCampo(campoNome);
			verificarCampo(campoCpf);
			verificarCampo(campoEndereco);
			verificarCampo(campoTelefone);
			verificarCampo(campoLogin);
			verificarCampo(campoSenha);
			verificarCampo(campoRepitaSenha);
			
			if (!campoSenha.getText().equals(campoRepitaSenha.getText())) {
				Telas.mensagemErro("As senhas não são iguais");
			}
			else {			
				UsuarioVO u = new UsuarioVO();
				u.setNome(campoNome.getText());
				u.setCpf(campoCpf.getText());
				u.setEndereco(campoEndereco.getText());
				u.setTelefone(campoTelefone.getText());
				u.setTipoUsuario(escolherTipoAcesso.getSelectionModel().getSelectedIndex());
				u.setLogin(campoLogin.getText());
				u.setSenha(campoSenha.getText());

				UsuarioBO<UsuarioVO> uBO = new UsuarioBO<UsuarioVO>();
				uBO.cadastrar(u);
				
				VisualizarController.tipoVisualizacao = 2;
				VisualizarController.usuario = u;
				Telas.telaVisualizar();	
			}
		} catch (AtributoInvalidoException | CampoVazioException | LoginExistenteException e) {
			Telas.mensagemErro(e.getMessage());
		}
		catch (Exception e) {
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
