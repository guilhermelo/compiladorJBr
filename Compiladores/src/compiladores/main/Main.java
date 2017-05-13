package compiladores.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		try {
			
			InputStream is = new FileInputStream("arquivo/jayBR.jbr");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			char caracter;
			List<String> tokens = new ArrayList<String>();
			while((caracter = (char) br.read()) != -1){
				StringBuilder token = new StringBuilder("");
				if(caracter != ' ' && caracter != '\n' && caracter != '.' && caracter != '"'){
					token.append(caracter);
				}
				
				while((caracter = (char) br.read()) != -1){
					if((caracter != ' ') && caracter != '\n' && caracter != '.' && caracter != '"'){
						token.append(caracter);
					}else{
						break;
					}
				}
				
				if(caracter == '"'){
					while((caracter = (char) br.read()) != -1 && caracter != '"'){
						System.out.println(caracter);
					}
					
					tokens.add(Character.toString(caracter));
				}
				
				if(caracter == '.'){
					tokens.add(Character.toString(caracter));
				}
				
				tokens.add(token.toString());
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
