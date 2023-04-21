package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserControllable;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Color;

public class Login extends JDialog implements ActionListener, MouseListener {
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField username_1;
	private JLabel signIn, acceder;
	private User user;
	private UserControllable controller;
	private MainWindow parent;

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
	public Login(UserControllable control, User userReceived, MainWindow main) {
		controller = control;
		user = userReceived;
		parent = main;
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"C:\\Users\\Aussar\\eclipse-workspace1\\pruebaVentanas\\Resources\\LoL_icon.svg (1) (1).png"));
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

		acceder = new JLabel("");
		acceder.addMouseListener(this);

		signIn = new JLabel("SIGN IN");
		signIn.addMouseListener(this);

		signIn.setBounds(174, 293, 85, 28);
		panel.add(signIn);
		signIn.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		signIn.setForeground(Color.BLACK);
		acceder.setBounds(126, 337, 55, 50);
		panel.add(acceder);
		acceder.setIcon(new ImageIcon(Login.class.getResource("/img/salir.png")));
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

		JLabel lblLogo = new JLabel("");
		lblLogo.addMouseListener(new MouseAdapter() {

		});
		lblLogo.setIcon(new ImageIcon(Login.class.getResource("/img/lolLogo (2).png")));
		lblLogo.setBounds(126, 25, 64, 64);
		PanelTransparente.add(lblLogo);

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setBounds(43, 191, 178, 41);
		PanelTransparente.add(lblPassword);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Bahnschrift", Font.BOLD, 17));

		passwordField = new JPasswordField();
		passwordField.setBounds(43, 243, 203, 20);
		PanelTransparente.add(passwordField);
		passwordField.addActionListener(this);

		username_1 = new JTextField();
		username_1.setBounds(43, 144, 203, 20);
		PanelTransparente.add(username_1);
		username_1.setColumns(10);

		JLabel lblNoAccount = new JLabel("No account?");
		lblNoAccount.setForeground(Color.BLACK);
		lblNoAccount.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		lblNoAccount.setBounds(54, 298, 92, 17);
		PanelTransparente.add(lblNoAccount);
		username_1.addActionListener(this);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(Login.class.getResource("/img/fondo.jpg")));
		lblFondo.setBounds(-57, -38, 759, 435);
		panel.add(lblFondo);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(signIn)) {
			// SignIn dialogSign = new SignIn();
			// dialogSign.setVisible(true);
			this.dispose();
		}
		if (e.getSource().equals(acceder)) {
			char[] pass = passwordField.getPassword();
			String passString = new String(pass);
			if (!username_1.getText().isBlank() && passString != null) {
				if (controller.logIn(username_1.getText(), passString)) {
					parent.setVisible(true);
					this.dispose();
				}

				else {
					JOptionPane.showMessageDialog(this, "Usuario o clave de acceso erronea.");
				}

			} else {
				JOptionPane.showMessageDialog(this, "ERROR. Rellene todos los campos.");
			}
			
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(signIn)) {
			signIn.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(signIn)) {
			signIn.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		}
	}
}
