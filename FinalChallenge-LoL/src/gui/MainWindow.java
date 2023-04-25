package gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JCalendar;

import controller.UserControllable;
import model.Administrator;
import model.Player;
import model.User;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.GridLayout;
import java.awt.FlowLayout;

public class MainWindow extends JFrame {


	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldNickname;
	private JTextField textFieldEmail;
	JComboBox comboBoxNationality = new JComboBox();
	JButton btnDelete = new JButton("DELETE");
	JButton btnModify = new JButton("MODIFY ");
	UserControllable controlador;
	private JTextField textFieldPhone;
	JCalendar jCalendar = new JCalendar();
	JCalendar jCalendarStartDate = new JCalendar();
	User user;
	private JTextField textFieldPassword;
	private String nicknameOriginal;
	private JTextField textFieldAdditions;
	JPanel panelAdmin = new JPanel();
	JLabel nickname = new JLabel("NICKNAME");
	SignIn signin = new SignIn(controlador);

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 * 
	 * @param user
	 * @param controlador
	 */
	public MainWindow(UserControllable controlador, User user) {
		this.controlador = controlador;
		this.user = user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 17));
		tabbedPane.setBounds(0, 0, 1196, 656);
		contentPane.add(tabbedPane);

		JPanel profile = new JPanel();
		profile.setBackground(new Color(240, 230, 140));
		tabbedPane.addTab("PROFILE\r\n", null, profile, null);
		profile.setLayout(null);

		panelAdmin = new JPanel();
		panelAdmin.setBounds(625, 10, 556, 609);
		panelAdmin.setBackground(new Color(255, 255, 255));
		profile.add(panelAdmin);
		panelAdmin.setLayout(null);

		JLabel lblAdministratorArea = new JLabel("ADMINISTRATOR AREA");
		lblAdministratorArea.setBounds(156, 29, 249, 26);
		lblAdministratorArea.setFont(new Font("Bahnschrift", Font.BOLD, 21));
		panelAdmin.add(lblAdministratorArea);

		JLabel startDate = new JLabel("START DATE");
		startDate.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		startDate.setBounds(48, 231, 132, 21);
		panelAdmin.add(startDate);

		jCalendarStartDate = new JCalendar();
		jCalendarStartDate.setBounds(177, 150, 199, 152);
		panelAdmin.add(jCalendarStartDate);

		JLabel additions = new JLabel("ADDITIONS");
		additions.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		additions.setBounds(48, 415, 92, 21);
		panelAdmin.add(additions);

		textFieldAdditions = new JTextField();
		textFieldAdditions.setBounds(177, 416, 199, 19);
		panelAdmin.add(textFieldAdditions);
		textFieldAdditions.setColumns(10);

		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(16, 10, 599, 609);
		panelInfo.setLayout(null);
		panelInfo.setBorder(null);
		panelInfo.setBackground(new Color(255, 255, 255));
		profile.add(panelInfo);

		JLabel password = new JLabel("PASSWORD");
		password.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		password.setBounds(65, 232, 95, 21);
		panelInfo.add(password);

		JLabel lblEmail = new JLabel("NAME");
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblEmail.setBounds(65, 159, 49, 21);
		panelInfo.add(lblEmail);

		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		email.setBounds(65, 289, 51, 21);
		panelInfo.add(email);

		textFieldName = new JTextField();
		textFieldName.setToolTipText("");
		textFieldName.setColumns(10);
		textFieldName.setBounds(215, 160, 199, 19);
		panelInfo.add(textFieldName);

		JLabel birthdate = new JLabel("BIRTHDATE");
		birthdate.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		birthdate.setBounds(65, 372, 92, 21);
		panelInfo.add(birthdate);

		JLabel lblNacionality = new JLabel("NATIONALITY");
		lblNacionality.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblNacionality.setBounds(65, 557, 110, 21);
		panelInfo.add(lblNacionality);

		nickname = new JLabel("NICKNAME");
		nickname.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		nickname.setBounds(65, 96, 88, 21);
		panelInfo.add(nickname);

		textFieldNickname = new JTextField();
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(215, 97, 199, 19);
		panelInfo.add(textFieldNickname);

		textFieldEmail = new JTextField();
		textFieldEmail.setToolTipText("");
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(215, 290, 199, 19);
		panelInfo.add(textFieldEmail);

		JLabel lblPersonalData = new JLabel("PERSONAL DATA");
		lblPersonalData.setFont(new Font("Bahnschrift", Font.BOLD, 21));
		lblPersonalData.setBounds(192, 37, 206, 26);
		panelInfo.add(lblPersonalData);

		btnModify = new JButton("MODIFY ");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnModify.setBackground(new Color(64, 224, 208));
		btnModify.setBounds(468, 116, 92, 67);
		panelInfo.add(btnModify);
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModify.addActionListener(this);

		btnDelete = new JButton("DELETE");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDelete.setBackground(new Color(64, 224, 208));
		btnDelete.setBounds(468, 289, 95, 67);
		panelInfo.add(btnDelete);
		btnDelete.addActionListener(this);

		comboBoxNationality = new JComboBox();
		comboBoxNationality.setModel(new DefaultComboBoxModel(new String[] { "Afghan", "Albanian", "Algerian",
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
		comboBoxNationality.setBounds(215, 557, 199, 21);
		panelInfo.add(comboBoxNationality);

		jCalendar = new JCalendar();
		jCalendar.setBounds(215, 331, 199, 152);
		panelInfo.add(jCalendar);

		JLabel phone = new JLabel("PHONE");
		phone.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		phone.setBounds(65, 504, 92, 21);
		panelInfo.add(phone);

		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(215, 505, 199, 19);
		panelInfo.add(textFieldPhone);
		textFieldPhone.setColumns(10);

		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(215, 233, 199, 19);
		panelInfo.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(255, 105, 180));
		lblNewLabel.setBounds(0, 0, 1201, 629);
		profile.add(lblNewLabel);

		JPanel champsPlayer = new JPanel();
		tabbedPane.addTab("CHAMPS", null, champsPlayer, null);

		JPanel champAdmin = new JPanel();
		tabbedPane.addTab("CHAMPS", null, champAdmin, null);

		JPanel game = new JPanel();
		tabbedPane.addTab("GAME", null, game, null);

		JPanel stadistics = new JPanel();
		tabbedPane.addTab("STADISTICS", null, stadistics, null);

		JPanel management = new JPanel();
		tabbedPane.addTab("MANAGEMENT", null, management, null);
		
		//Load the tab profile with the information for the database
		loadData(controlador, user);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnModify)) {
			modifyPlayer(controlador);
		}

		if (e.getSource().equals(btnDelete)) {
			deletePlayer(controlador);
		}
	}

	// Create the user with the information writen in the profile tab
	public User loadUser() {
		user.setName(textFieldName.getText());
		user.setNationality((String) comboBoxNationality.getSelectedItem());
		user.setEmail(textFieldEmail.getText());
		user.setPassword(textFieldPassword.getText());
		user.setPhone(textFieldPhone.getText());
		LocalDate date = jCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		user.setBirthDate(date);
		if (user instanceof Player) {
			((Player) user).setNickname(textFieldName.getText());
		} else {
			textFieldNickname.setVisible(false);
			LocalDate dateStart = jCalendarStartDate.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			((Administrator) user).setStartDate(dateStart);
			((Administrator) user).setAddtions(Integer.parseInt(textFieldAdditions.getText()));

		}

		return user;

	}

	// Load the data from the user for the profile tab
	public void loadData(UserControllable controller, User user) {
		textFieldName.setText(user.getName());
		textFieldEmail.setText(user.getEmail());
		jCalendar.setDate(Date.valueOf(user.getBirthDate()));
		textFieldPassword.setText(user.getPassword());
		textFieldPhone.setText(user.getPhone());
		comboBoxNationality.setSelectedItem(user.getNationality());

		if (user instanceof Player) {

			// We save the original nickname so that if the user changes his nickname the
			// query will be done with the original nickname.
			nicknameOriginal = ((Player) user).getNickname();
			// Panel with the admin information isn't visible
			panelAdmin.setVisible(false);
			textFieldNickname.setText(((Player) user).getNickname());

		} else {
			textFieldNickname.setVisible(false);
			btnDelete.setVisible(false);
			nickname.setVisible(false);
			// Change the btnModify location to panelAdmin
			panelAdmin.add(btnModify);
			btnModify.setBounds(249, 483, 92, 67);
			textFieldAdditions.setText(String.valueOf(((Administrator) user).getAddtions()));
			jCalendarStartDate.setDate(Date.valueOf(((Administrator) user).getStartDate()));
		}
	}

	// Clear method to set all the fields with no information.
	public void clear() {

		JCalendar.setDefaultLocale(getLocale());
		textFieldEmail.setText("");
		textFieldName.setText("");
		textFieldPassword.setText("");
		textFieldNickname.setText("");
		textFieldPhone.setText("");
		comboBoxNationality.setSelectedIndex(-1);
	}

	public void focusGained(FocusEvent e) {

	}

	public void modifyPlayer(UserControllable controlador) {
		boolean correct = false;
		// If the user is instance as player we use the original nickname saved before
		if (user instanceof Player) {
			user = controlador.findUser(nicknameOriginal);
		} else {
			user = controlador.findUser(user.getId());
		}
		//ADD CHECKEO
		User user = loadUser();

		correct = controlador.modifyUser(user);
		if (correct) {
			JOptionPane.showMessageDialog(this, "PERSONAL DATA MODIFIED");
		} else {
			JOptionPane.showMessageDialog(this, "NO MODIFICATION");
		}

	}

	// Method to delete Player
	public void deletePlayer(UserControllable controller) {
		boolean correct = false;
		int aceptar;
		User user = null;
		// Find the user
		user = controller.findUser(textFieldNickname.getText());
		// Show a confirmation dialog
		aceptar = JOptionPane.showConfirmDialog(this, "WARNING: do you want to delete your account?");
		// Yes --> 0 so If the user accepts the message, his account will be deleted.
		if (aceptar == 0) {
			controller.delete(user);
			clear();
		}

	}
}
