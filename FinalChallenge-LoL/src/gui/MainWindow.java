package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.JTableHeader;

import controller.*;
import model.*;
import java.util.List;
import java.util.ArrayList;

public class MainWindow extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField Nickname_TextField;
	private JTextField Email_textField;
	private JTextField textField_1;
	private JTextField Phone_textField;
	private JTextField Password_textField;
	private JTextField Nacionality_textField;
	private JTextField StartDate_textField;
	private JTextField Additions_textField;

	JPanel champsPlayer = new JPanel();
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

	private JPanel champAdmin = new JPanel();
	private JButton buttonChampsAdmin_Check = new JButton("Check name");
	private JLabel labeChampAdmin = new JLabel();
	private JButton buttonChampAdmin_Add = new JButton("Add Champ");
	private JButton buttonChampAdmin_Modify = new JButton("Modify Champ");

	private ChampEditable champEditable = new ChampEditableDBImplementation();

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

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 1196, 656);
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








		
		tabbedPane.addTab("CHAMPS", null, champsPlayer, null);
		champsPlayer.setLayout(null);
		
		JLabel labelChampsPlayer_Title = new JLabel("List Champs");
		labelChampsPlayer_Title.setFont(new Font("Arial Black", Font.BOLD, 22));
		labelChampsPlayer_Title.setBounds(501, 21, 301, 117);
		champsPlayer.add(labelChampsPlayer_Title);

		//Create a gorup and add each checkbox to it so only one can be selected
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

		//Confirmation button
		buttonChampsPlayer_Enter.setBounds(441, 340, 117, 29);
		buttonChampsPlayer_Enter.addActionListener(this);
		champsPlayer.add(buttonChampsPlayer_Enter);
		

		//Champs admin
		tabbedPane.addTab("CHAMPS", null, champAdmin, null);
		champAdmin.setLayout(null);
		ChampAdminTabConstruction();

		JPanel game = new JPanel();
		tabbedPane.addTab("GAME", null, game, null);
		
		JPanel stadistics = new JPanel();
		tabbedPane.addTab("STADISTICS", null, stadistics, null);
		
		JPanel management = new JPanel();
		tabbedPane.addTab("MANAGEMENT", null, management, null);
		
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

			JPanel panelChampAdmin = new JPanel();
			panelChampAdmin.setBounds(740, 207, 296, 134);
			champAdmin.add(panelChampAdmin);
			panelChampAdmin.setVisible(false);
			panelChampAdmin.setBackground(Color.LIGHT_GRAY);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(buttonChampsPlayer_Enter))
				listChampPlayer();
			if (e.getSource().equals(buttonChampsAdmin_Check))
				checkChampAdmin();
			if (e.getSource().equals(buttonChampAdmin_Add))
				addChampAdmin();
			if (e.getSource().equals(buttonChampAdmin_Modify))
				executeModificationChampAdmin();;
		}

		public void checkChampAdmin() {
			if (textFieldChampsAdmin_Name.getText().isEmpty()) 
    			JOptionPane.showMessageDialog(null,"Añade un nombre correcto","Alert",JOptionPane.WARNING_MESSAGE); 
			else 
				addOrModifyChamp();	
		}

		public void addOrModifyChamp() {
			buttonChampsAdmin_Check.setVisible(false);
			JLabel labelChampsAdmin_Position = new JLabel("Position");
			labelChampsAdmin_Position.setBounds(346, 162, 61, 16);
			champAdmin.add(labelChampsAdmin_Position);
					
			String[] positions = {"TOP", "JNG", "MID", "ADC", "SUP"};  
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
			}
			else 
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

			return(champ);
		}

		public boolean checkFieldsChampAdmin() {						
			if (jComboBoxChampAdmin_Positions.getSelectedIndex() == -1 || textFieldChampAdmin_Region.getText().isBlank() || textFieldChampAdmin_Passive.getText().isBlank() || textFieldChampAdmin_Q.getText().isBlank() || textFieldChampAdmin_W.getText().isBlank() || textFieldChampAdmin_E.getText().isBlank() || textFieldChampAdmin_R.getText().isBlank()) {
				JOptionPane.showMessageDialog(null,"Please fill all the fields", "Alert", JOptionPane.WARNING_MESSAGE);
				return false;
			}
			return true; 		
		}
		
		public void addChampAdmin() {
			Champ champ = new Champ();
			if (checkFieldsChampAdmin() == false)
				return;
			champ = fillChamp(champ);
			if (champEditable.addChamp(champ)) 
				JOptionPane.showMessageDialog(null,"Champ added successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null,"Champ couldn't be added", "Alert", JOptionPane.WARNING_MESSAGE);
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

		public void executeModificationChampAdmin() {
			Champ champ = new Champ();
			if (checkFieldsChampAdmin() == false)
				return;
			champ = fillChamp(champ);
			if (champEditable.modifyChamp(champ)) 
				JOptionPane.showMessageDialog(null,"Champ modified successfully", "Alert", JOptionPane.INFORMATION_MESSAGE);
			else
				JOptionPane.showMessageDialog(null,"Champ couldn't be modified", "Alert", JOptionPane.WARNING_MESSAGE);
			removeChampAdminTab();
		}

		public void removeChampAdminTab() {
			champAdmin.removeAll();
			ChampAdminTabConstruction();
		}

		public void listChampPlayer() {
			if (checkBoxChampsPlayer.isSelected() || checkBoxChampsPlayer_Filtered.isSelected()) {

				List<Champ> list = null;
				if (checkBoxChampsPlayer.isSelected()) {
					//Get an array of all champs
					list = champEditable.listChamp();
					//convert champs list to a bidimensional array
				} else if (checkBoxChampsPlayer_Filtered.isSelected()) {
					//Show champs by filter
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
				data[i] = new String[] { champ.getName(), champ.getRegion(), champ.getPassive(), champ.getPosition(), champ.getQ(), champ.getW(), champ.getE(), champ.getR()};
			};
			JScrollPane scrollPaneChampPlayer = new JScrollPane();
			scrollPaneChampPlayer.setBounds(175, 400, 700, 200);
			champsPlayer.add(scrollPaneChampPlayer);

			String[] columnNames = { "Name", "Region", "Passive", "Position", "Q", "W", "E", "R"};
			JTable table = new JTable(data, columnNames);
			scrollPaneChampPlayer.setViewportView(table);

			JTableHeader tableHeaderChampPlayer = table.getTableHeader();
			tableHeaderChampPlayer.setBackground(new Color(225, 223, 225));
		}

}
