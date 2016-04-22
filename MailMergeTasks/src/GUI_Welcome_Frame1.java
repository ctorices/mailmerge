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
