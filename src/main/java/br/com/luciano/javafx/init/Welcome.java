package br.com.luciano.javafx.init;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * 
 * @author Luciano Lima
 *
 */
public class Welcome extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Welcome");
		Pane root = FXMLLoader.load(getClass().getResource("/template/Welcome.fxml"));
		
		Scene cena = new Scene(root, 300, 250);
		primaryStage.setScene(cena);
		primaryStage.show();
	}
	
}
