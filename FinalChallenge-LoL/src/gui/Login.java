package gui;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserControllable;
import exceptions.PersonalizedException;
import model.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

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
	/**
	 * 
	 */
	//Instance of necessary global variables
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JTextField username_1;
	private JLabel signIn, acceder;
	private User user;
	private UserControllable controller;
	private MainWindow parent;

	/**
	 * Create the dialog.
	 */
	public Login(UserControllable control, MainWindow main) {
		setModal(true);
		//Receive and keep as global for later use controller and main window information.
		controller = control;
		parent = main;
		// Necessary code for window GUI.
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
	// Not needed.
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//Enter when "sign in" button is pressed
		if (e.getSource().equals(signIn)) {
			// SignIn dialogSign = new SignIn(parent);
			// dialogSign.setVisible(true);
			this.dispose();
		}
		//Enter when log in button is pressed.
		if (e.getSource().equals(acceder)) {
			try {
				access();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void access() throws PersonalizedException {
		// TODO Auto-generated method stub
		// Store the password as a String to set the user later.
					char[] pass = passwordField.getPassword();
					String passString = new String(pass);
					// Checks if the fields for password and user are blank or not.
					if (!username_1.getText().isBlank() && passString != "") {
						// Checks the credentials are correct with DB.
						if (controller.logIn(username_1.getText(), passString)) {
							// Sets the data found to user and calls for parent, disposes of window when finished.
							parent.setUser(controller.findUser(username_1.getText()));
							parent.setVisible(true);
							this.dispose();
						}

						else {
							//If credentials are wrong, panel shown to indicate so.
							JOptionPane.showMessageDialog(this, "Usuario o clave de acceso erronea.");

						}
					} else {
						//If none of the fields are filled, shows error panel.
						JOptionPane.showMessageDialog(this, "ERROR. Rellene todos los campos.");
					}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Not needed.
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Not needed.
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		if (e.getSource().equals(signIn)) {
			// If mouse hovers over "signIn" label, the font increases.
			signIn.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (e.getSource().equals(signIn)) {
			// When mouse exists the "signIn" label area, font decreases back to original size.
			signIn.setFont(new Font("Bahnschrift", Font.BOLD, 13));
		}
	}
}
