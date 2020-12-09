package Ewig.controller;

import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.UsuarioVO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import Ewig.view.Telas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

public class AutorizarAcessoController implements Initializable{
	
	private UsuarioBO<UsuarioVO> usuBo;
	
	@FXML private ChoiceBox<UsuarioVO> usuarioEscolha;
	@FXML private Label nome;
	@FXML private Label cpf;
	@FXML private Label endereco;
	@FXML private Label telefone;
	
	private List<UsuarioVO> list;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		list = usuBo.listarUsuariosSemPermissao();
		usuarioEscolha.setItems(FXCollections.observableArrayList(list));
		usuarioEscolha.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> ov, Number value, Number new_value) {
				nome.setText("Nome: " + list.get(new_value.intValue()).getNome());
				cpf.setText("Nome: " + list.get(new_value.intValue()).getCpf());
				endereco.setText("Nome: " + list.get(new_value.intValue()).getEndereco());
				telefone.setText("Nome: " + list.get(new_value.intValue()).getTelefone());
			}
		});
	}
	
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void autorizarAcesso() {
		
	}
}
