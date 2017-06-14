package compiladores.lexico;

import java.util.HashMap;
import java.util.Map;

public class Token {

	
	public static Map<String, String> mapTokens = new HashMap<String, String>();
	
	static{
		mapTokens.put("{", "{");
		mapTokens.put("}", "}");
		mapTokens.put(".", ";");
		mapTokens.put("[", "(");
		mapTokens.put("]", ")");
		mapTokens.put("$<", "<");
		mapTokens.put("$>", ">");
		mapTokens.put("$<=", "<=");
		mapTokens.put("$>=", ">=");
		mapTokens.put("$!=", "!=");
		mapTokens.put("$=", "==");
		mapTokens.put("<-", "=");
		mapTokens.put("$+", "+");
		mapTokens.put("$-", "-");
		mapTokens.put("$/", "/");
		mapTokens.put("$*", "*");
		mapTokens.put("EE", "&&");
		mapTokens.put("OU", "||");
		mapTokens.put("\"", "\"");
		mapTokens.put("CONDICAO", "if");
		mapTokens.put("CONTRA", "else");
		mapTokens.put("DURANTE", "while");
		mapTokens.put("LOOP", "for");
		mapTokens.put("RECEBA", "System.in");
		mapTokens.put("INSIRA", "System.out.println");
		mapTokens.put("VAI", "main");
		mapTokens.put("@inteiro", null);
		mapTokens.put("@real", null);
		mapTokens.put("@binario", null);
		mapTokens.put("@letras", null);
		mapTokens.put("CABEI", null);
	}
	
	public static String existToken(String token){
		
		switch (token) {
		case "{":
				if(token.equals("{")){
					return mapTokens.get(token);
				}
			
		break;
		
		case "}":
				if(token.equals("}")){
					return mapTokens.get(token);
				}
		break;
		
		case ".":
				if(token.equals(".")){
					return mapTokens.get(token);
				}
		break;
		
		case "[":
			if(token.equals("[")){
				return mapTokens.get(token);
			}
		break;
		
		case "]":
			if(token.equals("]")){
				return mapTokens.get(token);
			}
		break;
		
		case "$<":
				if(token.equals("$<")){
					return mapTokens.get(token);
				}
		break;
		
		case "$>":
				if(token.equals("$>")){
					return mapTokens.get(token);
				}
		break;
		
		case "$<=":
				if(token.equals("$<=")){
					return mapTokens.get(token);
				}
		break;
		
		case "$>=":
				if(token.equals("$>=")){
					return mapTokens.get(token);
				}
		break;
		
		case "$!=":
				if(token.equals("$!=")){
					return mapTokens.get(token);
				}
		break;
		
		case "$=":
				if(token.equals("$=")){
					return mapTokens.get(token);
				}
		break;
		
		case "<-":
				if(token.equals("<-")){
					return mapTokens.get(token);
				}
		break;
		
		case "$+":
				if(token.equals("$+")){
					return mapTokens.get(token);
				}
		break;
		
		case "$-":
				if(token.equals("$-")){
					return mapTokens.get(token);
				}
		break;
		
		case "$/":
				if(token.equals("$/")){
					return mapTokens.get(token);
				}
		break;
		
		case "$*":
				if(token.equals("$*")){
					return mapTokens.get(token);
				}
		break;
		
		case "E":
			if(token.equals("E")){
				return mapTokens.get(token);
			}
		break;
		
		case "OU*":
			if(token.equals("OU")){
				return mapTokens.get(token);
			}
		break;
		
		case "\"\"":
			if(token.equals("\"\"")){
				return mapTokens.get(token);
			}
		break;
		
		case "CONDICAO":
			if(token.equals("CONDICAO")){
				return mapTokens.get(token);
			}
		break;
		
		case "CONTRA":
			if(token.equals("CONTRA")){
				return mapTokens.get(token);
			}
		break;
		
		case "DURANTE":
			if(token.equals("DURANTE")){
				return mapTokens.get(token);
			}
		break;
		
		case "LOOP":
			if(token.equals("LOOP")){
				return mapTokens.get(token);
			}
		break;
		
		case "RECEBA":
			if(token.equals("RECEBA")){
				return mapTokens.get(token);
			}
		break;
		
		case "INSIRA":
			if(token.equals("INSIRA")){
				return mapTokens.get(token);
			}
		break;
		
		case "VAI":
			if(token.equals("VAI")){
				return mapTokens.get(token);
			}
		break;
		
		case "CABEI":
			if(token.equals("CABEI")){
				return mapTokens.get(token);
			}
		break;

		}
				
		return null;
	}
	
}

