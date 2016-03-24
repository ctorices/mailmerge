
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseHTML {

	public static void main(String [] args){
		
		File input = new File("Internet2 Tempe Lodging Confirmation Email.html");
		
		try {
			Document doc = Jsoup.parse(input, "UTF-8");
			String letter = doc.toString();
			
			
			ParseExcel parseExcel = new ParseExcel();
			ArrayList<ArrayList<String>> data = parseExcel.parseExcelData();
			//String [] selectedPlaceholders;
			String email = "pizza.com";		
			
			for(int i = 0; i < data.size(); i++){
				for (int j = 0; j < data.get(i).size(); j++){
					
				}
			}

			LetterEmailPair letterEmailPair = new LetterEmailPair(letter,email);
			Stack theStack = new Stack();
			
			theStack.push(letterEmailPair);
			
			System.out.println(theStack.toString());
			

			String outputFile = "filename.html";
			BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
			htmlWriter.write(letter);

			htmlWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
