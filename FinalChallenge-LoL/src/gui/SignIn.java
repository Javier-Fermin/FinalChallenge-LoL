package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SignIn extends JDialog {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignIn dialog = new SignIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignIn() {
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 933, 689);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 919, 652);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(222, 24, 498, 605);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel iconLol = new JLabel("");
		iconLol.setIcon(new ImageIcon("C:\\Users\\irati\\Desktop\\DAM\\pruebaVentanas\\pruebaVentanas\\Resources\\LoL_icon.svg (1) (2).png"));
		iconLol.setBounds(206, 28, 71, 72);
		panel_1.add(iconLol);
		
		JLabel SignIn = new JLabel("SIGN IN");
		SignIn.setForeground(Color.RED);
		SignIn.setFont(new Font("Bahnschrift", Font.BOLD, 47));
		SignIn.setBounds(155, 120, 172, 45);
		panel_1.add(SignIn);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\irati\\Desktop\\DAM\\pruebaVentanas\\pruebaVentanas\\Resources\\2021_Key_art (1).jpg"));
		lblNewLabel.setBounds(-130, 0, 1060, 671);
		panel.add(lblNewLabel);
	}

}
