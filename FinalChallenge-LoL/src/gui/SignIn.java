package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import com.toedter.calendar.JDayChooser;

import controller.UserControllable;
import exceptions.PersonalizedException;
import inputControl.InputControl;

import com.toedter.calendar.JCalendar;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JComboBox;
import javax.lang.model.util.ElementScanner14;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.ZoneId;

import model.User;
import model.Administrator;
import model.Player;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SignIn extends JDialog implements ActionListener, FocusListener, MouseListener {
	/**
	 * @author Irati Garzón
	 * @version 1.1 27/04/2023
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNickname;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JComboBox nationalityComboBox = new JComboBox();
	private JTextField textFieldPhone;
	private JCalendar jCalendar = new JCalendar();
	private UserControllable controller;
	private InputControl control = new InputControl();
	private MainWindow parent;
	private JPasswordField passwordField;
	private JLabel lblSend;
	private JLabel lblEye;

	public SignIn(UserControllable controller, MainWindow main) {
		this.controller = controller;
		parent = main;
		setIconImage(Toolkit.getDefaultToolkit().getImage(SignIn.class.getResource("/icon/LoL_icon.svg.png")));
		setModalityType(ModalityType.APPLICATION_MODAL);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 996, 718);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JPanel firstPanel = new JPanel();
		firstPanel.setBounds(0, 0, 982, 677);
		contentPanel.add(firstPanel);
		firstPanel.setLayout(null);

		JPanel secondPanel = new JPanel();
		secondPanel.setBackground(Color.WHITE);
		secondPanel.setBounds(208, 10, 495, 657);
		firstPanel.add(secondPanel);
		secondPanel.setLayout(null);

		lblEye = new JLabel("");
		lblEye.setIcon(new ImageIcon(SignIn.class.getResource("/img/pass_eye_25_17.jpg")));
		lblEye.setBounds(460, 193, 25, 21);
		secondPanel.add(lblEye);
		lblEye.addMouseListener(this);

		JLabel iconLol = new JLabel("");
		iconLol.setIcon(new ImageIcon(SignIn.class.getResource("/img/lolLogo (2).png")));
		iconLol.setBounds(206, 10, 71, 72);
		secondPanel.add(iconLol);

		JLabel SignIn = new JLabel("SIGN IN");
		SignIn.setForeground(Color.RED);
		SignIn.setFont(new Font("Bahnschrift", Font.BOLD, 40));
		SignIn.setBounds(155, 92, 172, 55);
		secondPanel.add(SignIn);

		JLabel nickname = new JLabel("NICKNAME");
		nickname.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		nickname.setBounds(50, 146, 114, 21);
		secondPanel.add(nickname);

		textFieldNickname = new JTextField();
		textFieldNickname.setBounds(245, 147, 212, 19);
		secondPanel.add(textFieldNickname);
		textFieldNickname.setColumns(10);
		textFieldNickname.addFocusListener(this);

		JLabel password = new JLabel("PASSWORD");
		password.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		password.setBounds(50, 193, 114, 21);
		secondPanel.add(password);

		JLabel lblEmail = new JLabel("NAME");
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblEmail.setBounds(50, 245, 114, 21);
		secondPanel.add(lblEmail);

		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		nameTextField.setBounds(245, 246, 212, 19);
		secondPanel.add(nameTextField);
		nameTextField.addFocusListener(this);

		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		email.setBounds(50, 293, 114, 21);
		secondPanel.add(email);

		emailTextField = new JTextField();
		emailTextField.setToolTipText("");
		emailTextField.setColumns(10);
		emailTextField.setBounds(245, 294, 212, 19);
		secondPanel.add(emailTextField);
		emailTextField.addFocusListener(this);

		JLabel birthdate = new JLabel("BIRTHDATE");
		birthdate.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		birthdate.setBounds(50, 401, 114, 21);
		secondPanel.add(birthdate);

		JLabel lblNacionality = new JLabel("NATIONALITY");
		lblNacionality.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblNacionality.setBounds(50, 550, 114, 21);
		secondPanel.add(lblNacionality);

		lblSend = new JLabel("");

		lblSend.setIcon(new ImageIcon(SignIn.class.getResource("/img/salir.png")));
		lblSend.setBounds(206, 602, 63, 45);
		secondPanel.add(lblSend);
		lblSend.addMouseListener(this);

		JCalendar calendar = new JCalendar();
		calendar.setBounds(245, 335, 212, 152);
		jCalendar.setSize(212, 152);
		jCalendar.setLocation(245, 330);
		secondPanel.add(jCalendar);

		nationalityComboBox = new JComboBox();
		nationalityComboBox.setModel(new DefaultComboBoxModel(new String[] { "Afghan", "Albanian", "Algerian",
				"American", "Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian",
				"Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana",
				"Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian",
				"British", "Bruneian", "Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian",
				"Canadian", "Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran",
				"Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican",
				"Dutch", "East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean",
				"Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian",
				"German", "Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese",
				"Haitian", "Herzegovinian", "Honduran", "Hungarian", "I-Kiribati", "Icelander", "Indian", "Indonesian",
				"Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian",
				"Kazakhstani", "Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese",
				"Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy",
				"Malawian", "Malaysian", "Maldivian", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian",
				"Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana",
				"Mozambican", "Namibian", "Nauruan", "Nepalese", "New Zealander", "Ni-Vanuatu", "Nicaraguan",
				"Nigerian", "Nigerien", "North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan",
				"Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari",
				"Romanian", "Russian", "Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean",
				"Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean",
				"Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish",
				"Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik",
				"Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish",
				"Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh",
				"Yemenite", "Zambian", "Zimbabwean" }));
		nationalityComboBox.setBounds(245, 550, 212, 21);
		secondPanel.add(nationalityComboBox);
		nationalityComboBox.setSelectedIndex(-1);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblPhone.setBounds(50, 499, 114, 21);
		secondPanel.add(lblPhone);

		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(245, 500, 212, 19);
		secondPanel.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		textFieldPhone.addFocusListener(this);

		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setBounds(244, 193, 212, 19);
		secondPanel.add(passwordField);
		passwordField.addMouseListener(this);

		JLabel Fondo = new JLabel("");
		Fondo.setBounds(0, 0, 1112, 677);
		firstPanel.add(Fondo);
		Fondo.setIcon(new ImageIcon(SignIn.class.getResource("/img/2021_Key_art (1).jpg")));

	}

	/**
	 * Method to add the new user and open the next window
	 * 
	 * @throws PersonalizedException
	 */
	public void openMainWindow() throws PersonalizedException {
		// TODO Auto-generated method stub
		int chooseConnection;
		// Pass from date to localDate
		LocalDate date = jCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String password = new String(passwordField.getPassword());
		// Check if all the fields have been filled.
		if (textFieldNickname.getText().isBlank() || password.isBlank() || textFieldPhone.getText().isBlank()
				|| nameTextField.getText().isBlank() || emailTextField.getText().isBlank() || date == LocalDate.now()
				|| nationalityComboBox.getSelectedIndex() == -1) {
			JOptionPane.showMessageDialog(null, "You have to fill all the fields", "League of legends",
					JOptionPane.ERROR_MESSAGE);
		} else {
			User user = setInformation();
			//if user is instace of player
			if (user instanceof Player)
				chooseConnection = 2;
			else 
				chooseConnection = 0;
			controller.addUser(user, chooseConnection);
			JOptionPane.showMessageDialog(null, "CORRECTO", "League of legends", JOptionPane.INFORMATION_MESSAGE);
			// OPEN MAIN WINDOW
		}
	}

	/**
	 * Method that creates the user with the information written by the user
	 * 
	 * @return User
	 */

	public User setInformation() {
		User user = new Player();
		String password = new String(passwordField.getPassword());
		user.setName(nameTextField.getText());
		user.setNationality((String) nationalityComboBox.getSelectedItem());
		user.setEmail(emailTextField.getText());
		user.setPassword(password);
		user.setPhone(textFieldPhone.getText());
		((Player) user).setNickname(textFieldNickname.getText());
		LocalDate date = jCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		user.setBirthDate(date);
		return user;
	}

	/**
	 * Method to make verifications when focusLost
	 */
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(textFieldNickname)) {
			try {
				checkUser();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(textFieldNickname)) {
			try {
				checkUser();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		if (e.getSource().equals(textFieldPhone)) {
			checkPhone();
		}

		if (e.getSource().equals(nameTextField)) {
			checkName();
		}

		if (e.getSource().equals(emailTextField)) {
			checkEmail();
		}
	}

	/**
	 * Method to check if the user exist and check that the user only inserts one
	 * word as nickname
	 * 
	 * @throws PersonalizedException
	 */
	private void checkUser() throws PersonalizedException {
		// TODO Auto-generated method stub
		// Check that the inserted nickname doesn't exists
		User userComprobar = null;
		userComprobar = controller.findUser(textFieldNickname.getText(), 1);

		if (userComprobar != null) {
			JOptionPane.showMessageDialog(this, "Nickname already exists", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldNickname.setText("");
		}
		if (!control.validateNickname(textFieldNickname.getText())) {
			JOptionPane.showMessageDialog(this, "Nickname can only consist of a single word", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldNickname.setText("");
		}
	}

	/**
	 * Method to validate that the text inserted in the email textField is correct
	 */
	public void checkEmail() {
			if (!control.validateEmail(emailTextField.getText()) && !emailTextField.getText().isBlank()) {
				JOptionPane.showMessageDialog(this, "Email format incorrect. Example: ____@____.com", "League of legends",
						JOptionPane.ERROR_MESSAGE);
				emailTextField.setText("");
			}
		}


	/**
	 * Method to validate that the text inserted by the user is a string
	 */
	public void checkName() {
		if (!control.validateString(nameTextField.getText()) && !nameTextField.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "This field can't contain numbers", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			nameTextField.setText("");
		}
	}

	/**
	 * Method to validate that the phone only consists of 9 numbers
	 */
	public void checkPhone() {
		if (textFieldPhone.getText().length()!= 9 ||control.validateInteger(textFieldPhone.getText()) && !textFieldPhone.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "The telephone must have a lenght of 9 numbers", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldPhone.setText("");
		}
	}

	/**
	 * Method implemented by FocusListener but not used
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// not used

	}

	/**
	 * Method implemented by ActionPerformed but not used
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// not used

	}

	/**
	 * Method to make a action when mouseClicked
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource().equals(lblSend)) {
			try {
				openMainWindow();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	/**
	 * Method to make a action during mousePressed
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(lblEye)) {
			passwordField.setEchoChar((char) 0);
		}

	}

	/**
	 * Method to make a action when mouseReleased
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource().equals(lblEye)) {
			passwordField.setEchoChar('*');
		}

	}

	/**
	 * Method implemented by MouseListener but not used
	 */

	@Override
	public void mouseEntered(MouseEvent e) {
		// not used

	}

	/**
	 * Method implemented by MouseListener but not used
	 */

	@Override
	public void mouseExited(MouseEvent e) {
		// not used

	}
}
