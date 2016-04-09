package mail;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.core.FileURIResolver;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DocxToHtml {
	
	
	public DocxToHtml(){};

	public File DocxToHtml(String doc) {
		
		InputStream in;
		File htmlFile = new File("converted.html");
		try {
		
			in = new FileInputStream(new File(doc));
			XWPFDocument document = new XWPFDocument(in);
			
			XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

			
			
			OutputStream out = new FileOutputStream(htmlFile);
			XHTMLConverter.getInstance().convert(document, out, options);
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return htmlFile;

	}

}
