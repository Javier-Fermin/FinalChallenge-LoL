package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.JTextField;
import java.awt.Dialog.ModalExclusionType;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.Administrator;
import model.Player;
import model.User;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

public class MainWindow extends JFrame {

	private JPanel contentPane;
	private JTextField Nickname_TextField;
	private JTextField Email_textField;
	private JTextField textField_1;
	private JTextField Phone_textField;
	private JTextField Password_textField;
	private JTextField Nacionality_textField;
	private JTextField StartDate_textField;
	private JTextField Additions_textField;
	private JTextField textName;
	private JPasswordField passwordField;
	private JTextField textMail;
	private JTextField textPhone;
	private JTextField textField_6;
	private JTextField textSearch;
	private User user;

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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1210, 703);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setMaximumSize(getMaximumSize());
		contentPane.setMinimumSize(getMinimumSize());

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// tabbedPane.setBounds(0, 0, 1196, 656);
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

		JPanel management = new JPanel();
		tabbedPane.addTab("MANAGEMENT", null, management, null);
		management.setLayout(new BoxLayout(management, BoxLayout.X_AXIS));

		JTabbedPane tabAdmin = new JTabbedPane(JTabbedPane.LEFT);
		management.add(tabAdmin);

		JPanel panelAdmin = new JPanel();
		tabAdmin.addTab("Add administrator", null, panelAdmin, null);

		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textName.setColumns(10);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordField.setColumns(10);

		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textMail = new JTextField();
		textMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textMail.setColumns(10);

		JLabel lblBdate = new JLabel("Birth date:");
		lblBdate.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblPhoneAdmin = new JLabel("Phone:");
		lblPhoneAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textPhone = new JTextField();
		textPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textPhone.setColumns(10);

		JLabel lblName_5 = new JLabel("Nationality:");
		lblName_5.setFont(new Font("Tahoma", Font.PLAIN, 15));

		textField_6 = new JTextField();
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_6.setColumns(10);

		/*
		 * JCalendar calendar = new JCalendar(); calendar.setBounds(245, 379, 212, 152);
		 * secondPanel.add(calendar);
		 */

		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Afghan", "Albanian", "Algerian", "American",
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
		comboBox.setSelectedIndex(-1);

		JButton btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 15));

		GroupLayout gl_panelAdmin = new GroupLayout(panelAdmin);
		gl_panelAdmin.setHorizontalGroup(gl_panelAdmin.createParallelGroup(Alignment.TRAILING).addGroup(gl_panelAdmin
				.createSequentialGroup().addGap(305)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAdmin
						.createSequentialGroup()
						.addGroup(gl_panelAdmin.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPhoneAdmin, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblName_5, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
						.addGroup(gl_panelAdmin.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_panelAdmin.createParallelGroup(Alignment.LEADING)
										.addComponent(lblBdate, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
										.addGroup(gl_panelAdmin.createSequentialGroup()
												.addGroup(gl_panelAdmin.createParallelGroup(Alignment.LEADING)
														.addComponent(lblName).addComponent(lblPassword,
																GroupLayout.PREFERRED_SIZE, 87,
																GroupLayout.PREFERRED_SIZE))
												.addGap(10))
										.addComponent(lblMail, GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE))))
				.addGap(53)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(comboBox, 0, 0, Short.MAX_VALUE).addComponent(textPhone).addComponent(textField_6)
						.addComponent(textMail, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
						.addComponent(textName, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
				.addContainerGap(433, Short.MAX_VALUE))
				.addGroup(gl_panelAdmin.createSequentialGroup().addContainerGap(998, Short.MAX_VALUE)
						.addComponent(btnSend).addContainerGap()));
		gl_panelAdmin.setVerticalGroup(gl_panelAdmin.createParallelGroup(Alignment.LEADING).addGroup(gl_panelAdmin
				.createSequentialGroup().addGap(90)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName))
				.addGap(34)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(45)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(textMail, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMail, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBdate, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(49)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneAdmin, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(textPhone, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
				.addGap(56)
				.addGroup(gl_panelAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName_5, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 126, Short.MAX_VALUE).addComponent(btnSend)
				.addContainerGap()));
		panelAdmin.setLayout(gl_panelAdmin);

		JPanel panelPlayer = new JPanel();
		tabAdmin.addTab("Delete player", null, panelPlayer, null);

		textSearch = new JTextField();
		textSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textSearch.setColumns(10);

		JLabel lblSearch = new JLabel("Search players:");
		lblSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JTextPane textPane = new JTextPane();
		textPane.setVisible(false);

		GroupLayout gl_panelPlayer = new GroupLayout(panelPlayer);
		gl_panelPlayer.setHorizontalGroup(gl_panelPlayer.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelPlayer.createSequentialGroup()
						.addGroup(gl_panelPlayer.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panelPlayer.createSequentialGroup().addGap(352).addComponent(lblSearch))
								.addGroup(gl_panelPlayer.createSequentialGroup().addGap(328).addComponent(textSearch,
										GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(585, Short.MAX_VALUE))
				.addGroup(gl_panelPlayer.createSequentialGroup().addContainerGap(990, Short.MAX_VALUE)
						.addComponent(btnDelete).addContainerGap())
				.addGroup(Alignment.LEADING,
						gl_panelPlayer.createSequentialGroup().addGap(257)
								.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE)
								.addContainerGap(455, Short.MAX_VALUE)));
		gl_panelPlayer.setVerticalGroup(gl_panelPlayer.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPlayer.createSequentialGroup().addGap(76).addComponent(lblSearch).addGap(37)
						.addComponent(textSearch, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE).addGap(46)
						.addComponent(btnDelete).addContainerGap()));
		panelPlayer.setLayout(gl_panelPlayer);
		if (user instanceof Administrator) {
			tabbedPane.remove(champsPlayer);
			tabbedPane.remove(game);
			tabbedPane.remove(stadistics);
		}
		if (user instanceof Player) {
			tabbedPane.remove(champAdmin);
			tabbedPane.remove(management);
		}
	}
}
