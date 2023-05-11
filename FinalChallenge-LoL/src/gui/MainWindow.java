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
import javax.swing.table.TableColumn;
import javax.swing.text.html.HTMLDocument.Iterator;

import controller.*;
import exceptions.PersonalizedException;
import inputControl.InputControl;
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
import java.util.LinkedHashSet;

import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class MainWindow extends JFrame implements ActionListener, MouseListener, FocusListener {
	private JPanel contentPane;
	private JButton btnModifyPlayer;
	private JDateChooser jCalendarProfile;
	private JPanel panelAdmin;
	private JLabel nicknameProfile;
	private JButton btnDeletePlayer;
	private JLabel lblEyeProfile;
	private User user, userDel;
	private JComboBox comboBoxNationalityProfile;
	private JPanel champsPlayer = new JPanel();
	private JButton buttonChampsPlayer_Enter = new JButton("ENTER");
	private JCheckBox checkBoxChampsPlayer = new JCheckBox("");
	private JCheckBox checkBoxChampsPlayer_Filtered = new JCheckBox("");
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox comboBoxSelectUser;
	
	private JPanel reportPanel;
	private JButton btnReport;

	private JTextField textNicknameStats;

	private JTable stats;
	private DefaultTableModel modelStats;
	private JScrollPane scrollPaneStats;
	private JTable games;
	private DefaultTableModel modelGame;
	private JCalendar calendar;

	private JTable statsTopPlayers;
	private DefaultTableModel modelTopPlayers;
	private JScrollPane scrollPaneTopPlayers;

	private JPanel champAdmin = new JPanel();
	private JLabel labeChampAdmin = new JLabel();
	private JComboBox comboBoxAddAdmin;
	private JDateChooser calendarAddAdmin;
	private JButton btnSendAddAdmin;
	private JLabel lblPassEyeAddAdmin;
	private JDateChooser dateChooser_1;
	private JButton buttonChampsAdmin_Check;
	private JButton btnModifyChamp;
	private JButton buttonChampAdd;
	private JLabel nicknameProfilePicture;
	private JButton btnDeletePlayerManagement;

	private JButton btnR;
	private JButton btnResolve;
	private JTable tableReports;
	private JScrollPane scrollPaneReports;

	private JButton btnAddGame;
	private ChampEditable champEditable;
	private Statable statable;
	private GameStorable gameStorable;
	private UserControllable userControllable;
	private InputControl control = new InputControl();
	private JTextField textFieldNicknameProfile;
	private JTextField textFieldPhoneProfile;
	private JTextField textFieldEmailProfile;
	private JTextField textFieldNameProfile;
	private JPasswordField passwordFieldProfile;
	private JTextField textFieldAdditionsProfile;
	private JPasswordField passwordFieldAddAdmin;
	private JTextField textFieldPhoneAddAdmin;
	private JTextField textFieldMailAddAdmin;
	private JTextField textFieldNameAddAdmin;
	private JButton btnUpdateStats;
	private JButton btnShowTopPlayers;
	private JTextField textFieldRegionChamp;
	private JTextField textFieldPassiveChamp;
	private JTextField textFieldQChamp;
	private JTextField textFieldWChamp;
	private JTextField textFieldRChamp;
	private JTextField textFieldEChamp;
	private JTextField textFieldChampName;
	private JLayeredPane panelHabilidades;
	private JComboBox comboBoxPosition;
	private JTextField textFieldChampPlayer_Region;
	private JTextField textFieldChampPlayer_Position;
	private JButton btnUpdateGame;
	private JTextField textNicknameGame;

	private JTextArea textAreaDeletePlayer;
	private JPanel panelAddModifyChamp;
	private JButton btnCancelChamp;
	private JScrollPane scrollPaneChampPlayer;
	private JTable champs;
	private JLayeredPane selectRegionPosition;
	private JButton btnLogOut;
	private JLayeredPane deletePlayerManagement;

	/**
	 * Create the frame.
	 */
	public MainWindow(UserControllable userControllable, ChampEditable champEditable, GameStorable gameStorable,
			Statable statable) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainWindow.class.getResource("/icon/LoL_icon.svg.png")));
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
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane);

		JPanel profile = new JPanel();
		profile.setBackground(new Color(0, 0, 0));
		tabbedPane.addTab("PROFILE\r\n", null, profile, null);

		textFieldNicknameProfile = new JTextField();
		textFieldNicknameProfile.setBounds(260, 165, 199, 27);
		textFieldNicknameProfile.setBackground(Color.BLACK);
		textFieldNicknameProfile.setForeground(Color.WHITE);
		textFieldNicknameProfile.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldNicknameProfile.setToolTipText("");
		textFieldNicknameProfile.setText((String) null);
		textFieldNicknameProfile.setColumns(10);
		textFieldNicknameProfile.addFocusListener(this);
		profile.setLayout(null);
		profile.add(textFieldNicknameProfile);

		lblEyeProfile = new JLabel("");
		lblEyeProfile.setBounds(477, 275, 30, 24);
		lblEyeProfile.setIcon(
				new ImageIcon(MainWindow.class.getResource("/img/1200px-OOjs_UI_icon_eye-progressive.svg.png")));
		lblEyeProfile.addMouseListener(this);
		profile.add(lblEyeProfile);

		JLabel iconProfile = new JLabel("");
		iconProfile.setBounds(109, 49, 64, 64);
		iconProfile.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lolLogo (2).png")));
		profile.add(iconProfile);

		nicknameProfilePicture = new JLabel("New label");
		nicknameProfilePicture.setBounds(915, 378, 135, 16);
		profile.add(nicknameProfilePicture);

		JLabel passwordProfile = new JLabel("PASSWORD");
		passwordProfile.setBounds(119, 274, 121, 21);
		passwordProfile.setForeground(new Color(255, 255, 255));
		passwordProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		profile.add(passwordProfile);

		JLabel lblEmailProfile = new JLabel("NAME");
		lblEmailProfile.setBounds(119, 221, 92, 21);
		lblEmailProfile.setForeground(new Color(255, 255, 255));
		lblEmailProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		profile.add(lblEmailProfile);

		JLabel emailProfile = new JLabel("EMAIL");
		emailProfile.setBounds(119, 343, 114, 21);
		emailProfile.setForeground(new Color(255, 255, 255));
		emailProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		profile.add(emailProfile);

		JLabel birthdateProfile = new JLabel("BIRTHDATE");
		birthdateProfile.setBounds(119, 448, 145, 21);
		profile.add(birthdateProfile);
		birthdateProfile.setForeground(new Color(255, 255, 255));
		birthdateProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));

		JLabel lblNacionalityProfile = new JLabel("NATIONALITY");
		lblNacionalityProfile.setBounds(119, 511, 168, 21);
		lblNacionalityProfile.setForeground(new Color(255, 255, 255));
		lblNacionalityProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		profile.add(lblNacionalityProfile);

		nicknameProfile = new JLabel("NICKNAME");
		nicknameProfile.setBounds(119, 165, 135, 21);
		nicknameProfile.setForeground(new Color(255, 255, 255));
		nicknameProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		nicknameProfile.addFocusListener(this);
		profile.add(nicknameProfile);

		textFieldPhoneProfile = new JTextField();
		textFieldPhoneProfile.setBounds(260, 394, 199, 27);
		textFieldPhoneProfile.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldPhoneProfile.setForeground(new Color(255, 255, 255));
		textFieldPhoneProfile.setBackground(new Color(0, 0, 0));
		textFieldPhoneProfile.setColumns(10);
		textFieldPhoneProfile.addFocusListener(this);
		profile.add(textFieldPhoneProfile);

		textFieldEmailProfile = new JTextField();
		textFieldEmailProfile.setBounds(260, 336, 199, 27);
		textFieldEmailProfile.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldEmailProfile.setForeground(new Color(255, 255, 255));
		textFieldEmailProfile.setBackground(new Color(0, 0, 0));
		textFieldEmailProfile.setToolTipText("");
		textFieldEmailProfile.setText((String) null);
		textFieldEmailProfile.setColumns(10);
		textFieldEmailProfile.addFocusListener(this);

		profile.add(textFieldEmailProfile);

		comboBoxNationalityProfile = new JComboBox();
		comboBoxNationalityProfile.setBounds(260, 510, 205, 21);
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
		comboBoxNationalityProfile.setSelectedIndex(-1);
		profile.add(comboBoxNationalityProfile);

		JLabel phoneProfile = new JLabel("PHONE");
		phoneProfile.setBounds(119, 396, 92, 21);
		phoneProfile.setForeground(new Color(255, 255, 255));
		phoneProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		profile.add(phoneProfile);

		textFieldNameProfile = new JTextField();
		textFieldNameProfile.setBounds(260, 218, 199, 27);
		textFieldNameProfile.setForeground(Color.WHITE);
		textFieldNameProfile.setBackground(Color.BLACK);
		textFieldNameProfile.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldNameProfile.setText((String) null);
		textFieldNameProfile.setColumns(9);
		textFieldNameProfile.addFocusListener(this);
		profile.add(textFieldNameProfile);

		passwordFieldProfile = new JPasswordField();
		passwordFieldProfile.setBounds(260, 275, 199, 27);
		passwordFieldProfile.setForeground(new Color(255, 255, 255));
		passwordFieldProfile.setBackground(new Color(0, 0, 0));
		passwordFieldProfile.setText((String) null);
		passwordFieldProfile.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		passwordFieldProfile.setEchoChar('·');
		passwordFieldProfile.addFocusListener(this);
		profile.add(passwordFieldProfile);

		jCalendarProfile = new JDateChooser();
		jCalendarProfile.setBounds(260, 444, 202, 22);
		jCalendarProfile.setDateFormatString("dd MM yy");
		profile.add(jCalendarProfile);

		panelAdmin = new JPanel();
		panelAdmin.setBounds(551, 193, 297, 309);
		panelAdmin.setBackground(new Color(0, 0, 0, 180));
		panelAdmin.setForeground(new Color(0, 0, 0));
		panelAdmin.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		profile.add(panelAdmin);
		panelAdmin.setLayout(null);

		JLabel personalDataProfile_1_1 = new JLabel("ADMINISTRATOR AREA");
		personalDataProfile_1_1.setBounds(30, 10, 267, 83);
		personalDataProfile_1_1.setForeground(new Color(0, 139, 139));
		personalDataProfile_1_1.setFont(new Font("Bahnschrift", Font.BOLD, 22));
		panelAdmin.add(personalDataProfile_1_1);

		JLabel startDate = new JLabel("START DATE");
		startDate.setForeground(new Color(255, 255, 255));
		startDate.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		startDate.setBounds(23, 87, 133, 21);
		panelAdmin.add(startDate);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(166, 87, 101, 22);
		panelAdmin.add(dateChooser_1);

		JLabel additionsProfile = new JLabel("ADDITIONS");
		additionsProfile.setForeground(new Color(255, 255, 255));
		additionsProfile.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		additionsProfile.setBounds(30, 183, 126, 21);
		panelAdmin.add(additionsProfile);

		textFieldAdditionsProfile = new JTextField();
		textFieldAdditionsProfile.setForeground(new Color(255, 255, 255));
		textFieldAdditionsProfile.setBackground(new Color(0, 0, 0));
		textFieldAdditionsProfile.setColumns(10);
		textFieldAdditionsProfile.setBounds(212, 181, 55, 22);
		textFieldAdditionsProfile.addFocusListener(this);
		panelAdmin.add(textFieldAdditionsProfile);

		JLabel personalDataProfile1 = new JLabel("PERSONAL DATA");
		personalDataProfile1.setBounds(260, 49, 579, 89);
		personalDataProfile1.setForeground(new Color(0, 139, 139));
		personalDataProfile1.setFont(new Font("Bahnschrift", Font.BOLD, 69));
		profile.add(personalDataProfile1);

		JLabel personalDataProfile = new JLabel("PERSONAL DATA");
		personalDataProfile.setBounds(257, 50, 579, 89);
		personalDataProfile.setFont(new Font("Bahnschrift", Font.BOLD, 69));
		personalDataProfile.setForeground(new Color(218, 165, 32, 150));
		profile.add(personalDataProfile);

		JPanel panelTransparenteProfile = new JPanel();
		panelTransparenteProfile.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(184, 134, 11), null));
		panelTransparenteProfile.setBackground(new Color(0, 0, 0, 180));
		panelTransparenteProfile.setBounds(49, 34, 1059, 563);
		profile.add(panelTransparenteProfile);
		panelTransparenteProfile.setLayout(null);

		btnLogOut = new JButton("LOG OUT");
		btnLogOut.setForeground(Color.WHITE);
		btnLogOut.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnLogOut.setBackground(new Color(0, 128, 128));
		btnLogOut.setBounds(81, 526, 92, 26);
		panelTransparenteProfile.add(btnLogOut);
		btnLogOut.addActionListener(this);

		btnModifyPlayer = new JButton("MODIFY ");
		btnModifyPlayer.setBounds(197, 526, 92, 26);
		panelTransparenteProfile.add(btnModifyPlayer);
		btnModifyPlayer.setForeground(new Color(255, 255, 255));
		btnModifyPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnModifyPlayer.setBackground(new Color(0, 128, 128));

		btnDeletePlayer = new JButton("DELETE");
		btnDeletePlayer.setBounds(308, 526, 95, 26);
		panelTransparenteProfile.add(btnDeletePlayer);
		btnDeletePlayer.setForeground(new Color(255, 255, 255));
		btnDeletePlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnDeletePlayer.setBackground(new Color(0, 128, 128));
		
				JLabel pictureProfile = new JLabel("");
				pictureProfile.setBounds(849, 75, 200, 478);
				panelTransparenteProfile.add(pictureProfile);
				pictureProfile.setIcon(new ImageIcon(MainWindow.class.getResource(
						"/img/Banner-Gold-keatas-Ranked-Season-LoL-Wild-Rift-700x394-PhotoRoom.png-PhotoRoom (1) (1).png")));
		btnDeletePlayer.addActionListener(this);
		btnDeletePlayer.setVisible(false);
		btnModifyPlayer.addActionListener(this);

		JLabel fondoPictureProfile = new JLabel("New label");
		fondoPictureProfile.setBounds(-393, -13, 1574, 675);
		fondoPictureProfile.setIcon(new ImageIcon(MainWindow.class.getResource("/img/LOL_PROMOART_14.jpg")));
		profile.add(fondoPictureProfile);

		champsPlayer = new JPanel();
		tabbedPane.addTab("CHAMPS", null, champsPlayer, null);
		champsPlayer.setLayout(null);
		// Create a gorup and add each checkbox to it so only one can be selected
		ButtonGroup buttonGroupChampsPlayer = new ButtonGroup();

		JPanel panelTransparente = new JPanel();
		panelTransparente.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		panelTransparente.setBackground(new Color(0, 0, 0, 180));
		panelTransparente.setBounds(59, 37, 1059, 553);
		champsPlayer.add(panelTransparente);
		panelTransparente.setLayout(null);

		JLabel lblChamps = new JLabel("CHAMPS");
		lblChamps.setBounds(375, 10, 328, 83);
		lblChamps.setForeground(new Color(0, 139, 139));
		lblChamps.setFont(new Font("Bahnschrift", Font.BOLD, 69));
		panelTransparente.add(lblChamps);

		JLabel lblChamps_1 = new JLabel("CHAMPS");
		lblChamps_1.setForeground(new Color(218, 165, 32));
		lblChamps_1.setFont(new Font("Bahnschrift", Font.BOLD, 69));
		lblChamps_1.setBounds(372, 10, 328, 83);
		panelTransparente.add(lblChamps_1);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lolLogo (2).png")));
		lblNewLabel_1.setBounds(10, 10, 64, 64);
		panelTransparente.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(MainWindow.class.getResource("/img/Controller_icon - copia (2).png")));
		lblNewLabel_2.setBounds(916, 8, 87, 131);
		panelTransparente.add(lblNewLabel_2);

		checkBoxChampsPlayer_Filtered = new JCheckBox("List champs by filter");
		buttonGroupChampsPlayer.add(checkBoxChampsPlayer_Filtered);
		checkBoxChampsPlayer_Filtered.setBackground(new Color(0, 0, 0, 180));
		checkBoxChampsPlayer_Filtered.setBounds(116, 145, 21, 23);
		panelTransparente.add(checkBoxChampsPlayer_Filtered);
		checkBoxChampsPlayer_Filtered.setForeground(new Color(255, 255, 255));
		checkBoxChampsPlayer_Filtered.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		checkBoxChampsPlayer.setBackground(new Color(0, 0, 0));
		checkBoxChampsPlayer.setBounds(116, 184, 21, 25);
		panelTransparente.add(checkBoxChampsPlayer);
		checkBoxChampsPlayer.setForeground(new Color(255, 255, 255));
		checkBoxChampsPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		checkBoxChampsPlayer_Filtered.addActionListener(this);
		checkBoxChampsPlayer.addActionListener(this);

		buttonGroupChampsPlayer.add(checkBoxChampsPlayer);

		JLabel lblListChampsByFilter = new JLabel("LIST CAMPS BY FILTER");
		lblListChampsByFilter.setForeground(new Color(255, 255, 255));
		lblListChampsByFilter.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblListChampsByFilter.setBounds(161, 142, 223, 36);
		panelTransparente.add(lblListChampsByFilter);
		buttonChampsPlayer_Enter.setForeground(new Color(255, 255, 255));
		buttonChampsPlayer_Enter.setBackground(new Color(0, 128, 128));
		buttonChampsPlayer_Enter.setBounds(185, 244, 117, 29);
		panelTransparente.add(buttonChampsPlayer_Enter);
		buttonChampsPlayer_Enter.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		buttonChampsPlayer_Enter.setEnabled(false);

		JLabel lblListAllChamps = new JLabel("LIST ALL CHAMPS");
		lblListAllChamps.setForeground(new Color(255, 255, 255));
		lblListAllChamps.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblListAllChamps.setBounds(161, 184, 209, 36);
		panelTransparente.add(lblListAllChamps);

		JLabel iconBottonChamps = new JLabel("");
		iconBottonChamps.setIcon(new ImageIcon(MainWindow.class.getResource("/img/Bottom_icon.png")));
		iconBottonChamps.setBounds(916, 135, 65, 57);
		panelTransparente.add(iconBottonChamps);

		JLabel iconJungleChamps = new JLabel("");
		iconJungleChamps.setIcon(
				new ImageIcon(MainWindow.class.getResource("/img/lol_jungle_icon_by_divoras_degndao-fullview.png")));
		iconJungleChamps.setBounds(916, 225, 74, 83);
		panelTransparente.add(iconJungleChamps);

		JLabel iconMiddleChamps = new JLabel("");
		iconMiddleChamps.setIcon(new ImageIcon(MainWindow.class.getResource("/img/Middle_icon.png")));
		iconMiddleChamps.setBounds(920, 342, 74, 64);
		panelTransparente.add(iconMiddleChamps);

		JLabel iconTopChamps = new JLabel("");
		iconTopChamps.setIcon(new ImageIcon(MainWindow.class.getResource("/img/Top_icon.png")));
		iconTopChamps.setBounds(920, 444, 87, 64);
		panelTransparente.add(iconTopChamps);

		selectRegionPosition = new JLayeredPane();
		selectRegionPosition.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		selectRegionPosition.setBounds(418, 103, 426, 159);
		panelTransparente.add(selectRegionPosition);
		selectRegionPosition.setLayout(null);

		JLabel labelChampsPlayer_Region = new JLabel("REGION");
		labelChampsPlayer_Region.setBounds(36, 40, 117, 36);
		labelChampsPlayer_Region.setForeground(Color.WHITE);
		labelChampsPlayer_Region.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		selectRegionPosition.add(labelChampsPlayer_Region);

		textFieldChampPlayer_Region = new JTextField();
		textFieldChampPlayer_Region.setEditable(false);
		textFieldChampPlayer_Region.setEnabled(false);
		textFieldChampPlayer_Region.setToolTipText("Leave it in blank for no filter");
		textFieldChampPlayer_Region.setForeground(Color.WHITE);
		textFieldChampPlayer_Region.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldChampPlayer_Region.setColumns(10);
		textFieldChampPlayer_Region.setBackground(Color.BLACK);
		textFieldChampPlayer_Region.setBounds(190, 40, 202, 26);
		selectRegionPosition.add(textFieldChampPlayer_Region);
		textFieldChampPlayer_Region.addActionListener(this);

		JLabel labelChampsPlayer_Position = new JLabel("POSITION");
		labelChampsPlayer_Position.setBounds(36, 105, 135, 26);
		selectRegionPosition.add(labelChampsPlayer_Position);
		labelChampsPlayer_Position.setForeground(new Color(255, 255, 255));
		labelChampsPlayer_Position.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

		textFieldChampPlayer_Position = new JTextField();
		textFieldChampPlayer_Position.setEnabled(false);
		textFieldChampPlayer_Position.setEditable(false);
		textFieldChampPlayer_Position.setToolTipText("Leave it in blank for no filter");
		textFieldChampPlayer_Position.setForeground(Color.WHITE);
		textFieldChampPlayer_Position.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldChampPlayer_Position.setColumns(10);
		textFieldChampPlayer_Position.setBackground(Color.BLACK);
		textFieldChampPlayer_Position.setBounds(190, 107, 202, 26);
		selectRegionPosition.add(textFieldChampPlayer_Position);
		textFieldChampPlayer_Position.addActionListener(this);

		buttonChampsPlayer_Enter.addActionListener(this);

		JLabel panelChampPlayer = new JLabel("");
		panelChampPlayer.setBackground(new Color(0, 0, 0, 180));
		panelChampPlayer.setIcon(new ImageIcon(MainWindow.class.getResource("/img/RuneterraMap.png")));
		panelChampPlayer.setBounds(-420, -35, 1601, 714);
		champsPlayer.add(panelChampPlayer);

		// Champs admin
		champAdmin = new JPanel();
		tabbedPane.addTab("CHAMPS", null, champAdmin, null);
		champAdmin.setLayout(null);

		panelHabilidades = new JLayeredPane();
		panelHabilidades.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		panelHabilidades.setBounds(621, 58, 428, 513);
		champAdmin.add(panelHabilidades);
		panelHabilidades.setLayout(null);
		panelHabilidades.setVisible(false);

		JLabel Region = new JLabel("REGION");
		Region.setForeground(new Color(255, 255, 255));
		Region.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		Region.setBounds(25, 118, 108, 25);
		panelHabilidades.add(Region);

		textFieldRegionChamp = new JTextField();
		textFieldRegionChamp.setToolTipText("Leave it in blank for no filter");
		textFieldRegionChamp.setForeground(Color.WHITE);
		textFieldRegionChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldRegionChamp.setColumns(10);
		textFieldRegionChamp.setBackground(Color.BLACK);
		textFieldRegionChamp.setBounds(169, 117, 202, 26);
		panelHabilidades.add(textFieldRegionChamp);

		JLabel lblPosition = new JLabel("POSITION");
		lblPosition.setForeground(Color.WHITE);
		lblPosition.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblPosition.setBounds(25, 55, 108, 25);
		panelHabilidades.add(lblPosition);

		JLabel lblPassive = new JLabel("PASSIVE");
		lblPassive.setForeground(Color.WHITE);
		lblPassive.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblPassive.setBounds(25, 193, 108, 25);
		panelHabilidades.add(lblPassive);

		textFieldPassiveChamp = new JTextField();
		textFieldPassiveChamp.setToolTipText("Leave it in blank for no filter");
		textFieldPassiveChamp.setForeground(Color.WHITE);
		textFieldPassiveChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldPassiveChamp.setColumns(10);
		textFieldPassiveChamp.setBackground(Color.BLACK);
		textFieldPassiveChamp.setBounds(169, 180, 202, 26);
		panelHabilidades.add(textFieldPassiveChamp);

		JLabel lblQ = new JLabel("Q");
		lblQ.setForeground(Color.WHITE);
		lblQ.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblQ.setBounds(25, 252, 108, 25);
		panelHabilidades.add(lblQ);

		textFieldQChamp = new JTextField();
		textFieldQChamp.setToolTipText("Leave it in blank for no filter");
		textFieldQChamp.setForeground(Color.WHITE);
		textFieldQChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldQChamp.setColumns(10);
		textFieldQChamp.setBackground(Color.BLACK);
		textFieldQChamp.setBounds(169, 237, 202, 26);
		panelHabilidades.add(textFieldQChamp);

		JLabel lblW = new JLabel("W");
		lblW.setForeground(Color.WHITE);
		lblW.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblW.setBounds(25, 301, 108, 25);
		panelHabilidades.add(lblW);

		textFieldWChamp = new JTextField();
		textFieldWChamp.setToolTipText("Leave it in blank for no filter");
		textFieldWChamp.setForeground(Color.WHITE);
		textFieldWChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldWChamp.setColumns(10);
		textFieldWChamp.setBackground(Color.BLACK);
		textFieldWChamp.setBounds(169, 300, 202, 26);
		panelHabilidades.add(textFieldWChamp);

		JLabel lblR = new JLabel("R");
		lblR.setForeground(Color.WHITE);
		lblR.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblR.setBounds(25, 347, 108, 25);
		panelHabilidades.add(lblR);

		JLabel lblE = new JLabel("E");
		lblE.setForeground(Color.WHITE);
		lblE.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblE.setBounds(25, 396, 108, 25);
		panelHabilidades.add(lblE);

		textFieldRChamp = new JTextField();
		textFieldRChamp.setToolTipText("Leave it in blank for no filter");
		textFieldRChamp.setForeground(Color.WHITE);
		textFieldRChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldRChamp.setColumns(10);
		textFieldRChamp.setBackground(Color.BLACK);
		textFieldRChamp.setBounds(169, 350, 202, 26);
		panelHabilidades.add(textFieldRChamp);

		textFieldEChamp = new JTextField();
		textFieldEChamp.setToolTipText("Leave it in blank for no filter");
		textFieldEChamp.setForeground(Color.WHITE);
		textFieldEChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldEChamp.setColumns(10);
		textFieldEChamp.setBackground(Color.BLACK);
		textFieldEChamp.setBounds(169, 399, 202, 26);
		panelHabilidades.add(textFieldEChamp);

		comboBoxPosition = new JComboBox();
		comboBoxPosition.setModel(new DefaultComboBoxModel(new String[] { "TOP", "JNG", "MID", "ADC", "SUP" }));
		comboBoxPosition.setBounds(169, 57, 202, 27);
		comboBoxPosition.setSelectedIndex(-1);
		panelHabilidades.add(comboBoxPosition);

		buttonChampAdd = new JButton("ADD");
		buttonChampAdd.setForeground(new Color(255, 255, 255));
		buttonChampAdd.setBackground(new Color(0, 128, 128));
		buttonChampAdd.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		buttonChampAdd.setBounds(271, 461, 85, 25);
		buttonChampAdd.addActionListener(this);
		buttonChampAdd.setVisible(false);
		panelHabilidades.add(buttonChampAdd);

		btnModifyChamp = new JButton("MODIFY");
		btnModifyChamp.setForeground(new Color(255, 255, 255));
		btnModifyChamp.setBackground(new Color(0, 128, 128));
		btnModifyChamp.setVerticalAlignment(SwingConstants.TOP);
		btnModifyChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnModifyChamp.setBounds(271, 462, 100, 25);
		btnModifyChamp.addActionListener(this);
		btnModifyChamp.setVisible(false);
		panelHabilidades.add(btnModifyChamp);

		btnCancelChamp = new JButton("CANCEL");
		btnCancelChamp.setForeground(Color.WHITE);
		btnCancelChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnCancelChamp.setBackground(new Color(0, 128, 128));
		btnCancelChamp.setBounds(25, 461, 131, 25);
		btnCancelChamp.addActionListener(this);
		panelHabilidades.add(btnCancelChamp);

		panelAddModifyChamp = new JPanel();
		panelAddModifyChamp.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(184, 134, 11), null));
		panelAddModifyChamp.setBackground(new Color(0, 0, 0, 180));
		panelAddModifyChamp.setBounds(59, 28, 1059, 566);
		champAdmin.add(panelAddModifyChamp);
		panelAddModifyChamp.setLayout(null);

		JLabel lblNewLabel_16 = new JLabel("MODIFY OR ADD CHAMPS");
		lblNewLabel_16.setForeground(new Color(0, 128, 128));
		lblNewLabel_16.setBackground(new Color(0, 128, 128));
		lblNewLabel_16.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblNewLabel_16.setBounds(109, 188, 311, 31);
		panelAddModifyChamp.add(lblNewLabel_16);

		JLabel lblChamps_2_1 = new JLabel("CHAMPS");
		lblChamps_2_1.setBounds(231, 24, 286, 83);
		panelAddModifyChamp.add(lblChamps_2_1);
		lblChamps_2_1.setForeground(new Color(218, 165, 32));
		lblChamps_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 69));

		JLabel lblChamps_2 = new JLabel("CHAMPS");
		lblChamps_2.setBounds(229, 24, 328, 83);
		panelAddModifyChamp.add(lblChamps_2);
		lblChamps_2.setForeground(new Color(0, 139, 139));
		lblChamps_2.setFont(new Font("Bahnschrift", Font.BOLD, 69));

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lolLogo (2).png")));
		lblNewLabel_4.setBounds(10, 10, 64, 64);
		panelAddModifyChamp.add(lblNewLabel_4);

		textFieldChampName = new JTextField();
		textFieldChampName.setBounds(251, 255, 202, 26);
		panelAddModifyChamp.add(textFieldChampName);
		textFieldChampName.setToolTipText("Champ's name");
		textFieldChampName.setForeground(Color.WHITE);
		textFieldChampName.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldChampName.setColumns(10);
		textFieldChampName.setBackground(Color.BLACK);
		textFieldChampName.addActionListener(this);
		textFieldChampName.addFocusListener(this);

		JLabel lblNewLabel_4_1_1 = new JLabel("CHAMP");
		lblNewLabel_4_1_1.setForeground(new Color(218, 165, 32));
		lblNewLabel_4_1_1.setFont(new Font("Bahnschrift", Font.PLAIN, 41));
		lblNewLabel_4_1_1.setBounds(35, 243, 242, 61);
		panelAddModifyChamp.add(lblNewLabel_4_1_1);

		buttonChampsAdmin_Check = new JButton("SEARCH");
		buttonChampsAdmin_Check.setForeground(new Color(255, 255, 255));
		buttonChampsAdmin_Check.setBackground(new Color(0, 128, 128));
		buttonChampsAdmin_Check.setBounds(181, 316, 131, 25);
		panelAddModifyChamp.add(buttonChampsAdmin_Check);
		buttonChampsAdmin_Check.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		buttonChampsAdmin_Check.addActionListener(this);
		buttonChampsAdmin_Check.setEnabled(false);

		JLabel fondoPictureChampsAdmin = new JLabel("");
		fondoPictureChampsAdmin.setBackground(new Color(0, 0, 0));
		fondoPictureChampsAdmin.setBounds(-283, -144, 1655, 837);
		fondoPictureChampsAdmin.setIcon(new ImageIcon(MainWindow.class.getResource("/img/LOL_PROMOART_14.jpg")));
		champAdmin.add(fondoPictureChampsAdmin);

		JPanel game = new JPanel();
		tabbedPane.addTab("GAME", null, game, null);
		game.setLayout(null);

		JLayeredPane addGamePanel = new JLayeredPane();
		addGamePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		addGamePanel.setBounds(122, 103, 419, 148);
		game.add(addGamePanel);
		addGamePanel.setLayout(null);

		btnAddGame = new JButton("ADD");
		btnAddGame.setForeground(new Color(255, 255, 255));
		btnAddGame.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnAddGame.setBackground(new Color(0, 128, 128));
		btnAddGame.setBounds(85, 111, 85, 27);
		btnAddGame.addActionListener(this);

		textNicknameGame = new JTextField();
		textNicknameGame.setForeground(new Color(255, 255, 255));
		textNicknameGame.setBackground(new Color(0, 0, 0));
		textNicknameGame.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameGame.setBounds(85, 48, 198, 27);
		addGamePanel.add(textNicknameGame);
		textNicknameGame.setColumns(10);
		addGamePanel.add(btnAddGame);

		JLabel lblNewLabel_14 = new JLabel("NEW GAME?");
		lblNewLabel_14.setForeground(new Color(0, 128, 128));
		lblNewLabel_14.setBackground(new Color(0, 128, 128));
		lblNewLabel_14.setFont(new Font("Bahnschrift", Font.PLAIN, 20));
		lblNewLabel_14.setBounds(130, 13, 132, 25);
		addGamePanel.add(lblNewLabel_14);

		btnUpdateGame = new JButton("UPDATE");
		btnUpdateGame.setForeground(new Color(255, 255, 255));
		btnUpdateGame.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnUpdateGame.setBackground(new Color(0, 128, 128));
		btnUpdateGame.setBounds(225, 111, 106, 27);
		btnUpdateGame.addActionListener(this);
		addGamePanel.add(btnUpdateGame);

		JLabel lblGame_1 = new JLabel("GAME");
		lblGame_1.setForeground(new Color(0, 139, 139));
		lblGame_1.setFont(new Font("Bahnschrift", Font.BOLD, 70));
		lblGame_1.setBounds(457, 30, 214, 89);
		game.add(lblGame_1);

		JLabel lblGame = new JLabel("GAME");
		lblGame.setForeground(new Color(218, 165, 32));
		lblGame.setFont(new Font("Bahnschrift", Font.BOLD, 69));
		lblGame.setBounds(455, 32, 286, 83);
		game.add(lblGame);

		JScrollPane scrollPaneGame = new JScrollPane();
		scrollPaneGame.setBounds(52, 270, 670, 307);
		game.add(scrollPaneGame);

		games = new JTable();
		games.addMouseListener(this);
		modelGame = new DefaultTableModel();
		games.setModel(modelGame);
		modelGame.addColumn("ID");
		modelGame.addColumn("Date");
		modelGame.addColumn("Duration");
		scrollPaneGame.setViewportView(games);

		calendar = new JCalendar();
		calendar.setBounds(730, 151, 367, 367);
		calendar.setEnabled(false);
		game.add(calendar);

		JPanel panelFondoGame = new JPanel();
		panelFondoGame.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(184, 134, 11), null));
		panelFondoGame.setBackground(new Color(0, 0, 0, 180));
		panelFondoGame.setBounds(42, 32, 1059, 553);
		game.add(panelFondoGame);
		panelFondoGame.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("");
		lblNewLabel_15.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lolLogo (2).png")));
		lblNewLabel_15.setBounds(10, 10, 64, 64);
		panelFondoGame.add(lblNewLabel_15);

		JLabel fondoPictureGame = new JLabel("");
		fondoPictureGame.setIcon(new ImageIcon(MainWindow.class.getResource("/img/LOL_PROMOART_14.jpg")));
		fondoPictureGame.setBounds(-100, 0, 1280, 647);
		game.add(fondoPictureGame);

		JPanel stadistics = new JPanel();
		tabbedPane.addTab("STADISTICS", null, stadistics, null);
		stadistics.setLayout(null);

		JPanel panelStadistics = new JPanel();
		panelStadistics.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		panelStadistics.setBackground(new Color(0, 0, 0, 180));
		panelStadistics.setBounds(59, 37, 1059, 553);
		stadistics.add(panelStadistics);
		panelStadistics.setLayout(null);

		JLabel lblStadistics = new JLabel("STADISTICS");
		lblStadistics.setBounds(295, 10, 495, 83);
		lblStadistics.setForeground(new Color(0, 139, 139));
		lblStadistics.setFont(new Font("Bahnschrift", Font.BOLD, 69));
		panelStadistics.add(lblStadistics);

		JLabel lblStadistics_1 = new JLabel("STADISTICS");
		lblStadistics_1.setForeground(new Color(218, 165, 32));
		lblStadistics_1.setFont(new Font("Bahnschrift", Font.BOLD, 69));
		lblStadistics_1.setBounds(292, 10, 495, 83);
		panelStadistics.add(lblStadistics_1);

		JLabel labelChampsAdmin_Name = new JLabel("NICKNAME");
		labelChampsAdmin_Name.setForeground(new Color(218, 165, 32));
		labelChampsAdmin_Name.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		labelChampsAdmin_Name.setBounds(87, 141, 341, 83);
		panelStadistics.add(labelChampsAdmin_Name);

		btnUpdateStats = new JButton("UPDATE");
		btnUpdateStats.setForeground(new Color(255, 255, 255));
		btnUpdateStats.setBackground(new Color(0, 128, 128));
		btnUpdateStats.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnUpdateStats.setBounds(102, 326, 105, 30);
		btnUpdateStats.addActionListener(this);
		panelStadistics.add(btnUpdateStats);

		btnShowTopPlayers = new JButton("TOP 5 PLAYERS");
		btnShowTopPlayers.setForeground(new Color(255, 255, 255));
		btnShowTopPlayers.setBackground(new Color(0, 128, 128));
		btnShowTopPlayers.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnShowTopPlayers.setBounds(260, 326, 155, 30);
		btnShowTopPlayers.addActionListener(this);
		panelStadistics.add(btnShowTopPlayers);

		scrollPaneStats = new JScrollPane();
		scrollPaneStats.setBounds(528, 85, 501, 421);
		panelStadistics.add(scrollPaneStats);


		modelStats = new DefaultTableModel();
		modelStats.addColumn("ID");
		modelStats.addColumn("Nickname");
		modelStats.addColumn("Name");
		modelStats.addColumn("Position");
		modelStats.addColumn("Win/Lose");
		stats = new JTable();
		stats.setModel(modelStats);
		scrollPaneStats.setViewportView(stats);

		modelTopPlayers = new DefaultTableModel();
		modelTopPlayers.addColumn("Nickname");
		modelTopPlayers.addColumn("Total");
		modelTopPlayers.addColumn("Wins");
		modelTopPlayers.addColumn("Winrate");
		modelTopPlayers.addColumn("Fav Champ");
		modelTopPlayers.addColumn("Fav Position");
		statsTopPlayers = new JTable();
		statsTopPlayers.setBounds(528, 85, 501, 421);
		statsTopPlayers.getTableHeader().setBackground(new Color(212, 175, 55));
		statsTopPlayers.setModel(modelTopPlayers);


		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lolLogo (2).png")));
		lblNewLabel_5.setBounds(10, 10, 64, 64);
		panelStadistics.add(lblNewLabel_5);

		JLabel labelChampsAdmin_Name_1 = new JLabel("NICKNAME");
		labelChampsAdmin_Name_1.setForeground(new Color(0, 139, 139));
		labelChampsAdmin_Name_1.setFont(new Font("Bahnschrift", Font.PLAIN, 60));
		labelChampsAdmin_Name_1.setBounds(90, 141, 341, 83);
		panelStadistics.add(labelChampsAdmin_Name_1);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(218, 165, 32));
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(455, 129, 3, 320);
		panelStadistics.add(separator_1);

		textNicknameStats = new JTextField();
		textNicknameStats.setToolTipText("");
		textNicknameStats.setText((String) null);
		textNicknameStats.setForeground(Color.WHITE);
		textNicknameStats.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameStats.setColumns(10);
		textNicknameStats.setBackground(Color.BLACK);
		textNicknameStats.setBounds(134, 244, 199, 27);
		panelStadistics.add(textNicknameStats);

		JLabel fondoPictureManagement = new JLabel("");
		fondoPictureManagement.setIcon(new ImageIcon(MainWindow.class.getResource("/img/LOL_PROMOART_14.jpg")));
		fondoPictureManagement.setBounds(-104, 0, 1312, 619);
		stadistics.add(fondoPictureManagement);

		JPanel management = new JPanel();
		management.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabbedPane.addTab("MANAGEMENT", null, management, null);

		lblPassEyeAddAdmin = new JLabel("");
		lblPassEyeAddAdmin.setBounds(491, 247, 30, 24);
		lblPassEyeAddAdmin.setIcon(
				new ImageIcon(MainWindow.class.getResource("/img/1200px-OOjs_UI_icon_eye-progressive.svg.png")));
		lblPassEyeAddAdmin.addMouseListener(this);
		management.setLayout(null);

		deletePlayerManagement = new JLayeredPane();
		deletePlayerManagement.setBounds(593, 104, 513, 491);
		management.add(deletePlayerManagement);
		deletePlayerManagement.setLayout(null);

		btnDeletePlayerManagement = new JButton("DELETE");
		btnDeletePlayerManagement.setForeground(new Color(255, 255, 255));
		btnDeletePlayerManagement.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnDeletePlayerManagement.setBackground(new Color(0, 128, 128));
		btnDeletePlayerManagement.setBounds(190, 463, 106, 27);
		btnDeletePlayerManagement.addActionListener(this);
		deletePlayerManagement.add(btnDeletePlayerManagement);

		textAreaDeletePlayer = new JTextArea();
		textAreaDeletePlayer.setForeground(Color.WHITE);
		textAreaDeletePlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		textAreaDeletePlayer.setBackground(Color.BLACK);
		textAreaDeletePlayer.setBounds(85, 363, 313, 94);
		deletePlayerManagement.add(textAreaDeletePlayer);
		textAreaDeletePlayer.setVisible(false);

		comboBoxSelectUser = new JComboBox();
		comboBoxSelectUser.setBounds(140, 332, 199, 21);
		deletePlayerManagement.add(comboBoxSelectUser);
		
		btnR = new JButton("REPORTS");
		btnR.setForeground(Color.WHITE);
		btnR.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnR.setBackground(new Color(0, 128, 128));
		btnR.setBounds(36, 463, 106, 27);
		btnR.addActionListener(this);
		deletePlayerManagement.add(btnR);
		
		btnResolve = new JButton("RESOLVE");
		btnResolve.setForeground(Color.WHITE);
		btnResolve.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnResolve.setBackground(new Color(0, 128, 128));
		btnResolve.setBounds(350, 463, 106, 27);
		btnResolve.addActionListener(this);
		deletePlayerManagement.add(btnResolve);
		btnResolve.setEnabled(false);
		
		scrollPaneReports = new JScrollPane();
		scrollPaneReports.setBounds(15, 41, 481, 281);
		deletePlayerManagement.add(scrollPaneReports);
		management.add(lblPassEyeAddAdmin);

		JLabel passwordAddAmin = new JLabel("PASSWORD");
		passwordAddAmin.setBounds(125, 247, 158, 21);
		passwordAddAmin.setForeground(Color.WHITE);
		passwordAddAmin.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		management.add(passwordAddAmin);

		passwordFieldAddAdmin = new JPasswordField();
		passwordFieldAddAdmin.setBounds(272, 244, 199, 27);
		passwordFieldAddAdmin.setForeground(new Color(255, 255, 255));
		passwordFieldAddAdmin.setBackground(new Color(0, 0, 0));
		passwordFieldAddAdmin.setText((String) null);
		passwordFieldAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		passwordFieldAddAdmin.setEchoChar('·');
		passwordFieldAddAdmin.addFocusListener(this);
		management.add(passwordFieldAddAdmin);
		JLabel lblName = new JLabel("NAME");
		lblName.setBounds(128, 187, 95, 21);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		management.add(lblName);

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(125, 309, 95, 21);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		management.add(lblEmail);

		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setBounds(125, 374, 95, 21);
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		management.add(lblPhone);

		JLabel lblBirthDay = new JLabel("BIRTHDATE");
		lblBirthDay.setBounds(125, 432, 158, 21);
		lblBirthDay.setForeground(Color.WHITE);
		lblBirthDay.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		management.add(lblBirthDay);

		JLabel lblNationality = new JLabel("NATIONALITY");
		lblNationality.setBounds(125, 485, 193, 21);
		lblNationality.setForeground(Color.WHITE);
		lblNationality.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		management.add(lblNationality);

		textFieldPhoneAddAdmin = new JTextField();
		textFieldPhoneAddAdmin.setBounds(272, 371, 199, 27);
		textFieldPhoneAddAdmin.setForeground(new Color(255, 255, 255));
		textFieldPhoneAddAdmin.setBackground(new Color(0, 0, 0));
		textFieldPhoneAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldPhoneAddAdmin.addFocusListener(this);
		management.add(textFieldPhoneAddAdmin);
		textFieldPhoneAddAdmin.setColumns(10);

		textFieldMailAddAdmin = new JTextField();
		textFieldMailAddAdmin.setBounds(272, 308, 199, 27);
		textFieldMailAddAdmin.setBackground(new Color(0, 0, 0));
		textFieldMailAddAdmin.setForeground(new Color(255, 255, 255));
		textFieldMailAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldMailAddAdmin.setColumns(10);
		textFieldMailAddAdmin.addFocusListener(this);
		management.add(textFieldMailAddAdmin);

		textFieldNameAddAdmin = new JTextField();
		textFieldNameAddAdmin.setBounds(272, 184, 199, 27);
		textFieldNameAddAdmin.setForeground(new Color(255, 255, 255));
		textFieldNameAddAdmin.setBackground(new Color(0, 0, 0));
		textFieldNameAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldNameAddAdmin.setColumns(10);
		textFieldNameAddAdmin.addFocusListener(this);
		management.add(textFieldNameAddAdmin);

		JLabel titleBlueAdmin = new JLabel("MANAGEMENT");
		titleBlueAdmin.setBounds(346, 41, 531, 89);
		titleBlueAdmin.setForeground(new Color(0, 139, 139));
		titleBlueAdmin.setFont(new Font("Bahnschrift", Font.BOLD, 70));
		management.add(titleBlueAdmin);

		JLabel titleYellowAdmin = new JLabel("MANAGEMENT");
		titleYellowAdmin.setBounds(343, 41, 513, 89);
		titleYellowAdmin.setForeground(new Color(218, 165, 32));
		titleYellowAdmin.setFont(new Font("Bahnschrift", Font.BOLD, 70));
		management.add(titleYellowAdmin);

		JLabel iconAdmin = new JLabel("");
		iconAdmin.setBounds(96, 41, 64, 64);
		iconAdmin.setIcon(new ImageIcon(MainWindow.class.getResource("/img/lolLogo (2).png")));
		management.add(iconAdmin);

		JLabel personalDataProfile_1_2_2 = new JLabel("ADD ADMINISTRATOR");
		personalDataProfile_1_2_2.setBounds(196, 98, 365, 89);
		personalDataProfile_1_2_2.setForeground(new Color(0, 139, 139));
		personalDataProfile_1_2_2.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		management.add(personalDataProfile_1_2_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(559, 125, 12, 418);
		separator.setBackground(new Color(218, 165, 32));
		separator.setOrientation(SwingConstants.VERTICAL);
		management.add(separator);

		calendarAddAdmin = new JDateChooser();
		calendarAddAdmin.setBounds(268, 432, 203, 19);
		management.add(calendarAddAdmin);

		comboBoxAddAdmin = new JComboBox();
		comboBoxAddAdmin.setBounds(272, 485, 205, 21);
		comboBoxAddAdmin.setModel(new DefaultComboBoxModel(new String[] { "Afghan", "Albanian", "Algerian", "American",
				"Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian", "Azerbaijani",
				"Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian",
				"Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian", "British", "Bruneian",
				"Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian",
				"Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese",
				"Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican", "Dutch",
				"East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean", "Estonian",
				"Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian", "German",
				"Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese", "Haitian",
				"Herzegovinian", "Honduran", "Hungarian", "I-Kiribati", "Icelander", "Indian", "Indonesian", "Iranian",
				"Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani",
				"Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian",
				"Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy", "Malawian",
				"Malaysian", "Maldivian", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican",
				"Micronesian", "Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana", "Mozambican",
				"Namibian", "Nauruan", "Nepalese", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerian", "Nigerien",
				"North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan", "Panamanian",
				"Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari", "Romanian", "Russian",
				"Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean", "Saudi", "Scottish",
				"Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean", "Slovakian", "Slovenian",
				"Solomon Islander", "Somali", "South African", "South Korean", "Spanish", "Sri Lankan", "Sudanese",
				"Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik", "Tanzanian", "Thai",
				"Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan", "Ugandan",
				"Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh", "Yemenite", "Zambian",
				"Zimbabwean" }));
		comboBoxAddAdmin.setSelectedIndex(-1);
		management.add(comboBoxAddAdmin);

		JLabel personalDataProfile_1_2_2_1 = new JLabel("MANAGE PLAYERS");
		personalDataProfile_1_2_2_1.setBounds(735, 83, 274, 89);
		personalDataProfile_1_2_2_1.setForeground(new Color(0, 139, 139));
		personalDataProfile_1_2_2_1.setFont(new Font("Bahnschrift", Font.BOLD, 28));
		management.add(personalDataProfile_1_2_2_1);

		btnSendAddAdmin = new JButton("SEND");
		btnSendAddAdmin.setForeground(new Color(255, 255, 255));
		btnSendAddAdmin.setBounds(317, 527, 85, 27);
		btnSendAddAdmin.setBackground(new Color(0, 128, 128));
		btnSendAddAdmin.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnSendAddAdmin.addActionListener(this);
		management.add(btnSendAddAdmin);

		JPanel panelTransparenteManagement = new JPanel();
		panelTransparenteManagement.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(184, 134, 11), null));
		panelTransparenteManagement.setBackground(new Color(0, 0, 0, 180));
		panelTransparenteManagement.setBounds(44, 25, 1071, 581);
		management.add(panelTransparenteManagement);

		JLabel pictureFondoManagement = new JLabel("");
		pictureFondoManagement.setBounds(-129, 0, 1325, 738);
		pictureFondoManagement.setIcon(new ImageIcon(MainWindow.class.getResource("/img/LOL_PROMOART_14.jpg")));
		management.add(pictureFondoManagement);

		reportPanel = new JPanel();
		reportPanel.setBounds(464, 127, 357, 396);
		panelTransparenteProfile.add(reportPanel);
		reportPanel.setLayout(null);
		reportPanel.setForeground(Color.BLACK);
		reportPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		reportPanel.setBackground(new Color(0, 0, 0, 180));
		
		JLabel reportUserLabel = new JLabel("REPORT A USER");
		reportUserLabel.setForeground(new Color(0, 139, 139));
		reportUserLabel.setFont(new Font("Bahnschrift", Font.BOLD, 34));
		reportUserLabel.setBounds(47, 0, 267, 83);
		reportPanel.add(reportUserLabel);
		
		JLabel reportNicknameLabel = new JLabel("Nickname :");
		reportNicknameLabel.setForeground(Color.WHITE);
		reportNicknameLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		reportNicknameLabel.setBounds(23, 87, 133, 21);
		reportPanel.add(reportNicknameLabel);
		
		JLabel categoryLabel = new JLabel("Category :");
		categoryLabel.setForeground(Color.WHITE);
		categoryLabel.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		categoryLabel.setBounds(23, 141, 126, 21);
		reportPanel.add(categoryLabel);
		
		JComboBox comboBoxReport = new JComboBox();
		comboBoxReport.setBounds(166, 86, 148, 22);
		reportPanel.add(comboBoxReport);
		
		JComboBox comboBoxReport_1 = new JComboBox();
		comboBoxReport_1.setBounds(166, 140, 148, 22);
		reportPanel.add(comboBoxReport_1);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setFont(new Font("Bahnschrift", Font.BOLD, 20));
		lblDescription.setBounds(109, 181, 126, 21);
		reportPanel.add(lblDescription);
		
		btnReport = new JButton("Report");
		btnReport.setForeground(Color.WHITE);
		btnReport.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnReport.setBackground(new Color(0, 128, 128));
		btnReport.setBounds(130, 355, 92, 26);
		btnReport.addActionListener(this);
		reportPanel.add(btnReport);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setBounds(68, 213, 244, 131);
		reportPanel.add(textArea);

		try {
			cargarUsers();
		} catch (PersonalizedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "An unexpected error has occured!",
					JOptionPane.ERROR_MESSAGE);
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

	// Setters & Getters
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// -----------------------Methods for tab Profile----------------------------

	//
	public void loadUser() {
		String password = new String(passwordFieldProfile.getPassword());
		user.setName(textFieldNameProfile.getText());
		user.setNationality((String) comboBoxNationalityProfile.getSelectedItem());
		user.setEmail(textFieldEmailProfile.getText());
		user.setPassword(password);
		user.setPhone(textFieldPhoneProfile.getText());
		LocalDate date = jCalendarProfile.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		user.setBirthDate(date);
		if (user instanceof Player) {
			((Player) user).setNickname(textFieldNicknameProfile.getText());
		} else {
			textFieldNicknameProfile.setVisible(false);
			LocalDate dateStart = dateChooser_1.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
			((Administrator) user).setStartDate(dateStart);
			((Administrator) user).setAddtions(Integer.parseInt(textFieldAdditionsProfile.getText()));

		}
	}

	// Load the information of the user in the tab profile
	public void loadData(UserControllable userControllable) {
		textFieldNameProfile.setText(user.getName());
		textFieldEmailProfile.setText(user.getEmail());
		jCalendarProfile.setDate(Date.valueOf(user.getBirthDate()));
		textFieldPhoneProfile.setText(user.getPhone());
		comboBoxNationalityProfile.setSelectedItem(user.getNationality());
		passwordFieldProfile.setText(user.getPassword());

		if (user instanceof Player) {
			textFieldNicknameProfile.setText(((Player) user).getNickname());
			// Panel with the admin information isn't visible
			panelAdmin.setVisible(false);
			btnDeletePlayer.setVisible(true);
			reportPanel.setVisible(true);
		} else {
			reportPanel.setVisible(false);
			textFieldNicknameProfile.setVisible(false);
			btnDeletePlayer.setVisible(false);
			nicknameProfile.setVisible(false);
			textFieldAdditionsProfile.setText(String.valueOf(((Administrator) user).getAddtions()));
			dateChooser_1.setDate(Date.valueOf(((Administrator) user).getStartDate()));
		}
	}

	// Clear method to set all the fields with no information.
	public void clear() {

		jCalendarProfile.setDefaultLocale(getLocale());
		textFieldEmailProfile.setText("");
		textFieldNameProfile.setText("");
		passwordFieldProfile.setText("");
		textFieldNicknameProfile.setText("");
		textFieldPhoneProfile.setText("");
		comboBoxNationalityProfile.setSelectedIndex(-1);
	}

	// Modify player method
	public void modifyPlayer(UserControllable userControllable) throws PersonalizedException {
		boolean found = false;
		int con = 2;
		// If the user is instance as player we use the original nickname saved before
		if (user instanceof Administrator) {
			con = 0;
		}
		// We check if the fields are modified
		if (user instanceof Player) {
			if (!((Player) user).getNickname().equals(textFieldNicknameProfile.getText())) {
				if (!checkPlayer()) {
					found = true;
				}
			}
		}
		if (!found) {
			loadUser();
			if (userControllable.modifyUser(user, con)) {
				JOptionPane.showMessageDialog(this, "PERSONAL DATA MODIFIED");
			} else {
				JOptionPane.showMessageDialog(this, "NO MODIFICATION");
			}
		} else {
			JOptionPane.showMessageDialog(this, "NO MODIFICATION");
		}
	}

	// Delete player method
	public void deletePlayer(UserControllable userControllable) throws PersonalizedException {
		int chooseConnection;
		boolean correct = false;
		int aceptar;
		User user = null;
		// Find the user
		user = userControllable.findUser(textFieldNicknameProfile.getText(), 1);
		// Show a confirmation dialog
		aceptar = JOptionPane.showConfirmDialog(this, "WARNING: do you want to delete your account?");
		// Yes --> 0 so If the user accepts the message, his account will be deleted.
		if (aceptar == 0) {
			if (userDel instanceof Player)
				chooseConnection = 2;
			else
				chooseConnection = 0;
			correct = userControllable.delete(user, chooseConnection);
			clear();
		}
		if (correct) {
			JOptionPane.showMessageDialog(this, "USER DELETE");
		} else {
			JOptionPane.showMessageDialog(this, "USER NO DELETE");
		}
	}

	// --------------------Methods for tab Champ(User)-------------------------

	// Method to list champs on a table
	public void listChampPlayer() throws PersonalizedException {
		if (checkBoxChampsPlayer.isSelected() || checkBoxChampsPlayer_Filtered.isSelected()) {

			List<Champ> list = null;
			if (checkBoxChampsPlayer.isSelected()) {
				// Get an array of all champs
				list = champEditable.listChamp();
				textFieldChampPlayer_Region.setText("");
				textFieldChampPlayer_Position.setText("");
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

	// Method to create a table with the champs
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

		String[] columnNames = { "Name", "Region", "Passive", "Position", "Q", "W", "E", "R" };
		champs = new JTable(data, columnNames);
		if (scrollPaneChampPlayer == null) {
			scrollPaneChampPlayer = new JScrollPane();
			scrollPaneChampPlayer.setBounds(190, 355, 684, 100);
		}
		champsPlayer.add(scrollPaneChampPlayer);
		scrollPaneChampPlayer.setViewportView(champs);

		JTableHeader tableHeaderChampPlayer = champs.getTableHeader();
		tableHeaderChampPlayer.setBackground(new Color(212, 175, 55));
	}

	// ------------------Methods for tab Champ(Admin)-------------------------

	// Method to check if the champ is already in the database
	public void checkChampAdmin() throws PersonalizedException {
		if (textFieldChampName.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Add a valid name", "Alert", JOptionPane.WARNING_MESSAGE);
		else
			addOrModifyChamp();
	}

	// Method to show the design of the tab to add or modify a champ
	public void addOrModifyChamp() throws PersonalizedException {

		Champ champ = champEditable.checkChampName(textFieldChampName.getText());
		textFieldChampName.setEditable(false);
		panelHabilidades.setVisible(true);
		if (champ.getName() == null) {
			buttonChampAdd.setVisible(true);
			btnModifyChamp.setVisible(false);
		} else {
			btnModifyChamp.setVisible(true);
			buttonChampAdd.setVisible(false);
			modifyChampAdmin(champ);
		}
		btnCancelChamp.setVisible(true);
	}

	// Method to add champ
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

	// Method that shows the current info of the champ that will be modified
	public void modifyChampAdmin(Champ champ) {
		textFieldChampName.setText(champ.getName());
		comboBoxPosition.setSelectedItem(champ.getPosition());
		textFieldRegionChamp.setText(champ.getRegion());
		textFieldPassiveChamp.setText(champ.getPassive());
		textFieldQChamp.setText(champ.getQ());
		textFieldWChamp.setText(champ.getW());
		textFieldEChamp.setText(champ.getE());
		textFieldRChamp.setText(champ.getR());

	}

	// Removes all the current design of the tab so it can start over with a new
	// champ
	public void removeChampAdminTab() {
		textFieldChampName.setText("");
		comboBoxPosition.setSelectedIndex(-1);
		textFieldRegionChamp.setText("");
		textFieldPassiveChamp.setText("");
		textFieldQChamp.setText("");
		textFieldWChamp.setText("");
		textFieldEChamp.setText("");
		textFieldRChamp.setText("");
		panelHabilidades.setVisible(false);
		textFieldChampName.setEditable(true);
		textFieldChampName.setText("");
	}

	// Executes the modification of the champ
	public void executeModificationChampAdmin() throws PersonalizedException {
		Champ champ = new Champ();
		if (checkFieldsChampAdmin() != false) {
			champ = fillChamp(champ);
			if (champEditable.modifyChamp(champ)) {
				JOptionPane.showMessageDialog(null, "Champ modified successfully", "Alert",
						JOptionPane.INFORMATION_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "Champ couldn't be modified", "Alert", JOptionPane.WARNING_MESSAGE);
			removeChampAdminTab();
		}
	}

	// Method that loads the champ with the current info on the tab
	public Champ fillChamp(Champ champ) {
		champ.setName(textFieldChampName.getText());
		champ.setPosition(comboBoxPosition.getSelectedItem().toString());
		champ.setRegion(textFieldRegionChamp.getText());
		champ.setPassive(textFieldPassiveChamp.getText());
		champ.setQ(textFieldQChamp.getText());
		champ.setW(textFieldWChamp.getText());
		champ.setE(textFieldEChamp.getText());
		champ.setR(textFieldRChamp.getText());

		return (champ);
	}

	// -----------------------Methods for tab Game----------------------------
	// NOTE: There is a button that creates the JDialog addGame, to see it go to the
	// actionPerformed method
	// This method is to update the table of the tab Game
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
			JOptionPane.showMessageDialog(this, "Insert a nickname");
		}
	}

	// -----------------------Methods for tab Stadistics----------------------------
	// This method is to update the table of the tab Stadistics
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
			JOptionPane.showMessageDialog(this, "Insert a nickname");
		}
	}

	public void showTopPlayers() throws PersonalizedException {
		try {
			modelTopPlayers.setRowCount(0);
			Set<TopPlayers> listStats;
			listStats = statable.topPlayers();
			for (TopPlayers topPlayers : listStats) {
				Object[] row = new Object[6];
				row[0] = topPlayers.getNickname();
				row[1] = topPlayers.getTotalPlays();
				row[2] = topPlayers.getWins();
				row[3] = topPlayers.getWinRate();
				row[4] = topPlayers.getName();
				row[5] = topPlayers.getPosition();
				modelTopPlayers.addRow(row);
			}
		} catch (PersonalizedException e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	// -----------------------Methods for tab Management----------------------------
	// This method is to load the user that will be added
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

			userControllable.addUser(user, 0);

			JOptionPane.showMessageDialog(getParent(), "Successfully sent.");
			textFieldNameAddAdmin.setText("");
			passwordFieldAddAdmin.setText("");
			textFieldMailAddAdmin.setText("");
			textFieldPhoneAddAdmin.setText("");
			comboBoxAddAdmin.setSelectedIndex(-1);
			calendarAddAdmin.setDate(null);

		} else {
			JOptionPane.showMessageDialog(this, "ERROR. Fill in all fields.");
		}
	}

	// This method makes an Admin delete a Player
	private void deletePlayerAdmin() throws PersonalizedException {
		// TODO Auto-generated method stub
		int chooseConnection;
		int option;
		if (comboBoxSelectUser.getSelectedIndex() != -1) {
			try {
				userDel = userControllable.findUser(comboBoxSelectUser.getSelectedItem().toString(), 1);
			} catch (PersonalizedException e) {
				// TODO Auto-generated catch block

				e.getMessage();
			}
			textAreaDeletePlayer.append("ID: " + userDel.getId() + "\nNickname: " + ((Player) userDel).getNickname()
					+ "\nName: " + userDel.getName() + "\nEmail: " + userDel.getEmail() + "\n");
			textAreaDeletePlayer.setVisible(true);
			option = JOptionPane.showConfirmDialog(this, "Do you want to delete " + userDel.getName() + "?");
			if (option == 0) {
				if (userDel instanceof Player)
					chooseConnection = 2;
				else
					chooseConnection = 0;
				userControllable.delete(userDel, chooseConnection);
				JOptionPane.showMessageDialog(this, userDel.getName() + " eliminado correctamente.");
				cargarUsers();
			}
		} else {
			JOptionPane.showMessageDialog(this, "ERROR. Fill in all fields.");
		}
		comboBoxSelectUser.setSelectedIndex(-1);
		textAreaDeletePlayer.setText("");
		textAreaDeletePlayer.setVisible(false);
	}

	// This methods adds current Users to a comboBox so the Admin can choose
	private void cargarUsers() throws PersonalizedException {
		Set<User> users = userControllable.listPlayers();
		comboBoxSelectUser.removeAllItems();
		for (User u : users) {
			comboBoxSelectUser.addItem(((Player) u).getNickname());
		}
		comboBoxSelectUser.setSelectedIndex(-1);
	}

	private void listReports() throws PersonalizedException {
		try {
			Set<Report> reports = userControllable.listReports();
			String[][] data = null;
			data = new String[reports.size()][];
			int i = 0;
			for (Report report : reports) {
				data[i] = new String[] {String.valueOf(report.getId()), report.getReportedNickname(), report.getCategory(), report.getDescription(),
						report.getComplainantNickname()};
				i++;
			}
			String[] columnNames = { "Id", "Reported", "Category", "Description", "Complainant" };
			tableReports = new JTable(data, columnNames);
	
			TableColumn column = tableReports.getColumnModel().getColumn(3);
			column.setPreferredWidth(300); 
			column = tableReports.getColumnModel().getColumn(4);
			column.setPreferredWidth(90);
			column = tableReports.getColumnModel().getColumn(2);
			column.setPreferredWidth(90);
			column = tableReports.getColumnModel().getColumn(0);
			column.setPreferredWidth(45);
	
			scrollPaneReports.setViewportView(tableReports);
	
			JTableHeader tableHeaderReports = tableReports.getTableHeader();
			tableHeaderReports.setBackground(new Color(212, 175, 55));
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	private void resolveReport() throws PersonalizedException {
		try {
			Boolean correct = false;
			if (tableReports.getSelectedRow() != -1) {
				//Ask i a message dialog if it wants to archive it or eliminate the user
				int i = JOptionPane.showOptionDialog(this, "Do you want to eliminate the user or archive the report?", "Resolve report", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] {"Cancel", "Eliminate user", "Archive report"}, null);	
				if (i == 1) {
					//Eliminate the user
					correct = userControllable.delete(userControllable.findUser(tableReports.getValueAt(tableReports.getSelectedRow(), 1).toString(), 0), 0);
					if (correct) {
						JOptionPane.showMessageDialog(this, "User eliminated successfully.");
					} else {
						JOptionPane.showMessageDialog(this, "Error eliminating user.");
					}
				}
				else if (i == 2) {
					//Archive the report
					Report report = new Report();
					report.setId(Integer.parseInt(tableReports.getValueAt(tableReports.getSelectedRow(), 0).toString()));
					report.setSituation("Archived");
					correct = userControllable.resolveReport(report);
					if (correct) {
						JOptionPane.showMessageDialog(this, "Report resolved successfully.");
					} else {
						JOptionPane.showMessageDialog(this, "Error resolving report.");
					}
				}
				listReports();
			} else {
				JOptionPane.showMessageDialog(this, "Select a report.");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage());
		}
	}

	// ---------------------Methods to validate information-------------------------
	// This method checks if all fields on Admin Champs tab are filled correctly
	public boolean checkFieldsChampAdmin() {
		if (comboBoxPosition.getSelectedIndex() == -1 || textFieldRegionChamp.getText().isBlank()
				|| textFieldPassiveChamp.getText().isBlank() || textFieldQChamp.getText().isBlank()
				|| textFieldWChamp.getText().isBlank() || textFieldEChamp.getText().isBlank()
				|| textFieldRChamp.getText().isBlank()) {
			JOptionPane.showMessageDialog(null, "Please fill all the fields", "Alert", JOptionPane.WARNING_MESSAGE);

			return false;
		}
		return true;
	}

	// This method checks if all fields on Profile tab are filled correctly
	public boolean checkFieldsModify() {
		boolean correct = false;
		if (!textFieldEmailProfile.getText().equals(user.getEmail())
				|| !textFieldNameProfile.getText().equals(user.getName())
				|| !textFieldPhoneProfile.getText().equals(user.getPhone())
				|| !comboBoxNationalityProfile.getSelectedItem().equals(user.getNationality())) {
			correct = true;
		}
		if (user instanceof Player) {
			if (!textFieldNicknameProfile.getText().equals(((Player) user).getNickname())) {
				correct = true;
			}
		} else {
			if (Integer.parseInt(textFieldAdditionsProfile.getText()) != ((Administrator) user).getAddtions()) {
				correct = true;
			}
		}
		if (!correct) {
			JOptionPane.showMessageDialog(this, "No changes in any field", "League of legends",
					JOptionPane.ERROR_MESSAGE);
		}
		return correct;
	}

	// This methods checks if the email is valid
	public void checkEmail(String email) {
		if (!control.validateEmail(email) && !email.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Email format incorrect. Example: ____@____.com", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldEmailProfile.setText(user.getEmail());
			textFieldMailAddAdmin.setText("");
		}

	}

	// This method checks if the nickname doesnt exists and is valid
	private boolean checkPlayer() throws PersonalizedException {
		// TODO Auto-generated method stub
		// Check that the inserted nickname doesn't exists
		User userComprobar = null;
		boolean correct = true;
		userComprobar = userControllable.findUser(textFieldNicknameProfile.getText(), 2);

		if (userComprobar != null) {
			correct = false;
			JOptionPane.showMessageDialog(null, "Nickname allready exists", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldNicknameProfile.setText(((Player) user).getNickname());
		}
		if (!control.validateNickname(textFieldNicknameProfile.getText())) {
			JOptionPane.showMessageDialog(this, "Nickname can only consist of a single word", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			correct = false;
			textFieldNicknameProfile.setText(((Player) user).getNickname());
		}
		return correct;
	}

	// This method checks if the name is written correctly
	public void checkName(String name) {
		if (!control.validateString(name) && !name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "This field can't contain numbers", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldNameProfile.setText(user.getName());
			textFieldNameAddAdmin.setText("");
		}

	}

	// This method checks if the phone number is written correctly
	public void checkPhone(String phone) {
		if ((phone.length() != 9 || !control.validateInteger(phone)) && !phone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "The telephone must have a lenght of 9 numbers", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldPhoneProfile.setText(user.getPhone());
			textFieldPhoneAddAdmin.setText("");
		}
	}

	// This method checks if the number is written correctly
	public void checkNumber(String number) {
		if (!control.validateInteger(textFieldAdditionsProfile.getText())
				&& !textFieldAdditionsProfile.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Only numbers", "League of legends", JOptionPane.ERROR_MESSAGE);
			textFieldAdditionsProfile.setText(String.valueOf(((Administrator) user).getAddtions()));
		}
	}

	// ----------------------------Listeners methods--------------------------------

	// Action Listener
	@Override
	// This method checks which button or action is perfomed and the following step
	// of it
	public void actionPerformed(ActionEvent e) {
		try {
			// If textFieldChampPlayer_Region or textFieldChampPlayer_Position is pressed,
			// buttonChampsPlayer_Enter is enabled if any of both is not blank
			if (e.getSource().equals(textFieldChampPlayer_Region)
					|| e.getSource().equals(textFieldChampPlayer_Position)) {
				if (!(textFieldChampPlayer_Region.getText().isBlank()
						&& textFieldChampPlayer_Position.getText().isBlank())) {
					buttonChampsPlayer_Enter.setEnabled(true);
				}
			}
			// If btnLogOut is pressed, it disposes current window and opens a new main
			// window
			if (e.getSource().equals(btnLogOut)) {
				this.dispose();
				MainWindow newMain = new MainWindow(userControllable, champEditable, gameStorable, statable);
				newMain.setVisible(true);
			}
			// If textFieldChampName is pressed, buttonChampsAdmin_Check is called
			if (e.getSource().equals(textFieldChampName)) {
				buttonChampsAdmin_Check.setEnabled(true);
			}
			// If checkBoxChampsPlayer_Filtered is pressed, the textFields for filter list
			// are enabled
			if (e.getSource().equals(checkBoxChampsPlayer_Filtered)) {
				textFieldChampPlayer_Region.setEnabled(true);
				textFieldChampPlayer_Region.setEditable(true);
				textFieldChampPlayer_Position.setEnabled(true);
				textFieldChampPlayer_Position.setEditable(true);
				buttonChampsPlayer_Enter.setEnabled(false);
			}
			// If checkBoxChampsPlayer is pressed, the textFields for filter list are
			// disabled
			if (e.getSource().equals(checkBoxChampsPlayer)) {
				textFieldChampPlayer_Region.setText("");
				textFieldChampPlayer_Position.setText("");
				textFieldChampPlayer_Region.setEnabled(false);
				textFieldChampPlayer_Region.setEditable(false);
				textFieldChampPlayer_Position.setEnabled(false);
				textFieldChampPlayer_Position.setEditable(false);
				buttonChampsPlayer_Enter.setEnabled(true);
			}
			// If btnCancelChamp is pressed, removeChampAdminTab is called
			// and buttonChampsAdmin_Check set to false
			if (e.getSource() == btnCancelChamp) {
				removeChampAdminTab();
				buttonChampsAdmin_Check.setEnabled(false);
			}
			// If btnUpdateStats is pressed, updateStats is called
			if (e.getSource() == btnUpdateStats) {
				scrollPaneStats.setViewportView(stats);
				updateStats();
			}
			//
			if (e.getSource() == btnShowTopPlayers) {
				scrollPaneStats.setViewportView(statsTopPlayers);
				textNicknameStats.setText("");
				showTopPlayers();
			}
			// If btnUpdateGame is pressed, updateGame is called
			if (e.getSource() == btnUpdateGame) {
				updateGame();
			}
			// If btnAddGame is pressed, addGame is shown
			if (e.getSource() == btnAddGame) {
				AddGame addGame = new AddGame(this, true, gameStorable, userControllable, champEditable);
				addGame.setVisible(true);
			}
			// If btnSendAddAdmin is pressed, the method sendAddAdmin is called
			if (e.getSource().equals(btnSendAddAdmin)) {
				sendAddAdmin();
			}
			// If btnModifyPlayerManagement is pressed, the method deletePlayerAdmin is
			// called
			if (e.getSource().equals(btnDeletePlayerManagement)) {
				deletePlayerAdmin();
			}
			// If btnModifyPlayer is pressed and checkUser returns true, the method
			// modifyPlayer is called
			if (e.getSource().equals(btnModifyPlayer)) {
				if (checkFieldsModify()) {
					modifyPlayer(userControllable);
				}
			}
			// If btnDeletePlayer is pressed, the method deletePlayer is called
			if (e.getSource().equals(btnDeletePlayer)) {
				deletePlayer(userControllable);
				this.dispose();
				MainWindow newMain = new MainWindow(userControllable, champEditable, gameStorable, statable);
				newMain.setVisible(true);
			}
			// If buttonChampsPlayer_Enter is pressed, the method listChampPlayer is called
			if (e.getSource().equals(buttonChampsPlayer_Enter)) {
				listChampPlayer();
			}
			// If buttonChampCheck is pressed, the method checkChampAdmin is called
			if (e.getSource().equals(buttonChampsAdmin_Check)) {
				checkChampAdmin();
			}
			// If buttonChampAdd is pressed, the method addChampAdmin is called
			if (e.getSource().equals(buttonChampAdd)) {
				addChampAdmin();
			}
			// If btnModifyChamp is pressed, the method executeModificationChampAdmin is
			// called
			if (e.getSource().equals(btnModifyChamp)) {
				executeModificationChampAdmin();
			}
			if (e.getSource().equals(btnR)) {
				btnResolve.setEnabled(true);
				listReports();
			}
			if (e.getSource().equals(btnResolve)) {
				resolveReport();
			}
			
		} catch (PersonalizedException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// Mouse Listener
	// If mouse is clicked on games table, the date is set to the calendar
	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == games) {
			calendar.setDate(Date.valueOf((LocalDate) games.getValueAt(games.getSelectedRow(), 1)));
		}
		calendar.setEnabled(false);
	}

	// If mouse is pressed on lblPassEyeAddAdmin or lblEyeProfile, the password is
	// shown
	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getSource().equals(lblPassEyeAddAdmin)) {
			passwordFieldAddAdmin.setEchoChar((char) 0);
		}
		if (e.getSource().equals(lblEyeProfile)) {
			passwordFieldProfile.setEchoChar((char) 0);
		}
	}

	// If mouse is released on lblPassEyeAddAdmin or lblEyeProfile, the password is
	// hidden
	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource().equals(lblPassEyeAddAdmin)) {
			passwordFieldAddAdmin.setEchoChar('·');
		}
		if (e.getSource().equals(lblEyeProfile)) {
			passwordFieldProfile.setEchoChar('·');
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

	// Focus Listener
	@Override
	public void focusGained(FocusEvent e) {

	}

	// If focus is lost on any of the following
	// it will check that the input is correct
	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(textFieldNameProfile))
			checkName(textFieldNameProfile.getText());

		if (e.getSource().equals(textFieldNameAddAdmin))
			checkName(textFieldNameAddAdmin.getText());

		if (e.getSource().equals(textFieldEmailProfile))
			checkEmail(textFieldEmailProfile.getText());

		if (e.getSource().equals(textFieldMailAddAdmin))
			checkEmail(textFieldMailAddAdmin.getText());

		if (e.getSource().equals(textFieldPhoneProfile))
			checkPhone(textFieldPhoneProfile.getText());

		if (e.getSource().equals(textFieldPhoneAddAdmin))
			checkPhone(textFieldPhoneAddAdmin.getText());

		if (e.getSource().equals(textFieldAdditionsProfile)) {
			checkNumber(textFieldAdditionsProfile.getText());
		}
	}
}
