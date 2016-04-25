//package mail;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GUI_SendConfirmation_Frame4 extends JFrame {

	private JPanel contentPane;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JLabel lblPleaseEnterYour;
	private JButton loginButton;
	private JLabel lblPassword;
	private JLabel lblEmail;
	private Stack letters;
	private Session session;
	private Transport transport;
	static GUI_SendConfirmation_Frame4 frame;
        private Properties props = serverSettings("smtp.gmail.com", "465");
        private JButton serverSettings;
        private JButton loginWindow;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI_SendConfirmation_Frame4();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_SendConfirmation_Frame4() {

		letters = GUI_DocAndExcelSelect_Frame2.parseHTML.getEmailLetterStack();
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

		loginField();

		passwordField();

		loginButton();

                serverSettingsButton();
	}

	public void sendEmailsButton() {
		JButton btnNewButton = new JButton("Send");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					while(!letters.isEmpty()){

						MimeMessage message = new MimeMessage(session);
						//System.out.println(message.getFrom().toString());
						//Set From
						message.setFrom(new InternetAddress(transport.getURLName().getUsername()));

						//Set reply to 
						message.setReplyTo(new javax.mail.Address[] {
								new javax.mail.internet.InternetAddress(transport.getURLName().getUsername())
						});

						//Send to
						message.addRecipient(Message.RecipientType.TO, new InternetAddress(letters.peek().getEmail()));

						//Subject
						message.setSubject("Mail Merge Test");

						//Set the HTML message
						message.setContent(letters.peek().getLetter(), "text/html" );


						//Send message
						message.saveChanges();
						transport.sendMessage(message, message.getAllRecipients());
						System.out.println("Sent message successfully....");

						letters.pop();
					}

					transport.close();
				} catch (MessagingException mex) {
					mex.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnNewButton.setBounds(445, 337, 115, 29);
		contentPane.add(btnNewButton);
		contentPane.remove(emailField);
		contentPane.remove(passwordField);
		contentPane.remove(lblPleaseEnterYour);
		contentPane.remove(loginButton);
		contentPane.remove(lblEmail);
		contentPane.remove(lblPassword);
                contentPane.remove(serverSettings);
		contentPane.revalidate(); 
		contentPane.repaint();

	}

	private void loginField() {

		lblPleaseEnterYour = new JLabel("Please enter your login credentials");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseEnterYour.setBounds(387, 376, 327, 20);
		getContentPane().add(lblPleaseEnterYour);

		lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(358, 441, 69, 20);
		getContentPane().add(lblEmail);
		
                emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setBounds(455, 440, 299, 26);
		//**********************************************************
                Action action = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				authLogin();
			}
		};
		emailField.addActionListener(action);
                //**********************************************************
                getContentPane().add(emailField);
		emailField.setColumns(10);

	}

	private void passwordField() {
		lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(323, 483, 117, 20);
		getContentPane().add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(455, 482, 299, 26);
		//**********************************************************
                Action action = new AbstractAction()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				authLogin();
			}
		};
		passwordField.addActionListener(action);
		//**********************************************************
                getContentPane().add(passwordField);
	}
        
        private void serverGoBackButton() {
            loginWindow = new JButton("Login");
            loginWindow.setFont(new Font("Verdana", Font.PLAIN, 18));
	    loginWindow.setBounds(455, 576, 166, 29);
	    getContentPane().add(loginWindow);
            
            loginWindow.addActionListener((ActionEvent arg0) -> {
                contentPane.remove(loginWindow);
                serverTransitionAdd();
                    //String newHost = JOptionPane.showInputDialog("Enter Host: <Defualt is \"smtp.gmail.com\">", "smtp.gmail.com");
                    //String newPort = JOptionPane.showInputDialog("Enter Port: <Defualt is \"465\">", "465");
                    //this.props = serverSettings(newHost, newPort);
                    //authLogin();
		});
        }
        
        private void serverSettingsButton() {
		serverSettings = new JButton("Server");
		
		serverSettings.setFont(new Font("Verdana", Font.PLAIN, 18));
		serverSettings.setBounds(455, 576, 166, 29);
		getContentPane().add(serverSettings);

		serverSettings.addActionListener((ActionEvent arg0) -> {
                    String param1;
                    String param2;
                    Properties temp = new Properties();
                    param1 = JOptionPane.showInputDialog("Enter Server Paramater 1");
                    while(!param1.contentEquals("-1")){
                        param2 = JOptionPane.showInputDialog("Enter Server Paramater 2");
                        temp = serverSettingsInput(param1, param2, temp);
                        param1 = JOptionPane.showInputDialog("Enter Server Paramater 1");
                        
                    }
                    
                    //serverTransitionRemove();
                    //serverGoBackButton();
                    
                    
                    this.props = temp;
                    //authLogin();
		
                });
	}
	
        private void loginButton() {
		loginButton = new JButton("Login Screen");
		// ADD EMAIL VALIDATION!!!!!!!!!!!!!!! *************************
		loginButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		loginButton.setBounds(455, 536, 166, 29);
		getContentPane().add(loginButton);

		loginButton.addActionListener((ActionEvent arg0) -> {
			
                    authLogin();
                        
		});
	}
        
        private void serverTransitionRemove(){
                contentPane.remove(emailField);
		contentPane.remove(passwordField);
		contentPane.remove(lblPleaseEnterYour);
		contentPane.remove(loginButton);
		contentPane.remove(lblEmail);
		contentPane.remove(lblPassword);
                contentPane.remove(serverSettings);
		contentPane.revalidate(); 
		contentPane.repaint();    
        }
        
        private void serverTransitionAdd(){
                contentPane.add(emailField);
		contentPane.add(passwordField);
		contentPane.add(lblPleaseEnterYour);
		contentPane.add(loginButton);
		contentPane.add(lblEmail);
		contentPane.add(lblPassword);
                contentPane.add(serverSettings);
		contentPane.revalidate(); 
		contentPane.repaint();    
        }
        
        private Properties serverSettingsInput(String newHost, String newPort, Properties temp) {		
           
            temp.put(newHost, newPort);
            
            return temp;
        }
        
        private Properties serverSettings(String newHost, String newPort) {		
            
            String [] host = {"mail.smtp.host", newHost};
            String [] sockets = {"mail.smtp.socketFactory.port" , newPort };//Not the Cigerette
	    String [] sslSockets = {"mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"};
	    String [] smtpAuth = {"mail.smtp.auth", "true"};
	    String [] serverPort = {"mail.smtp.port", newPort};
            
            Properties temp = new Properties();
            
            //temp.setProperty("mail.transport.protocol", "smtp");
            //temp.setProperty("mail.host", "smtp.live.com");
            //temp.put("mail.smtp.starttls.enable", "true");
           
            temp.put(smtpAuth[0], smtpAuth[1]);
            temp.put(host[0], host[1]);
            temp.put(sockets[0], sockets[1]);
            temp.put(sslSockets[0], sslSockets[1]);
            temp.put(serverPort[0], serverPort[1]);
            
            //temp.put("mail.smtp.socketFactory.fallback", "false"); 
            
            return temp;
        }
	private void authLogin() {
		//get log in info

		String userName = emailField.getText();
		String temp = "";
		for(int i = 0; i < passwordField.getPassword().length; i++){
			temp += passwordField.getPassword()[i];
		}
		String pass = temp;


		//using googles SMTP server to send email's
		
                
		/*
                props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
                */
                //props.list(System.out);
		session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(userName, pass);
			}
		});

		boolean rightAuth = validateAuth();

		if (rightAuth)
			sendEmailsButton();
		else{
			frame.dispose();
			GUI_SendConfirmation_Frame4 frame = new GUI_SendConfirmation_Frame4();
			frame.setVisible(true);	
		}
	}

	public boolean validateAuth() {
		try{
			transport = session.getTransport();
			transport.connect();
			return true;
		}catch (MessagingException mex) {
			//mex.printStackTrace();
			//pop up ask again
			JOptionPane.showMessageDialog(contentPane, "Incorrect, please enter in log in credentials again");

			return false;
		}
	}
}
