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
import model.Player;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
import javax.swing.JComboBox;

public class AddGame extends JDialog implements ActionListener, PropertyChangeListener {

	private final JPanel contentPanel = new JPanel();
	private Map<String, String> blueTeam = new HashMap<String, String>();
	private Map<String, String> redTeam = new HashMap<String, String>();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GameStorable gameStorable;
	private UserControllable userControllable;
	private ChampEditable champEditable;
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
	private JLabel lblDuration;
	private JComboBox comboBoxC5B;
	private JComboBox comboBoxP5B;
	private JComboBox comboBoxC4B;
	private JComboBox comboBoxP4B;
	private JComboBox comboBoxC3B;
	private JComboBox comboBoxP3B;
	private JComboBox comboBoxC2B;
	private JComboBox comboBoxP2B;
	private JComboBox comboBoxC1B;
	private JComboBox comboBoxP1B;
	private JComboBox comboBoxP1R;
	private JComboBox comboBoxC1R;
	private JComboBox comboBoxP2R;
	private JComboBox comboBoxC2R;
	private JComboBox comboBoxP3R;
	private JComboBox comboBoxC3R;
	private JComboBox comboBoxP4R;
	private JComboBox comboBoxC4R;
	private JComboBox comboBoxP5R;
	private JComboBox comboBoxC5R;
	private List<String> playersSelected, champsSelected;

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
		dateChooser.setEnabled(false);
		dateChooser.addPropertyChangeListener(this);

		textDuration = new JTextField();
		textDuration.setEditable(false);
		textDuration.setEnabled(false);
		textDuration.setColumns(10);
		textDuration.setBounds(281, 140, 52, 27);
		addGamePanel.add(textDuration);
		textDuration.addActionListener(this);

		chckbxT1 = new JCheckBox("Blue Team");
		chckbxT1.setForeground(new Color(255, 255, 255));
		chckbxT1.setFont(new Font("Bahnschrift", Font.PLAIN, 23));
		chckbxT1.setBounds(42, 236, 151, 36);
		chckbxT1.setOpaque(false);
		addGamePanel.add(chckbxT1);
		buttonGroup.add(chckbxT1);
		chckbxT1.setEnabled(false);
		chckbxT1.addActionListener(this);

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
		buttonGroup.add(chckbxT2);
		chckbxT2.setEnabled(false);
		chckbxT2.addActionListener(this);

		btnAdd = new JButton("ADD");
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBackground(new Color(0, 128, 128));
		btnAdd.setFont(new Font("Bahnschrift", Font.PLAIN, 15));
		btnAdd.setBounds(144, 326, 101, 33);
		btnAdd.addActionListener(this);
		addGamePanel.add(btnAdd);
		btnAdd.setEnabled(false);

		lblDuration = new JLabel("DURATION");
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

		JLabel iconJungleRed = new JLabel("");
		iconJungleRed.setIcon(
				new ImageIcon(AddGame.class.getResource("/img/lol_jungle_icon_by_divoras_degndao-fullview.png")));
		iconJungleRed.setBounds(20, 166, 101, 85);
		RedTeamPanel.add(iconJungleRed);

		JLabel iconMidRed = new JLabel("");
		iconMidRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/Middle_icon.png")));
		iconMidRed.setBounds(20, 271, 101, 85);
		RedTeamPanel.add(iconMidRed);

		JLabel iconBottonRed = new JLabel("");
		iconBottonRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/Bottom_icon.png")));
		iconBottonRed.setBounds(20, 378, 101, 85);
		RedTeamPanel.add(iconBottonRed);

		JLabel iconSupportRed = new JLabel("");
		iconSupportRed.setIcon(new ImageIcon(AddGame.class.getResource("/img/Controller_icon - copia (2).png")));
		iconSupportRed.setBounds(20, 499, 101, 85);
		RedTeamPanel.add(iconSupportRed);

		comboBoxP1R = new JComboBox();
		comboBoxP1R.setBounds(145, 71, 163, 25);
		RedTeamPanel.add(comboBoxP1R);
		comboBoxP1R.setEnabled(false);

		comboBoxC1R = new JComboBox();
		comboBoxC1R.setBounds(145, 106, 163, 25);
		RedTeamPanel.add(comboBoxC1R);
		comboBoxC1R.setEnabled(false);

		comboBoxP2R = new JComboBox();
		comboBoxP2R.setBounds(145, 177, 163, 25);
		RedTeamPanel.add(comboBoxP2R);
		comboBoxP2R.setEnabled(false);

		comboBoxC2R = new JComboBox();
		comboBoxC2R.setBounds(145, 212, 163, 25);
		RedTeamPanel.add(comboBoxC2R);
		comboBoxC2R.setEnabled(false);

		comboBoxP3R = new JComboBox();
		comboBoxP3R.setBounds(145, 282, 163, 25);
		RedTeamPanel.add(comboBoxP3R);
		comboBoxP3R.setEnabled(false);

		comboBoxC3R = new JComboBox();
		comboBoxC3R.setBounds(145, 317, 163, 25);
		RedTeamPanel.add(comboBoxC3R);
		comboBoxC3R.setEnabled(false);

		comboBoxP4R = new JComboBox();
		comboBoxP4R.setBounds(145, 394, 163, 25);
		RedTeamPanel.add(comboBoxP4R);
		comboBoxP4R.setEnabled(false);

		comboBoxC4R = new JComboBox();
		comboBoxC4R.setBounds(145, 429, 163, 25);
		RedTeamPanel.add(comboBoxC4R);
		comboBoxC4R.setEnabled(false);

		comboBoxP5R = new JComboBox();
		comboBoxP5R.setBounds(145, 508, 163, 25);
		RedTeamPanel.add(comboBoxP5R);
		comboBoxP5R.setEnabled(false);

		comboBoxC5R = new JComboBox();
		comboBoxC5R.setBounds(145, 543, 163, 25);
		RedTeamPanel.add(comboBoxC5R);
		comboBoxC5R.setEnabled(false);

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

		JLabel iconJungleBlue = new JLabel("");
		iconJungleBlue.setIcon(
				new ImageIcon(AddGame.class.getResource("/img/lol_jungle_icon_by_divoras_degndao-fullview.png")));
		iconJungleBlue.setBounds(20, 166, 101, 85);
		blueTeamPanel.add(iconJungleBlue);

		JLabel iconMidBlue = new JLabel("");
		iconMidBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/Middle_icon.png")));
		iconMidBlue.setBounds(20, 271, 101, 85);
		blueTeamPanel.add(iconMidBlue);

		JLabel iconBottonBlue = new JLabel("");
		iconBottonBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/Bottom_icon.png")));
		iconBottonBlue.setBounds(20, 378, 101, 85);
		blueTeamPanel.add(iconBottonBlue);

		JLabel iconSupportBlue = new JLabel("");
		iconSupportBlue.setIcon(new ImageIcon(AddGame.class.getResource("/img/Controller_icon - copia (2).png")));
		iconSupportBlue.setBounds(20, 499, 101, 85);
		blueTeamPanel.add(iconSupportBlue);

		comboBoxP1B = new JComboBox();
		comboBoxP1B.setBounds(145, 81, 163, 25);
		blueTeamPanel.add(comboBoxP1B);

		comboBoxC1B = new JComboBox();
		comboBoxC1B.setBounds(145, 116, 163, 25);
		blueTeamPanel.add(comboBoxC1B);

		comboBoxP2B = new JComboBox();
		comboBoxP2B.setBounds(145, 181, 163, 25);
		blueTeamPanel.add(comboBoxP2B);
		comboBoxP2B.setEnabled(false);

		comboBoxC2B = new JComboBox();
		comboBoxC2B.setBounds(145, 216, 163, 25);
		blueTeamPanel.add(comboBoxC2B);
		comboBoxC2B.setEnabled(false);

		comboBoxP3B = new JComboBox();
		comboBoxP3B.setBounds(145, 282, 163, 25);
		blueTeamPanel.add(comboBoxP3B);
		comboBoxP3B.setEnabled(false);

		comboBoxC3B = new JComboBox();
		comboBoxC3B.setBounds(145, 317, 163, 25);
		blueTeamPanel.add(comboBoxC3B);
		comboBoxC3B.setEnabled(false);

		comboBoxP4B = new JComboBox();
		comboBoxP4B.setBounds(145, 394, 163, 25);
		blueTeamPanel.add(comboBoxP4B);
		comboBoxP4B.setEnabled(false);

		comboBoxC4B = new JComboBox();
		comboBoxC4B.setBounds(145, 429, 163, 25);
		blueTeamPanel.add(comboBoxC4B);
		comboBoxC4B.setEnabled(false);

		comboBoxP5B = new JComboBox();
		comboBoxP5B.setBounds(145, 509, 163, 25);
		blueTeamPanel.add(comboBoxP5B);
		comboBoxP5B.setEnabled(false);

		comboBoxC5B = new JComboBox();
		comboBoxC5B.setBounds(145, 544, 163, 25);
		blueTeamPanel.add(comboBoxC5B);
		comboBoxC5B.setEnabled(false);

		panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0, 180));
		panel.setBounds(0, 10, 1280, 676);
		contentPanel.add(panel);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(-27, 10, 1307, 676);
		lblNewLabel.setIcon(new ImageIcon(AddGame.class.getResource("/img/Summoner27s_Rift_Update_Map1.jpg")));
		contentPanel.add(lblNewLabel);

		champsSelected = new ArrayList<String>();
		playersSelected = new ArrayList<String>();

		try {
			loadComboBox(comboBoxP1B, comboBoxC1B, null, null);
		} catch (PersonalizedException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e.getMessage(), "An unexpected error has occured!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void loadComboBox(JComboBox comboBoxPlayer, JComboBox comboBoxChamp, List<String> playersSelected,
			List<String> champsSelected) throws PersonalizedException {
		// TODO Auto-generated method stub
		List<Champ> champs = new ArrayList<Champ>();
		champs = champEditable.listChamp();
		boolean selected = false;
		for (Champ champ : champs) {
			if (champsSelected != null) {
				selected = false;
				for (int i = 0; i < champsSelected.size(); i++) {
					if (champsSelected.get(i).equals(champ.getName())) {
						selected = true;
						i = champsSelected.size();
					}
				}
			}
			if (!selected) {
				comboBoxChamp.addItem(champ.getName());
			}
		}
		Set<User> users = new HashSet<User>();
		users = userControllable.listPlayers();
		for (User user : users) {
			if (playersSelected != null) {
				selected = false;
				for (int i = 0; i < playersSelected.size(); i++) {
					if (playersSelected.get(i).equals(((Player) user).getNickname())) {
						selected = true;
						i = playersSelected.size();
					}
				}
			}
			if (!selected) {
				comboBoxPlayer.addItem(((Player) user).getNickname());
			}
		}
		comboBoxChamp.setSelectedIndex(-1);
		comboBoxPlayer.setSelectedIndex(-1);
		comboBoxChamp.addActionListener(this);
		comboBoxPlayer.addActionListener(this);
	}

	private void addGame() throws PersonalizedException {
		// TODO Auto-generated method stub
		Game aux = new Game();
		blueTeam.put((String) comboBoxP1B.getSelectedItem(), (String) comboBoxC1B.getSelectedItem());
		blueTeam.put((String) comboBoxP2B.getSelectedItem(), (String) comboBoxC2B.getSelectedItem());
		blueTeam.put((String) comboBoxP3B.getSelectedItem(), (String) comboBoxC3B.getSelectedItem());
		blueTeam.put((String) comboBoxP4B.getSelectedItem(), (String) comboBoxC4B.getSelectedItem());
		blueTeam.put((String) comboBoxP5B.getSelectedItem(), (String) comboBoxC5B.getSelectedItem());
		redTeam.put((String) comboBoxP1R.getSelectedItem(), (String) comboBoxC1R.getSelectedItem());
		redTeam.put((String) comboBoxP2R.getSelectedItem(), (String) comboBoxC2R.getSelectedItem());
		redTeam.put((String) comboBoxP3R.getSelectedItem(), (String) comboBoxC3R.getSelectedItem());
		redTeam.put((String) comboBoxP4R.getSelectedItem(), (String) comboBoxC4R.getSelectedItem());
		redTeam.put((String) comboBoxP5R.getSelectedItem(), (String) comboBoxC5R.getSelectedItem());
		aux.setDateGame(dateChooser.getDate().toInstant().atZone(ZoneId.of("Europe/Paris")).toLocalDate());
		aux.setDuration(Float.parseFloat(textDuration.getText()));
		aux.setId(gameStorable.addGame(aux));
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

			gameStorable.completeGame(aux.getId(), entry.getKey(), entry.getValue(), chckbxT1.isSelected(), role);
			count++;

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

			gameStorable.completeGame(aux.getId(), entry.getKey(), entry.getValue(), chckbxT2.isSelected(), role);
			count++;

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource().equals(comboBoxC1B) || e.getSource().equals(comboBoxP1B)) {
				if (comboBoxC1B.getSelectedIndex() != -1 && comboBoxP1B.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC1B.getSelectedItem());
					playersSelected.add((String) comboBoxP1B.getSelectedItem());
					comboBoxP2B.setEnabled(true);
					comboBoxC2B.setEnabled(true);
					comboBoxP1B.setEnabled(false);
					comboBoxC1B.setEnabled(false);
					loadComboBox(comboBoxP2B, comboBoxC2B, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC2B) || e.getSource().equals(comboBoxP2B)) {
				if (comboBoxC2B.getSelectedIndex() != -1 && comboBoxP2B.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC2B.getSelectedItem());
					playersSelected.add((String) comboBoxP2B.getSelectedItem());
					comboBoxP3B.setEnabled(true);
					comboBoxC3B.setEnabled(true);
					comboBoxP2B.setEnabled(false);
					comboBoxC2B.setEnabled(false);
					loadComboBox(comboBoxP3B, comboBoxC3B, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC3B) || e.getSource().equals(comboBoxP3B)) {
				if (comboBoxC3B.getSelectedIndex() != -1 && comboBoxP3B.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC3B.getSelectedItem());
					playersSelected.add((String) comboBoxP3B.getSelectedItem());
					comboBoxP4B.setEnabled(true);
					comboBoxC4B.setEnabled(true);
					comboBoxP3B.setEnabled(false);
					comboBoxC3B.setEnabled(false);
					loadComboBox(comboBoxP4B, comboBoxC4B, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC4B) || e.getSource().equals(comboBoxP4B)) {
				if (comboBoxC4B.getSelectedIndex() != -1 && comboBoxP4B.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC4B.getSelectedItem());
					playersSelected.add((String) comboBoxP4B.getSelectedItem());
					comboBoxP5B.setEnabled(true);
					comboBoxC5B.setEnabled(true);
					comboBoxP4B.setEnabled(false);
					comboBoxC4B.setEnabled(false);
					loadComboBox(comboBoxP5B, comboBoxC5B, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC5B) || e.getSource().equals(comboBoxP5B)) {
				if (comboBoxC5B.getSelectedIndex() != -1 && comboBoxP5B.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC5B.getSelectedItem());
					playersSelected.add((String) comboBoxP5B.getSelectedItem());
					comboBoxP1R.setEnabled(true);
					comboBoxC1R.setEnabled(true);
					comboBoxP5B.setEnabled(false);
					comboBoxC5B.setEnabled(false);
					loadComboBox(comboBoxP1R, comboBoxC1R, playersSelected, champsSelected);
				}
			}

			if (e.getSource().equals(comboBoxC1R) || e.getSource().equals(comboBoxP1R)) {
				if (comboBoxC1R.getSelectedIndex() != -1 && comboBoxP1R.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC1R.getSelectedItem());
					playersSelected.add((String) comboBoxP1R.getSelectedItem());
					comboBoxP2R.setEnabled(true);
					comboBoxC2R.setEnabled(true);
					comboBoxP1R.setEnabled(false);
					comboBoxC1R.setEnabled(false);
					loadComboBox(comboBoxP2R, comboBoxC2R, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC2R) || e.getSource().equals(comboBoxP2R)) {
				if (comboBoxC2R.getSelectedIndex() != -1 && comboBoxP2R.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC2R.getSelectedItem());
					playersSelected.add((String) comboBoxP2R.getSelectedItem());
					comboBoxP3R.setEnabled(true);
					comboBoxC3R.setEnabled(true);
					comboBoxP2R.setEnabled(false);
					comboBoxC2R.setEnabled(false);
					loadComboBox(comboBoxP3R, comboBoxC3R, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC3R) || e.getSource().equals(comboBoxP3R)) {
				if (comboBoxC3R.getSelectedIndex() != -1 && comboBoxP3R.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC3R.getSelectedItem());
					playersSelected.add((String) comboBoxP3R.getSelectedItem());
					comboBoxP4R.setEnabled(true);
					comboBoxC4R.setEnabled(true);
					comboBoxP3R.setEnabled(false);
					comboBoxC3R.setEnabled(false);
					loadComboBox(comboBoxP4R, comboBoxC4R, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC4R) || e.getSource().equals(comboBoxP4R)) {
				if (comboBoxC4R.getSelectedIndex() != -1 && comboBoxP4R.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC4R.getSelectedItem());
					playersSelected.add((String) comboBoxP4R.getSelectedItem());
					comboBoxP5R.setEnabled(true);
					comboBoxC5R.setEnabled(true);
					comboBoxP4R.setEnabled(false);
					comboBoxC4R.setEnabled(false);
					loadComboBox(comboBoxP5R, comboBoxC5R, playersSelected, champsSelected);
				}
			}
			if (e.getSource().equals(comboBoxC5R) || e.getSource().equals(comboBoxP5R)) {
				if (comboBoxC5R.getSelectedIndex() != -1 && comboBoxP5R.getSelectedIndex() != -1) {
					champsSelected.add((String) comboBoxC5R.getSelectedItem());
					playersSelected.add((String) comboBoxP5R.getSelectedItem());
					comboBoxP5R.setEnabled(false);
					comboBoxC5R.setEnabled(false);
					dateChooser.setEnabled(true);
				}
			}
			if (e.getSource().equals(btnAdd)) {
				addGame();
				this.dispose();
			}
			if (e.getSource().equals(textDuration)) {
				if (!textDuration.getText().isBlank()) {
					chckbxT1.setEnabled(true);
					chckbxT2.setEnabled(true);
					textDuration.setEnabled(false);
				}
			}
			if (e.getSource().equals(chckbxT1) || e.getSource().equals(chckbxT2)) {
				btnAdd.setEnabled(true);
			}
		} catch (PersonalizedException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e1.getMessage(), "An unexpected error has occured!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Method to check if the user exists
	 * 
	 * @param user
	 * @return correct
	 * @throws PersonalizedException
	 */

	public boolean checkUser(String user) throws PersonalizedException {
		boolean correct = true;
		User userCheck = userControllable.findUser(user, 2);
		if (userCheck == null && !user.isEmpty()) {
			correct = false;
			JOptionPane.showMessageDialog(this, "The nickname doesn't exist", "League of legends",
					JOptionPane.ERROR_MESSAGE);
		}

		return correct;
	}

	/**
	 * Method to check if the champ exits
	 * 
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

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getSource().equals(dateChooser)) {
			dateChooser.setEnabled(false);
			textDuration.setEnabled(true);
			textDuration.setEditable(true);
			textDuration.grabFocus();
		}
	}
}
