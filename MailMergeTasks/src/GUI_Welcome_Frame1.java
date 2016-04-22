

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GUI_Welcome_Frame1 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Welcome_Frame1 window = new GUI_Welcome_Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private JFrame frame;
	private JTextField emailField;
	private JPasswordField passwordField;

	public GUI_Welcome_Frame1() {
		initialize();
	}

	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 18));
		frame.setBounds(450, 50, 1056, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lblLogin = new JLabel("Welcome!");
		lblLogin.setBounds(455, 16, 179, 63);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
		frame.getContentPane().add(lblLogin);

		// logo
		JLabel label_1 = new JLabel("");
		label_1.setBounds(210, 83, 630, 277);
		Image img = new ImageIcon(this.getClass().getResource("/resources/EagleMerge.png")).getImage();
		label_1.setIcon(new ImageIcon(img));
		frame.getContentPane().add(label_1);

		welcome();
	}

	private void welcome() {
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2016 Eastern Michigan Unversity");
		lblCopyright.setBounds(392, 624, 340, 20);
		frame.getContentPane().add(lblCopyright);

		JButton btnNewButton = new JButton("Start");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				nextFrame();
			}
		});
		btnNewButton.setBounds(392, 449, 290, 29);
		frame.getContentPane().add(btnNewButton);

		JLabel lblClickToGet = new JLabel("Click to get started!");
		lblClickToGet.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblClickToGet.setBounds(444, 401, 190, 20);
		frame.getContentPane().add(lblClickToGet);
	}



	private void nextFrame() {
		// currently just goes to next frame with no validation
		frame.dispose();
		//TEST
		GUI_DocAndExcelSelect_Frame2 DocAndExcelSelect = new GUI_DocAndExcelSelect_Frame2();
		DocAndExcelSelect.setVisible(true);
	}

}

/*
    private void authLogin() {
        String username = emailField.getText();
        String temp = "";

        for(int i = 0; i < passwordField.getPassword().length; i++){
            temp += passwordField.getPassword()[i];
        }
        String password = temp;


        //System.out.println(username + " " + password);
        Properties props = new Properties();
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {

            @Override

            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(username, password);

            }
        });
        try {

            session.setDebug(true);

            Transport transport = session.getTransport();
            transport.connect();
            System.out.println(transport.getURLName().getUsername());

            /**
            //Default MimeMessage object
            MimeMessage message = new MimeMessage(session);

            //Set From
            message.setFrom(new InternetAddress(username));


            //Send to
            message.addRecipient(Message.RecipientType.TO, new InternetAddress("amandamc727@gmail.com"));

            //Subject
            message.setSubject("Mail Merge Test");

            //Set the HTML message
            message.setText("This message was sent from Eagle Mail GUI :)");
            //Send message
            message.saveChanges();
            transport.sendMessage(message, message.getAllRecipients());
            System.out.println("Sent message successfully....");


            nextFrame(transport, session);

            //transport.close();

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

    private void loginButton() {
        JButton loginButton = new JButton("Login");
        // ADD EMAIL VALIDATION!!!!!!!!!!!!!!! *******************************
        loginButton.setFont(new Font("Verdana", Font.PLAIN, 18));
        loginButton.setBounds(455, 536, 166, 29);
        frame.getContentPane().add(loginButton);

        loginButton.addActionListener((ActionEvent arg0) -> {
            authLogin();
            //nextFrame();
        });
    }

    private void initialize() {

        frame = new JFrame();
        frame.setBounds(450, 50, 1056, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblLogin = new JLabel("Welcome!");
        lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 30));
        lblLogin.setBounds(455, 16, 179, 63);
        frame.getContentPane().add(lblLogin);

        // logo
        JLabel label_1 = new JLabel("");
        Image img = new ImageIcon(this.getClass().getResource("/resources/EagleMerge.png")).getImage();
        label_1.setIcon(new ImageIcon(img));
        label_1.setBounds(210, 83, 630, 277);
        frame.getContentPane().add(label_1);

        copyrightField();

        loginField();

        passwordField();

        loginButton();
    }

    private void copyrightField() {
        JLabel lblCopyright = new JLabel("Copyright \u00A9 2016 Eastern Michigan Unversity");
        lblCopyright.setBounds(392, 624, 340, 20);
        frame.getContentPane().add(lblCopyright);
    }

    private void loginField() {

        JLabel lblPleaseEnterYour = new JLabel("Please enter your login credentials");
        lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblPleaseEnterYour.setBounds(387, 376, 327, 20);
        frame.getContentPane().add(lblPleaseEnterYour);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmail.setBounds(358, 441, 69, 20);
        frame.getContentPane().add(lblEmail);
        emailField = new JTextField();
        emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        emailField.setBounds(455, 440, 299, 26);
        frame.getContentPane().add(emailField);
        emailField.setColumns(10);

    }

    private void passwordField() {
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(323, 483, 117, 20);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        passwordField.setBounds(455, 482, 299, 26);
        Action action = new AbstractAction()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                authLogin();
            }
        };
        passwordField.addActionListener(action);
        frame.getContentPane().add(passwordField);
    }

    private void nextFrame(Transport transport, Session session) {
        // currently just goes to next frame with no validation
        frame.dispose();
        GUI_DocAndExcelSelect_Frame2 DocAndExcelSelect = new GUI_DocAndExcelSelect_Frame2(transport, session);
        DocAndExcelSelect.setVisible(true);
    }
}
 */