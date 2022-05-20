package model;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GeraConselho {
	
	//String da URL da API
	static String webService = "https://api.adviceslip.com/advice";
	
	//Abre conexão e retorna um conselho aleatório vindo da API
	public Conselho aconselhar() throws Exception {
		
		String urlDeChamada = webService;
		
		try {
			URL url = new URL(urlDeChamada);
			 HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			 BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
			 
			 String objetoEmString = "";
			 String respostaEmString = resposta.readLine();
			 
			 if(respostaEmString != null) {
		    	 objetoEmString += respostaEmString;
		     }
			 
			 int index = objetoEmString.indexOf("\"advice\"");
			 String conselhoString = objetoEmString.substring(index).replaceAll("}", "").replace("\"advice\":", "").replaceAll("\n", "").replace("\\", "");
			 Conselho c1 = new Conselho(conselhoString);
			 return c1;
			 
		}catch(Exception a) {
			throw new Exception("Erro: " + a);
		}
	}
	
}
