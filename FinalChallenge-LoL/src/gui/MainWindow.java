package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.UserControllabe;
import model.Administrator;
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
import java.awt.BorderLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;

public class MainWindow extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField Nickname_TextField;
	private JTextField Email_textField;
	private JTextField textField_1;
	private JTextField Phone_textField;
	private JTextField Password_textField;
	private JTextField Nacionality_textField;
	private JTextField StartDate_textField;
	private JTextField Additions_textField;
	private JTextField textFieldName;
	private JTextField textFieldMail;
	private JTextField textFieldPhone;
	private JPasswordField passwordField;
	private JComboBox comboBox;
	private JButton btnSend;
	private JButton btnDelete;
	private JTextArea textArea;
	
	private User user;
	private JTextField textFieldFindUser;

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
		//tabbedPane.setBounds(0, 0, 1196, 656);
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
		management.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPaneAdmin = new JTabbedPane(JTabbedPane.LEFT);
		
		JPanel addAdmin = new JPanel();
		tabbedPaneAdmin.addTab("Add administrator", null, addAdmin, null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnSend = new JButton("Send");
		btnSend.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSend.addActionListener(this);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblMail = new JLabel("Mail:");
		lblMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldMail = new JTextField();
		textFieldMail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldMail.setColumns(10);
		
		JLabel lblBDate = new JLabel("Birth date:");
		lblBDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblPhoneAdmin = new JLabel("Phone:");
		lblPhoneAdmin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldPhone.setColumns(10);
		
		JLabel lblNationality = new JLabel("Nationality:");
		lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Afghan", "Albanian", "Algerian", "American", "Andorran", "Angolan", "Antiguans", "Argentinean", "Armenian", "Australian", "Austrian", "Azerbaijani", "Bahamian", "Bahraini", "Bangladeshi", "Barbadian", "Barbudans", "Batswana", "Belarusian", "Belgian", "Belizean", "Beninese", "Bhutanese", "Bolivian", "Bosnian", "Brazilian", "British", "Bruneian", "Bulgarian", "Burkinabe", "Burmese", "Burundian", "Cambodian", "Cameroonian", "Canadian", "Cape Verdean", "Central African", "Chadian", "Chilean", "Chinese", "Colombian", "Comoran", "Congolese", "Congolese", "Costa Rican", "Croatian", "Cuban", "Cypriot", "Czech", "Danish", "Djibouti", "Dominican", "Dominican", "Dutch", "Dutchman", "Dutchwoman", "East Timorese", "Ecuadorean", "Egyptian", "Emirian", "Equatorial Guinean", "Eritrean", "Estonian", "Ethiopian", "Fijian", "Filipino", "Finnish", "French", "Gabonese", "Gambian", "Georgian", "German", "Ghanaian", "Greek", "Grenadian", "Guatemalan", "Guinea-Bissauan", "Guinean", "Guyanese", "Haitian", "Herzegovinian", "Honduran", "Hungarian", "I-Kiribati", "Icelander", "Indian", "Indonesian", "Iranian", "Iraqi", "Irish", "Irish", "Israeli", "Italian", "Ivorian", "Jamaican", "Japanese", "Jordanian", "Kazakhstani", "Kenyan", "Kittian and Nevisian", "Kuwaiti", "Kyrgyz", "Laotian", "Latvian", "Lebanese", "Liberian", "Libyan", "Liechtensteiner", "Lithuanian", "Luxembourger", "Macedonian", "Malagasy", "Malawian", "Malaysian", "Maldivan", "Malian", "Maltese", "Marshallese", "Mauritanian", "Mauritian", "Mexican", "Micronesian", "Moldovan", "Monacan", "Mongolian", "Moroccan", "Mosotho", "Motswana", "Mozambican", "Namibian", "Nauruan", "Nepalese", "Netherlander", "New Zealander", "Ni-Vanuatu", "Nicaraguan", "Nigerian", "Nigerien", "North Korean", "Northern Irish", "Norwegian", "Omani", "Pakistani", "Palauan", "Panamanian", "Papua New Guinean", "Paraguayan", "Peruvian", "Polish", "Portuguese", "Qatari", "Romanian", "Russian", "Rwandan", "Saint Lucian", "Salvadoran", "Samoan", "San Marinese", "Sao Tomean", "Saudi", "Scottish", "Senegalese", "Serbian", "Seychellois", "Sierra Leonean", "Singaporean", "Slovakian", "Slovenian", "Solomon Islander", "Somali", "South African", "South Korean", "Spanish", "Sri Lankan", "Sudanese", "Surinamer", "Swazi", "Swedish", "Swiss", "Syrian", "Taiwanese", "Tajik", "Tanzanian", "Thai", "Togolese", "Tongan", "Trinidadian or Tobagonian", "Tunisian", "Turkish", "Tuvaluan", "Ugandan", "Ukrainian", "Uruguayan", "Uzbekistani", "Venezuelan", "Vietnamese", "Welsh", "Welsh", "Yemenite", "Zambian", "Zimbabwean"}));
		comboBox.setSelectedIndex(-1);
		GroupLayout gl_addAdmin = new GroupLayout(addAdmin);
		gl_addAdmin.setHorizontalGroup(
			gl_addAdmin.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_addAdmin.createSequentialGroup()
					.addGap(131)
					.addGroup(gl_addAdmin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addAdmin.createSequentialGroup()
							.addComponent(lblName)
							.addGap(261)
							.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_addAdmin.createSequentialGroup()
							.addComponent(lblPassword)
							.addGap(239)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_addAdmin.createSequentialGroup()
							.addComponent(lblMail)
							.addGap(276)
							.addComponent(textFieldMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblBDate)
						.addGroup(gl_addAdmin.createParallelGroup(Alignment.TRAILING, false)
							.addGroup(gl_addAdmin.createSequentialGroup()
								.addComponent(lblPhoneAdmin)
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textFieldPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(Alignment.LEADING, gl_addAdmin.createSequentialGroup()
								.addComponent(lblNationality)
								.addGap(234)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE))))
					.addGap(0, 501, Short.MAX_VALUE))
				.addGroup(gl_addAdmin.createSequentialGroup()
					.addContainerGap(992, Short.MAX_VALUE)
					.addComponent(btnSend, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_addAdmin.setVerticalGroup(
			gl_addAdmin.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_addAdmin.createSequentialGroup()
					.addGap(101)
					.addGroup(gl_addAdmin.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_addAdmin.createSequentialGroup()
							.addGap(3)
							.addComponent(lblName))
						.addComponent(textFieldName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_addAdmin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPassword)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_addAdmin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMail)
						.addComponent(textFieldMail, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addComponent(lblBDate)
					.addGap(150)
					.addGroup(gl_addAdmin.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPhoneAdmin)
						.addComponent(textFieldPhone, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(21)
					.addGroup(gl_addAdmin.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNationality)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(130)
					.addComponent(btnSend)
					.addContainerGap())
		);
		addAdmin.setLayout(gl_addAdmin);
		
		JPanel playerDelete = new JPanel();
		tabbedPaneAdmin.addTab("Delete player", null, playerDelete, null);
		
		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.addActionListener(this);
		
		JLabel lblSearchUser = new JLabel("Search a user:");
		lblSearchUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textFieldFindUser = new JTextField();
		textFieldFindUser.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldFindUser.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setVisible(false);
		
		GroupLayout gl_playerDelete = new GroupLayout(playerDelete);
		gl_playerDelete.setHorizontalGroup(
			gl_playerDelete.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_playerDelete.createSequentialGroup()
					.addContainerGap(990, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addContainerGap())
				.addGroup(gl_playerDelete.createSequentialGroup()
					.addGap(485)
					.addComponent(lblSearchUser)
					.addContainerGap(493, Short.MAX_VALUE))
				.addGroup(gl_playerDelete.createSequentialGroup()
					.addGap(438)
					.addComponent(textFieldFindUser, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(434, Short.MAX_VALUE))
				.addGroup(gl_playerDelete.createSequentialGroup()
					.addGap(412)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 328, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(333, Short.MAX_VALUE))
		);
		gl_playerDelete.setVerticalGroup(
			gl_playerDelete.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_playerDelete.createSequentialGroup()
					.addGap(79)
					.addComponent(lblSearchUser)
					.addGap(47)
					.addComponent(textFieldFindUser, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(83)
					.addComponent(textArea, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(btnDelete)
					.addContainerGap())
		);
		playerDelete.setLayout(gl_playerDelete);
		management.add(tabbedPaneAdmin);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(btnSend)) {
			if(!textFieldName.getText().isBlank() && !passwordField.getPassword().toString().isBlank() && !textFieldMail.getText().isBlank() && !textFieldPhone.getText().isBlank()
					&& comboBox.getSelectedIndex() != -1) {
				user = new Administrator();
				user.setName(textFieldName.getText());
				user.setPassword(passwordField.getPassword().toString());
				user.setEmail(textFieldMail.getText());
				//birthdate
				user.setPhone(textFieldPhone.getText());
				
					user.setNationality(comboBox.getSelectedItem().toString());
				
				((Administrator) user).setAddtions(0);
				//UserControllabe.addUser(user);
				JOptionPane.showMessageDialog(getParent(), "Enviado correctamente.");
				textFieldName.setText("");
				passwordField.setText("");
				textFieldMail.setText("");
				textFieldPhone.setText("");
				comboBox.setSelectedIndex(-1);
			}
			else {
				JOptionPane.showMessageDialog(this, "ERROR. Rellene todos los campos.");
			}
		}
		if(e.getSource().equals(btnDelete)) {
			user = null;
			if(!textFieldFindUser.getText().isBlank()) {
				//user.findUser(textFieldFindUser.getText());
				if(user != null) {
					textArea.append(user.getId() + "\n" + user.getName() + "\n" + user.getEmail() + "\n");
					textArea.setVisible(true);
					JOptionPane.showConfirmDialog(this, "Quiere borrar a " + user.getName() + "?");
				}
				else {
					JOptionPane.showMessageDialog(this, "No se ha encontrado el usuario.\nAsegúrese de introducir los datos correctamente.");
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "ERROR. Rellene todos los campos.");
			}
		}
	}
}