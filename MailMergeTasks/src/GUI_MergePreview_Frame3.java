package mail;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.JList;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class GUI_MergePreview_Frame3 extends JFrame {

	private JPanel contentPane;	
	private Stack emailAndLetterStack;
	private int emailIndex;
	private String email;
       
	// for design purposes
               
	public Stack getEmailAndLetterStack() {
		return emailAndLetterStack;
	}

	public void setEmailAndLetterStack(Stack emailAndLetterStack) {
		this.emailAndLetterStack = emailAndLetterStack;
	}

	public static void main(String[] args) {
            String emailPath = "";
            String docPath = "";
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MergePreview_Frame3 frame = new GUI_MergePreview_Frame3(emailPath, docPath, Transport.class.newInstance(), Session.class.newInstance());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_MergePreview_Frame3(String excel, String doc, Transport transport, Session session) {
                System.out.println(excel + "\n"+ doc);
		//****************Create stack from doc file with emails and letters*******//
		ParseHTML htmlParse = new ParseHTML(excel);
		setEmailAndLetterStack(htmlParse.getEmailLetterStack(excel, doc));


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 1056, 950);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// EagleMerge logo top right
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/EagleMergeThumbnail.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(711, 16, 308, 53);
		contentPane.add(label);
                
		// go to Sent confirmation page
		JButton btnNewButton = new JButton("Confirm >>");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				setBounds(450, 50, 1056, 700);
				contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
				setContentPane(contentPane);
				contentPane.setLayout(null);
				GUI_SendConfirmation_Frame4 SendConfirmation = new GUI_SendConfirmation_Frame4(transport,emailAndLetterStack, session);
				SendConfirmation.setVisible(true);
			}
		});
		btnNewButton.setBounds(883, 554, 136, 35);
		contentPane.add(btnNewButton);

		JLabel lblCopyright = new JLabel("Copyright \u00A9 2016 Eastern Michigan Unversity");
		lblCopyright.setBounds(388, 874, 340, 20);
		contentPane.add(lblCopyright);

		JLabel lblRecipientList = new JLabel("Recipient List");
		lblRecipientList.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRecipientList.setBounds(690, 188, 156, 20);
		contentPane.add(lblRecipientList);

		JLabel lblNewLabel = new JLabel("Preview");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(292, 188, 156, 20);
		contentPane.add(lblNewLabel);

		// ************************* PREVIEW PANE *********************
		// preview pane set up using an Editor Pane (editable)
		JEditorPane previewPane = new JEditorPane();
		previewPane.setBounds(30, 224, 585, 623);
		previewPane.setContentType("text/html");
		previewPane.setEditable(false);

		HTMLEditorKit kit = new HTMLEditorKit();
		previewPane.setEditorKit(kit);

		// ************************** POPULATE RECIPIENT NAMES HERE ******************************
		DefaultListModel<String> recipientListNames = new DefaultListModel<String>();

		//Add emails to recipient list
		for (int i = 0; i < emailAndLetterStack.size(); i++)
			recipientListNames.addElement(emailAndLetterStack.getEmail(i));


		JList<String> recipientList = new JList<String>();
		recipientList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		recipientList.setBounds(628, 224, 240, 623);
		contentPane.add(recipientList);

		recipientList.setModel(recipientListNames);
		recipientList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				emailIndex = recipientList.getSelectedIndex();
				displayLetter(previewPane);
			}

		});

		JLabel lblNewLabel_1 = new JLabel("Select recipient from list to preview document and confirm merge.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(251, 106, 631, 20);
		contentPane.add(lblNewLabel_1);

		JLabel three = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/three.png")).getImage();
		three.setIcon(new ImageIcon(img3));
		three.setBounds(130, 61, 125, 111);
		contentPane.add(three);

		JLabel four = new JLabel("");
		Image img4 = new ImageIcon(this.getClass().getResource("/four.png")).getImage();
		four.setIcon(new ImageIcon(img4));
		four.setBounds(922, 483, 80, 61);
		contentPane.add(four);

	}
	
	public void displayLetter(JEditorPane pane)
	{
		email = emailAndLetterStack.getLetter(emailIndex);
		pane.setText(email);
		contentPane.add(pane);
	}
}