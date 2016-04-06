
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseHTML {
	

	private ParseExcel parseExcel;
	private ArrayList<ArrayList<String>> data;
	private Stack theStack;
	
	
	public ParseHTML(){
		parseExcel = new ParseExcel();
		theStack = new Stack();
	}
	
		
	public Stack getEmailLetterStack(){

		File input = new File("Internet2 Tempe Lodging Confirmation Email.html");

		try {
			
			String letter = "";
			String email = "";
			data = parseExcel.parseExcelData();

			int i = 0;
			for (int k = 1; k < data.size(); k++){

				Document doc = Jsoup.parse(input, "UTF-8");
				letter = doc.toString();

				for (int j = 0; j < data.get(k).size(); j++){
					if (data.get(i).get(j).equalsIgnoreCase("email")){
						email = data.get(k).get(j);
					}
					letter = letter.replace(data.get(i).get(j), data.get(k).get(j));
					//To clean up MS office encoding
					
					letter = letter.replace("’", "&#39;");
					letter = letter.replace("“", "&#8220;");
					letter = letter.replace("”", "&#8221;");
					
				}
				LetterEmailPair letterEmailPair = new LetterEmailPair(letter,email);
				theStack.push(letterEmailPair);
			}

			//System.out.println(theStack.toString());
		
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return theStack;
	}
}
