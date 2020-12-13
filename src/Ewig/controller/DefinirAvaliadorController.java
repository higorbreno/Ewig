package Ewig.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import Ewig.model.BO.AvaliadorBO;
import Ewig.model.BO.ObraBO;
import Ewig.model.VO.AvaliadorVO;
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
import javafx.scene.paint.Color;

public class DefinirAvaliadorController implements Initializable{
	private ObraBO obBo = new ObraBO();
	private AvaliadorBO usBo = new AvaliadorBO();
	
	@FXML private ComboBox<String> escolherObra;
	@FXML private ComboBox<String> escolherAvaliador;
	@FXML private Label labelAutorObra;
	@FXML private Label labelAnoObra;
	@FXML private Label labelGeneroObra;
	@FXML private Label labelMensagem;
	
	private List<ObraVO> obrasList;
	private List<UsuarioVO> avaliadorList;
	private ObservableList<String> obraStringList;
	private ObservableList<String> avalStringList;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		atualizarObras();
		atualizarAvaliadores();
	}
	
	public void definirAvaliador() {
		int index0 = escolherObra.getSelectionModel().getSelectedIndex();
		ObraVO obra = obrasList.get(index0);
		
		int index1 = escolherAvaliador.getSelectionModel().getSelectedIndex();
		UsuarioVO usuario = avaliadorList.get(index1);
		
		obra.setAvaliador(new AvaliadorVO(usuario));
		
		try {
			obBo.editar(obra);
		
			labelMensagem.setText("Avaliador definido.");
			labelMensagem.setVisible(true);
			labelMensagem.setTextFill(Color.GREEN);
		} catch (Exception e) {
			e.printStackTrace();
			labelMensagem.setText("Erro em definir Avaliador.");
			labelMensagem.setVisible(true);
			labelMensagem.setTextFill(Color.RED);
		}
		atualizarObras();
	}
	
	private void atualizarObras() {
		if(escolherObra != null) {
			obrasList = obBo.listar();
			List<String> stList = new ArrayList<String>();
			Iterator<ObraVO> iter = obrasList.iterator();
			while(iter.hasNext()) {
				ObraVO ob = iter.next();
				if(ob.getAvaliador() != null) {
					iter.remove();
				} else {
					stList.add(ob.getTitulo());
				}
			}
			obraStringList = FXCollections.observableArrayList(stList);
			escolherObra.setItems(obraStringList);
			escolherObra.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
				@Override
				public void changed(ObservableValue<? extends Number> ov, Number value, Number new_value) {
					if(new_value.intValue() >= 0) {
						labelAutorObra.setText("Autor: " + obrasList.get(new_value.intValue()).getAutor().getNome());
						labelAnoObra.setText("Ano: " + obrasList.get(new_value.intValue()).getAno());
						labelGeneroObra.setText("Genero: " + obrasList.get(new_value.intValue()).getGenero());
					}
				}
			});
		}
	}
	
	private void atualizarAvaliadores() {
		if(escolherAvaliador != null) {
			avaliadorList = usBo.listar(1);
			List<String> stList = new ArrayList<String>();
			Iterator<UsuarioVO> iter = avaliadorList.iterator();
			while(iter.hasNext()) {
				UsuarioVO us = iter.next();
				if (us.getPermissaoAcesso())
					stList.add(us.getNome());
			}
			avalStringList = FXCollections.observableArrayList(stList);
			escolherAvaliador.setItems(avalStringList);
		}
	}
	
	public void dadosObra() {
		labelAutorObra.setText("Pegar do BD");
		labelAutorObra.setVisible(true);
		labelAnoObra.setText("Pegar do BD");
		labelAnoObra.setVisible(true);
	}
	
	public void irMenu() {
		try {
			Telas.telaMenu();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
