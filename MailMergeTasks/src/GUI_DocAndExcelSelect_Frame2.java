import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

@SuppressWarnings("serial")
public class GUI_DocAndExcelSelect_Frame2 extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_DocAndExcelSelect_Frame2 frame = new GUI_DocAndExcelSelect_Frame2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public GUI_DocAndExcelSelect_Frame2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 50, 1056, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		// document file path text
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setBounds(358, 197, 577, 32);
		contentPane.add(textArea);
		
		// Browse for document template button
		JButton documentButton = new JButton("Browse");
		documentButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		documentButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == documentButton){
		            final JFileChooser jFileChooser = new JFileChooser();
		            int returnVal = jFileChooser.showOpenDialog(documentButton);
		            if(returnVal == JFileChooser.APPROVE_OPTION){
		                File file = jFileChooser.getSelectedFile();
		                textArea.setText("Selected: " + file.getName());
		            }else if(returnVal == JFileChooser.CANCEL_OPTION){
		                textArea.setText("Cancelled");
		            }else if(returnVal == JFileChooser.ERROR_OPTION){
		                textArea.setText("Error!");
		            }else{
		                textArea.setText("unknown...");
		            }
		        }
			}
		});
		
		documentButton.setBounds(207, 196, 136, 32);
		contentPane.add(documentButton);
		
		// Select document template text
		JLabel lblPleaseSelectYour = new JLabel("Please select your document template:");
		lblPleaseSelectYour.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseSelectYour.setBounds(207, 150, 408, 20);
		contentPane.add(lblPleaseSelectYour);
		
		// EagleMerge logo top right
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/EagleMergeThumbnail.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(711, 16, 308, 53);
		contentPane.add(label);
		
		// Step 1 image
		JLabel label_1 = new JLabel("");
		Image one = new ImageIcon(this.getClass().getResource("/one.png")).getImage();
		label_1.setIcon(new ImageIcon(one));
		label_1.setBounds(68, 128, 109, 125);
		contentPane.add(label_1);
		
		// Step 2 image
		JLabel label_2 = new JLabel("");
		Image two = new ImageIcon(this.getClass().getResource("/two.png")).getImage();
		label_2.setIcon(new ImageIcon(two));
		label_2.setBounds(68, 345, 109, 111);
		contentPane.add(label_2);
		
		// Select excel sheet text
		JLabel lblPleaseSelectYour_1 = new JLabel("Please select your spreadsheet:");
		lblPleaseSelectYour_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPleaseSelectYour_1.setBounds(207, 350, 408, 20);
		contentPane.add(lblPleaseSelectYour_1);
		
		// excel sheet file path text
		JTextArea textArea_sheet = new JTextArea();
		textArea_sheet.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea_sheet.setBounds(358, 402, 577, 32);
		contentPane.add(textArea_sheet);
		
		// Browse for excel sheet button
		JButton sheetButton = new JButton("Browse");
		sheetButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		sheetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(e.getSource() == sheetButton){
		            final JFileChooser jFileChooser = new JFileChooser();
		            int returnVal = jFileChooser.showOpenDialog(sheetButton);
		            if(returnVal == JFileChooser.APPROVE_OPTION){
		                File file = jFileChooser.getSelectedFile();
		                textArea_sheet.setText("Selected file: " + file.getName());
		            }else if(returnVal == JFileChooser.CANCEL_OPTION){
		                textArea_sheet.setText("Cancelled");
		            }else if(returnVal == JFileChooser.ERROR_OPTION){
		                textArea_sheet.setText("Error!");
		            }else{
		                textArea_sheet.setText("unknown...");
		            }
		        }

			}
		});
		
		sheetButton.setBounds(207, 401, 136, 32);
		contentPane.add(sheetButton);
		
		// go to Merge confirmation page
		JButton btnNewButton = new JButton("Merge!");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				contentPane.setVisible(false);
				GUI_MergePreview_Frame3 MergeConfirmation = new GUI_MergePreview_Frame3();
				MergeConfirmation.setVisible(true);
			}
		});
		btnNewButton.setBounds(467, 531, 115, 29);
		contentPane.add(btnNewButton);
		
		JLabel lblCopyright = new JLabel("Copyright \u00A9 2016 Eastern Michigan Unversity");
		lblCopyright.setBounds(392, 624, 340, 20);
		contentPane.add(lblCopyright);
	}
}