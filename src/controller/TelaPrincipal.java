package controller;

import java.awt.AWTException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Conselho;
import model.GeraConselho;
import model.GeraMeme;

public class TelaPrincipal implements Initializable{
	
	String diretorioAtual = System.getProperty("user.dir");
	
	private Stage stage;
	
	private Scene scene;
    
	@FXML
    private Label advicesText;

    @FXML
    private Pane barraSuperior;

    @FXML
    private ImageView buttonClose;

    @FXML
    private Button buttonFlor;

    @FXML
    private ImageView buttonPepe;
    
    @FXML
    private ImageView memeGerado;
    
    //Gera um novo conselho quando clica na flor
    @FXML
    void aconselhar(ActionEvent event) {
    	GeraConselho geraConselho = new GeraConselho();
    	try {
			Conselho conselho = geraConselho.aconselhar();
			String conselhoString = conselho.getAdvice();
			
			this.advicesText.setText(conselhoString);	
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		//Fecha o programa quando clica na imagem de fechar
		buttonClose.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		//Gera um meme quando clica no GIF do Pepe
		buttonPepe.setOnMouseClicked(event -> {
			
			GeraMeme geraMeme = new GeraMeme();
	    	try {
				boolean meme = geraMeme.gerarMeme(advicesText.getText());
				if(meme) {
					Main.mudarTela("secundaria"); //Muda para a tela de exibição do meme gerado
					Alert avisoSucesso = new Alert(Alert.AlertType.INFORMATION); //Gera aviso informando que o meme foi gerado com sucesso
					avisoSucesso.setTitle("Sucesso");
					avisoSucesso.setHeaderText("Gerado com sucesso!!!");
					avisoSucesso.setContentText("MEME GERADO COM SUCESSO!!! CONFIRA A PASTA RAIZ DO PROJETO");
					avisoSucesso.showAndWait();
				}else {
					Alert avisoFalha = new Alert(Alert.AlertType.WARNING);//Gera aviso informando que o meme não foi gerado
					avisoFalha.setTitle("Falha");
					avisoFalha.setHeaderText("Meme não gerado!");
					avisoFalha.setContentText("MEME NÃO GERADO! A FRASE NÃO CABE NA IMAGEM!");
					avisoFalha.showAndWait();
				}
			} catch (AWTException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
		});
		
	}

}
