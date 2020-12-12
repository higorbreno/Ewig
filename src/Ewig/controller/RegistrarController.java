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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

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
	@FXML private Label labelMensagem;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mensagem("");
		atualizarLista();
	}
	
	public void atualizarLista() {
		stringList.add("Gerente");
		stringList.add("Avaliador");
		stringList.add("Autor");
	
		obsListVO = FXCollections.observableArrayList(stringList);
		escolherTipoAcesso.setItems(obsListVO);
	}
	
	private void mensagem(String m) {
		labelMensagem.setText(m);
		labelMensagem.setVisible(true);
		labelMensagem.setTextFill(Color.RED);
	}
	
	private void verificarCampo(TextField a) throws CampoVazioException{
		if (a.getText().isEmpty()) {
			mensagem("Complete todos os campos.");
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
				mensagem("As senhas não são iguais");
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
				
				//if(uBO.buscar(u, 0) != null) {
					VisualizarController.tipoVisualizacao = 2;
					VisualizarController.usuario = u;
					Telas.telaVisualizar();	
				//}
				//else mensagem("Houve um problema grave");
			}
		} catch (LoginExistenteException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
			mensagem("Login já existe, tente outro Login");
		} catch (AtributoInvalidoException e) {
			e.printStackTrace();
			mensagem(e.getMessage());
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
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
