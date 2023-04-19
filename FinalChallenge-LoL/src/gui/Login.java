package gui;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class Login extends JDialog implements ActionListener {
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField Username_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Login dialog = new Login();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Aussar\\eclipse-workspace1\\pruebaVentanas\\Resources\\LoL_icon.svg (1) (1).png"));
		setResizable(false);
		setBounds(100, 100, 708, 431);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 255));
		panel.setBounds(0, 0, 692, 450);
		contentPanel.add(panel);
		panel.setLayout(null);

		JLabel Username = new JLabel("USERNAME");
		
		
		JLabel SALIR = new JLabel("");
		
		JLabel SignIn = new JLabel("SIGN IN");
		
		SignIn.setBounds(174, 293, 85, 28);
		panel.add(SignIn);
		SignIn.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		SignIn.setForeground(Color.BLACK);
		SALIR.setBounds(126, 337, 55, 50);
		panel.add(SALIR);
		SALIR.setIcon(new ImageIcon(Login.class.getResource("/img/salir.png")));
		Username.setForeground(new Color(0, 0, 0));
		Username.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Username.setBounds(43, 99, 178, 41);
		panel.add(Username);
		
		JPanel PanelTransparente = new JPanel();
		PanelTransparente.setBorder(null);
		PanelTransparente.setBackground(new Color(100, 149, 237, 200));
		PanelTransparente.setBounds(0, 0, 316, 398);
		panel.add(PanelTransparente);
		PanelTransparente.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			
		});
		lblNewLabel_1.setIcon(new ImageIcon(Login.class.getResource("/img/lolLogo (2).png")));
		lblNewLabel_1.setBounds(126, 25, 64, 64);
		PanelTransparente.add(lblNewLabel_1);
		
		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(43, 191, 178, 41);
		PanelTransparente.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(43, 243, 203, 20);
		PanelTransparente.add(passwordField);
		passwordField.addActionListener(this);
		
		Username_1 = new JTextField();
		Username_1.setBounds(43, 144, 203, 20);
		PanelTransparente.add(Username_1);
		Username_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("No account?");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblNewLabel_3.setBounds(54, 298, 92, 17);
		PanelTransparente.add(lblNewLabel_3);
		Username_1.addActionListener(this);
		
		
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/img/fondo.jpg")));
		lblFondo.setBounds(-57, -38, 759, 435);
		panel.add(lblFondo);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}
