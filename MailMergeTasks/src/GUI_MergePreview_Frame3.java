import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JEditorPane;

@SuppressWarnings("serial")
public class GUI_MergePreview_Frame3 extends JFrame {

	private JPanel contentPane;		
	// for design purposes

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_MergePreview_Frame3 frame = new GUI_MergePreview_Frame3();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_MergePreview_Frame3() {
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
				GUI_SendConfirmation_Frame4 SendConfirmation = new GUI_SendConfirmation_Frame4();
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
		contentPane.add(previewPane);
		
		// ************************** POPULATE RECIPIENT NAMES HERE ******************************
		DefaultListModel<String> recipientListNames = new DefaultListModel<String>();
		
		recipientListNames.addElement("Apple, Red");
		recipientListNames.addElement("Banana, Yellow");
		recipientListNames.addElement("Berry, Blue");
		recipientListNames.addElement("Kiwi, Green");
		recipientListNames.addElement("Peach, Pink");
		
		JList<String> recipientList = new JList<String>();
		recipientList.setFont(new Font("Tahoma", Font.PLAIN, 18));
		recipientList.setBounds(628, 224, 240, 623);
		contentPane.add(recipientList);
		
		recipientList.setModel(recipientListNames);
		
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
}