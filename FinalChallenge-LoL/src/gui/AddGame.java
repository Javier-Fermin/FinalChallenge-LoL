package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.ChampEditable;
import controller.GameStorable;
import controller.GameStorableDBImplementation;
import controller.UserControllable;
import exceptions.PersonalizedException;
import model.Champ;
import model.Game;
import model.User;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.ButtonGroup;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import javax.swing.JLayeredPane;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTabbedPane;
import java.awt.Toolkit;

public class AddGame extends JDialog implements ActionListener, FocusListener {

	private final JPanel contentPanel = new JPanel();
	private Map<String, String> blueTeam = new HashMap<String, String>();
	private Map<String, String> redTeam = new HashMap<String, String>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GameStorable gameStorable;
	private UserControllable userControllable;
	private ChampEditable champEditable;
	private JTextField textNicknameP1T1;
	private JTextField textChampP1T1;
	private JTextField textNicknameP2T1;
	private JTextField textChampP2T1;
	private JTextField textNicknameP3T1;
	private JTextField textChampP3T1;
	private JTextField textNicknameP4T1;
	private JTextField textChampP4T1;
	private JTextField textNicknameP5T1;
	private JTextField textChampP5T1;
	private JTextField textNicknameP1T2;
	private JTextField textChampP1T2;
	private JTextField textNicknameP2T2;
	private JTextField textChampP2T2;
	private JTextField textNicknameP3T2;
	private JTextField textChampP3T2;
	private JTextField textNicknameP4T2;
	private JTextField textChampP4T2;
	private JTextField textNicknameP5T2;
	private JTextField textChampP5T2;
	private JLabel lblDate;
	private JDateChooser dateChooser;
	private JTextField textDuration;
	private JCheckBox chckbxT1;
	private JLabel lblWinner;
	private JCheckBox chckbxT2;
	private JButton btnAdd;
	private JLabel lblGame;
	private JLabel lblGame_1;
	private JLabel iconlol;
	private JPanel panel;

	/**
	 * Create the dialog.
	 * 
	 * @param gameStorable
	 * @param b
	 * @param mainWindow
	 */
	public AddGame(MainWindow mainWindow, boolean b, GameStorable gameStorable, UserControllable userControllable,
			ChampEditable champEditable) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AddGame.class.getResource("/img/lolLogo (2).png")));
		this.gameStorable = gameStorable;
		this.userControllable = userControllable;
		this.champEditable = champEditable;
		this.setModal(b);
		setBounds(100, 100, 1294, 728);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		iconlol = new JLabel("");
		iconlol.setIcon(new ImageIcon(AddGame.class.getResource("/img/lolLogo (2).png")));
		iconlol.setBounds(591, 135, 80, 76);
		contentPanel.add(iconlol);
		
		lblGame = new JLabel("GAME");
		lblGame.setForeground(new Color(0, 139, 139));
		lblGame.setFont(new Font("Bahnschrift", Font.BOLD, 70));
		lblGame.setBounds(523, 61, 214, 89);
		contentPanel.add(lblGame);
		
		lblGame_1 = new JLabel("GAME");
		lblGame_1.setForeground(new Color(184, 134, 11));
		lblGame_1.setFont(new Font("Bahnschrift", Font.BOLD, 70));
		lblGame_1.setBounds(519, 61, 214, 89);
		contentPanel.add(lblGame_1);
		
		JLayeredPane addGamePanel = new JLayeredPane();
		addGamePanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(218, 165, 32), null));
		addGamePanel.setBounds(439, 225, 366, 369);
		contentPanel.add(addGamePanel);
		addGamePanel.setLayout(null);
		
		lblDate = new JLabel("DATE");
		lblDate.setForeground(Color.WHITE);
		lblDate.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblDate.setBounds(10, 64, 82, 49);
		addGamePanel.add(lblDate);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("dd MM yy");
		dateChooser.setBounds(87, 76, 246, 27);
		addGamePanel.add(dateChooser);
		
		textDuration = new JTextField();
		textDuration.setColumns(10);
		textDuration.setBounds(281, 140, 52, 27);
		addGamePanel.add(textDuration);
		
		chckbxT1 = new JCheckBox("Blue Team");
		chckbxT1.setForeground(new Color(255, 255, 255));
		chckbxT1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		chckbxT1.setBounds(42, 236, 151, 36);
		chckbxT1.setOpaque(false);
		addGamePanel.add(chckbxT1);
		
		lblWinner = new JLabel("WINNER");
		lblWinner.setForeground(new Color(255, 255, 255));
		lblWinner.setFont(new Font("Bahnschrift", Font.PLAIN, 25));
		lblWinner.setBounds(128, 193, 117, 32);
		addGamePanel.add(lblWinner);
		
		chckbxT2 = new JCheckBox("Red Team");
		chckbxT2.setForeground(new Color(255, 255, 255));
		chckbxT2.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		chckbxT2.setBounds(42, 288, 187, 32);
		chckbxT2.setOpaque(false);
		addGamePanel.add(chckbxT2);
		
		btnAdd = new JButton("ADD");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setBackground(new Color(0, 128, 128));
		btnAdd.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnAdd.setBounds(144, 326, 101, 33);
		btnAdd.addActionListener(this);
		addGamePanel.add(btnAdd);
		
		JLabel lblDuration = new JLabel("DURATION");
		lblDuration.setForeground(Color.WHITE);
		lblDuration.setFont(new Font("Bahnschrift", Font.PLAIN, 26));
		lblDuration.setBounds(10, 134, 176, 49);
		addGamePanel.add(lblDuration);
		
		JLayeredPane RedTeamPanel = new JLayeredPane();
		RedTeamPanel.setBounds(858, 37, 401, 613);
		RedTeamPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, Color.RED, null));
		contentPanel.add(RedTeamPanel);
		
		JLabel lableRedTeam = new JLabel("RED TEAM");
		lableRedTeam.setForeground(Color.RED);
		lableRedTeam.setFont(new Font("Bahnschrift", Font.BOLD, 26));
		lableRedTeam.setBounds(145, 20, 163, 28);
		RedTeamPanel.add(lableRedTeam);
		
		JLabel iconTopRed = new JLabel("");
		iconTopRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/Top_icon.png")));
		iconTopRed.setBounds(20, 61, 101, 85);
		RedTeamPanel.add(iconTopRed);
		
		textNicknameP1T2 = new JTextField();
		textNicknameP1T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP1T2.setToolTipText("Nickname\r\n");
		textNicknameP1T2.setColumns(10);
		textNicknameP1T2.setBounds(145, 71, 163, 27);
		RedTeamPanel.add(textNicknameP1T2);
		
		textChampP1T2 = new JTextField();
		textChampP1T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP1T2.setToolTipText("Champ");
		textChampP1T2.setColumns(10);
		textChampP1T2.setBounds(145, 119, 163, 27);
		RedTeamPanel.add(textChampP1T2);
		
		JLabel iconJungleRed = new JLabel("");
		iconJungleRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/lol_jungle_icon_by_divoras_degndao-fullview.png")));
		iconJungleRed.setBounds(20, 166, 101, 85);
		RedTeamPanel.add(iconJungleRed);
		
		textNicknameP2T2 = new JTextField();
		textNicknameP2T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP2T2.setToolTipText("Nickname\r\n");
		textNicknameP2T2.setColumns(10);
		textNicknameP2T2.setBounds(145, 177, 163, 27);
		RedTeamPanel.add(textNicknameP2T2);
		
		textChampP2T2 = new JTextField();
		textChampP2T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP2T2.setToolTipText("Champ");
		textChampP2T2.setColumns(10);
		textChampP2T2.setBounds(145, 224, 163, 27);
		RedTeamPanel.add(textChampP2T2);
		
		JLabel iconMidRed = new JLabel("");
		iconMidRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/Middle_icon.png")));
		iconMidRed.setBounds(20, 271, 101, 85);
		RedTeamPanel.add(iconMidRed);
		
		textNicknameP3T2 = new JTextField();
		textNicknameP3T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP3T2.setToolTipText("Nickname\r\n");
		textNicknameP3T2.setColumns(10);
		textNicknameP3T2.setBounds(145, 282, 163, 27);
		RedTeamPanel.add(textNicknameP3T2);
		
		textChampP3T2 = new JTextField();
		textChampP3T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP3T2.setToolTipText("Champ");
		textChampP3T2.setColumns(10);
		textChampP3T2.setBounds(145, 329, 163, 27);
		RedTeamPanel.add(textChampP3T2);
		
		JLabel iconBottonRed = new JLabel("");
		iconBottonRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/Bottom_icon.png")));
		iconBottonRed.setBounds(20, 378, 101, 85);
		RedTeamPanel.add(iconBottonRed);
		
		textNicknameP4T2 = new JTextField();
		textNicknameP4T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP4T2.setToolTipText("Nickname\r\n");
		textNicknameP4T2.setColumns(10);
		textNicknameP4T2.setBounds(145, 394, 163, 27);
		RedTeamPanel.add(textNicknameP4T2);
		
		textChampP4T2 = new JTextField();
		textChampP4T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP4T2.setToolTipText("Champ");
		textChampP4T2.setColumns(10);
		textChampP4T2.setBounds(145, 436, 163, 27);
		RedTeamPanel.add(textChampP4T2);
		
		JLabel iconSupportRed = new JLabel("");
		iconSupportRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/Controller_icon - copia (2).png")));
		iconSupportRed.setBounds(20, 499, 101, 85);
		RedTeamPanel.add(iconSupportRed);
		
		textNicknameP5T2 = new JTextField();
		textNicknameP5T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP5T2.setToolTipText("Nickname\r\n");
		textNicknameP5T2.setColumns(10);
		textNicknameP5T2.setBounds(145, 509, 163, 27);
		RedTeamPanel.add(textNicknameP5T2);
		
		textChampP5T2 = new JTextField();
		textChampP5T2.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP5T2.setToolTipText("Champ");
		textChampP5T2.setColumns(10);
		textChampP5T2.setBounds(145, 557, 163, 27);
		RedTeamPanel.add(textChampP5T2);
		
		JLayeredPane blueTeamPanel = new JLayeredPane();
		blueTeamPanel.setBounds(10, 37, 401, 613);
		blueTeamPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 139, 139), null));
		contentPanel.add(blueTeamPanel);
		{
			JLabel lblNewLabel_1 = new JLabel("BLUE TEAM");
			lblNewLabel_1.setForeground(new Color(0, 128, 128));
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 26));
			lblNewLabel_1.setBounds(126, 23, 163, 28);
			blueTeamPanel.add(lblNewLabel_1);
		}
		{
			JLabel iconTopBlue = new JLabel("");
			iconTopBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/Top_icon.png")));
			iconTopBlue.setBounds(20, 61, 101, 85);
			blueTeamPanel.add(iconTopBlue);
		}
		
		textNicknameP1T1 = new JTextField();
		textNicknameP1T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP1T1.setToolTipText("Nickname\r\n");
		textNicknameP1T1.setBounds(145, 79, 163, 27);
		blueTeamPanel.add(textNicknameP1T1);
		textNicknameP1T1.setColumns(10);
		
		textChampP1T1 = new JTextField();
		textChampP1T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP1T1.setToolTipText("Champ");
		textChampP1T1.setColumns(10);
		textChampP1T1.setBounds(145, 119, 163, 27);
		blueTeamPanel.add(textChampP1T1);
		
		JLabel iconJungleBlue = new JLabel("");
		iconJungleBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/lol_jungle_icon_by_divoras_degndao-fullview.png")));
		iconJungleBlue.setBounds(20, 166, 101, 85);
		blueTeamPanel.add(iconJungleBlue);
		
		textNicknameP2T1 = new JTextField();
		textNicknameP2T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP2T1.setToolTipText("Nickname\r\n");
		textNicknameP2T1.setColumns(10);
		textNicknameP2T1.setBounds(145, 177, 163, 27);
		blueTeamPanel.add(textNicknameP2T1);
		
		textChampP2T1 = new JTextField();
		textChampP2T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP2T1.setToolTipText("Champ");
		textChampP2T1.setColumns(10);
		textChampP2T1.setBounds(145, 214, 163, 27);
		blueTeamPanel.add(textChampP2T1);
		
		JLabel iconMidBlue = new JLabel("");
		iconMidBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/Middle_icon.png")));
		iconMidBlue.setBounds(20, 271, 101, 85);
		blueTeamPanel.add(iconMidBlue);
		
		textNicknameP3T1 = new JTextField();
		textNicknameP3T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP3T1.setToolTipText("Nickname\r\n");
		textNicknameP3T1.setColumns(10);
		textNicknameP3T1.setBounds(145, 282, 163, 27);
		blueTeamPanel.add(textNicknameP3T1);
		
		textChampP3T1 = new JTextField();
		textChampP3T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP3T1.setToolTipText("Champ");
		textChampP3T1.setColumns(10);
		textChampP3T1.setBounds(145, 319, 163, 27);
		blueTeamPanel.add(textChampP3T1);
		
		JLabel iconBottonBlue = new JLabel("");
		iconBottonBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/Bottom_icon.png")));
		iconBottonBlue.setBounds(20, 378, 101, 85);
		blueTeamPanel.add(iconBottonBlue);
		
		textNicknameP4T1 = new JTextField();
		textNicknameP4T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP4T1.setToolTipText("Nickname\r\n");
		textNicknameP4T1.setColumns(10);
		textNicknameP4T1.setBounds(145, 390, 163, 27);
		blueTeamPanel.add(textNicknameP4T1);
		
		textChampP4T1 = new JTextField();
		textChampP4T1.setToolTipText("Champ");
		textChampP4T1.setColumns(10);
		textChampP4T1.setBounds(145, 427, 163, 27);
		blueTeamPanel.add(textChampP4T1);
		
		JLabel iconSupportBlue = new JLabel("");
		iconSupportBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/Controller_icon - copia (2).png")));
		iconSupportBlue.setBounds(20, 499, 101, 85);
		blueTeamPanel.add(iconSupportBlue);
		
		textNicknameP5T1 = new JTextField();
		textNicknameP5T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textNicknameP5T1.setToolTipText("Nickname\r\n");
		textNicknameP5T1.setColumns(10);
		textNicknameP5T1.setBounds(145, 509, 163, 27);
		blueTeamPanel.add(textNicknameP5T1);
		
		textChampP5T1 = new JTextField();
		textChampP5T1.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		textChampP5T1.setToolTipText("Champ");
		textChampP5T1.setColumns(10);
		textChampP5T1.setBounds(145, 546, 163, 27);
		blueTeamPanel.add(textChampP5T1);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 180));
		panel.setBounds(0, 10, 1280, 676);
		contentPanel.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-27, 10, 1307, 676);
		lblNewLabel.setIcon(new ImageIcon(AddGame.class.getResource("/img/Summoner27s_Rift_Update_Map1.jpg")));
		contentPanel.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}

	private void addGame() throws PersonalizedException {
		// TODO Auto-generated method stub
		Game aux = new Game();
		if (checkFields()) {
			blueTeam.put(textNicknameP1T1.getText(), textChampP1T1.getText());
			blueTeam.put(textNicknameP2T1.getText(), textChampP2T1.getText());
			blueTeam.put(textNicknameP3T1.getText(), textChampP3T1.getText());
			blueTeam.put(textNicknameP4T1.getText(), textChampP4T1.getText());
			blueTeam.put(textNicknameP5T1.getText(), textChampP5T1.getText());
			redTeam.put(textNicknameP1T2.getText(), textChampP1T2.getText());
			redTeam.put(textNicknameP2T2.getText(), textChampP2T2.getText());
			redTeam.put(textNicknameP3T2.getText(), textChampP3T2.getText());
			redTeam.put(textNicknameP4T2.getText(), textChampP4T2.getText());
			redTeam.put(textNicknameP5T2.getText(), textChampP5T2.getText());
			aux.setDateGame(dateChooser.getDate().toInstant().atZone(ZoneId.of("Europe/Paris")).toLocalDate());
			aux.setDuration(Float.parseFloat(textDuration.getText()));
			aux.setId(gameStorable.addGame(aux));
		} else {
			JOptionPane.showMessageDialog(this, "There are empty fields. Please check it!", "League of legends",
					JOptionPane.ERROR_MESSAGE);
		}
		Set<Entry<String, String>> redTeamSet = redTeam.entrySet(), blueTeamSet = blueTeam.entrySet();
		int count = 0;
		String role = null;
		for (Entry<String, String> entry : blueTeamSet) {
			if (count == 0) {
				role = "TOP";
			}
			if (count == 1) {
				role = "JNG";
			}
			if (count == 2) {
				role = "MID";
			}
			if (count == 3) {
				role = "ADC";
			}
			if (count == 4) {
				role = "SUP";
			}
			if(checkFields()) {
			gameStorable.completeGame(aux.getId(), entry.getKey(), entry.getValue(), chckbxT1.isSelected(), role);
			count++;
			}

		}
		count = 0;
		for (Entry<String, String> entry : redTeamSet) {
			if (count == 0) {
				role = "TOP";
			}
			if (count == 1) {
				role = "JNG";
			}
			if (count == 2) {
				role = "MID";
			}
			if (count == 3) {
				role = "ADC";
			}
			if (count == 4) {
				role = "SUP";
			}
			if(checkFields()) {
			gameStorable.completeGame(aux.getId(), entry.getKey(), entry.getValue(), chckbxT2.isSelected(), role);
			count++;
			}

		}
	}
	/**
	 * Method to check if the user exists
	 * @param user
	 * @return correct
	 * @throws PersonalizedException
	 */

	public boolean checkUser(String user) throws PersonalizedException {
		boolean correct = true;
		User userCheck = userControllable.findUser(user);
		if (userCheck == null && !user.isEmpty()) {
			correct = false;
			JOptionPane.showMessageDialog(this, "The nickname doesn't exist", "League of legends",
					JOptionPane.ERROR_MESSAGE);
		}

		return correct;
	}
	/**
	 * Method to check if the champ exits
	 * @param champ
	 * @return
	 * @throws PersonalizedException
	 */

	public boolean checkChamp(String champ) throws PersonalizedException {
		boolean correct = true;

		Champ champCheck = champEditable.checkChampName(champ);
		if (champCheck == null && !champ.isEmpty()) {
			correct = false;
			JOptionPane.showMessageDialog(this, "Champ doesn't exist", "League of legends", JOptionPane.ERROR_MESSAGE);
		}
		return correct;
	}

	/**
	 * Method to check if the fields aren't empty before sending the information
	 * @return
	 */
	public boolean checkFields() {
		boolean correct = false;
		if (textChampP1T1.getText().isBlank() || textChampP2T1.getText().isBlank() || textChampP3T1.getText().isBlank()
				|| textChampP4T1.getText().isBlank() || textChampP5T1.getText().isBlank()
				|| textNicknameP1T1.getText().isBlank() || textNicknameP2T1.getText().isBlank()
				|| textNicknameP3T1.getText().isBlank() || textNicknameP4T1.getText().isBlank()
				|| textNicknameP5T1.getText().isBlank() || textDuration.getText().isBlank()
				|| dateChooser.getDate() == null) {
			correct = false;

			if (chckbxT1.isSelected() || chckbxT2.isSelected()) {
				correct = true;
			} else {
				correct = false;
			}
		}
		return correct;
	}

	/**
	 * Method implemented by FocusListener but not used
	 */
	@Override
	public void focusGained(FocusEvent e) {
		// not used

	}
	/**
	 * Method to make validations when focusLost
	 */

	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource().equals(textNicknameP1T1)) {
			try {
				if (!checkUser(textNicknameP1T1.getText())) {
					textNicknameP1T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textNicknameP1T2)) {
			try {
				if (!checkUser(textNicknameP1T2.getText())) {
					textNicknameP1T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textNicknameP2T1)) {
			try {
				if (!checkUser(textNicknameP2T1.getText())) {
					textNicknameP2T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textNicknameP2T2)) {
			try {
				if (!checkUser(textNicknameP2T2.getText())) {
					textNicknameP2T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textNicknameP3T1)) {
			try {
				if (!checkUser(textNicknameP3T1.getText())) {
					textNicknameP3T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textNicknameP3T2)) {
			try {
				if (!checkUser(textNicknameP3T2.getText())) {
					textNicknameP3T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(textNicknameP4T1)) {
			try {
				if (!checkUser(textNicknameP4T1.getText())) {
					textNicknameP4T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textNicknameP4T2)) {
			try {
				if (!checkUser(textNicknameP4T2.getText())) {
					textNicknameP4T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(textNicknameP5T1)) {
			try {
				if (!checkUser(textNicknameP5T1.getText())) {
					textNicknameP5T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textNicknameP5T2)) {
			try {
				if (!checkUser(textNicknameP5T2.getText())) {
					textNicknameP5T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(textChampP1T1)) {
			try {
				if (!checkChamp(textChampP1T1.getText())) {
					textChampP1T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textChampP1T2)) {
			try {
				if (!checkChamp(textChampP1T2.getText())) {
					textChampP1T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(textChampP2T1)) {
			try {
				if (!checkChamp(textChampP2T1.getText())) {
					textChampP2T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(textChampP2T2)) {
			try {
				if (!checkChamp(textChampP2T2.getText())) {
					textChampP2T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(textChampP3T1)) {
			try {
				if (!checkChamp(textChampP3T1.getText())) {
					textChampP3T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textChampP3T2)) {
			try {
				if (!checkChamp(textChampP3T2.getText())) {
					textChampP3T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textChampP4T1)) {
			try {
				if (!checkChamp(textChampP4T1.getText())) {
					textChampP4T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textChampP4T2)) {
			try {
				if (!checkChamp(textChampP4T2.getText())) {
					textChampP4T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if (e.getSource().equals(textChampP5T1)) {
			try {
				if (!checkChamp(textChampP5T1.getText())) {
					textChampP5T1.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		if (e.getSource().equals(textChampP5T2)) {
			try {
				if (!checkChamp(textChampP5T2.getText())) {
					textChampP5T2.setText("");
				}

			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		if(e.getSource().equals(btnAdd)) {
			try {
				addGame();
			} catch (PersonalizedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
