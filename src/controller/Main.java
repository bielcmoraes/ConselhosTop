package controller;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	private static Stage stage;
	
	private static Scene mainCena;
	private static Scene meme;
	
	private double y = 0;
	private double x = 0;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			stage = primaryStage;
			AnchorPane xmlMain = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/TelaPrincipalView.fxml"));
			mainCena = new Scene(xmlMain);
			mainCena.setFill(Color.TRANSPARENT);
			primaryStage.setScene(mainCena);
			primaryStage.initStyle(StageStyle.TRANSPARENT); //Remove a barra superior
			primaryStage.setResizable(false); //Impede de alterar tamanho
			
			xmlMain.setOnMousePressed(event -> {
				x = event.getSceneX();
				y = event.getSceneY();
			});
			
			xmlMain.setOnMouseDragged(event -> {
	            primaryStage.setX(event.getScreenX() - x);
	            primaryStage.setY(event.getScreenY() - y);
	        });
			
			AnchorPane xmlMeme = (AnchorPane)FXMLLoader.load(getClass().getResource("/view/MemeView.fxml"));
			meme = new Scene(xmlMeme);
			
			meme.setFill(Color.TRANSPARENT);
			primaryStage.setScene(meme);
			primaryStage.initStyle(StageStyle.TRANSPARENT); //Remove a barra superior
			primaryStage.setResizable(false); //Impede de alterar tamanho
			
			//Possibilita mover a janela com o mouse
			xmlMeme.setOnMousePressed(event -> {
				x = event.getSceneX();
				y = event.getSceneY();
			});
			
			xmlMeme.setOnMouseDragged(event -> {
	            primaryStage.setX(event.getScreenX() - x);
	            primaryStage.setY(event.getScreenY() - y);
	        });
			
			//Inicializa a tela principal
			mainCena.getStylesheets().add(getClass().getResource("/view/TelaPrincipalView.fxml").toExternalForm());
			primaryStage.setScene(mainCena);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//Metodo de mudança de tela
	public static void mudarTela(String telaNova) {
		if(telaNova == "principal") {
			stage.setScene(mainCena);
		} else if(telaNova == "secundaria") {
			stage.setScene(meme);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
