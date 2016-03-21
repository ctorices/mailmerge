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

	public static void main(String [] args){
		
		InputStream in;
		try {
			// 1) Load DOCX into XWPFDocument
			in = new FileInputStream(new File("Internet2 Tempe Lodging Confirmation Email.docx"));
			XWPFDocument document = new XWPFDocument(in);

			// 2) Prepare XHTML options (here we set the IURIResolver to load images from a "word/media" folder)
			XHTMLOptions options = XHTMLOptions.create().URIResolver(new FileURIResolver(new File("word/media")));

			// 3) Convert XWPFDocument to XHTML
			OutputStream out = new FileOutputStream(new File("Internet2 Tempe Lodging Confirmation Email.html"));
			XHTMLConverter.getInstance().convert(document, out, options);	

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
