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

import controller.UserControllable;

import com.toedter.calendar.JCalendar;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.LocalDate;
import java.time.ZoneId;

import model.User;
import model.Player;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignIn extends JDialog implements ActionListener, FocusListener {
	/** 
	 * @author Irati Garzón
	 */
	private final JPanel contentPanel = new JPanel();
	private JTextField textFieldNickname;
	private JTextField nameTextField;
	private JTextField emailTextField;
	JComboBox nationalityComboBox = new JComboBox();
	private JTextField textFieldPassword;
	private JTextField textFieldPhone;
	JCalendar jCalendar = new JCalendar();
	UserControllable controller;
	public SignIn(UserControllable controller) {
		this.controller= controller;
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
		
		JLabel email = new JLabel("EMAIL");
		email.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		email.setBounds(50, 293, 114, 21);
		secondPanel.add(email);
		
		emailTextField = new JTextField();
		emailTextField.setToolTipText("");
		emailTextField.setColumns(10);
		emailTextField.setBounds(245, 294, 212, 19);
		secondPanel.add(emailTextField);
		
		JLabel birthdate = new JLabel("BIRTHDATE");
		birthdate.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		birthdate.setBounds(50, 401, 114, 21);
		secondPanel.add(birthdate);
		
		JLabel lblNacionality = new JLabel("NATIONALITY");
		lblNacionality.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblNacionality.setBounds(50, 550, 114, 21);
		secondPanel.add(lblNacionality);
		
		JLabel lblNewLabel_1 = new JLabel("");
		
		lblNewLabel_1.setIcon(new ImageIcon(SignIn.class.getResource("/img/salir.png")));
		lblNewLabel_1.setBounds(206, 602, 63, 45);
		secondPanel.add(lblNewLabel_1);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(245, 335, 212, 152);
		jCalendar.setSize(212, 152);
		jCalendar.setLocation(245, 330);
		secondPanel.add(jCalendar);
	
		nationalityComboBox = new JComboBox();
		nationalityComboBox.setModel(new DefaultComboBoxModel(new String[] {"Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian", "Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican", "Dutch", "East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian", "German", "Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese", "Haitian", "Herzegovinian", "Honduran", "Hungarian", "I-Kiribati", "Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani", "Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy", "Malawian", "Malaysian", "Maldivian", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian", "Nauruan", "Nepalese", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerian", "Nigerien", "North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan", "Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari", "Romanian", "Russian", "Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean", "Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean", "Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish", "Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik", "Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh", "Yemenite", "Zambian", "Zimbabwean"}));
		nationalityComboBox.setBounds(245, 550, 212, 21);
		secondPanel.add(nationalityComboBox);
		nationalityComboBox.setSelectedIndex(-1);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(245, 194, 212, 19);
		secondPanel.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JLabel lblPhone = new JLabel("PHONE");
		lblPhone.setFont(new Font("Bahnschrift", Font.BOLD, 17));
		lblPhone.setBounds(50, 499, 114, 21);
		secondPanel.add(lblPhone);
		
		textFieldPhone = new JTextField();
		textFieldPhone.setBounds(245, 500, 212, 19);
		secondPanel.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		JLabel Fondo = new JLabel("New label");
		Fondo.setBounds(0, 0, 1112, 677);
		firstPanel.add(Fondo);
		Fondo.setIcon(new ImageIcon(SignIn.class.getResource("/img/2021_Key_art (1).jpg")));
		//Event handler to user a label as a botton
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//Pass from date to localDate
				LocalDate date= jCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				//Check if all the fields have been filled.
				if(textFieldNickname.getText().isBlank() || textFieldPassword.getText().isBlank() || textFieldPhone.getText().isBlank() || nameTextField.getText().isBlank() ||
						emailTextField.getText().isBlank() || date== LocalDate.now() || nationalityComboBox.getSelectedIndex()== -1) {
					JOptionPane.showMessageDialog(null, "You have to fill all the fields",
						      "League of legends", JOptionPane.ERROR_MESSAGE);
				}else {
					User user= setInformation();
				controller.addUser(user);
				JOptionPane.showMessageDialog(null, "CORRECTO",
					      "League of legends", JOptionPane.INFORMATION_MESSAGE);
				//OPEN MAIN WINDOW

				}
			}
		});
		
		
	}
	
	//Method create the user with the information given
	public User setInformation() {
		User user = new Player();
		user.setName(nameTextField.getText());
		user.setNationality((String)nationalityComboBox.getSelectedItem());
		user.setEmail(emailTextField.getText());
		user.setPassword(textFieldPassword.getText());
		user.setPhone(textFieldPhone.getText());
		((Player) user).setNickname(textFieldNickname.getText());
		LocalDate date= jCalendar.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		user.setBirthDate(date);
		return user;
	}
	public void focusLost(FocusEvent e) {
		//Check that the inserted nickname doesn't exists
		if(e.getSource().equals(textFieldNickname)) {
			User userComprobar = null;
			userComprobar= controller.findUser(textFieldNickname.getText());
					
			if(userComprobar!= null) {
				JOptionPane.showMessageDialog(null, "Nickname allready exists",
					      "League of legends", JOptionPane.ERROR_MESSAGE);
				textFieldNickname.setText("");
			}
		}

	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
