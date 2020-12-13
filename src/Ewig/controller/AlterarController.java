package Ewig.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Ewig.exception.AtributoInvalidoException;
import Ewig.model.BO.AutorBO;
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
import javafx.scene.control.TextField;

public class AlterarController implements Initializable {
	
	UsuarioBO<AutorVO> usuBO = new AutorBO();
	private List<UsuarioVO> listVO;
	private List<String> stringList = new ArrayList<>();
	private ObservableList<String> obsListVO;
	
	public static boolean alterarUsuario;
	public static ObraVO obra;
	public static UsuarioVO usuario;
	
	@FXML private TextField campo1;
	@FXML private TextField campo2;
	@FXML private TextField campo3;
	@FXML private ComboBox<String> escolherAutor;
	@FXML private Label labelMensagem;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if (alterarUsuario) { // Alterar USUARIO
			campo1.setText(usuario.getNome());
			campo2.setText(usuario.getEndereco());
			campo2.setText(usuario.getTelefone());
			escolherAutor.setVisible(false);
		}
		else { // Alterar OBRA
			campo1.setText(obra.getTitulo());
			campo2.setText(obra.getGenero());
			campo3.setText("" + obra.getAno());
			escolherAutor.setVisible(true);
			escolherAutor.setPromptText(obra.getAutor().getNome());
			atualizarLista();
		}
	}
	
	public void atualizarLista() {
		listVO = usuBO.listar(2);
		for(UsuarioVO u : listVO)
			stringList.add(u.getNome());
		obsListVO = FXCollections.observableArrayList(stringList);
		escolherAutor.setItems(obsListVO);
	}
	
	public void alterar() {	
		try {
			if (alterarUsuario) { // Alterar USUARIO
				usuario.setNome(campo1.getText());
				usuario.setEndereco(campo2.getText());
				usuario.setTelefone(campo3.getText());
				
				UsuarioBO<UsuarioVO> uBO = new UsuarioBO<UsuarioVO>();
				uBO.editar(usuario);
			}
			else { // Alterar OBRA
				campo1.setText(obra.getTitulo());
				campo2.setText(obra.getGenero());
				campo3.setText("" + obra.getAno());
				escolherAutor.setVisible(true);
				escolherAutor.setPromptText(obra.getAutor().getNome());
				atualizarLista();
				
				obra.setTitulo(campo1.getText());
				obra.setGenero(campo2.getText());
				obra.setAno(Integer.parseInt(campo3.getText()));
				
				int index = escolherAutor.getSelectionModel().getSelectedIndex();
				UsuarioVO us = new UsuarioVO();
				us = listVO.get(index);
				
				obra.setAutor(new AutorVO(us));
				
				ObraBO oBO = new ObraBO();
				oBO.editar(obra);
			}
			try {
				Telas.telaBuscar();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (AtributoInvalidoException e) {
			labelMensagem.setText(e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			obra.setTitulo(campo1.getText());
			obra.setGenero(campo2.getText());
			obra.setAno(Integer.parseInt(campo3.getText()));
			
			ObraBO oBO = new ObraBO();
			oBO.editar(obra);
			try {
				Telas.telaBuscar();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}	
	
	public void irBuscar() {
		try {
			Telas.telaBuscar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
