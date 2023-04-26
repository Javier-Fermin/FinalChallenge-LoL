package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserControllable;
import model.Administrator;
import model.Player;
import model.User;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;
import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame implements ActionListener, MouseListener {

	private JPanel contentPane;
	private JTextField Nickname_TextField;
	private JTextField Email_textField;
	private JTextField textField_1;
	private JTextField Phone_textField;
	private JTextField Password_textField;
	private JTextField Nacionality_textField;
	private JTextField StartDate_textField;
	private JTextField Additions_textField;
	private JTextField textFieldNameAddAdmin;
	private JTextField textFieldMailAddAdmin;
	private JTextField textFieldPhoneAddAdmin;
	private JPasswordField passwordFieldAddAdmin;
	private JComboBox comboBoxAddAdmin;
	private JButton btnSendAddAdmin;
	private JButton btnDeletePlayer;
	private JTextArea textAreaDeletePlayer;
	private JCalendar calendarAddAdmin;
	private JLabel lblPassEyeAddAdmin;

	private User user, userDel;
	private JComboBox comboBoxSelectUser;
	private UserControllable controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainWindow(UserControllable control/* , User userReceived, MainWindow main */) {
		controller = control;
		Login login = new Login(control, this);
		login.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setMaximumSize(getMaximumSize());
		contentPane.setMinimumSize(getMinimumSize());

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setMaximumSize(getMaximumSize());
		tabbedPane.setMinimumSize(getMinimumSize());
		contentPane.add(tabbedPane);

		JPanel profile = new JPanel();
		tabbedPane.addTab("PROFILE\r\n", null, profile, null);
		profile.setLayout(null);

		JLabel Nickname = new JLabel("NICKNAME");
		Nickname.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Nickname.setBounds(64, 96, 108, 28);
		profile.add(Nickname);

		Nickname_TextField = new JTextField();
		Nickname_TextField.setBounds(64, 134, 191, 19);
		profile.add(Nickname_TextField);
		Nickname_TextField.setColumns(10);

		JLabel Email = new JLabel("EMAIL");
		Email.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Email.setBounds(64, 244, 108, 28);
		profile.add(Email);

		Email_textField = new JTextField();
		Email_textField.setColumns(10);
		Email_textField.setBounds(64, 271, 191, 19);
		profile.add(Email_textField);

		JLabel Birthdate_textField = new JLabel("");
		Birthdate_textField.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Birthdate_textField.setBounds(64, 342, 108, 28);
		profile.add(Birthdate_textField);

		JLabel Birthdate = new JLabel("BIRTHDATE");
		Birthdate.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Birthdate.setBounds(64, 314, 108, 28);
		profile.add(Birthdate);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(64, 352, 191, 19);
		profile.add(textField_1);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblPhone.setBounds(64, 399, 108, 28);
		profile.add(lblPhone);

		Phone_textField = new JTextField();
		Phone_textField.setColumns(10);
		Phone_textField.setBounds(64, 437, 191, 19);
		profile.add(Phone_textField);

		JLabel Password = new JLabel("PASSWORD");
		Password.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Password.setBounds(64, 174, 108, 28);
		profile.add(Password);

		Password_textField = new JTextField();
		Password_textField.setColumns(10);
		Password_textField.setBounds(64, 212, 191, 19);
		profile.add(Password_textField);

		JLabel Nacionality = new JLabel("NACIONALITY");
		Nacionality.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Nacionality.setBounds(64, 490, 156, 28);
		profile.add(Nacionality);

		Nacionality_textField = new JTextField();
		Nacionality_textField.setColumns(10);
		Nacionality_textField.setBounds(64, 528, 191, 19);
		profile.add(Nacionality_textField);

		JLabel StartDate = new JLabel("START DATE");
		StartDate.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		StartDate.setBounds(494, 174, 108, 28);
		profile.add(StartDate);

		StartDate_textField = new JTextField();
		StartDate_textField.setColumns(10);
		StartDate_textField.setBounds(493, 212, 191, 19);
		profile.add(StartDate_textField);

		JLabel Additions = new JLabel("ADDITIONS");
		Additions.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		Additions.setBounds(494, 274, 108, 28);
		profile.add(Additions);

		Additions_textField = new JTextField();
		Additions_textField.setColumns(10);
		Additions_textField.setBounds(494, 319, 191, 19);
		profile.add(Additions_textField);

		JPanel champsPlayer = new JPanel();
		tabbedPane.addTab("CHAMPS", null, champsPlayer, null);

		JPanel champAdmin = new JPanel();
		tabbedPane.addTab("CHAMPS", null, champAdmin, null);

		JPanel game = new JPanel();
		tabbedPane.addTab("GAME", null, game, null);

		JPanel stadistics = new JPanel();
		tabbedPane.addTab("STADISTICS", null, stadistics, null);
		stadistics.setLayout(null);

		JPanel management = new JPanel();
		management.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.addTab("MANAGEMENT", null, management, null);
		management.setLayout(new GridLayout(0, 2, 0, 0));

		JPanel addAdmin = new JPanel();
		addAdmin.setForeground(new Color(255, 255, 255));
		addAdmin.setBackground(new Color(255, 255, 255));
		addAdmin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		management.add(addAdmin);

		JLabel lblNameAddAdmin = new JLabel("NAME");
		lblNameAddAdmin.setForeground(new Color(0, 0, 0));
		lblNameAddAdmin.setBounds(54, 137, 56, 19);
		lblNameAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 17));

		btnSendAddAdmin = new JButton("SEND");
		btnSendAddAdmin.setBounds(258, 584, 80, 27);
		btnSendAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnSendAddAdmin.addActionListener(this);

		textFieldNameAddAdmin = new JTextField();
		textFieldNameAddAdmin.setBounds(341, 137, 199, 25);
		textFieldNameAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldNameAddAdmin.setColumns(10);

		JLabel lblPasswordAddAdmin = new JLabel("PASSWORD");
		lblPasswordAddAdmin.setForeground(new Color(0, 0, 0));
		lblPasswordAddAdmin.setBounds(54, 177, 91, 19);
		lblPasswordAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 17));

		JLabel lblMailAddAdmin = new JLabel("MAIL");
		lblMailAddAdmin.setForeground(new Color(0, 0, 0));
		lblMailAddAdmin.setBounds(54, 220, 45, 19);
		lblMailAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 17));

		textFieldMailAddAdmin = new JTextField();
		textFieldMailAddAdmin.setBounds(341, 220, 199, 25);
		textFieldMailAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldMailAddAdmin.setColumns(10);

		JLabel lblBDateAddAdmin = new JLabel("BIRTH DATE");
		lblBDateAddAdmin.setForeground(new Color(0, 0, 0));
		lblBDateAddAdmin.setBounds(54, 344, 98, 19);
		lblBDateAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 17));

		JLabel lblPhoneAdmin = new JLabel("PHONE");
		lblPhoneAdmin.setForeground(new Color(0, 0, 0));
		lblPhoneAdmin.setBounds(54, 451, 56, 19);
		lblPhoneAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 17));

		textFieldPhoneAddAdmin = new JTextField();
		textFieldPhoneAddAdmin.setBounds(341, 448, 199, 25);
		textFieldPhoneAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldPhoneAddAdmin.setColumns(10);

		JLabel lblNationalityAddAdmin = new JLabel("NATIONALITY");
		lblNationalityAddAdmin.setForeground(new Color(0, 0, 0));
		lblNationalityAddAdmin.setBounds(54, 494, 108, 19);
		lblNationalityAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 17));

		comboBoxAddAdmin = new JComboBox();
		comboBoxAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		comboBoxAddAdmin.setBounds(341, 495, 199, 25);
		comboBoxAddAdmin.setModel(new DefaultComboBoxModel(new String[] { "Afghan", "Albanian", "Algerian", "American",
				"Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian", "Azerbaijani",
				"Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian",
				"Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian", "British", "Bruneian",
				"Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian",
				"Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese",
				"Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican",
				"Dominican", "Dutch", "Dutchman", "Dutchwoman", "East Timorese", "Ecuadorean", "Egyptian", "Emirian",
				"Equatorial Guinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French",
				"Gabonese", "Gambian", "Georgian", "German", "Ghanaian", "Greek", "Grenadian", "Guatemalan",
				"Guinea-Bissauan", "Guinean", "Guyanese", "Haitian", "Herzegovinian", "Honduran", "Hungarian",
				"I-Kiribati", "Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Irish", "Israeli",
				"Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani", "Kenyan",
				"Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan",
				"Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy", "Malawian", "Malaysian",
				"Maldivan", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican", "Micronesian",
				"Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian",
				"Nauruan", "Nepalese", "Netherlander", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerian",
				"Nigerien", "North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan",
				"Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari",
				"Romanian", "Russian", "Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean",
				"Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean",
				"Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish",
				"Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik",
				"Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish",
				"Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh",
				"Welsh", "Yemenite", "Zambian", "Zimbabwean" }));
		comboBoxAddAdmin.setSelectedIndex(-1);
		addAdmin.setLayout(null);
		
		lblPassEyeAddAdmin = new JLabel("");
		lblPassEyeAddAdmin.addMouseListener(this);
		lblPassEyeAddAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassEyeAddAdmin.setVerticalAlignment(SwingConstants.TOP);
		lblPassEyeAddAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassEyeAddAdmin.setIcon(new ImageIcon(MainWindow.class.getResource("/img/pass_eye_25_17.jpg")));
		lblPassEyeAddAdmin.setBounds(546, 180, 31, 22);
		addAdmin.add(lblPassEyeAddAdmin);
		addAdmin.add(lblMailAddAdmin);
		addAdmin.add(textFieldMailAddAdmin);
		addAdmin.add(lblBDateAddAdmin);
		addAdmin.add(lblNationalityAddAdmin);
		addAdmin.add(lblPhoneAdmin);
		addAdmin.add(comboBoxAddAdmin);
		addAdmin.add(textFieldPhoneAddAdmin);
		addAdmin.add(lblPasswordAddAdmin);
		addAdmin.add(lblNameAddAdmin);
		addAdmin.add(textFieldNameAddAdmin);
		addAdmin.add(btnSendAddAdmin);
		
				passwordFieldAddAdmin = new JPasswordField();
				passwordFieldAddAdmin.setEchoChar('·');
				passwordFieldAddAdmin.setBounds(341, 177, 199, 25);
				passwordFieldAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
				addAdmin.add(passwordFieldAddAdmin);
		
		JLabel lblAddAdminTitle = new JLabel("ADD AMINISTRATOR");
		lblAddAdminTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAdminTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblAddAdminTitle.setBounds(197, 25, 193, 25);
		addAdmin.add(lblAddAdminTitle);
		
		calendarAddAdmin = new JCalendar();
		calendarAddAdmin.setBounds(341, 265, 198, 153);
		addAdmin.add(calendarAddAdmin);

		JPanel playerDelete = new JPanel();
		playerDelete.setBackground(new Color(255, 255, 255));
		playerDelete.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		management.add(playerDelete);

		btnDeletePlayer = new JButton("DELETE");
		btnDeletePlayer.setBounds(246, 584, 95, 27);
		btnDeletePlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnDeletePlayer.addActionListener(this);

		JLabel lblSelectUser = new JLabel("SELECT A USER");
		lblSelectUser.setForeground(new Color(0, 0, 0));
		lblSelectUser.setBounds(232, 137, 122, 19);
		lblSelectUser.setFont(new Font("Bahnschrift", Font.PLAIN, 17));

		comboBoxSelectUser = new JComboBox();
		comboBoxSelectUser.setBounds(193, 214, 201, 27);
		comboBoxSelectUser.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textAreaDeletePlayer = new JTextArea();
		textAreaDeletePlayer.setForeground(new Color(0, 0, 0));
		textAreaDeletePlayer.setBackground(new Color(255, 255, 255));
		textAreaDeletePlayer.setBounds(132, 207, 328, 316);
		textAreaDeletePlayer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textAreaDeletePlayer.setEditable(false);
		textAreaDeletePlayer.setVisible(false);
		playerDelete.setLayout(null);
		playerDelete.add(lblSelectUser);
		playerDelete.add(comboBoxSelectUser);
		playerDelete.add(textAreaDeletePlayer);
		playerDelete.add(btnDeletePlayer);
		
		JLabel lblDeletePlayerTitle = new JLabel("DELETE PLAYERS");
		lblDeletePlayerTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeletePlayerTitle.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblDeletePlayerTitle.setBounds(197, 27, 193, 25);
		playerDelete.add(lblDeletePlayerTitle);

		cargarUsers(control);

		if (user instanceof Player) {
			tabbedPane.remove(champAdmin);
			tabbedPane.remove(management);
		}
		if (user instanceof Administrator) {
			tabbedPane.remove(champsPlayer);
			tabbedPane.remove(game);
			tabbedPane.remove(stadistics);
		}
	}

	private void cargarUsers(UserControllable control) {
		Set<User> users = control.listPlayers();

		for (User u : users) {
			if (comboBoxSelectUser.getItemAt(0) != (u.getId() + " " + u.getName())) {
				comboBoxSelectUser.addItem(((Player) u).getNickname());
			}
			comboBoxSelectUser.setSelectedIndex(-1);
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btnSendAddAdmin)) {
			char[] pass = passwordFieldAddAdmin.getPassword();
			String passString = new String(pass);
			if (!textFieldNameAddAdmin.getText().isBlank() && passString != null && !textFieldMailAddAdmin.getText().isBlank()
					&& !textFieldPhoneAddAdmin.getText().isBlank() && comboBoxAddAdmin.getSelectedIndex() > -1) {
				user = new Administrator();
				user.setName(textFieldNameAddAdmin.getText());
				user.setPassword(passString);
				user.setEmail(textFieldMailAddAdmin.getText());
				LocalDate date = calendarAddAdmin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				user.setBirthDate(date);
				user.setBirthDate(LocalDate.now());
				user.setPhone(textFieldPhoneAddAdmin.getText());
				user.setNationality(comboBoxAddAdmin.getSelectedItem().toString());
				controller.addUser(user);

				JOptionPane.showMessageDialog(getParent(), "Enviado correctamente.");
				textFieldNameAddAdmin.setText("");
				passwordFieldAddAdmin.setText("");
				textFieldMailAddAdmin.setText("");
				textFieldPhoneAddAdmin.setText("");
				comboBoxAddAdmin.setSelectedIndex(-1);
				calendarAddAdmin.setDate(Date.valueOf(LocalDate.now()));

			} else {
				JOptionPane.showMessageDialog(this, "ERROR. Rellene todos los campos.");
			}
		}
		if (e.getSource().equals(btnDeletePlayer)) {
			int option;
			if (comboBoxSelectUser.getSelectedIndex() != -1) {
				userDel = controller.findUser(comboBoxSelectUser.getSelectedItem().toString());
				textAreaDeletePlayer.append("ID: " + userDel.getId() + "\nNickname: " + ((Player) userDel).getNickname() + "\nName: " + userDel.getName() + "\nEmail: " + userDel.getEmail() + "\n");
				textAreaDeletePlayer.setVisible(true);
				option = JOptionPane.showConfirmDialog(this, "Quiere borrar a " + userDel.getName() + "?");
				if (option == 0) {
					controller.delete(userDel);
					JOptionPane.showMessageDialog(this, userDel.getName() + " eliminado correctamente.");
					comboBoxSelectUser.setSelectedIndex(-1);
					textAreaDeletePlayer.setText("");
					textAreaDeletePlayer.setVisible(false);
				}
				if (option == 1) {
					comboBoxSelectUser.setSelectedIndex(-1);
					textAreaDeletePlayer.setText("");
					textAreaDeletePlayer.setVisible(false);
				}
				if (option == 2) {
					comboBoxSelectUser.setSelectedIndex(-1);
					textAreaDeletePlayer.setText("");
					textAreaDeletePlayer.setVisible(false);
				}
			} else {
				JOptionPane.showMessageDialog(this,
						"ERROR. Rellene todos los campos.");
				comboBoxSelectUser.setSelectedIndex(-1);
				textAreaDeletePlayer.setText("");
				textAreaDeletePlayer.setVisible(false);
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// Not used.
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(e.getSource().equals(lblPassEyeAddAdmin)) {
			passwordFieldAddAdmin.setEchoChar((char) 0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(e.getSource().equals(lblPassEyeAddAdmin)) {
			passwordFieldAddAdmin.setEchoChar('·');
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Not used.
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Not used.
	}
}