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
	
	public static int tipoVisualizacao;
	
	@FXML private Label label1;
	@FXML private Label label2;
	@FXML private Label label3;
	@FXML private Label label4;
	@FXML private Label label5;
	@FXML private Label label6;
	@FXML private Label label7;
	@FXML private Label label8;
	@FXML private Label labelNovoUsu;
	@FXML private Label rotulo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		switch (tipoVisualizacao) {
			case 0:
				mostrarDadosObra();
			break;
			case 1:
				mostrarDadosUsuario();
			break;
			case 2:
				mostrarNovoUsuario();
			break;
			default:
				System.out.println("Valor invalido em VisualizarController.tipoVisualização()");
		}
	}
	
	private void mostrarDadosObra() {
		rotulo.setText("Visualizar");
		label1.setText("Título: " + obra.getTitulo());
		label2.setText("Gênero: " + obra.getGenero());
		label3.setText("Ano: " + obra.getAno());
		label4.setText("Status: " + obra.getStatus());
		if(obra.getDataAvaliacao() == null)
			label5.setText("Tipo de Usuário: Obra em avaliação");
		else
			label5.setText("Tipo de Usuário: " + obra.getDataAvaliacao());
		label6.setText("Autor: " + obra.getAutor().getNome());
		if(obra.getAvaliador() == null)
			label7.setText("Avaliador: Obra sem avaliador");
		else
			label7.setText("Avaliador: " + obra.getAvaliador().getNome());
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(true);
		label7.setVisible(true);
	}
	
	private void mostrarDadosUsuario() {
		rotulo.setText("Visualizar");
		label1.setText("Nome: " + usuario.getNome());
		label2.setText("CPF: " + usuario.getCpf());
		label3.setText("Endereço: " + usuario.getEndereco());
		label4.setText("Telefone: " + usuario.getTelefone());
		if(usuario.getTipoUsuario() == 1) 
			label5.setText("Tipo de usuário: Gerente");
		else if(usuario.getTipoUsuario() == 2)
			label5.setText("Tipo de usuário: Avaliador");
		else if(usuario.getTipoUsuario() == 3)
			label5.setText("Tipo de usuário: Autor");
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(false);
		label7.setVisible(false);
		label8.setVisible(false);
	}
	
	public void mostrarNovoUsuario() {
		labelNovoUsu.setVisible(true);
		rotulo.setText("Registre-se");
		
		label1.setText("Nome: " + usuario.getNome());
		label2.setText("CPF: " + usuario.getCpf());
		label3.setText("Endereço: " + usuario.getEndereco());
		label4.setText("Telefone: " + usuario.getTelefone());
		if(usuario.getTipoUsuario() == 0) 
			label5.setText("Tipo de usuário: Gerente");
		else if(usuario.getTipoUsuario() == 1)
			label5.setText("Tipo de usuário: Avaliador");
		else if(usuario.getTipoUsuario() == 2)
			label5.setText("Tipo de usuário: Autor");
		label7.setText("Login: " + usuario.getLogin());
		
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		label6.setVisible(false);
		label7.setVisible(true);
		label8.setVisible(false);
	}
	
	public void irVoltarBuscar() {
		try {
			if (tipoVisualizacao == 2) {
				Telas.telaLogin();
			}
			else {
				Telas.telaBuscar();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	
}
