package Ewig.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application{

	public static void main(String[] args) {
		launch();

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("VE/Login.fxml"));
		Scene cena = new Scene(root);
		
		primaryStage.setTitle("Projeto Ewig");
		primaryStage.setScene(cena);
		primaryStage.show();
	}

}
