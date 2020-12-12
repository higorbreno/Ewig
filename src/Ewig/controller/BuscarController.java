package Ewig.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import Ewig.exception.AtributoInvalidoException;
import Ewig.model.BO.ObraBO;
import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.AutorVO;
import Ewig.model.VO.ObraVO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

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
	
	@FXML private ListView<String> listView;
	
	@FXML private Label erro;
	
	private ToggleGroup toggle = new ToggleGroup();
	
	private List<UsuarioVO> autores;
	private ObservableList<String> nomeAutores;
	
	private List<UsuarioVO> usuarios;
	private ObservableList<String> nomeUsuarios;
	private List<ObraVO> obras;
	private ObservableList<String> tituloObras;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		selecaoObras.setToggleGroup(toggle);
		selecaoAutores.setToggleGroup(toggle);
		selecaoAvaliadores.setToggleGroup(toggle);
		
		atualizarComboBoxAutores();
	}
	
	public void buscar() {
		RadioButton selectedButton = (RadioButton)toggle.getSelectedToggle();
		String tipoPesquisa = selectedButton.getText();
		System.out.println(tipoPesquisa);
		
		if(campo1.getText() == null && campo2.getText() == null && campo3.getText() == null && autorCombo.getSelectionModel().getSelectedItem() == null) {
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
			if(campo1.getText() != null) 
				ob.setTitulo(campo1.getText());
			if(campo2.getText() != null)
				ob.setGenero(campo2.getText());
			if(campo3.getText() != null)
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
				if(campo1.getText() != null)
					av.setNome(campo1.getText());
				if(campo2.getText() != null)
					av.setCpf(campo2.getText());
			} catch (AtributoInvalidoException e) {
				e.printStackTrace();
			}
			usuarios = usuBo.buscar(av, 1);
			atualizarListViewComUsuarios();
			
		} else if(tipoPesquisa.contentEquals("Autores")) {
			
			UsuarioVO au = new UsuarioVO();
			try {
				if(campo1.getText() != null)
					au.setNome(campo1.getText());
				if(campo2.getText() != null)
					au.setCpf(campo2.getText());
			} catch (AtributoInvalidoException e) {
				e.printStackTrace();
			}
			//usuarios = usuBo.buscar(au, 1);
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
			nomeAutores = FXCollections.observableArrayList(stList);
			autorCombo.setItems(nomeAutores);
		}
	}
	
	private void atualizarListViewComUsuarios() {
		//nomeUsuarios = FXCollections.observableArrayList(usuarios);
		listView.setItems(nomeUsuarios);
	}
	
	private void atualizarListViewComObras() {
		List<String> stList = new ArrayList<String>();
		Iterator<ObraVO> iter = obras.iterator();
		while(iter.hasNext()) {
			ObraVO ob = iter.next();
			stList.add(ob.getTitulo());
		}
		tituloObras = FXCollections.observableArrayList(stList);
		listView.setItems(tituloObras);
	}
	
	public void irVoltarMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//inutilizavel enquanto não houver objetos na lista de busca
	public void irVisualizar() {
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
