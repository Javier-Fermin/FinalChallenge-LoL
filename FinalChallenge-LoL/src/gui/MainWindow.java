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

import javax.swing.border.EtchedBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class MainWindow extends JFrame implements ActionListener, MouseListener, FocusListener {
	private JPanel contentPane;
	private String nicknameOriginal;
	private JButton btnModifyPlayer;
	private JLabel jCalendarStartDateProfile;
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
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable stats;
	private DefaultTableModel modelStats;
	private JTable games;
	private DefaultTableModel modelGame;
	private JCalendar calendar;
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
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton btnUpdateStats;
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
	private JTextField textNicknameStats;
	private JButton btnUpdateGame;
	private JButton btnAddGame;
	private JTextField textNicknameGame;
	private JComboBox comboBoxSelectUser;
	private JTextArea textAreaDeletePlayer;
	private JPanel panelAddModifyChamp;

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

		JLabel pictureProfile = new JLabel("");
		pictureProfile.setBounds(881, 109, 200, 478);
		pictureProfile.setIcon(new ImageIcon(MainWindow.class.getResource(
				"/img/Banner-Gold-keatas-Ranked-Season-LoL-Wild-Rift-700x394-PhotoRoom.png-PhotoRoom (1) (1).png")));
		profile.add(pictureProfile);

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

		btnModifyPlayer = new JButton("MODIFY ");
		btnModifyPlayer.setForeground(new Color(255, 255, 255));
		btnModifyPlayer.setBounds(597, 524, 92, 26);
		btnModifyPlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnModifyPlayer.setBackground(new Color(0, 128, 128));
		btnModifyPlayer.addActionListener(this);
		profile.add(btnModifyPlayer);

		btnDeletePlayer = new JButton("DELETE");
		btnDeletePlayer.setForeground(new Color(255, 255, 255));
		btnDeletePlayer.setBounds(717, 524, 95, 26);
		btnDeletePlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 14));
		btnDeletePlayer.setBackground(new Color(0, 128, 128));
		btnDeletePlayer.addActionListener(this);
		btnDeletePlayer.setVisible(false);
		profile.add(btnDeletePlayer);

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
		panelAdmin.setBounds(551, 153, 297, 309);
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
		panelTransparenteProfile.setBounds(49, 34, 1059, 553);
		profile.add(panelTransparenteProfile);

		JLabel fondoPictureProfile = new JLabel("New label");
		fondoPictureProfile.setBounds(-393, -13, 1574, 675);
		fondoPictureProfile.setIcon(new ImageIcon(MainWindow.class.getResource("/img/LOL_PROMOART_14.jpg")));
		profile.add(fondoPictureProfile);

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

		JLayeredPane selectRegionPosition = new JLayeredPane();
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
		textFieldChampPlayer_Region.setToolTipText("Leave it in blank for no filter");
		textFieldChampPlayer_Region.setForeground(Color.WHITE);
		textFieldChampPlayer_Region.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldChampPlayer_Region.setColumns(10);
		textFieldChampPlayer_Region.setBackground(Color.BLACK);
		textFieldChampPlayer_Region.setBounds(190, 40, 202, 26);
		selectRegionPosition.add(textFieldChampPlayer_Region);

		JLabel labelChampsPlayer_Position = new JLabel("POSITION");
		labelChampsPlayer_Position.setBounds(36, 105, 135, 26);
		selectRegionPosition.add(labelChampsPlayer_Position);
		labelChampsPlayer_Position.setForeground(new Color(255, 255, 255));
		labelChampsPlayer_Position.setFont(new Font("Bahnschrift", Font.PLAIN, 20));

		textFieldChampPlayer_Position = new JTextField();
		textFieldChampPlayer_Position.setToolTipText("Leave it in blank for no filter");
		textFieldChampPlayer_Position.setForeground(Color.WHITE);
		textFieldChampPlayer_Position.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textFieldChampPlayer_Position.setColumns(10);
		textFieldChampPlayer_Position.setBackground(Color.BLACK);
		textFieldChampPlayer_Position.setBounds(190, 107, 202, 26);
		selectRegionPosition.add(textFieldChampPlayer_Position);
		buttonChampsPlayer_Enter.addActionListener(this);

		JLabel panelChampPlayer = new JLabel("");
		panelChampPlayer.setBackground(new Color(0, 0, 0, 180));
		panelChampPlayer.setIcon(new ImageIcon(MainWindow.class.getResource("/img/RuneterraMap.png")));
		panelChampPlayer.setBounds(-420, -35, 1601, 714);
		champsPlayer.add(panelChampPlayer);

		// Champs admin
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
		buttonChampAdd.setBounds(214, 460, 85, 25);
		buttonChampAdd.addActionListener(this);
		buttonChampAdd.setVisible(false);
		panelHabilidades.add(buttonChampAdd);

		btnModifyChamp = new JButton("MODIFY");
		btnModifyChamp.setForeground(new Color(255, 255, 255));
		btnModifyChamp.setBackground(new Color(0, 128, 128));
		btnModifyChamp.setVerticalAlignment(SwingConstants.TOP);
		btnModifyChamp.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnModifyChamp.setBounds(214, 461, 100, 25);
		btnModifyChamp.addActionListener(this);
		btnModifyChamp.setVisible(false);
		panelHabilidades.add(btnModifyChamp);

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
		btnUpdateStats.setBounds(182, 326, 105, 30);
		btnUpdateStats.addActionListener(this);
		panelStadistics.add(btnUpdateStats);

		JScrollPane scrollPaneStats = new JScrollPane();
		scrollPaneStats.setBounds(528, 85, 501, 421);
		panelStadistics.add(scrollPaneStats);

		stats = new JTable();
		stats.setModel(new DefaultTableModel(new Object[][] {}, new String[] {}));
		scrollPaneStats.setViewportView(stats);

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
		modelStats = new DefaultTableModel();
		modelStats.addColumn("ID");
		modelStats.addColumn("Nickname");
		modelStats.addColumn("Name");
		modelStats.addColumn("Position");
		modelStats.addColumn("Win/Lose");

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

		JLayeredPane deletePlayerManagement = new JLayeredPane();
		deletePlayerManagement.setBounds(677, 113, 389, 452);
		management.add(deletePlayerManagement);
		deletePlayerManagement.setLayout(null);

		btnDeletePlayerManagement = new JButton("DELETE");
		btnDeletePlayerManagement.setForeground(new Color(255, 255, 255));
		btnDeletePlayerManagement.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnDeletePlayerManagement.setBackground(new Color(0, 128, 128));
		btnDeletePlayerManagement.setBounds(144, 425, 106, 27);
		btnDeletePlayerManagement.addActionListener(this);
		deletePlayerManagement.add(btnDeletePlayerManagement);

		textAreaDeletePlayer = new JTextArea();
		textAreaDeletePlayer.setForeground(Color.WHITE);
		textAreaDeletePlayer.setFont(new Font("Bahnschrift", Font.PLAIN, 17));
		textAreaDeletePlayer.setBackground(Color.BLACK);
		textAreaDeletePlayer.setBounds(43, 116, 311, 291);
		deletePlayerManagement.add(textAreaDeletePlayer);

		comboBoxSelectUser = new JComboBox();
		comboBoxSelectUser.setBounds(98, 75, 199, 21);
		deletePlayerManagement.add(comboBoxSelectUser);
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
		titleBlueAdmin.setBounds(386, 41, 531, 89);
		titleBlueAdmin.setForeground(new Color(0, 139, 139));
		titleBlueAdmin.setFont(new Font("Bahnschrift", Font.BOLD, 70));
		management.add(titleBlueAdmin);

		JLabel titleYellowAdmin = new JLabel("MANAGEMENT");
		titleYellowAdmin.setBounds(383, 41, 513, 89);
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
		separator.setBounds(599, 125, 12, 418);
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

		JLabel personalDataProfile_1_2_2_1 = new JLabel("DELETE PLAYER");
		personalDataProfile_1_2_2_1.setBounds(755, 98, 244, 89);
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
		panelTransparenteManagement.setBounds(50, 24, 1059, 553);
		management.add(panelTransparenteManagement);

		JLabel pictureFondoManagement = new JLabel("");
		pictureFondoManagement.setBounds(-129, 0, 1325, 738);
		pictureFondoManagement.setIcon(new ImageIcon(MainWindow.class.getResource("/img/LOL_PROMOART_14.jpg")));
		management.add(pictureFondoManagement);

		try {
			cargarUsers(userControllable);
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

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnUpdateStats) {
			try {
				updateStats();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnUpdateGame) {
			try {
				updateGame();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == btnAddGame) {
			AddGame addGame = new AddGame(this, true, gameStorable, userControllable, champEditable);
			addGame.setVisible(true);
		}
		if (e.getSource().equals(btnSendAddAdmin)) {
			try {
				sendAddAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(btnDeletePlayerManagement)) {
			try {
				deletePlayerAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource().equals(btnModifyPlayer)) {
			try {
				modifyPlayer(userControllable);
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource().equals(btnDeletePlayer)) {
			try {
				deletePlayer(userControllable);
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(buttonChampsPlayer_Enter)) {
			try {
				listChampPlayer();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(buttonChampsAdmin_Check)) {
			try {
				checkChampAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(buttonChampAdd)) {
			try {
				addChampAdmin();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource().equals(btnModifyChamp)) {
			try {
				executeModificationChampAdmin();

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private void deletePlayerAdmin() throws PersonalizedException {
		// TODO Auto-generated method stub
		int chooseConnection;
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
			option = JOptionPane.showConfirmDialog(this, "Do you want to delete " + userDel.getName() + "?");
			if (option == 0) {
				if (userDel instanceof Player)
					chooseConnection = 2;
				else
					chooseConnection = 0;
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
			JOptionPane.showMessageDialog(this, "ERROR. Fill in all fields.");
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

	/**
	 * Method to create the user with the information writen in the profile tab
	 * 
	 * @return User
	 */
	public User loadUser() {
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

		return user;

	}

	/**
	 * Method to load the data from the database to the profile tab
	 * 
	 * @param userControllable
	 */
	public void loadData(UserControllable userControllable) {
		textFieldNameProfile.setText(user.getName());
		textFieldEmailProfile.setText(user.getEmail());
		jCalendarProfile.setDate(Date.valueOf(user.getBirthDate()));
		textFieldPhoneProfile.setText(user.getPhone());
		comboBoxNationalityProfile.setSelectedItem(user.getNationality());
		passwordFieldProfile.setText(user.getPassword());

		if (user instanceof Player) {
			textFieldNicknameProfile.setText(((Player) user).getNickname());
			// We save the original nickname so that if the user changes his nickname the
			// query will be done with the original nickname.
			nicknameOriginal = ((Player) user).getNickname();
			// Panel with the admin information isn't visible
			panelAdmin.setVisible(false);
			btnDeletePlayer.setVisible(true);
		} else {
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

	public void focusGained(FocusEvent e) {

	}

	/**
	 * Method to modify player's account information
	 * 
	 * @param userControllable
	 * @throws PersonalizedException
	 */
	public void modifyPlayer(UserControllable userControllable) throws PersonalizedException {

		// If the user is instance as player we use the original nickname saved before
		if (user instanceof Player) {
			user = userControllable.findUser(nicknameOriginal);
		} else {
			user = userControllable.findUser(user.getId());
		}

		if (checkFieldsModify()) {
			if (userControllable.modifyUser(user)) {
				JOptionPane.showMessageDialog(this, "PERSONAL DATA MODIFIED");
			} else {
				JOptionPane.showMessageDialog(this, "NO MODIFICATION");
			}
		}

	}

	/**
	 * Method to delete the player's account
	 * 
	 * @param userControllable
	 * @throws PersonalizedException
	 */
	public void deletePlayer(UserControllable userControllable) throws PersonalizedException {
		int chooseConnection;
		boolean correct = false;
		int aceptar;
		User user = null;
		// Find the user
		user = userControllable.findUser(textFieldNicknameProfile.getText());
		// Show a confirmation dialog
		aceptar = JOptionPane.showConfirmDialog(this, "WARNING: do you want to delete your account?");
		// Yes --> 0 so If the user accepts the message, his account will be deleted.
		if (aceptar == 0) {
			if (userDel instanceof Player)
				chooseConnection = 2;
			else
				chooseConnection = 0;
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

	public void checkChampAdmin() throws PersonalizedException {
		if (textFieldChampName.getText().isEmpty())
			JOptionPane.showMessageDialog(null, "Añade un nombre correcto", "Alert", JOptionPane.WARNING_MESSAGE);
		else
			addOrModifyChamp();
	}

	public void addOrModifyChamp() throws PersonalizedException {

		Champ champ = champEditable.checkChampName(textFieldChampName.getText());
		panelHabilidades.setVisible(true);
		if (champ.getName() == null) {
			buttonChampAdd.setVisible(true);

		} else {
			btnModifyChamp.setVisible(true);
			modifyChampAdmin(champ);
		}
	}

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
		textFieldChampName.setText(champ.getName());
		comboBoxPosition.setSelectedItem(champ.getPosition());
		textFieldRegionChamp.setText(champ.getRegion());
		textFieldPassiveChamp.setText(champ.getPassive());
		textFieldQChamp.setText(champ.getQ());
		textFieldWChamp.setText(champ.getW());
		textFieldEChamp.setText(champ.getE());
		textFieldRChamp.setText(champ.getR());
	}

	public void executeModificationChampAdmin() throws PersonalizedException {
		Champ champ = new Champ();
		if (checkFieldsChampAdmin() == false)
			return;
		champ = fillChamp(champ);
		if (champEditable.modifyChamp(champ)) {
			JOptionPane.showMessageDialog(null, "Champ modified successfully", "Alert",
					JOptionPane.INFORMATION_MESSAGE);
		}
		else
			JOptionPane.showMessageDialog(null, "Champ couldn't be modified", "Alert", JOptionPane.WARNING_MESSAGE);
		removeChampAdminTab();
	}

	public void removeChampAdminTab() {
		champAdmin.removeAll();
		// ChampAdminTabConstruction();
	}

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
		scrollPaneChampPlayer.setBounds(190, 355, 684, 100);
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
		if (e.getSource().equals(lblEyeProfile)) {
			passwordFieldProfile.setEchoChar((char) 0);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (e.getSource().equals(lblPassEyeAddAdmin)) {
			passwordFieldAddAdmin.setEchoChar('·');
		}
		if (e.getSource().equals(lblEyeProfile)) {
			passwordFieldProfile.setEchoChar('·');
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
		userComprobar = userControllable.findUser(textFieldNicknameProfile.getText());

		if (userComprobar != null) {
			JOptionPane.showMessageDialog(null, "Nickname allready exists", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldNicknameProfile.setText(((Player) user).getNickname());
		}
		if (!control.validateNickname(textFieldNicknameProfile.getText())) {
			JOptionPane.showMessageDialog(this, "Nickname can only consist of a single word", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldNicknameProfile.setText(((Player) user).getNickname());
		}
	}

	/**
	 * Method to validate that the text inserted in the email textField is correct
	 * 
	 * @param email
	 */

	public void checkEmail(String email) {
		if (!control.validateEmail(email) && !email.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Email format incorrect. Example: ____@____.com", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldEmailProfile.setText(user.getEmail());
			textFieldMailAddAdmin.setText("");
		}

	}

	/**
	 * Method to validate that the text inserted by the user is a string
	 * 
	 * @param name
	 */
	public void checkName(String name) {
		if (!control.validateString(name) && !name.isEmpty()) {
			JOptionPane.showMessageDialog(this, "This field can't contain numbers", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldNameProfile.setText(user.getName());
			textFieldNameAddAdmin.setText("");
		}

	}

	/**
	 * Method to validate that the phone only consists of 9 numbers
	 * 
	 * @param phone
	 */

	public void checkPhone(String phone) {
		if ((phone.length() != 9 || !control.validateInteger(phone)) && !phone.isEmpty()) {
			JOptionPane.showMessageDialog(this, "The telephone must have a lenght of 9 numbers", "League of legends",
					JOptionPane.ERROR_MESSAGE);
			textFieldPhoneProfile.setText(user.getPhone());
			textFieldPhoneAddAdmin.setText("");
		}
	}

	public void checkNumber(String number) {
		if (!control.validateInteger(textFieldAdditionsProfile.getText())
				&& !textFieldAdditionsProfile.getText().isBlank()) {
			JOptionPane.showMessageDialog(this, "Only numbers", "League of legends", JOptionPane.ERROR_MESSAGE);
			textFieldAdditionsProfile.setText(String.valueOf(((Administrator) user).getAddtions()));
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

	/**
	 * Method to check if any all the fields have changed to do the modification
	 * 
	 * @return correct
	 */
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
		}
		if (user instanceof Administrator) {
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

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(textFieldNameProfile))
			checkName(textFieldNameProfile.getText());

		if (e.getSource().equals(textFieldNameAddAdmin))
			checkName(textFieldNameAddAdmin.getText());

		if (e.getSource().equals(textFieldNicknameProfile)) {
			try {
				checkUser();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

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
