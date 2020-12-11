package Ewig.controller;

import java.net.URL;
import java.util.ResourceBundle;

import Ewig.view.Telas;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MenuController implements Initializable{
	@FXML private ImageView botaoBuscar;
	@FXML private ImageView botaoAvaliar;
	@FXML private ImageView botaoCadastrar;
	@FXML private ImageView botaoDefinir;
	@FXML private ImageView botaoGerar;
	@FXML private ImageView botaoAutorizar;
	@FXML private Label indentificacaoUsu;
	@FXML private Label indentificacaoTipo;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		switch (Telas.Mestre.getTipoUsuario()) {
		
			case 0: // gerente
				mostrarB(botaoBuscar);
				esconderB(botaoAvaliar);
				mostrarB(botaoCadastrar);
				mostrarB(botaoDefinir);
				mostrarB(botaoGerar);
				mostrarB(botaoAutorizar);
				indentificacaoUsu.setText(Telas.Mestre.getLogin());
				indentificacaoTipo.setText("Gerente");
				break;
				
			case 1: // avaliador
				mostrarB(botaoBuscar);
				mostrarB(botaoAvaliar);
				esconderB(botaoCadastrar);
				esconderB(botaoDefinir);
				esconderB(botaoGerar);
				esconderB(botaoAutorizar);
				indentificacaoUsu.setText(Telas.Mestre.getLogin());
				indentificacaoTipo.setText("Avaliador");
				//indentificacaoUsu.setText("Usuario " +Telas.Mestre.getLogin()+ "; Tipo de Acesso: Avaliador.");
				break;
				
			case 2: // autor
				mostrarB(botaoBuscar);
				esconderB(botaoAvaliar);
				mostrarB(botaoCadastrar);
				esconderB(botaoDefinir);
				esconderB(botaoGerar);
				esconderB(botaoAutorizar);
				indentificacaoUsu.setText(Telas.Mestre.getLogin());
				indentificacaoTipo.setText("Autor");
				//indentificacaoUsu.setText("Usuario " +Telas.Mestre.getLogin()+ "; Tipo de Acesso: Autor.");
				break;
				
			default:
				System.out.println("Codigo invalido no getTipoUsuario() em Mestre");
		}
	}
	
	private void mostrarB(ImageView botao) {
		botao.setDisable(false);
		botao.setOpacity(1);
	}
	
	private void esconderB(ImageView botao) {
		botao.setCursor(null);
		botao.setDisable(true);
		botao.setOpacity(0.3);
	}
	
	public void irBuscar() {
		try {
			Telas.telaBuscar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irCadastrar() {
		try {
			Telas.telaCadastrar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void irRelatorio() {
		try {
			Telas.telaRelatorio();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void irDefinirAvaliador() {
		try {
			Telas.telaDefinirAvaliador();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irAvaliar() {
		try {
			Telas.telaAvaliar();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irAutorizarAcesso() {
		try {
			Telas.telaAutorizarAcesso();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void irSair() {
		try {
			Telas.telaLogin();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}