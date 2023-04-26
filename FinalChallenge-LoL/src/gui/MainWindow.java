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
	private JTextField textFieldNameProfile;
	private JTextField textFieldNicknameProfile;
	private JTextField textFieldEmailProfile;
	private JComboBox comboBoxNationalityProfile;
	private JButton btnDeleteProfile;
	private JButton btnModifyProfile;
	private JTextField textFieldPhoneProfile;
	private JCalendar jCalendarProfile;
	private JCalendar jCalendarStartDateProfile;
	private JTextField textFieldPasswordProfile;
	private String nicknameOriginal;
	private JTextField textFieldAdditionsProfile;
	private JLabel nicknameProfile;

	public MainWindow2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1196, 656);
		contentPane.add(tabbedPane);

		JPanel profile = new JPanel();
		profile.setBackground(new Color(240, 230, 140));
		tabbedPane.addTab("PROFILE\r\n", null, profile, null);
		profile.setLayout(null);

		JPanel panelAdmin = new JPanel();
		panelAdmin.setBounds(625, 10, 556, 609);
		panelAdmin.setBackground(new Color(255, 255, 255));
		profile.add(panelAdmin);
		panelAdmin.setLayout(null);

		JLabel lblAdministratorAreaProfile = new JLabel("ADMINISTRATOR AREA");
		lblAdministratorAreaProfile.setBounds(156, 29, 249, 26);
		lblAdministratorAreaProfile.setFont(new Font("Bahnschrift", Font.BOLD, 21));
		panelAdmin.add(lblAdministratorAreaProfile);

		JLabel startDateProfile = new JLabel("START DATE");
		startDateProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		startDateProfile.setBounds(48, 231, 132, 21);
		panelAdmin.add(startDateProfile);

		jCalendarStartDateProfile = new JCalendar();
		jCalendarStartDateProfile.setBounds(177, 150, 199, 152);
		panelAdmin.add(jCalendarStartDateProfile);

		JLabel additionsProfile = new JLabel("ADDITIONS");
		additionsProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		additionsProfile.setBounds(48, 415, 92, 21);
		panelAdmin.add(additionsProfile);

		textFieldAdditionsProfile = new JTextField();
		textFieldAdditionsProfile.setBounds(177, 416, 199, 19);
		panelAdmin.add(textFieldAdditionsProfile);
		textFieldAdditionsProfile.setColumns(10);

		JPanel panelInfo = new JPanel();
		panelInfo.setBounds(16, 10, 599, 609);
		panelInfo.setLayout(null);
		panelInfo.setBorder(null);
		panelInfo.setBackground(new Color(255, 255, 255));
		profile.add(panelInfo);

		JLabel passwordProfile = new JLabel("PASSWORD");
		passwordProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		passwordProfile.setBounds(65, 232, 95, 21);
		panelInfo.add(passwordProfile);

		JLabel lblEmailProfile = new JLabel("NAME");
		lblEmailProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblEmailProfile.setBounds(65, 159, 49, 21);
		panelInfo.add(lblEmailProfile);

		JLabel emailProfile = new JLabel("EMAIL");
		emailProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		emailProfile.setBounds(65, 289, 51, 21);
		panelInfo.add(emailProfile);

		textFieldNameProfile = new JTextField();
		textFieldNameProfile.setToolTipText("");
		textFieldNameProfile.setColumns(10);
		textFieldNameProfile.setBounds(215, 160, 199, 19);
		panelInfo.add(textFieldNameProfile);

		JLabel birthdateProfile = new JLabel("BIRTHDATE");
		birthdateProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		birthdateProfile.setBounds(65, 372, 92, 21);
		panelInfo.add(birthdateProfile);

		JLabel lblNacionalityProfile = new JLabel("NATIONALITY");
		lblNacionalityProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblNacionalityProfile.setBounds(65, 557, 110, 21);
		panelInfo.add(lblNacionalityProfile);

		nicknameProfile = new JLabel("NICKNAME");
		nicknameProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		nicknameProfile.setBounds(65, 96, 88, 21);
		panelInfo.add(nicknameProfile);

		textFieldNicknameProfile = new JTextField();
		textFieldNicknameProfile.setColumns(10);
		textFieldNicknameProfile.setBounds(215, 97, 199, 19);
		panelInfo.add(textFieldNicknameProfile);

		textFieldEmailProfile = new JTextField();
		textFieldEmailProfile.setToolTipText("");
		textFieldEmailProfile.setColumns(10);
		textFieldEmailProfile.setBounds(215, 290, 199, 19);
		panelInfo.add(textFieldEmailProfile);

		JLabel lblPersonalDataProfile = new JLabel("PERSONAL DATA");
		lblPersonalDataProfile.setFont(new Font("Bahnschrift", Font.BOLD, 21));
		lblPersonalDataProfile.setBounds(192, 37, 206, 26);
		panelInfo.add(lblPersonalDataProfile);

		btnModifyProfile = new JButton("MODIFY ");
	;
		btnModifyProfile.setBackground(new Color(64, 224, 208));
		btnModifyProfile.setBounds(468, 116, 92, 67);
		panelInfo.add(btnModifyProfile);
		btnModifyProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnModifyProfile.addActionListener(this);

		btnDeleteProfile = new JButton("DELETE");
		btnDeleteProfile.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDeleteProfile.setBackground(new Color(64, 224, 208));
		btnDeleteProfile.setBounds(468, 289, 95, 67);
		panelInfo.add(btnDeleteProfile);
		btnDeleteProfile.addActionListener(this);

		comboBoxNationalityProfile = new JComboBox();
		comboBoxNationalityProfile.setModel(new DefaultComboBoxModel(new String[] { "Afghan", "Albanian", "Algerian",
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
		comboBoxNationalityProfile.setBounds(215, 557, 199, 21);
		panelInfo.add(comboBoxNationalityProfile);

		jCalendarProfile = new JCalendar();
		jCalendarProfile.setBounds(215, 331, 199, 152);
		panelInfo.add(jCalendarProfile);

		JLabel phoneProfile = new JLabel("PHONE");
		phoneProfile.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		phoneProfile.setBounds(65, 504, 92, 21);
		panelInfo.add(phoneProfile);

		textFieldPhoneProfile = new JTextField();
		textFieldPhoneProfile.setBounds(215, 505, 199, 19);
		panelInfo.add(textFieldPhoneProfile);
		textFieldPhoneProfile.setColumns(10);

		textFieldPasswordProfile = new JTextField();
		textFieldPasswordProfile.setBounds(215, 233, 199, 19);
		panelInfo.add(textFieldPasswordProfile);
		textFieldPasswordProfile.setColumns(10);
		
		JLabel lblNewLabelProfile = new JLabel("");
		lblNewLabelProfile.setBackground(new Color(255, 105, 180));
		lblNewLabelProfile.setBounds(0, 0, 1201, 629);
		profile.add(lblNewLabelProfile);

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
		loadData(userControllable);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(btnModifyProfile)) {
			modifyPlayer(userControllable);
		}

		if (e.getSource().equals(btnDeleteProfile)) {
			deletePlayer(userControllable);
		}
	}

	// Create the user with the information writen in the profile tab
	public User loadUser() {
		user.setName(textFieldNameProfile.getText());
		user.setNationality((String) comboBoxNationalityProfile.getSelectedItem());
		user.setEmail(textFieldEmailProfile.getText());
		user.setPassword(textFieldPasswordProfile.getText());
		user.setPhone(textFieldPhoneProfile.getText());
		LocalDate date = jCalendarProfile.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		user.setBirthDate(date);
		if (user instanceof Player) {
			((Player) user).setNickname(textFieldNameProfile.getText());
		} else {
			textFieldNicknameProfile.setVisible(false);
			LocalDate dateStart = jCalendarStartDateProfile.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			((Administrator) user).setStartDate(dateStart);
			((Administrator) user).setAddtions(Integer.parseInt(textFieldAdditionsProfile.getText()));

		}

		return user;

	}

	// Load the data from the user for the profile tab
	public void loadData(UserControllable userControllable) {
		textFieldNameProfile.setText(user.getName());
		textFieldEmailProfile.setText(user.getEmail());
		jCalendarProfile.setDate(Date.valueOf(user.getBirthDate()));
		textFieldPasswordProfile.setText(user.getPassword());
		textFieldPhoneProfile.setText(user.getPhone());
		comboBoxNationalityProfile.setSelectedItem(user.getNationality());

		if (user instanceof Player) {

			// We save the original nickname so that if the user changes his nickname the
			// query will be done with the original nickname.
			nicknameOriginal = ((Player) user).getNickname();
			// Panel with the admin information isn't visible
			panelAdmin.setVisible(false);
			textFieldNicknameProfile.setText(((Player) user).getNickname());

		} else {
			textFieldNicknameProfile.setVisible(false);
			btnDeleteProfile.setVisible(false);
			nicknameProfile.setVisible(false);
			// Change the btnModify location to panelAdmin
			panelAdmin.add(btnModifyProfile);
			btnModifyProfile.setBounds(249, 483, 92, 67);
			textFieldAdditionsProfile.setText(String.valueOf(((Administrator) user).getAddtions()));
			jCalendarStartDateProfile.setDate(Date.valueOf(((Administrator) user).getStartDate()));
		}
	}

	// Clear method to set all the fields with no information.
	public void clear() {

		jCalendarProfile.setDefaultLocale(getLocale());
		textFieldEmailProfile.setText("");
		textFieldNameProfile.setText("");
		textFieldPasswordProfile.setText("");
		textFieldNicknameProfile.setText("");
		textFieldPhoneProfile.setText("");
		comboBoxNationalityProfile.setSelectedIndex(-1);
	}

	public void focusGained(FocusEvent e) {

	}

	public void modifyPlayer(UserControllable userControllable) {
		boolean correct = false;
		// If the user is instance as player we use the original nickname saved before
		if (user instanceof Player) {
			user = userControllable.findUser(nicknameOriginal);
		} else {
			user = userControllable.findUser(user.getId());
		}
		//ADD CHECKEO
		User user = loadUser();

		correct = userControllable.modifyUser(user);
		if (correct) {
			JOptionPane.showMessageDialog(this, "PERSONAL DATA MODIFIED");
		} else {
			JOptionPane.showMessageDialog(this, "NO MODIFICATION");
		}

	}

	// Method to delete Player
	public void deletePlayer(UserControllable userControllable) {
		boolean correct = false;
		int aceptar;
		User user = null;
		// Find the user
		user = userControllable.findUser(textFieldNicknameProfile.getText());
		// Show a confirmation dialog
		aceptar = JOptionPane.showConfirmDialog(this, "WARNING: do you want to delete your account?");
		// Yes --> 0 so If the user accepts the message, his account will be deleted.
		if (aceptar == 0) {
			correct= userControllable.delete(user);
			clear();
		}
		if (correct) {
			JOptionPane.showMessageDialog(this, "USER DELETE");
		} else {
			JOptionPane.showMessageDialog(this, "USER NO DELETE");
		}

	}
}
