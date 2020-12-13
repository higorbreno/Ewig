package Ewig.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Ewig.exception.AtributoInvalidoException;
import Ewig.model.BO.ObraBO;
import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.AutorVO;
import Ewig.model.VO.ObraVO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

public class BuscarController implements Initializable{
	
	private ObraBO obBo = new ObraBO();
	private UsuarioBO<UsuarioVO> usuBo = new UsuarioBO<UsuarioVO>();
	
	@FXML private RadioButton selecaoObras;
	@FXML private RadioButton selecaoAutores;
	@FXML private RadioButton selecaoAvaliadores;
	
	@FXML private TextField campo1;
	@FXML private TextField campo2;
	@FXML private TextField campo3;
	
	@FXML private ComboBox<String> autorCombo;
	
	@FXML private TableView<UsuarioVO> lista1;
	@FXML private TableColumn<UsuarioVO, String> resultados1;
	@FXML private TableView<ObraVO> lista2;
	@FXML private TableColumn<ObraVO, String> resultados2;
	
	@FXML private Label erro;
	
	private ToggleGroup toggle = new ToggleGroup();
	
	private List<UsuarioVO> autores;
	private ObservableList<String> nomeAutores;
	
	private List<UsuarioVO> usuarios;
	private ObservableList<UsuarioVO> obsUsuarios;
	private List<ObraVO> obras;
	private ObservableList<ObraVO> obsObras;
	
	private boolean estaTabelaUsuario;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		estaTabelaUsuario = false;
		
		selecaoObras.setSelected(true);
		
		selecaoObras.setToggleGroup(toggle);
		selecaoAutores.setToggleGroup(toggle);
		selecaoAvaliadores.setToggleGroup(toggle);
		
		toggle.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
			public void changed(ObservableValue<? extends Toggle> ov,
					Toggle old_toggle, Toggle new_toggle) {
				if (toggle.getSelectedToggle() != null) {
					RadioButton selectedButton = (RadioButton)toggle.getSelectedToggle();
					String tipo = selectedButton.getText();
					
					if(tipo.contentEquals("Obras")) {
						campo1.setDisable(false);
						campo2.setDisable(false);
						campo3.setDisable(false);
						autorCombo.setDisable(false);
						
						campo1.setVisible(true);
						campo2.setVisible(true);
						campo3.setVisible(true);
						autorCombo.setVisible(true);
						
						campo1.setPromptText("Título");
						campo2.setPromptText("Gênero");
					} else if(tipo.contentEquals("Autores") || tipo.contentEquals("Avaliadores")) {
						campo1.setDisable(false);
						campo2.setDisable(false);
						campo3.setDisable(true);
						autorCombo.setDisable(true);
						
						campo1.setVisible(true);
						campo2.setVisible(true);
						campo3.setVisible(false);
						autorCombo.setVisible(false);
						
						campo1.setPromptText("Nome");
						campo2.setPromptText("CPF");
					}
				}
			}
		});
		
		atualizarComboBoxAutores();
		
		resultados1.setCellValueFactory(new PropertyValueFactory<UsuarioVO, String>("nome"));
		resultados2.setCellValueFactory(new PropertyValueFactory<ObraVO, String>("titulo"));
	}
	
	public void buscar() {
		RadioButton selectedButton = (RadioButton)toggle.getSelectedToggle();
		String tipoPesquisa = selectedButton.getText();
		boolean check1 = campo1.getText() == null || campo1.getText().trim().isEmpty();
		boolean check2 = campo2.getText() == null || campo2.getText().trim().isEmpty();
		boolean check3 = campo3.getText() == null || campo3.getText().trim().isEmpty();
		boolean check4 = autorCombo.getSelectionModel().getSelectedItem() == null;

		if(check1 && check2 && check3 && check4) {
			if(tipoPesquisa.contentEquals("Obras")) {
				obras = obBo.listar();
				atualizarListViewComObras();
				return;
			} else if(tipoPesquisa.contentEquals("Avaliadores")) {
				usuarios = usuBo.listar(1);
				atualizarListViewComUsuarios();
				return;
			} else if(tipoPesquisa.contentEquals("Autores")) {
				usuarios = usuBo.listar(2);
				atualizarListViewComUsuarios();
				return;
			} else {
				erro.setText("Tipo de Pesquisa não selecionado");
				erro.setVisible(true);
				return;
			}
		}
		
		if(tipoPesquisa.contentEquals("Obras")) {
			
			ObraVO ob = new ObraVO();
			if(campo1.getText() != null && !campo1.getText().trim().isEmpty()) 
				ob.setTitulo(campo1.getText());
			if(campo2.getText() != null && !campo2.getText().trim().isEmpty())
				ob.setGenero(campo2.getText());
			if(campo3.getText() != null && !campo3.getText().trim().isEmpty())
				ob.setAno(Integer.parseInt(campo3.getText()));
			if(autorCombo.getSelectionModel().getSelectedItem() != null) {
				int index = autorCombo.getSelectionModel().getSelectedIndex();
				UsuarioVO u = autores.get(index);
				ob.setAutor(new AutorVO(u));
			}
			obras = obBo.buscar(ob);
			atualizarListViewComObras();
			
		} else if(tipoPesquisa.contentEquals("Avaliadores")) {
			
			UsuarioVO av = new UsuarioVO();
			try {
				if(campo1.getText() != null && !campo1.getText().trim().isEmpty())
					av.setNome(campo1.getText());
				if(campo2.getText() != null && !campo2.getText().trim().isEmpty())
					av.setCpf(campo2.getText());
			} catch (AtributoInvalidoException e) {
				e.printStackTrace();
			}
			usuarios = usuBo.buscarPorNomeECpf(av, 1);
			atualizarListViewComUsuarios();
			
		} else if(tipoPesquisa.contentEquals("Autores")) {
			
			UsuarioVO au = new UsuarioVO();
			
			try {
				if(campo1.getText() != null && !campo1.getText().trim().isEmpty())
					au.setNome(campo1.getText());
				if(campo2.getText() != null && !campo2.getText().trim().isEmpty())
					au.setCpf(campo2.getText());
			} catch (AtributoInvalidoException e) {
				e.printStackTrace();
			}
			usuarios = usuBo.buscarPorNomeECpf(au, 2);
			atualizarListViewComUsuarios();
			
		} else {
			erro.setText("Tipo de Pesquisa não selecionado");
			erro.setVisible(true);
		}
	}
	
	private void atualizarComboBoxAutores() {
		if(autorCombo != null) {
			autores = usuBo.listar(2);
			List<String> stList = new ArrayList<String>();
			for(UsuarioVO vo : autores) {
				stList.add(vo.getNome());
			}
			nomeAutores = FXCollections.observableArrayList(stList);
			autorCombo.setItems(nomeAutores);
		}
	}
	
	private void atualizarListViewComUsuarios() {
		obsUsuarios = FXCollections.observableArrayList(usuarios);
		lista1.setItems(obsUsuarios);
		lista1.setDisable(false);
		lista1.setVisible(true);
		lista2.setDisable(true);
		lista2.setVisible(false);
		estaTabelaUsuario = true;
	}
	
	private void atualizarListViewComObras() {
		obsObras = FXCollections.observableArrayList(obras);
		lista2.setItems(obsObras);
		lista1.setDisable(true);
		lista1.setVisible(false);
		lista2.setDisable(false);
		lista2.setVisible(true);
		estaTabelaUsuario = false;
	}
	
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletar() {
		if(estaTabelaUsuario) {
			UsuarioVO us = lista1.getSelectionModel().getSelectedItem();
			usuBo.excluir(us);
		} else {
			ObraVO ob = lista2.getSelectionModel().getSelectedItem();
			obBo.excluir(ob);
		}
	}
	
	//inutilizavel enquanto não houver objetos na lista de busca
	public void irVisualizar() {
		
		if(estaTabelaUsuario) {
			VisualizarController.usuario = lista1.getSelectionModel().getSelectedItem();
			VisualizarController.tipoVisualizacao = 1;
		} else {
			VisualizarController.obra = lista2.getSelectionModel().getSelectedItem();
			VisualizarController.tipoVisualizacao = 0;
		}
		
		try {
			Telas.telaVisualizar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inutilizavel enquanto não houver objetos na lista de busca
	public void irAlterar() {
		try {
			Telas.telaAlterar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
