package Ewig.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import Ewig.model.BO.AutorBO;
import Ewig.model.BO.UsuarioBO;
import Ewig.model.VO.AutorVO;
import Ewig.model.VO.ObraVO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.util.Callback;

public class CadastrarController implements Initializable {
	
	UsuarioBO<AutorVO> usuBO = new AutorBO();
	private List<UsuarioVO> listVO = new ArrayList<>();
	private ObservableList<String> obsListVO;
	
	@FXML private TextField campoTitulo;
	@FXML private TextField campoGenero;
	@FXML private TextField campoAno;
	@FXML private ComboBox<String> escolherAutor;
	@FXML private Label labelMensagem;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		atualizarLista();
	}
	
	public void atualizarLista() {
		if(Telas.Mestre.getTipoUsuario() == 2 ) {
			obsListVO.add(Telas.Mestre.getNome());
		} 
		else {
			listVO.addAll(usuBO.listar(2));
			
			for(UsuarioVO u : listVO) {
				obsListVO.add(u.getNome());
			}
		}
		
		escolherAutor.setItems(obsListVO);
	}
	
	public void cadastrarObra() {
		try {
			ObraVO o = new ObraVO();
			o.setTitulo(campoTitulo.getText());
			o.setGenero(campoGenero.getText());
			o.setAno(Integer.parseInt(campoAno.getText()));
			//o.setAutor(); recebe o valor de campoAutor
		
			//chama cadastrar() de ObraVO
			
			
			
			labelMensagem.setText("O cadastro foi realizado com sucesso");
			labelMensagem.setTextFill(Color.WHITE);
			labelMensagem.setVisible(true);
			
			campoTitulo.setText(null);
			campoGenero.setText(null);
			campoAno.setText(null);
			//escolherAutor
			
		} catch (Exception e) {
			e.printStackTrace();
			labelMensagem.setText("Não foi possivel realizar o cadastro");
			labelMensagem.setTextFill(Color.RED);
			labelMensagem.setVisible(true);
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
