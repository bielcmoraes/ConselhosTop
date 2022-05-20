package model;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class GeraMeme {
	
	public boolean gerarMeme(String frase) throws AWTException, IOException {
		
		String diretorioAtual = System.getProperty("user.dir");
		if(frase.length() < 56) {
			
			Random gerador = new Random();
			String nameImage = String.valueOf(gerador.nextInt(10));
			BufferedImage bufferImage = ImageIO.read(new File(diretorioAtual + "\\images\\" + nameImage + ".png" )); //Sorteia uma imagem para ser base do meme			
			int largura = 3;
			int altura = bufferImage.getHeight() / 2;
			Graphics graphics = bufferImage.getGraphics();
			graphics.setColor(Color.BLACK);
			graphics.setFont(new Font("Arial Black", Font.PLAIN, 30));
			graphics.drawString(frase, largura, altura);
			File arquivoImg = new File(diretorioAtual + "Meme.png"); //Cria o arquivo da imagem
			try {
				ImageIO.write(bufferImage, "png", arquivoImg); //Salva a imagem no arquivo
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			return true;
		}else {
			return false;
		}
		
	}
}