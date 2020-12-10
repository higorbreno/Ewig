package Ewig.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Ewig.model.VO.ObraVO;
import Ewig.model.VO.UsuarioVO;
import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class VisualizarController implements Initializable{
	
	public static UsuarioVO usuario;
	public static ObraVO obra;
	
	public static int tipoVisualiza��o;
	
	@FXML private Label label1;
	@FXML private Label label2;
	@FXML private Label label3;
	@FXML private Label label4;
	@FXML private Label label5;
	@FXML private Label label6;
	@FXML private Label label7;
	@FXML private Label label8;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		if(tipoVisualiza��o == 0) {
			mostrarDadosObra();
		} else if (tipoVisualiza��o == 1) {
			mostrarDadosUsuario();
		}
	}
	
	private void mostrarDadosObra() {
		label1.setText("T�tulo: " + obra.getTitulo());
		label2.setText("G�nero: " + obra.getGenero());
		label3.setText("Ano: " + obra.getAno());
		label4.setText("Status: " + obra.getStatus());
		if(obra.getDataAvaliacao() == null)
			label5.setText("Tipo de Usu�rio: Obra em avalia��o");
		else
			label5.setText("Tipo de Usu�rio: " + obra.getDataAvaliacao());
		label6.setText("Autor: " + obra.getAutor().getNome());
		if(obra.getAvaliador() == null)
			label7.setText("Avaliador: Obra sem avaliador");
		else
			label7.setText("Avaliador: " + obra.getAvaliador().getNome());
		label8.setText("Gerente: " + obra.getGerente().getNome());
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(true);
		label7.setVisible(true);
		label8.setVisible(true);
	}
	
	private void mostrarDadosUsuario() {
		label1.setText("Nome: " + usuario.getNome());
		label2.setText("CPF: " + usuario.getCpf());
		label3.setText("Endere�o: " + usuario.getEndereco());
		label4.setText("Telefone: " + usuario.getTelefone());
		if(usuario.getTipoUsuario() == 1) 
			label5.setText("Tipo de usu�rio: Gerente");
		else if(usuario.getTipoUsuario() == 2)
			label5.setText("Tipo de usu�rio: Avaliador");
		else if(usuario.getTipoUsuario() == 3)
			label5.setText("Tipo de usu�rio: Autor");
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(false);
		label7.setVisible(false);
		label8.setVisible(false);
	}
	
	public void irVoltarBuscar() {
		try {
			Telas.telaBuscar();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
