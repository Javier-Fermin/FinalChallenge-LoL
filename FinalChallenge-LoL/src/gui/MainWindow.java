package gui;

import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JCalendar;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.*;
import exceptions.PersonalizedException;
import model.*;
import java.util.List;
import java.util.ArrayList;

import java.awt.Dialog.ModalExclusionType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Set;

import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;

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
	private JPanel champsPlayer = new JPanel();
	private JButton buttonChampsPlayer_Enter = new JButton("Enter");
	private JCheckBox checkBoxChampsPlayer = new JCheckBox("List all champs");
	private JCheckBox checkBoxChampsPlayer_Filtered = new JCheckBox("List champs by filter");
	private JTextField textFieldChampPlayer_Region;
	private JTextField textFieldChampPlayer_Position;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFieldChampsAdmin_Name;
	private JComboBox<String> jComboBoxChampAdmin_Positions;
	private JTextField textFieldChampAdmin_Region;
	private JTextField textFieldChampAdmin_Passive;
	private JTextField textFieldChampAdmin_Q;
	private JTextField textFieldChampAdmin_W;
	private JTextField textFieldChampAdmin_E;
	private JTextField textFieldChampAdmin_R;
	private JTextField textNicknameStats;
	private JTable stats;
	private JButton btnUpdateStats;
	private DefaultTableModel modelStats;
	private JTextField textNicknameGame;
	private JTable games;
	private DefaultTableModel modelGame;
	private JButton btnUpdateGame;
	private JCalendar calendar;
	private JButton btnAddGame;
	private JPanel panelAdmin;
	private JPanel champAdmin = new JPanel();
	private JButton buttonChampsAdmin_Check = new JButton("Check name");
	private JLabel labeChampAdmin = new JLabel();
	private JButton buttonChampAdmin_Add = new JButton("Add Champ");
	private JButton buttonChampAdmin_Modify = new JButton("Modify Champ");

	private ChampEditable champEditable;
	private Statable statable;
	private GameStorable gameStorable;
	private UserControllable userControllable;

	/**
	 * Create the frame.
	 */
	public MainWindow(UserControllable userControllable, ChampEditable champEditable, GameStorable gameStorable,
			Statable statable) {
		this.userControllable = userControllable;
		this.champEditable = champEditable;
		this.gameStorable = gameStorable;
		this.statable = statable;
		Login login = new Login(userControllable, this);
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

		panelAdmin = new JPanel();
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

		tabbedPane.addTab("CHAMPS", null, champsPlayer, null);
		champsPlayer.setLayout(null);

		JLabel labelChampsPlayer_Title = new JLabel("List Champs");
		labelChampsPlayer_Title.setFont(new Font("Arial Black", Font.BOLD, 22));
		labelChampsPlayer_Title.setBounds(501, 21, 301, 117);
		champsPlayer.add(labelChampsPlayer_Title);

		// Create a gorup and add each checkbox to it so only one can be selected
		ButtonGroup buttonGroupChampsPlayer = new ButtonGroup();

		buttonGroupChampsPlayer.add(checkBoxChampsPlayer);
		checkBoxChampsPlayer.setBounds(275, 139, 128, 23);
		champsPlayer.add(checkBoxChampsPlayer);

		buttonGroupChampsPlayer.add(checkBoxChampsPlayer_Filtered);
		checkBoxChampsPlayer_Filtered.setBounds(275, 193, 217, 23);
		champsPlayer.add(checkBoxChampsPlayer_Filtered);

		JLabel labelChampsPlayer_Region = new JLabel("Region");
		labelChampsPlayer_Region.setBounds(342, 247, 61, 16);
		champsPlayer.add(labelChampsPlayer_Region);

		JLabel labelChampsPlayer_Position = new JLabel("Position");
		labelChampsPlayer_Position.setBounds(342, 288, 61, 16);
		champsPlayer.add(labelChampsPlayer_Position);

		textFieldChampPlayer_Region = new JTextField();
		textFieldChampPlayer_Region.setToolTipText("Leave it in blank for no filter");
		textFieldChampPlayer_Region.setBounds(428, 242, 130, 26);
		champsPlayer.add(textFieldChampPlayer_Region);
		textFieldChampPlayer_Region.setColumns(10);

		textFieldChampPlayer_Position = new JTextField();
		textFieldChampPlayer_Position.setToolTipText("Leave it in blank for no filter");
		textFieldChampPlayer_Position.setBounds(428, 283, 130, 26);
		champsPlayer.add(textFieldChampPlayer_Position);
		textFieldChampPlayer_Position.setColumns(10);

		// Confirmation button
		buttonChampsPlayer_Enter.setBounds(441, 340, 117, 29);
		buttonChampsPlayer_Enter.addActionListener(this);
		champsPlayer.add(buttonChampsPlayer_Enter);

		// Champs admin
		tabbedPane.addTab("CHAMPS", null, champAdmin, null);
		champAdmin.setLayout(null);
		ChampAdminTabConstruction();

		JPanel game = new JPanel();
		tabbedPane.addTab("GAME", null, game, null);
		GridBagLayout gbl_game = new GridBagLayout();
		gbl_game.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_game.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_game.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_game.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		game.setLayout(gbl_game);

		JLabel lblNicknameGame = new JLabel("Nickname");
		GridBagConstraints gbc_gNicknamelbl = new GridBagConstraints();
		gbc_gNicknamelbl.insets = new Insets(0, 0, 5, 5);
		gbc_gNicknamelbl.gridx = 1;
		gbc_gNicknamelbl.gridy = 1;
		game.add(lblNicknameGame, gbc_gNicknamelbl);

		textNicknameGame = new JTextField();
		GridBagConstraints gbc_gNicknametxt = new GridBagConstraints();
		gbc_gNicknametxt.insets = new Insets(0, 0, 5, 0);
		gbc_gNicknametxt.fill = GridBagConstraints.HORIZONTAL;
		gbc_gNicknametxt.gridx = 3;
		gbc_gNicknametxt.gridy = 1;
		game.add(textNicknameGame, gbc_gNicknametxt);
		textNicknameGame.setColumns(10);

		btnUpdateGame = new JButton("Update");
		btnUpdateGame.addActionListener(this);
		GridBagConstraints gbc_gUpdatebtn = new GridBagConstraints();
		gbc_gUpdatebtn.insets = new Insets(0, 0, 5, 5);
		gbc_gUpdatebtn.gridx = 1;
		gbc_gUpdatebtn.gridy = 3;
		game.add(btnUpdateGame, gbc_gUpdatebtn);

		btnAddGame = new JButton("Add");
		btnAddGame.addActionListener(this);
		GridBagConstraints gbc_btnAddGame = new GridBagConstraints();
		gbc_btnAddGame.insets = new Insets(0, 0, 5, 0);
		gbc_btnAddGame.gridx = 3;
		gbc_btnAddGame.gridy = 3;
		game.add(btnAddGame, gbc_btnAddGame);

		JScrollPane scrollPaneGame = new JScrollPane();
		GridBagConstraints gbc_gscrollPane = new GridBagConstraints();
		gbc_gscrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_gscrollPane.fill = GridBagConstraints.BOTH;
		gbc_gscrollPane.gridx = 1;
		gbc_gscrollPane.gridy = 5;
		game.add(scrollPaneGame, gbc_gscrollPane);

		games = new JTable();
		games.addMouseListener(this);
		modelGame = new DefaultTableModel();
		games.setModel(modelGame);
		modelGame.addColumn("ID");
		modelGame.addColumn("Date");
		modelGame.addColumn("Duration");
		scrollPaneGame.setViewportView(games);

		calendar = new JCalendar();
		calendar.setEnabled(false);
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.gridx = 3;
		gbc_calendar.gridy = 5;
		game.add(calendar, gbc_calendar);

		JPanel stadistics = new JPanel();
		tabbedPane.addTab("STADISTICS", null, stadistics, null);
		GridBagLayout gbl_stadistics = new GridBagLayout();
		gbl_stadistics.columnWidths = new int[]{248, 66, 96, 65, 452, 0};
		gbl_stadistics.rowHeights = new int[]{402, 0};
		gbl_stadistics.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_stadistics.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		stadistics.setLayout(gbl_stadistics);
				
						JLabel lblNickStats = new JLabel("Nickname");
						lblNickStats.setFont(new Font("Tahoma", Font.PLAIN, 15));
						GridBagConstraints gbc_lblNickStats = new GridBagConstraints();
						gbc_lblNickStats.anchor = GridBagConstraints.WEST;
						gbc_lblNickStats.insets = new Insets(0, 0, 0, 5);
						gbc_lblNickStats.gridx = 1;
						gbc_lblNickStats.gridy = 0;
						stadistics.add(lblNickStats, gbc_lblNickStats);
		
				textNicknameStats = new JTextField();
				GridBagConstraints gbc_textNicknameStats = new GridBagConstraints();
				gbc_textNicknameStats.anchor = GridBagConstraints.WEST;
				gbc_textNicknameStats.insets = new Insets(0, 0, 0, 5);
				gbc_textNicknameStats.gridx = 2;
				gbc_textNicknameStats.gridy = 0;
				stadistics.add(textNicknameStats, gbc_textNicknameStats);
				textNicknameStats.setColumns(10);
		
				btnUpdateStats = new JButton("Update");
				btnUpdateStats.addActionListener(this);
				GridBagConstraints gbc_btnUpdateStats = new GridBagConstraints();
				gbc_btnUpdateStats.anchor = GridBagConstraints.WEST;
				gbc_btnUpdateStats.insets = new Insets(0, 0, 0, 5);
				gbc_btnUpdateStats.gridx = 3;
				gbc_btnUpdateStats.gridy = 0;
				stadistics.add(btnUpdateStats, gbc_btnUpdateStats);
		modelStats = new DefaultTableModel();
		modelStats.addColumn("ID");
		modelStats.addColumn("Nickname");
		modelStats.addColumn("Name");
		modelStats.addColumn("Position");
		modelStats.addColumn("Win/Lose");
		
				JScrollPane scrollPaneStats = new JScrollPane();
				GridBagConstraints gbc_scrollPaneStats = new GridBagConstraints();
				gbc_scrollPaneStats.anchor = GridBagConstraints.NORTHWEST;
				gbc_scrollPaneStats.gridx = 4;
				gbc_scrollPaneStats.gridy = 0;
				stadistics.add(scrollPaneStats, gbc_scrollPaneStats);
				
						stats = new JTable();
						stats.setModel(modelStats);
						scrollPaneStats.setViewportView(stats);

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

		try {
			cargarUsers(userControllable);
		} catch (PersonalizedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
		}

		if (user instanceof Player) {
			tabbedPane.remove(champAdmin);
			tabbedPane.remove(management);
		}
		if (user instanceof Administrator) {
			tabbedPane.remove(champsPlayer);
			tabbedPane.remove(game);
			tabbedPane.remove(stadistics);
		}

		// Load the tab profile with the information for the database
		loadData(userControllable);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdateStats) {
			try {
				updateStats();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnUpdateGame) {
			try {
				updateGame();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnAddGame) {
			AddGame addGame = new AddGame(this, true, gameStorable);
			addGame.setVisible(true);
		}
		if (e.getSource().equals(btnSendAddAdmin)) {
			try {
				sendAddAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(btnDeletePlayer)) {
			try {
				deletePlayerAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource().equals(btnModifyProfile)) {
			try {
				modifyPlayer(userControllable);
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource().equals(btnDeleteProfile)) {
			try {
				deletePlayer(userControllable);
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(buttonChampsPlayer_Enter)) {
			try {
				listChampPlayer();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(buttonChampsAdmin_Check)){
			try {
				checkChampAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(buttonChampAdmin_Add)) {
			try {
				addChampAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(buttonChampAdmin_Modify)) {
			try {
				executeModificationChampAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(),"An unexpected error has occured!", JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void deletePlayerAdmin() throws PersonalizedException {
		// TODO Auto-generated method stub
		int option;
		if (comboBoxSelectUser.getSelectedIndex() != -1) {
			try {
				userDel = userControllable.findUser(comboBoxSelectUser.getSelectedItem().toString());
			} catch (PersonalizedException e) {
				// TODO Auto-generated catch block

				e.getMessage();
			}
			textAreaDeletePlayer.append("ID: " + userDel.getId() + "\nNickname: " + ((Player) userDel).getNickname()
					+ "\nName: " + userDel.getName() + "\nEmail: " + userDel.getEmail() + "\n");
			textAreaDeletePlayer.setVisible(true);
			option = JOptionPane.showConfirmDialog(this, "Quiere borrar a " + userDel.getName() + "?");
			if (option == 0) {
				userControllable.delete(userDel);
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
			JOptionPane.showMessageDialog(this, "ERROR. Rellene todos los campos.");
			comboBoxSelectUser.setSelectedIndex(-1);
			textAreaDeletePlayer.setText("");
			textAreaDeletePlayer.setVisible(false);
		}
	}

	private void sendAddAdmin() throws PersonalizedException {
		// TODO Auto-generated method stub
		char[] pass = passwordFieldAddAdmin.getPassword();
		String passString = new String(pass);
		if (!textFieldNameAddAdmin.getText().isBlank() && passString != null
				&& !textFieldMailAddAdmin.getText().isBlank() && !textFieldPhoneAddAdmin.getText().isBlank()
				&& comboBoxAddAdmin.getSelectedIndex() > -1) {
			user = new Administrator();
			user.setName(textFieldNameAddAdmin.getText());
			user.setPassword(passString);
			user.setEmail(textFieldMailAddAdmin.getText());
			LocalDate date = calendarAddAdmin.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			user.setBirthDate(date);
			user.setBirthDate(LocalDate.now());
			user.setPhone(textFieldPhoneAddAdmin.getText());
			user.setNationality(comboBoxAddAdmin.getSelectedItem().toString());
			userControllable.addUser(user);

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

	private void updateGame() throws PersonalizedException {
		// TODO Auto-generated method stub
		if (!textNicknameGame.getText().isEmpty()) {
			modelGame.setRowCount(0);
			Set<Game> listGames = gameStorable.searchGames(textNicknameGame.getText());
			for (Game game : listGames) {
				Object[] row = new Object[3];
				row[0] = game.getId();
				row[1] = game.getDateGame();
				row[2] = game.getDuration();
				modelGame.addRow(row);
			}

		} else {
			JOptionPane.showMessageDialog(this, "Introduzca un nickname");
		}
	}

	public void updateStats() throws PersonalizedException {
		if (!textNicknameStats.getText().isEmpty()) {
			modelStats.setRowCount(0);
			Set<Played> listStats;
			listStats = statable.stadistics(textNicknameStats.getText());
			for (Played played : listStats) {
				Object[] row = new Object[5];
				row[0] = played.getId();
				row[1] = played.getNickname();
				row[2] = played.getName();
				row[3] = played.getPosition();
				if (played.isWin()) {
					row[4] = "Win";
				} else {
					row[4] = "Lose";
				}
				modelStats.addRow(row);
			}

		} else {
			JOptionPane.showMessageDialog(this, "Introduzca un nickname");
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
			LocalDate dateStart = jCalendarStartDateProfile.getDate().toInstant().atZone(ZoneId.systemDefault())
					.toLocalDate();
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

	public void modifyPlayer(UserControllable userControllable) throws PersonalizedException {
		boolean correct = false;
		// If the user is instance as player we use the original nickname saved before
		if (user instanceof Player) {
			user = userControllable.findUser(nicknameOriginal);
		} else {
			user = userControllable.findUser(user.getId());
		}
		// ADD CHECKEO
		User user = loadUser();

		correct = userControllable.modifyUser(user);
		if (correct) {
			JOptionPane.showMessageDialog(this, "PERSONAL DATA MODIFIED");
		} else {
			JOptionPane.showMessageDialog(this, "NO MODIFICATION");
		}

	}

	// Method to delete Player
	public void deletePlayer(UserControllable userControllable) throws PersonalizedException {
		boolean correct = false;
		int aceptar;
		User user = null;
		// Find the user
		user = userControllable.findUser(textFieldNicknameProfile.getText());
		// Show a confirmation dialog
		aceptar = JOptionPane.showConfirmDialog(this, "WARNING: do you want to delete your account?");
		// Yes --> 0 so If the user accepts the message, his account will be deleted.
		if (aceptar == 0) {
			correct = userControllable.delete(user);
			clear();
		}
		if (correct) {
			JOptionPane.showMessageDialog(this, "USER DELETE");
		} else {
			JOptionPane.showMessageDialog(this, "USER NO DELETE");
		}
	}

	private void cargarUsers(UserControllable control) throws PersonalizedException {
		Set<User> users = control.listPlayers();

		for (User u : users) {
			if (comboBoxSelectUser.getItemAt(0) != (u.getId() + " " + u.getName())) {
				comboBoxSelectUser.addItem(((Player) u).getNickname());
			}
			comboBoxSelectUser.setSelectedIndex(-1);
		}
	}

	public void ChampAdminTabConstruction() {
		JLabel labelChampsAdmin_Title = new JLabel("Add or modify champ");
		labelChampsAdmin_Title.setFont(new Font("Arial Black", Font.BOLD, 22));
		labelChampsAdmin_Title.setBounds(363, 47, 555, 27);
		champAdmin.add(labelChampsAdmin_Title);

		JLabel labelChampsAdmin_Name = new JLabel("Name");
		labelChampsAdmin_Name.setBounds(346, 122, 61, 16);
		champAdmin.add(labelChampsAdmin_Name);

		textFieldChampsAdmin_Name = new JTextField();
		textFieldChampsAdmin_Name.setBounds(459, 117, 130, 26);
		champAdmin.add(textFieldChampsAdmin_Name);
		textFieldChampsAdmin_Name.setColumns(10);

		buttonChampsAdmin_Check.setBounds(479, 226, 117, 29);
		buttonChampsAdmin_Check.addActionListener(this);
		buttonChampsAdmin_Check.setVisible(true);
		champAdmin.add(buttonChampsAdmin_Check);
	}

	public void checkChampAdmin() throws PersonalizedException {
		if (textFieldChampsAdmin_Name.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Añade un nombre correcto", "Alert", JOptionPane.WARNING_MESSAGE);
		else
			addOrModifyChamp();
	}

	public void addOrModifyChamp() throws PersonalizedException {
		buttonChampsAdmin_Check.setVisible(false);
		JLabel labelChampsAdmin_Position = new JLabel("Position");
		labelChampsAdmin_Position.setBounds(346, 162, 61, 16);
		champAdmin.add(labelChampsAdmin_Position);

		String[] positions = { "TOP", "JNG", "MID", "ADC", "SUP" };
		jComboBoxChampAdmin_Positions = new JComboBox<String>(positions);
		jComboBoxChampAdmin_Positions.setBounds(459, 157, 130, 26);
		jComboBoxChampAdmin_Positions.setSelectedIndex(-1);
		champAdmin.add(jComboBoxChampAdmin_Positions);

		JLabel labelChampsAdmin_Region = new JLabel("Region");
		labelChampsAdmin_Region.setBounds(346, 204, 61, 16);
		champAdmin.add(labelChampsAdmin_Region);

		textFieldChampAdmin_Region = new JTextField();
		textFieldChampAdmin_Region.setColumns(10);
		textFieldChampAdmin_Region.setBounds(459, 197, 130, 26);
		champAdmin.add(textFieldChampAdmin_Region);

		JLabel labelChampsAdmin_Passive = new JLabel("Passive");
		labelChampsAdmin_Passive.setBounds(346, 244, 61, 16);
		champAdmin.add(labelChampsAdmin_Passive);

		textFieldChampAdmin_Passive = new JTextField();
		textFieldChampAdmin_Passive.setColumns(10);
		textFieldChampAdmin_Passive.setBounds(459, 237, 130, 26);
		champAdmin.add(textFieldChampAdmin_Passive);

		JLabel labelChampsAdmin_Q = new JLabel("Q");
		labelChampsAdmin_Q.setBounds(346, 284, 61, 16);
		champAdmin.add(labelChampsAdmin_Q);

		textFieldChampAdmin_Q = new JTextField();
		textFieldChampAdmin_Q.setColumns(10);
		textFieldChampAdmin_Q.setBounds(459, 277, 130, 26);
		champAdmin.add(textFieldChampAdmin_Q);

		JLabel labelChampsAdmin_W = new JLabel("W");
		labelChampsAdmin_W.setBounds(346, 324, 61, 16);
		champAdmin.add(labelChampsAdmin_W);

		textFieldChampAdmin_W = new JTextField();
		textFieldChampAdmin_W.setColumns(10);
		textFieldChampAdmin_W.setBounds(459, 317, 130, 26);
		champAdmin.add(textFieldChampAdmin_W);

		JLabel labelChampsAdmin_E = new JLabel("E");
		labelChampsAdmin_E.setBounds(346, 364, 61, 16);
		champAdmin.add(labelChampsAdmin_E);

		textFieldChampAdmin_E = new JTextField();
		textFieldChampAdmin_E.setColumns(10);
		textFieldChampAdmin_E.setBounds(459, 357, 130, 26);
		champAdmin.add(textFieldChampAdmin_E);

		JLabel labelChampsAdmin_R = new JLabel("R");
		labelChampsAdmin_R.setBounds(346, 404, 61, 16);
		champAdmin.add(labelChampsAdmin_R);

		textFieldChampAdmin_R = new JTextField();
		textFieldChampAdmin_R.setColumns(10);
		textFieldChampAdmin_R.setBounds(459, 397, 130, 26);
		champAdmin.add(textFieldChampAdmin_R);

		textFieldChampsAdmin_Name.setEditable(false);

		Champ champ = champEditable.checkChampName(textFieldChampsAdmin_Name.getText());
		if (champ.getName() == null) {
			buttonChampAdmin_Add.setBounds(459, 500, 117, 29);
			buttonChampAdmin_Add.addActionListener(this);
			champAdmin.add(buttonChampAdmin_Add);
		} else
			modifyChampAdmin(champ);
	}

	public Champ fillChamp(Champ champ) {
		champ.setName(textFieldChampsAdmin_Name.getText());
		champ.setPosition(jComboBoxChampAdmin_Positions.getItemAt(jComboBoxChampAdmin_Positions.getSelectedIndex()));
		champ.setRegion(textFieldChampAdmin_Region.getText());
		champ.setPassive(textFieldChampAdmin_Passive.getText());
		champ.setQ(textFieldChampAdmin_Q.getText());
		champ.setW(textFieldChampAdmin_W.getText());
		champ.setE(textFieldChampAdmin_E.getText());
		champ.setR(textFieldChampAdmin_R.getText());

		return (champ);
	}

	public boolean checkFieldsChampAdmin() {
		if (jComboBoxChampAdmin_Positions.getSelectedIndex() == -1 || textFieldChampAdmin_Region.getText().isBlank()
				|| textFieldChampAdmin_Passive.getText().isBlank() || textFieldChampAdmin_Q.getText().isBlank()
				|| textFieldChampAdmin_W.getText().isBlank() || textFieldChampAdmin_E.getText().isBlank()
				|| textFieldChampAdmin_R.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please fill all the fields", "Alert", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		return true;
	}

	public void addChampAdmin() throws PersonalizedException {
		Champ champ = new Champ();
		if (checkFieldsChampAdmin() == false)
			return;
		champ = fillChamp(champ);
		if (champEditable.addChamp(champ))
			JOptionPane.showMessageDialog(null, "Champ added successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Champ couldn't be added", "Alert", JOptionPane.WARNING_MESSAGE);
		removeChampAdminTab();
	}

	public void modifyChampAdmin(Champ champ) {
		textFieldChampsAdmin_Name.setText(champ.getName());
		jComboBoxChampAdmin_Positions.setSelectedItem(champ.getPosition());
		textFieldChampAdmin_Region.setText(champ.getRegion());
		textFieldChampAdmin_Passive.setText(champ.getPassive());
		textFieldChampAdmin_Q.setText(champ.getQ());
		textFieldChampAdmin_W.setText(champ.getW());
		textFieldChampAdmin_E.setText(champ.getE());
		textFieldChampAdmin_R.setText(champ.getR());

		buttonChampAdmin_Modify.setBounds(459, 500, 117, 29);
		buttonChampAdmin_Modify.addActionListener(this);
		champAdmin.add(buttonChampAdmin_Modify);
	}

	public void executeModificationChampAdmin() throws PersonalizedException {
		Champ champ = new Champ();
		if (checkFieldsChampAdmin() == false)
			return;
		champ = fillChamp(champ);
		if (champEditable.modifyChamp(champ))
			JOptionPane.showMessageDialog(null, "Champ modified successfully", "Alert",
					JOptionPane.INFORMATION_MESSAGE);
		else
			JOptionPane.showMessageDialog(null, "Champ couldn't be modified", "Alert", JOptionPane.WARNING_MESSAGE);
		removeChampAdminTab();
	}

	public void removeChampAdminTab() {
		champAdmin.removeAll();
		ChampAdminTabConstruction();
	}

	public void listChampPlayer() throws PersonalizedException {
		if (checkBoxChampsPlayer.isSelected() || checkBoxChampsPlayer_Filtered.isSelected()) {

			List<Champ> list = null;
			if (checkBoxChampsPlayer.isSelected()) {
				// Get an array of all champs
				list = champEditable.listChamp();
				// convert champs list to a bidimensional array
			} else if (checkBoxChampsPlayer_Filtered.isSelected()) {
				// Show champs by filter
				String region = textFieldChampPlayer_Region.getText();
				if (region.equals("")) {
					region = null;
				}
				String position = textFieldChampPlayer_Position.getText();
				if (position.equals("")) {
					position = null;
				}
				list = champEditable.listChamp(position, region);

			}
			createChampPlayerTable(list);
		}
	}

	public void createChampPlayerTable(List<Champ> list) {
		String[][] data = null;
		data = new String[list.size()][];
		for (int i = 0; i < list.size(); i++) {
			Champ champ = new Champ();
			champ = list.get(i);
			data[i] = new String[] { champ.getName(), champ.getRegion(), champ.getPassive(), champ.getPosition(),
					champ.getQ(), champ.getW(), champ.getE(), champ.getR() };
		}
		;
		JScrollPane scrollPaneChampPlayer = new JScrollPane();
		scrollPaneChampPlayer.setBounds(175, 400, 700, 200);
		champsPlayer.add(scrollPaneChampPlayer);

		String[] columnNames = { "Name", "Region", "Passive", "Position", "Q", "W", "E", "R" };
		JTable table = new JTable(data, columnNames);
		scrollPaneChampPlayer.setViewportView(table);

		JTableHeader tableHeaderChampPlayer = table.getTableHeader();
		tableHeaderChampPlayer.setBackground(new Color(225, 223, 225));
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == games) {
			calendar.setDate(Date.valueOf((LocalDate) games.getValueAt(games.getSelectedRow(), 1)));
		}
		calendar.setEnabled(false);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(lblPassEyeAddAdmin)) {
			passwordFieldAddAdmin.setEchoChar((char) 0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource().equals(lblPassEyeAddAdmin)) {
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
