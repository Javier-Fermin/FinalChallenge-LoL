package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.GameStorable;
import controller.GameStorableDBImplementation;
import model.Game;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class AddGame extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private Map <String,String> blueTeam=new HashMap<String,String>();
	private Map <String,String> redTeam=new HashMap<String,String>();
	private JTextField textChampP5T1;
	private JTextField textNicknameP5T1;
	private JTextField textNicknameP4T1;
	private JTextField textChampP4T1;
	private JTextField textChampP3T1;
	private JTextField textNicknameP3T1;
	private JTextField textNicknameP2T1;
	private JTextField textChampP2T1;
	private JTextField textChampP1T1;
	private JTextField textNicknameP1T1;
	private JTextField textNicknameP1T2;
	private JTextField textChampP1T2;
	private JTextField textNicknameP2T2;
	private JTextField textChampP2T2;
	private JTextField textChampP3T2;
	private JTextField textNicknameP3T2;
	private JTextField textChampP4T2;
	private JTextField textNicknameP4T2;
	private JTextField textChampP5T2;
	private JTextField textNicknameP5T2;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private GameStorable gameStorable;
	private JButton btnAdd;
	private JDateChooser dateChooser;
	private JTextField textDuration;
	private JCheckBox chckbxT1;
	private JCheckBox chckbxT2;

	/**
	 * Create the dialog.
	 * @param gameStorable 
	 * @param b 
	 * @param mainWindow 
	 */
	public AddGame(MainWindow mainWindow, boolean b, GameStorable gameStorable) {
		this.gameStorable = gameStorable;
		this.setModal(b);
		setBounds(100, 100, 745, 791);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JSplitPane splitPaneTeams = new JSplitPane();
			splitPaneTeams.setContinuousLayout(true);
			GridBagConstraints gbc_splitPaneTeams = new GridBagConstraints();
			gbc_splitPaneTeams.gridheight = 8;
			gbc_splitPaneTeams.gridwidth = 14;
			gbc_splitPaneTeams.insets = new Insets(0, 0, 5, 5);
			gbc_splitPaneTeams.fill = GridBagConstraints.BOTH;
			gbc_splitPaneTeams.gridx = 5;
			gbc_splitPaneTeams.gridy = 0;
			contentPanel.add(splitPaneTeams, gbc_splitPaneTeams);
			{
				JPanel panel = new JPanel();
				splitPaneTeams.setLeftComponent(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
				gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel lblTeam1 = new JLabel("Blue Team");
					GridBagConstraints gbc_lblTeam1 = new GridBagConstraints();
					gbc_lblTeam1.insets = new Insets(0, 0, 5, 5);
					gbc_lblTeam1.gridx = 2;
					gbc_lblTeam1.gridy = 0;
					panel.add(lblTeam1, gbc_lblTeam1);
				}
				{
					JLabel lblPlayer1T1 = new JLabel("Player 1");
					GridBagConstraints gbc_lblPlayer1T1 = new GridBagConstraints();
					gbc_lblPlayer1T1.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer1T1.gridx = 1;
					gbc_lblPlayer1T1.gridy = 2;
					panel.add(lblPlayer1T1, gbc_lblPlayer1T1);
				}
				{
					textNicknameP1T1 = new JTextField();
					GridBagConstraints gbc_textNicknameP1T1 = new GridBagConstraints();
					gbc_textNicknameP1T1.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP1T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP1T1.gridx = 3;
					gbc_textNicknameP1T1.gridy = 2;
					panel.add(textNicknameP1T1, gbc_textNicknameP1T1);
					textNicknameP1T1.setColumns(10);
				}
				{
					JLabel lblTopT1 = new JLabel("TOP");
					GridBagConstraints gbc_lblTopT1 = new GridBagConstraints();
					gbc_lblTopT1.insets = new Insets(0, 0, 5, 5);
					gbc_lblTopT1.gridx = 1;
					gbc_lblTopT1.gridy = 3;
					panel.add(lblTopT1, gbc_lblTopT1);
				}
				{
					textChampP1T1 = new JTextField();
					GridBagConstraints gbc_textChampP1T1 = new GridBagConstraints();
					gbc_textChampP1T1.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP1T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP1T1.gridx = 3;
					gbc_textChampP1T1.gridy = 3;
					panel.add(textChampP1T1, gbc_textChampP1T1);
					textChampP1T1.setColumns(10);
				}
				{
					JLabel lblPlayer2T1 = new JLabel("Player 2");
					GridBagConstraints gbc_lblPlayer2T1 = new GridBagConstraints();
					gbc_lblPlayer2T1.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer2T1.gridx = 1;
					gbc_lblPlayer2T1.gridy = 5;
					panel.add(lblPlayer2T1, gbc_lblPlayer2T1);
				}
				{
					textNicknameP2T1 = new JTextField();
					GridBagConstraints gbc_textNicknameP2T1 = new GridBagConstraints();
					gbc_textNicknameP2T1.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP2T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP2T1.gridx = 3;
					gbc_textNicknameP2T1.gridy = 5;
					panel.add(textNicknameP2T1, gbc_textNicknameP2T1);
					textNicknameP2T1.setColumns(10);
				}
				{
					JLabel lblJngT1 = new JLabel("JNG");
					GridBagConstraints gbc_lblJngT1 = new GridBagConstraints();
					gbc_lblJngT1.insets = new Insets(0, 0, 5, 5);
					gbc_lblJngT1.gridx = 1;
					gbc_lblJngT1.gridy = 6;
					panel.add(lblJngT1, gbc_lblJngT1);
				}
				{
					textChampP2T1 = new JTextField();
					GridBagConstraints gbc_textChampP2T1 = new GridBagConstraints();
					gbc_textChampP2T1.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP2T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP2T1.gridx = 3;
					gbc_textChampP2T1.gridy = 6;
					panel.add(textChampP2T1, gbc_textChampP2T1);
					textChampP2T1.setColumns(10);
				}
				{
					JLabel lblPlayer3T1 = new JLabel("Player 3");
					GridBagConstraints gbc_lblPlayer3T1 = new GridBagConstraints();
					gbc_lblPlayer3T1.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer3T1.gridx = 1;
					gbc_lblPlayer3T1.gridy = 8;
					panel.add(lblPlayer3T1, gbc_lblPlayer3T1);
				}
				{
					textNicknameP3T1 = new JTextField();
					GridBagConstraints gbc_textNicknameP3T1 = new GridBagConstraints();
					gbc_textNicknameP3T1.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP3T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP3T1.gridx = 3;
					gbc_textNicknameP3T1.gridy = 8;
					panel.add(textNicknameP3T1, gbc_textNicknameP3T1);
					textNicknameP3T1.setColumns(10);
				}
				{
					JLabel lblMidT1 = new JLabel("MID");
					GridBagConstraints gbc_lblMidT1 = new GridBagConstraints();
					gbc_lblMidT1.insets = new Insets(0, 0, 5, 5);
					gbc_lblMidT1.gridx = 1;
					gbc_lblMidT1.gridy = 9;
					panel.add(lblMidT1, gbc_lblMidT1);
				}
				{
					textChampP3T1 = new JTextField();
					GridBagConstraints gbc_textChampP3T1 = new GridBagConstraints();
					gbc_textChampP3T1.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP3T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP3T1.gridx = 3;
					gbc_textChampP3T1.gridy = 9;
					panel.add(textChampP3T1, gbc_textChampP3T1);
					textChampP3T1.setColumns(10);
				}
				{
					JLabel lblPlayer4T1 = new JLabel("Player 4");
					GridBagConstraints gbc_lblPlayer4T1 = new GridBagConstraints();
					gbc_lblPlayer4T1.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer4T1.gridx = 1;
					gbc_lblPlayer4T1.gridy = 11;
					panel.add(lblPlayer4T1, gbc_lblPlayer4T1);
				}
				{
					textNicknameP4T1 = new JTextField();
					GridBagConstraints gbc_textNicknameP4T1 = new GridBagConstraints();
					gbc_textNicknameP4T1.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP4T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP4T1.gridx = 3;
					gbc_textNicknameP4T1.gridy = 11;
					panel.add(textNicknameP4T1, gbc_textNicknameP4T1);
					textNicknameP4T1.setColumns(10);
				}
				{
					JLabel lblAdcT1 = new JLabel("ADC");
					GridBagConstraints gbc_lblAdcT1 = new GridBagConstraints();
					gbc_lblAdcT1.insets = new Insets(0, 0, 5, 5);
					gbc_lblAdcT1.gridx = 1;
					gbc_lblAdcT1.gridy = 12;
					panel.add(lblAdcT1, gbc_lblAdcT1);
				}
				{
					textChampP4T1 = new JTextField();
					GridBagConstraints gbc_textChampP4T1 = new GridBagConstraints();
					gbc_textChampP4T1.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP4T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP4T1.gridx = 3;
					gbc_textChampP4T1.gridy = 12;
					panel.add(textChampP4T1, gbc_textChampP4T1);
					textChampP4T1.setColumns(10);
				}
				{
					JLabel lblPlayer5T1 = new JLabel("Player 5");
					GridBagConstraints gbc_lblPlayer5T1 = new GridBagConstraints();
					gbc_lblPlayer5T1.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer5T1.gridx = 1;
					gbc_lblPlayer5T1.gridy = 14;
					panel.add(lblPlayer5T1, gbc_lblPlayer5T1);
				}
				{
					textNicknameP5T1 = new JTextField();
					GridBagConstraints gbc_textNicknameP5T1 = new GridBagConstraints();
					gbc_textNicknameP5T1.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP5T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP5T1.gridx = 3;
					gbc_textNicknameP5T1.gridy = 14;
					panel.add(textNicknameP5T1, gbc_textNicknameP5T1);
					textNicknameP5T1.setColumns(10);
				}
				{
					JLabel lblSupT1 = new JLabel("SUP");
					GridBagConstraints gbc_lblSupT1 = new GridBagConstraints();
					gbc_lblSupT1.insets = new Insets(0, 0, 0, 5);
					gbc_lblSupT1.gridx = 1;
					gbc_lblSupT1.gridy = 15;
					panel.add(lblSupT1, gbc_lblSupT1);
				}
				{
					textChampP5T1 = new JTextField();
					GridBagConstraints gbc_textChampP5T1 = new GridBagConstraints();
					gbc_textChampP5T1.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP5T1.gridx = 3;
					gbc_textChampP5T1.gridy = 15;
					panel.add(textChampP5T1, gbc_textChampP5T1);
					textChampP5T1.setColumns(10);
				}
			}
			{
				JPanel panel = new JPanel();
				splitPaneTeams.setRightComponent(panel);
				GridBagLayout gbl_panel = new GridBagLayout();
				gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
				gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
				gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
				gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
				panel.setLayout(gbl_panel);
				{
					JLabel lblNewLabel_6 = new JLabel("Red Team");
					GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
					gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
					gbc_lblNewLabel_6.gridx = 2;
					gbc_lblNewLabel_6.gridy = 0;
					panel.add(lblNewLabel_6, gbc_lblNewLabel_6);
				}
				{
					JLabel lblPlayer1T2 = new JLabel("Player 1");
					GridBagConstraints gbc_lblPlayer1T2 = new GridBagConstraints();
					gbc_lblPlayer1T2.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer1T2.gridx = 1;
					gbc_lblPlayer1T2.gridy = 2;
					panel.add(lblPlayer1T2, gbc_lblPlayer1T2);
				}
				{
					textNicknameP1T2 = new JTextField();
					textNicknameP1T2.setColumns(10);
					GridBagConstraints gbc_textNicknameP1T2 = new GridBagConstraints();
					gbc_textNicknameP1T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP1T2.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP1T2.gridx = 3;
					gbc_textNicknameP1T2.gridy = 2;
					panel.add(textNicknameP1T2, gbc_textNicknameP1T2);
				}
				{
					JLabel lblTopT2 = new JLabel("TOP");
					GridBagConstraints gbc_lblTopT2 = new GridBagConstraints();
					gbc_lblTopT2.insets = new Insets(0, 0, 5, 5);
					gbc_lblTopT2.gridx = 1;
					gbc_lblTopT2.gridy = 3;
					panel.add(lblTopT2, gbc_lblTopT2);
				}
				{
					textChampP1T2 = new JTextField();
					textChampP1T2.setColumns(10);
					GridBagConstraints gbc_textChampP1T2 = new GridBagConstraints();
					gbc_textChampP1T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP1T2.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP1T2.gridx = 3;
					gbc_textChampP1T2.gridy = 3;
					panel.add(textChampP1T2, gbc_textChampP1T2);
				}
				{
					JLabel lblPlayer2T2 = new JLabel("Player 2");
					GridBagConstraints gbc_lblPlayer2T2 = new GridBagConstraints();
					gbc_lblPlayer2T2.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer2T2.gridx = 1;
					gbc_lblPlayer2T2.gridy = 5;
					panel.add(lblPlayer2T2, gbc_lblPlayer2T2);
				}
				{
					textNicknameP2T2 = new JTextField();
					textNicknameP2T2.setColumns(10);
					GridBagConstraints gbc_textNicknameP2T2 = new GridBagConstraints();
					gbc_textNicknameP2T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP2T2.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP2T2.gridx = 3;
					gbc_textNicknameP2T2.gridy = 5;
					panel.add(textNicknameP2T2, gbc_textNicknameP2T2);
				}
				{
					JLabel lblJngT1 = new JLabel("JNG");
					GridBagConstraints gbc_lblJngT1 = new GridBagConstraints();
					gbc_lblJngT1.insets = new Insets(0, 0, 5, 5);
					gbc_lblJngT1.gridx = 1;
					gbc_lblJngT1.gridy = 6;
					panel.add(lblJngT1, gbc_lblJngT1);
				}
				{
					textChampP2T2 = new JTextField();
					textChampP2T2.setColumns(10);
					GridBagConstraints gbc_textChampP2T2 = new GridBagConstraints();
					gbc_textChampP2T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP2T2.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP2T2.gridx = 3;
					gbc_textChampP2T2.gridy = 6;
					panel.add(textChampP2T2, gbc_textChampP2T2);
				}
				{
					JLabel lblPlayer3T2 = new JLabel("Player 3");
					GridBagConstraints gbc_lblPlayer3T2 = new GridBagConstraints();
					gbc_lblPlayer3T2.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer3T2.gridx = 1;
					gbc_lblPlayer3T2.gridy = 8;
					panel.add(lblPlayer3T2, gbc_lblPlayer3T2);
				}
				{
					textNicknameP3T2 = new JTextField();
					textNicknameP3T2.setColumns(10);
					GridBagConstraints gbc_textNicknameP3T2 = new GridBagConstraints();
					gbc_textNicknameP3T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP3T2.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP3T2.gridx = 3;
					gbc_textNicknameP3T2.gridy = 8;
					panel.add(textNicknameP3T2, gbc_textNicknameP3T2);
				}
				{
					JLabel lblMidT2 = new JLabel("MID");
					GridBagConstraints gbc_lblMidT2 = new GridBagConstraints();
					gbc_lblMidT2.insets = new Insets(0, 0, 5, 5);
					gbc_lblMidT2.gridx = 1;
					gbc_lblMidT2.gridy = 9;
					panel.add(lblMidT2, gbc_lblMidT2);
				}
				{
					textChampP3T2 = new JTextField();
					textChampP3T2.setColumns(10);
					GridBagConstraints gbc_textChampP3T2 = new GridBagConstraints();
					gbc_textChampP3T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP3T2.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP3T2.gridx = 3;
					gbc_textChampP3T2.gridy = 9;
					panel.add(textChampP3T2, gbc_textChampP3T2);
				}
				{
					JLabel lblPlayer4T2 = new JLabel("Player 4");
					GridBagConstraints gbc_lblPlayer4T2 = new GridBagConstraints();
					gbc_lblPlayer4T2.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer4T2.gridx = 1;
					gbc_lblPlayer4T2.gridy = 11;
					panel.add(lblPlayer4T2, gbc_lblPlayer4T2);
				}
				{
					textNicknameP4T2 = new JTextField();
					textNicknameP4T2.setColumns(10);
					GridBagConstraints gbc_textNicknameP4T2 = new GridBagConstraints();
					gbc_textNicknameP4T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP4T2.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP4T2.gridx = 3;
					gbc_textNicknameP4T2.gridy = 11;
					panel.add(textNicknameP4T2, gbc_textNicknameP4T2);
				}
				{
					JLabel lblAdcT2 = new JLabel("ADC");
					GridBagConstraints gbc_lblAdcT2 = new GridBagConstraints();
					gbc_lblAdcT2.insets = new Insets(0, 0, 5, 5);
					gbc_lblAdcT2.gridx = 1;
					gbc_lblAdcT2.gridy = 12;
					panel.add(lblAdcT2, gbc_lblAdcT2);
				}
				{
					textChampP4T2 = new JTextField();
					textChampP4T2.setColumns(10);
					GridBagConstraints gbc_textChampP4T2 = new GridBagConstraints();
					gbc_textChampP4T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP4T2.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP4T2.gridx = 3;
					gbc_textChampP4T2.gridy = 12;
					panel.add(textChampP4T2, gbc_textChampP4T2);
				}
				{
					JLabel lblPlayer5T2 = new JLabel("Player 5");
					GridBagConstraints gbc_lblPlayer5T2 = new GridBagConstraints();
					gbc_lblPlayer5T2.insets = new Insets(0, 0, 5, 5);
					gbc_lblPlayer5T2.gridx = 1;
					gbc_lblPlayer5T2.gridy = 14;
					panel.add(lblPlayer5T2, gbc_lblPlayer5T2);
				}
				{
					textNicknameP5T2 = new JTextField();
					textNicknameP5T2.setColumns(10);
					GridBagConstraints gbc_textNicknameP5T2 = new GridBagConstraints();
					gbc_textNicknameP5T2.insets = new Insets(0, 0, 5, 0);
					gbc_textNicknameP5T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textNicknameP5T2.gridx = 3;
					gbc_textNicknameP5T2.gridy = 14;
					panel.add(textNicknameP5T2, gbc_textNicknameP5T2);
				}
				{
					JLabel lblSupT2 = new JLabel("SUP");
					GridBagConstraints gbc_lblSupT2 = new GridBagConstraints();
					gbc_lblSupT2.insets = new Insets(0, 0, 5, 5);
					gbc_lblSupT2.gridx = 1;
					gbc_lblSupT2.gridy = 15;
					panel.add(lblSupT2, gbc_lblSupT2);
				}
				{
					textChampP5T2 = new JTextField();
					textChampP5T2.setColumns(10);
					GridBagConstraints gbc_textChampP5T2 = new GridBagConstraints();
					gbc_textChampP5T2.fill = GridBagConstraints.HORIZONTAL;
					gbc_textChampP5T2.insets = new Insets(0, 0, 5, 0);
					gbc_textChampP5T2.gridx = 3;
					gbc_textChampP5T2.gridy = 15;
					panel.add(textChampP5T2, gbc_textChampP5T2);
				}
			}
		}
		{
			JLabel lblDate = new JLabel("Date");
			GridBagConstraints gbc_lblDate = new GridBagConstraints();
			gbc_lblDate.insets = new Insets(0, 0, 5, 5);
			gbc_lblDate.gridx = 8;
			gbc_lblDate.gridy = 9;
			contentPanel.add(lblDate, gbc_lblDate);
		}
		{
			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd MM yy");
			GridBagConstraints gbc_dateChooser = new GridBagConstraints();
			gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
			gbc_dateChooser.fill = GridBagConstraints.BOTH;
			gbc_dateChooser.gridx = 11;
			gbc_dateChooser.gridy = 9;
			contentPanel.add(dateChooser, gbc_dateChooser);
		}
		{
			JLabel lblDuration = new JLabel("Duration");
			GridBagConstraints gbc_lblDuration = new GridBagConstraints();
			gbc_lblDuration.insets = new Insets(0, 0, 5, 5);
			gbc_lblDuration.gridx = 8;
			gbc_lblDuration.gridy = 11;
			contentPanel.add(lblDuration, gbc_lblDuration);
		}
		{
			textDuration = new JTextField();
			GridBagConstraints gbc_textDuration = new GridBagConstraints();
			gbc_textDuration.insets = new Insets(0, 0, 5, 5);
			gbc_textDuration.fill = GridBagConstraints.HORIZONTAL;
			gbc_textDuration.gridx = 11;
			gbc_textDuration.gridy = 11;
			contentPanel.add(textDuration, gbc_textDuration);
			textDuration.setColumns(10);
		}
		{
			chckbxT1 = new JCheckBox("Blue Team");
			buttonGroup.add(chckbxT1);
			GridBagConstraints gbc_chckbxT1 = new GridBagConstraints();
			gbc_chckbxT1.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxT1.gridx = 11;
			gbc_chckbxT1.gridy = 13;
			contentPanel.add(chckbxT1, gbc_chckbxT1);
		}
		{
			JLabel lblWinner = new JLabel("Winner");
			GridBagConstraints gbc_lblWinner = new GridBagConstraints();
			gbc_lblWinner.insets = new Insets(0, 0, 5, 5);
			gbc_lblWinner.gridx = 8;
			gbc_lblWinner.gridy = 14;
			contentPanel.add(lblWinner, gbc_lblWinner);
		}
		{
			chckbxT2 = new JCheckBox("Red Team");
			buttonGroup.add(chckbxT2);
			GridBagConstraints gbc_chckbxT2 = new GridBagConstraints();
			gbc_chckbxT2.insets = new Insets(0, 0, 5, 5);
			gbc_chckbxT2.gridx = 11;
			gbc_chckbxT2.gridy = 15;
			contentPanel.add(chckbxT2, gbc_chckbxT2);
		}
		{
			btnAdd = new JButton("Add");
			btnAdd.addActionListener(this);
			GridBagConstraints gbc_btnAdd = new GridBagConstraints();
			gbc_btnAdd.insets = new Insets(0, 0, 5, 5);
			gbc_btnAdd.gridx = 11;
			gbc_btnAdd.gridy = 17;
			contentPanel.add(btnAdd, gbc_btnAdd);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnAdd) {
			addGame();
		}
	}

	private void addGame() {
		// TODO Auto-generated method stub
		Game aux = new Game();
		//It is stored the information of both blue and red team
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
		//Then the necessary information for the Game is stored
		aux.setDateGame(dateChooser.getDate().toInstant().atZone(ZoneId.of("Europe/Paris")).toLocalDate());
		aux.setDuration(Float.parseFloat(textDuration.getText()));
		//The the game is sent to be added and in the process the Id of the game that has been generated is stored
		aux.setId(gameStorable.addGame(aux));
		//Then the data of the teams are moved into a Set for easier management of the data
		Set <Entry<String,String>>redTeamSet = redTeam.entrySet(),blueTeamSet = blueTeam.entrySet();
		//Then two variables that are for setting the Role of the Player automatically are declared create
		int count=0;
		String role = null;
		//Now one team is Stored with all the data that has been stored previously
		for (Entry<String,String> entry : blueTeamSet) {
			if(count==0) {
				role="TOP";
			}
			if(count==1) {
				role="JNG";
			}
			if(count==2) {
				role="MID";
			}
			if(count==3) {
				role="ADC";
			}
			if(count==4) {
				role="SUP";
			}
			gameStorable.completeGame(aux.getId(), entry.getKey(), entry.getValue(), chckbxT1.isSelected(),role);
			count++;
		}
		//Now the other team is Stored with all the data that has been stored previously
		count=0;
		for (Entry<String,String> entry : redTeamSet) {
			if(count==0) {
				role="TOP";
			}
			if(count==1) {
				role="JNG";
			}
			if(count==2) {
				role="MID";
			}
			if(count==3) {
				role="ADC";
			}
			if(count==4) {
				role="SUP";
			}
			gameStorable.completeGame(aux.getId(), entry.getKey(), entry.getValue(), chckbxT2.isSelected(),role);
			count++;
		}
	}

}
