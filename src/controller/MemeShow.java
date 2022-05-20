package controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MemeShow implements Initializable{
	
	@FXML
    private ImageView buttonClose;
	
    @FXML
    private ImageView memeGerado;
    
    @FXML
    private Button buttonVoltar;
    
    @FXML
    void voltar(MouseEvent event) {
    	Main.mudarTela("principal");
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		buttonClose.setOnMouseClicked(event -> {
			System.exit(0);
		});
		
		String diretorioAtual = System.getProperty("user.dir");
		this.memeGerado.setImage(new Image(diretorioAtual + "Meme.png"));
		
	}
    
    

}

