package Ewig.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Telas extends Application{
	private static Stage primaryStage;

	public static void main(String[] args) {
		launch();
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}
	
	public void setPrimaryStage(Stage primaryStage) {
		Telas.primaryStage = primaryStage;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		setPrimaryStage(primaryStage);
		primaryStage.setTitle("Projeto Ewig");
		primaryStage.show();
		telaLogin();
	}

	public static void telaLogin() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Login.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);
	}
	public static void telaMenu() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Menu.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);;
	}
	public static void telaBuscar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Buscar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);;
	}
	public static void telaCadastrar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Cadastrar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);;
	}
	public static void telaDefinirAvaliador() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/DefinirAvaliador.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);;
	}
	public static void telaRelatorio() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Relatorio.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);;
	}
	public static void telaVisualizar() throws Exception{
		Parent root = FXMLLoader.load(Telas.class.getResource("VE/Telas/Visualizar.fxml"));
		Scene cena = new Scene(root);
		primaryStage.setScene(cena);;
	}
}
