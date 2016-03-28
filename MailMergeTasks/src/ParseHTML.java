
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
			
			String letter = "";
			String email = "";

			ParseExcel parseExcel = new ParseExcel();
			ArrayList<ArrayList<String>> data = parseExcel.parseExcelData();
			Stack theStack = new Stack();	

			int i = 0;
			for (int k = 1; k < data.size(); k++){

				Document doc = Jsoup.parse(input, "UTF-8");
				letter = doc.toString();

				for (int j = 0; j < data.get(k).size(); j++){
					if (data.get(i).get(j).equalsIgnoreCase("email")){
						email = data.get(k).get(j);
					}
					letter = letter.replace(data.get(i).get(j), data.get(k).get(j));
				}
				
				LetterEmailPair letterEmailPair = new LetterEmailPair(letter,email);
				theStack.push(letterEmailPair);
			}

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
