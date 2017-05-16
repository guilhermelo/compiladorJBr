package lexico;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JTextPane;

public class Analisador {

	public static String[][] Analisar(JTextPane jtp) {
		try {
			InputStream is = new FileInputStream("arquivo/jayBR.jbr");

			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			char last;
			char caracter;
			List<String> tokens = new ArrayList<String>();
			int asci = br.read();
			caracter = (char) asci;
			while (asci != -1) {
				StringBuilder token = new StringBuilder("");
				if (caracter == '"') {
					last = caracter;

					while ((caracter = (char) br.read()) != -1 && caracter != '"') {
						token.append(caracter);
						jtp.setText(""+caracter);
						
						last = caracter;
					}

					tokens.add(token.toString());
					caracter = (char) br.read();
				}

				if (caracter != ' ' && caracter != '\n' && caracter != '.' && caracter != '"') {
					token.append(caracter);
					jtp.setText(""+caracter);
				}

				while (asci != -1) {
					asci = br.read();
					caracter = (char) asci;

					if ((caracter != ' ') && caracter != '\n' && caracter != '.' && caracter != '"') {
						token.append(caracter);
						jtp.setText(""+caracter);
					} else {
						break;
					}
				}

				if (caracter == '.') {
					tokens.add(Character.toString(caracter));
				}

				tokens.add(token.toString());
				asci = br.read();
				caracter = (char) asci;
			}
			return geraMatriz(tokens);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;

	}

	private static String[][] geraMatriz(List<String> lista) {

		List<String> listafinal = new ArrayList<String>();

		int counter = 0;
		for (String string : lista) {
			if (!listafinal.contains(string)) {
				listafinal.add(string);
			}
		}
		String[][] matrizfinal = new String[listafinal.size()][2];
		for (String string : listafinal) {
			matrizfinal[counter][0] = string;
			matrizfinal[counter][1] = new Integer(Collections.frequency(lista, string)).toString();
			counter++;
		}

		return matrizfinal;
	}

}
