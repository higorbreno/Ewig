package Ewig.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import Ewig.model.BO.ObraBO;
import Ewig.model.VO.ObraVO;
import Ewig.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;

public class AvaliarController implements Initializable{
	ObraBO obBo = new ObraBO();
	
	@FXML private ComboBox<String> escolherObra;
	@FXML private RadioButton checkAceitar;
	@FXML private RadioButton checkRejeitar;
	
	final ToggleGroup toggle = new ToggleGroup();
	
	private List<ObraVO> list;
	private ObservableList<String> stringList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		checkAceitar.setToggleGroup(toggle);
		checkRejeitar.setToggleGroup(toggle);
		
		atualizarLista();
	}

	private void atualizarLista() {
		if(escolherObra != null) {
			list = obBo.listar();
			List<String> stList = new ArrayList<String>();
			Iterator<ObraVO> iter = list.iterator();
			while(iter.hasNext()) {
				ObraVO ob = iter.next();
				if(ob.getStatus() != "Em Avalia��o" || ob.getAvaliador() == null || ob.getAvaliador().getId() != Telas.Mestre.getId()) {
					iter.remove();
				} else {
					stList.add(ob.getTitulo());
				}
			}
			stringList = FXCollections.observableArrayList(stList);
			
			escolherObra.setItems(stringList);
		}
	}
	
	public void avaliarObra() {
		try {
			RadioButton selectedButton = (RadioButton)toggle.getSelectedToggle();
			String toggleGroupValue = selectedButton.getText();
			
			int index = escolherObra.getSelectionModel().getSelectedIndex();
			ObraVO obra = list.get(index);
			
			if(toggleGroupValue.equals("Aceitar")) {
				obra.setStatus("Aprovado");
				obBo.editar(obra);	
			} else {
				obra.setStatus("Rejeitado");
				obBo.editar(obra);
			}
			
			atualizarLista();
			Telas.mensagemInfo("A obra foi avaliada");
		} catch (ArrayIndexOutOfBoundsException e) {
			Telas.mensagemErro("Nenhuma obra selecionada");
		} catch (Exception e) {
			Telas.mensagemErro("Ocorreu um erro na avalia��o");
		}
	}
	
	public void irMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
}
