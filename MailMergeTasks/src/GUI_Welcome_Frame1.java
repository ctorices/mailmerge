import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

//import apple.laf.JRSUIUtils.Images;

import javax.swing.JPasswordField;

public class GUI_Welcome_Frame1 {

	private JFrame frame;
	private JTextField emailField;
	private JPasswordField passwordField;

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

	public GUI_Welcome_Frame1() {
		initialize();
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
		
		JButton loginButton = new JButton("Login");
		// ADD EMAIL VALIDATION!!!!!!!!!!!!!!! *************************************************
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// currently just goes to next frame with no validation
				frame.dispose();
				GUI_DocAndExcelSelect_Frame2 DocAndExcelSelect = new GUI_DocAndExcelSelect_Frame2();
				DocAndExcelSelect.setVisible(true);
			}
		});
		loginButton.setFont(new Font("Verdana", Font.PLAIN, 18));
		loginButton.setBounds(455, 536, 166, 29);
		frame.getContentPane().add(loginButton);
		
		// logo
		JLabel label_1 = new JLabel("");
		ImageIcon img = new ImageIcon(Images.class.getResource("/resources/EagleMerge.png"));
		label_1.setIcon(img);
		label_1.setBounds(210, 83, 630, 277);
		frame.getContentPane().add(label_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(358, 441, 69, 20);
		frame.getContentPane().add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(323, 483, 117, 20);
		frame.getContentPane().add(lblPassword);
		
		emailField = new JTextField();
		emailField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		emailField.setBounds(455, 440, 299, 26);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2016 Eastern Michigan Unversity");
		lblCopyright.setBounds(392, 624, 340, 20);
		frame.getContentPane().add(lblCopyright);
		
		JLabel lblPleaseEnterYour = new JLabel("Please enter your login credentials");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPleaseEnterYour.setBounds(387, 376, 327, 20);
		frame.getContentPane().add(lblPleaseEnterYour);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		passwordField.setBounds(455, 482, 299, 26);
		frame.getContentPane().add(passwordField);
	}
}
