package pkjaya;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("resource")
		Lexical_Analyzer lex = new Lexical_Analyzer();
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		String st;
		while ((st = br.readLine()) != null) {
			String[] elements = st.split("[\\s\\xA0]+");
			if(elements[0].charAt(elements[0].length() - 1) == ':') {
				String temp = new String();
				for(int i = 1; i < elements.length; i++)
					temp+= elements[i];
				lex.regularDefinition.put(elements[0].substring(0, elements[0].length() - 1), temp);
			}
			else if(elements[1].equals("=")) {
				String temp = new String();
				for(int i = 2; i < elements.length; i++)
					temp+= elements[i];
				lex.regularExpression.put(elements[0], temp);
			}
			else if(elements[0].equals("[")) {
				for(int i = 1; i < elements.length - 1; i++)
					lex.punctuation.put(elements[i], "Punctuation");
			}
			else if(elements[0].equals("{")) {
				for(int i = 1; i < elements.length - 1; i++)
					lex.keyword.put(elements[i], "Keyword");
			}
		}
		System.out.println(lex.keyword);
		System.out.println(lex.punctuation);
		System.out.println(lex.regularDefinition);
		System.out.println(lex.regularExpression);
	}
}
