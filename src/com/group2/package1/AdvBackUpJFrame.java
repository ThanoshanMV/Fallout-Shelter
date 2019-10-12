package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class AdvBackUpJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldAdvBackupSourcePath;
	private JTextField textFieldAdvBackupDestinationPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					AdvBackUpJFrame frame = new AdvBackUpJFrame();
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
	public AdvBackUpJFrame() {
		SqLiteConnection.createAdvBackupTable();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, 0, 315, 525);
		contentPane.add(panel);
		panel.setLayout(null);

		Label labelAdvancedBackup = new Label("Advanced Backup");
		labelAdvancedBackup.setForeground(Color.WHITE);
		labelAdvancedBackup.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelAdvancedBackup.setBounds(29, 74, 247, 61);
		panel.add(labelAdvancedBackup);

		Label labelFalloutPremiereEdition = new Label("- Fallout Premiere Edition\n");
		labelFalloutPremiereEdition.setForeground(Color.WHITE);
		labelFalloutPremiereEdition.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelFalloutPremiereEdition.setBounds(29, 122, 263, 61);
		panel.add(labelFalloutPremiereEdition);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(309, -13, 312, 538);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setFocusable(true);

		Label labelSourcePath = new Label("Source Path");
		labelSourcePath.setForeground(UIManager.getColor("Button.disabledText"));
		labelSourcePath.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelSourcePath.setBounds(24, 103, 102, 36);
		panel_1.add(labelSourcePath);

		textFieldAdvBackupSourcePath = new JTextField();
		textFieldAdvBackupSourcePath.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textFieldAdvBackupSourcePath.getText().trim().equals("/home/***/**")) {
					textFieldAdvBackupSourcePath.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldAdvBackupSourcePath.getText().trim().equals("")) {
					textFieldAdvBackupSourcePath.setText("/home/***/**");
				}
			}
		});
		textFieldAdvBackupSourcePath.setText("/home/***/**");
		textFieldAdvBackupSourcePath.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAdvBackupSourcePath.setForeground(Color.WHITE);
		textFieldAdvBackupSourcePath.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldAdvBackupSourcePath.setColumns(10);
		textFieldAdvBackupSourcePath.setBorder(null);
		textFieldAdvBackupSourcePath.setBackground(UIManager.getColor("Button.foreground"));
		textFieldAdvBackupSourcePath.setBounds(24, 158, 252, 23);
		panel_1.add(textFieldAdvBackupSourcePath);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(24, 189, 252, 8);
		panel_1.add(separator);

		JButton btnAdvancedBackup = new JButton("Advanced Backup");
		btnAdvancedBackup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticFields.advancedBackupSourcePath = textFieldAdvBackupSourcePath.getText();
				StaticFields.advancedBackupDestinationPath = textFieldAdvBackupDestinationPath.getText();
				PublicKeyJFrame publicKeyJFrameObject = new PublicKeyJFrame();
				publicKeyJFrameObject.setVisible(true);
				// t.setSize(450,500);
				publicKeyJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});

		btnAdvancedBackup.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdvancedBackup.setForeground(UIManager.getColor("Button.foreground"));
		btnAdvancedBackup.setFocusable(false);
		btnAdvancedBackup.setBorder(null);
		btnAdvancedBackup.setBackground(new Color(51, 153, 153));
		btnAdvancedBackup.setBounds(158, 365, 130, 44);
		panel_1.add(btnAdvancedBackup);

		Label labelDestinationPath = new Label("Destination Path");
		labelDestinationPath.setForeground(UIManager.getColor("Button.disabledText"));
		labelDestinationPath.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelDestinationPath.setBounds(24, 232, 147, 36);
		panel_1.add(labelDestinationPath);

		textFieldAdvBackupDestinationPath = new JTextField();
		textFieldAdvBackupDestinationPath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnAdvancedBackup.doClick();
				}
			}
		});
		textFieldAdvBackupDestinationPath.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textFieldAdvBackupDestinationPath.getText().trim().equals("/home/***/**")) {
					textFieldAdvBackupDestinationPath.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldAdvBackupDestinationPath.getText().trim().equals("")) {
					textFieldAdvBackupDestinationPath.setText("/home/***/**");
				}
			}
		});
		textFieldAdvBackupDestinationPath.setText("/home/***/**");
		textFieldAdvBackupDestinationPath.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldAdvBackupDestinationPath.setForeground(Color.WHITE);
		textFieldAdvBackupDestinationPath.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldAdvBackupDestinationPath.setColumns(10);
		textFieldAdvBackupDestinationPath.setBorder(null);
		textFieldAdvBackupDestinationPath.setBackground(UIManager.getColor("Button.foreground"));
		textFieldAdvBackupDestinationPath.setBounds(24, 286, 252, 30);
		panel_1.add(textFieldAdvBackupDestinationPath);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(29, 321, 247, 8);
		panel_1.add(separator_1);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldAdvBackupSourcePath.setText("");
				textFieldAdvBackupDestinationPath.setText("");
			}
		});
		btnReset.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReset.setForeground(UIManager.getColor("Button.foreground"));
		btnReset.setFocusable(false);
		btnReset.setBorder(null);
		btnReset.setBackground(new Color(51, 153, 153));
		btnReset.setBounds(24, 372, 102, 30);
		panel_1.add(btnReset);

		JButton btnDashboard = new JButton("Back to Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DashboardJFrame dashboardJFrameObject = new DashboardJFrame();
				dashboardJFrameObject.setVisible(true);
				dashboardJFrameObject.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDashboard.setForeground(UIManager.getColor("Button.foreground"));
		btnDashboard.setFocusable(false);
		btnDashboard.setBorder(null);
		btnDashboard.setBackground(new Color(51, 153, 153));
		btnDashboard.setBounds(24, 461, 178, 30);
		panel_1.add(btnDashboard);

		JButton btnBrowse = new JButton("Browse Here");
		btnBrowse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Choose the Source Path");
				// chooser.setMultiSelectionEnabled(true);
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int response = chooser.showOpenDialog(null);
				if (response == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					textFieldAdvBackupSourcePath.setText(selectedFile.getAbsolutePath());

				}
			}
		});
		btnBrowse.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBrowse.setForeground(UIManager.getColor("Button.foreground"));
		btnBrowse.setFocusable(false);
		btnBrowse.setBorder(null);
		btnBrowse.setBackground(new Color(153, 153, 153));
		btnBrowse.setBounds(174, 103, 114, 30);
		panel_1.add(btnBrowse);

		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select the Destination Directory");
				// chooser.setMultiSelectionEnabled(true);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int response = chooser.showOpenDialog(null);
				if (response == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					textFieldAdvBackupDestinationPath.setText(selectedFile.getAbsolutePath());

				}
			}
		});
		btnSelect.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSelect.setForeground(UIManager.getColor("Button.foreground"));
		btnSelect.setFocusable(false);
		btnSelect.setBorder(null);
		btnSelect.setBackground(new Color(153, 153, 153));
		btnSelect.setBounds(174, 238, 114, 30);
		panel_1.add(btnSelect);

		JLabel minimizeLabel = new JLabel("");
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		minimizeLabel.setBounds(157, 25, 48, 48);
		panel_1.add(minimizeLabel);
		Image labelMinimizeImage = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
		minimizeLabel.setIcon(new ImageIcon(labelMinimizeImage));

		JLabel closeLabel = new JLabel("");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeLabel.setBounds(228, 25, 48, 48);
		panel_1.add(closeLabel);
		Image labelCloseImage = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		closeLabel.setIcon(new ImageIcon(labelCloseImage));
	}
}
