package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

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
import com.toedter.calendar.JCalendar;
import javax.swing.JList;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class SignIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField Name_TextField;
	private JTextField email_TextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SignIn dialog = new SignIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public SignIn() {
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
		secondPanel.setBounds(254, 10, 495, 657);
		firstPanel.add(secondPanel);
		secondPanel.setLayout(null);
		
		JLabel iconLol = new JLabel("");
		iconLol.setIcon(new ImageIcon(SignIn.class.getResource("/img/lolLogo (2).png")));
		iconLol.setBounds(206, 28, 71, 72);
		secondPanel.add(iconLol);
		
		JLabel SignIn = new JLabel("SIGN IN");
		SignIn.setForeground(Color.RED);
		SignIn.setFont(new Font("Bahnschrift", Font.BOLD, 47));
		SignIn.setBounds(155, 110, 172, 55);
		secondPanel.add(SignIn);
		
		JLabel nickname = new JLabel("NICKNAME");
		nickname.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		nickname.setBounds(50, 187, 114, 21);
		secondPanel.add(nickname);
		
		textField = new JTextField();
		textField.setBounds(223, 188, 234, 19);
		secondPanel.add(textField);
		textField.setColumns(10);
		
		JLabel password = new JLabel("PASSWORD");
		password.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		password.setBounds(50, 236, 114, 21);
		secondPanel.add(password);
		
		JLabel lblEmail = new JLabel("NAME");
		lblEmail.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblEmail.setBounds(50, 287, 114, 21);
		secondPanel.add(lblEmail);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(223, 237, 234, 19);
		secondPanel.add(passwordField);
		
		Name_TextField = new JTextField();
		Name_TextField.setColumns(10);
		Name_TextField.setBounds(223, 288, 234, 19);
		secondPanel.add(Name_TextField);
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		email.setBounds(50, 334, 114, 21);
		secondPanel.add(email);
		
		email_TextField = new JTextField();
		email_TextField.setToolTipText("");
		email_TextField.setColumns(10);
		email_TextField.setBounds(223, 335, 234, 19);
		secondPanel.add(email_TextField);
		
		JLabel birthdate = new JLabel("BIRTHDATE");
		birthdate.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		birthdate.setBounds(50, 425, 114, 21);
		secondPanel.add(birthdate);
		
		JLabel lblNacionality = new JLabel("NACIONALITY");
		lblNacionality.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblNacionality.setBounds(50, 550, 114, 21);
		secondPanel.add(lblNacionality);
		
		JLabel submit = new JLabel("");
		submit.setIcon(new ImageIcon(SignIn.class.getResource("/img/salir.png")));
		submit.setBounds(206, 602, 63, 45);
		secondPanel.add(submit);
		
		JLabel messageNickname = new JLabel("Nickname already exits");
		messageNickname.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		messageNickname.setForeground(Color.RED);
		messageNickname.setBounds(223, 216, 204, 13);
		secondPanel.add(messageNickname);
		messageNickname.setVisible(false);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(223, 379, 234, 152);
		secondPanel.add(calendar);
	
		JComboBox nacionalityComboBox = new JComboBox();
		nacionalityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian", "Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican", "Dutch", "East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian", "German", "Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese", "Haitian", "Herzegovinian", "Honduran", "Hungarian", "I-Kiribati", "Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani", "Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy", "Malawian", "Malaysian", "Maldivian", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian", "Nauruan", "Nepalese", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerian", "Nigerien", "North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan", "Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari", "Romanian", "Russian", "Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean", "Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean", "Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish", "Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik", "Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh", "Yemenite", "Zambian", "Zimbabwean"}));
		nacionalityComboBox.setBounds(223, 550, 234, 21);
		secondPanel.add(nacionalityComboBox);
		nacionalityComboBox.setSelectedIndex(-1);
		JLabel Fondo = new JLabel("New label");
		Fondo.setBounds(0, 0, 1112, 677);
		firstPanel.add(Fondo);
		Fondo.setIcon(new ImageIcon(SignIn.class.getResource("/img/2021_Key_art (1).jpg")));
		
		
		
	}
}
