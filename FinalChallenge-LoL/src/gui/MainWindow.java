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
import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
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
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;
import com.toedter.calendar.JCalendar;
import javax.swing.ImageIcon;

public class MainWindow extends JFrame implements ActionListener, MouseListener {
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

		JPanel management = new JPanel();
		tabbedPane.addTab("MANAGEMENT", null, management, null);
		
		//Load the tab profile with the information for the database
		loadData(userControllable);

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