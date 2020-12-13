package Ewig.controller;

import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.UsuarioVO;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import Ewig.view.Telas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class AutorizarAcessoController implements Initializable{
	
	private UsuarioBO<UsuarioVO> usuBo = new UsuarioBO<UsuarioVO>();
	
	@FXML private ComboBox<String> usuarioEscolha;
	@FXML private Label nome;
	@FXML private Label cpf;
	@FXML private Label endereco;
	@FXML private Label telefone;
	@FXML private Label tipoAcesso;
	@FXML private Label aviso;
	
	
	private List<UsuarioVO> list;
	private ObservableList<String> stringList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		atualizarLista();
	}
	
	private void atualizarLista() {
		if(usuarioEscolha != null) {
			list = usuBo.listarUsuariosSemPermissao();
			List<String> stList =  new ArrayList<String>();
			for(UsuarioVO vo : list) {
				stList.add(vo.getNome());
			}
			stringList = FXCollections.observableArrayList(stList);
			usuarioEscolha.setItems(stringList);
			usuarioEscolha.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number value, Number new_value) {
					if (new_value.intValue() >= 0) {
						nome.setText("Nome: " + list.get(new_value.intValue()).getNome());
						cpf.setText("CPF: " + list.get(new_value.intValue()).getCpf());
						endereco.setText("Endere�o: " + list.get(new_value.intValue()).getEndereco());
						telefone.setText("Telefone: " + list.get(new_value.intValue()).getTelefone());
						if(list.get(new_value.intValue()).getTipoUsuario() == 0) {
							tipoAcesso.setText("Tipo de Acesso: Gerente");
						} else if (list.get(new_value.intValue()).getTipoUsuario() == 1) {
							tipoAcesso.setText("Tipo de Acesso: Avaliador");
						  } else if (list.get(new_value.intValue()).getTipoUsuario() == 2) {
							  tipoAcesso.setText("Tipo de Acesso: Autor");
						    }
					}
				}
			});
		}
	}
	
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void autorizarAcesso() {
		try {
			int index = usuarioEscolha.getSelectionModel().getSelectedIndex();
			UsuarioVO us;
			us = list.get(index);
			
			us.setPermissaoAcesso(true);
			usuBo.editar(us);
			aviso.setTextFill(Color.GREEN);
			aviso.setText("Usu�rio autorizado");
			aviso.setVisible(true);
			atualizarLista();
		} catch (ArrayIndexOutOfBoundsException e) {
			aviso.setTextFill(Color.RED);
			aviso.setText("Selecione um usu�rio");
			aviso.setVisible(true);
		}
		
		nome.setText("Nome: ");
		cpf.setText("CPF: ");
		endereco.setText("Endere�o: ");
		telefone.setText("Telefone: ");
		tipoAcesso.setText("Tipo de Acesso: ");
	}
}
