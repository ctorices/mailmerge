
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ParseHTML {

	public static void main(String [] args){
		
		File input = new File("Internet2 Tempe Lodging Confirmation Email.html");
		try {
			Document doc = Jsoup.parse(input, "UTF-8");
			String letter = doc.toString();

			letter = letter.replace("firstName", "Amanda");
			letter = letter.replace("lastName", "McCarty");

			String outputFile = "filename.html";
			BufferedWriter htmlWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile)));
			htmlWriter.write(letter);

			htmlWriter.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
