
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GUI_SendConfirmation_Frame4 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_SendConfirmation_Frame4 frame = new GUI_SendConfirmation_Frame4(Transport.class.newInstance(), Stack.class.newInstance(), Session.class.newInstance());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_SendConfirmation_Frame4(Transport transport, Stack letter, Session session) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 1056, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// EagleMerge logo top right
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/resources/EagleMergeThumbnail.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(711, 16, 308, 53);
		contentPane.add(label);
		
		// go to Merge confirmation page
                
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
                            try {
                                while(!letter.isEmpty()){
                                
                                MimeMessage message = new MimeMessage(session);
                                //System.out.println(message.getFrom().toString());
				//Set From
				message.setFrom(new InternetAddress(transport.getURLName().getUsername()));
				
				//Set reply to 
				message.setReplyTo(new javax.mail.Address[] {
						new javax.mail.internet.InternetAddress(transport.getURLName().getUsername())
				});
	
				//Send to
				message.addRecipient(Message.RecipientType.TO, new InternetAddress(letter.peek().getEmail()));
				
				//Subject
				message.setSubject("Mail Merge Test");
	
				//Set the HTML message
				message.setContent(letter.peek().getLetter(), "text/html" );
	

				//Send message
				message.saveChanges();
				transport.sendMessage(message, message.getAllRecipients());
				System.out.println("Sent message successfully....");
				
				letter.pop();
                                }
			
                            transport.close();
                            }catch (MessagingException mex) {
			mex.printStackTrace();
		}
                            System.exit(0);
			}
		});
		btnNewButton.setBounds(445, 337, 115, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2016 Eastern Michigan Unversity");
		lblCopyright.setBounds(392, 624, 340, 20);
		contentPane.add(lblCopyright);
		
		JLabel letters = new JLabel("");
		Image imgLetters = new ImageIcon(this.getClass().getResource("/resources/letters.png")).getImage();
		letters.setIcon(new ImageIcon(imgLetters));
		letters.setBounds(55, 192, 308, 104);
		contentPane.add(letters);
		
		JLabel letters2 = new JLabel("");
		Image imgLetters2 = new ImageIcon(this.getClass().getResource("/resources/letters.png")).getImage();
		letters2.setIcon(new ImageIcon(imgLetters2));
		letters2.setBounds(684, 192, 308, 104);
		contentPane.add(letters2);
		
		JLabel lblSendMerge = new JLabel("Send mailmerge to # recipients");
		lblSendMerge.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSendMerge.setBounds(365, 224, 308, 53);
		contentPane.add(lblSendMerge);
		
		JLabel five = new JLabel("");
		Image img5 = new ImageIcon(this.getClass().getResource("/resources/five.png")).getImage();
		five.setIcon(new ImageIcon(img5));
		five.setBounds(455, 104, 115, 104);
		contentPane.add(five);
	}
}