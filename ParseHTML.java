package mail;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseHTML {
	

	private ParseExcel parseExcel;
	private ArrayList<ArrayList<String>> data;
	private Stack theStack;
	
	
	public ParseHTML(String excel){
		parseExcel = new ParseExcel(excel);
		theStack = new Stack();
	}
	
		
	public Stack getEmailLetterStack(String excel, String doc){

		DocxToHtml converter = new DocxToHtml();
		File input = converter.DocxToHtml(doc);

		try {
			
			String letter = "";
			String email = "";
			data = parseExcel.parseExcelData(excel);

			int i = 0;
			for (int k = 1; k < data.size(); k++){

				Document parser = Jsoup.parse(input, "UTF-8");
				letter = parser.toString();

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
