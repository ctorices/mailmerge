
//Imported libraries
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;


public class PreviewHTML {

	 public PreviewHTML()
	  {
	    SwingUtilities.invokeLater(new Runnable()
	    {
	      public void run()
	      {
	        // create jeditorpane
	        JEditorPane jEditorPane = new JEditorPane();
	        
	        // make it read-only
	        jEditorPane.setEditable(false);
	        
	        // create a scrollpane; modify its attributes as desired
	        JScrollPane scrollPane = new JScrollPane(jEditorPane);
	        
	        // add an html editor kit
	        HTMLEditorKit kit = new HTMLEditorKit();
	        jEditorPane.setEditorKit(kit);
	        
	        // create a document, set it on the jeditorpane, then add the html
	        Document doc = kit.createDefaultDocument();
	        jEditorPane.setDocument(doc);
	        File file = new File("Internet2 Tempe Lodging Confirmation Email.html");
	        try {
				jEditorPane.setPage(file.toURI().toURL());
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	        // now add it all to a frame
	        JFrame j = new JFrame("Document Preview");
	        j.getContentPane().add(scrollPane, BorderLayout.CENTER);

	        // make it easy to close the application
	        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        // display the frame
	        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	        screenSize.setSize(screenSize.getWidth(), screenSize.getHeight());
	        j.setSize(screenSize);
	        
	        // center the jframe, then make it visible
	        j.setLocationRelativeTo(null);
	        j.setVisible(true);
	      }
	    });
	  }
	 
	//To test methods
	public static void main(String[] args) {
		new PreviewHTML();
	}
}
