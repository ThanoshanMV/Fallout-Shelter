package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class QuickBackUpJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldQuickBackupSourcePath;
	private JTextField textFieldQuickBackupDestinationPath;
	private String quickBackupSourcepath;
	private String quickBackupDestinationPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					QuickBackUpJFrame frame = new QuickBackUpJFrame();
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
	public QuickBackUpJFrame() {
		
	
		
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 635, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, -13, 305, 547);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setFocusable(true);
		
		Label labelQuickBackup = new Label("Quick Backup");
		labelQuickBackup.setForeground(Color.WHITE);
		labelQuickBackup.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelQuickBackup.setBounds(28, 88, 153, 53);
		panel.add(labelQuickBackup);
		
		Label labelExpressEdition = new Label("-Fallout Express Edition");
		labelExpressEdition.setForeground(Color.WHITE);
		labelExpressEdition.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelExpressEdition.setBounds(21, 136, 243, 53);
		panel.add(labelExpressEdition);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(302, -13, 333, 547);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Label labelSourcePath = new Label("Source Path");
		labelSourcePath.setForeground(UIManager.getColor("Button.disabledText"));
		labelSourcePath.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelSourcePath.setBounds(22, 96, 118, 42);
		panel_1.add(labelSourcePath);
		
		Label labelDestinationPath = new Label("Destination Path");
		labelDestinationPath.setForeground(UIManager.getColor("Button.disabledText"));
		labelDestinationPath.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelDestinationPath.setBounds(22, 241, 137, 35);
		panel_1.add(labelDestinationPath);
		
		textFieldQuickBackupSourcePath = new JTextField();
		textFieldQuickBackupSourcePath.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFieldQuickBackupSourcePath.getText().trim().equals("/home/***/**")) {
					textFieldQuickBackupSourcePath.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldQuickBackupSourcePath.getText().trim().equals("")) {
					textFieldQuickBackupSourcePath.setText("/home/***/**");
				}
			}
		});
		
		JButton btnQuickBackup = new JButton("Quick Backup");
		btnQuickBackup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Compress compress_obj = new Compress();
				QuickBackUpJFrame quickBackUpJFrameObject = new QuickBackUpJFrame();
				quickBackUpJFrameObject.setQuickBackupSourcepath(textFieldQuickBackupSourcePath.getText());
				quickBackUpJFrameObject.setQuickBackupDestinationPath(textFieldQuickBackupDestinationPath.getText());
				StaticFields.quickBackupDestinationPath = quickBackUpJFrameObject.getQuickBackupDestinationPath();
				try {
					compress_obj.checkPathExistence(quickBackUpJFrameObject.getQuickBackupSourcepath(), quickBackUpJFrameObject.getQuickBackupDestinationPath());	
					JOptionPane.showMessageDialog(null, "Quick Backup was succesfully completed!");
				} catch (FileNotFoundException e1) {
					JOptionPane.showMessageDialog(null, "FileNotFoundException in QuickBackUpJFrame.");
					e1.printStackTrace();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "IOException in QuickBackUpJFrame.");
					e1.printStackTrace();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null, "Some sort of error in QuickBackUpJFrame.");
					e1.printStackTrace();
				}
				
			}
		});
		btnQuickBackup.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuickBackup.setForeground(UIManager.getColor("Button.foreground"));
		btnQuickBackup.setFocusable(false);
		btnQuickBackup.setBorder(null);
		btnQuickBackup.setBackground(new Color(51, 153, 153));
		btnQuickBackup.setBounds(189, 342, 118, 44);
		panel_1.add(btnQuickBackup);
		textFieldQuickBackupSourcePath.setText("/home/***/**");
		textFieldQuickBackupSourcePath.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQuickBackupSourcePath.setForeground(Color.WHITE);
		textFieldQuickBackupSourcePath.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldQuickBackupSourcePath.setColumns(10);
		textFieldQuickBackupSourcePath.setBorder(null);
		textFieldQuickBackupSourcePath.setBackground(UIManager.getColor("Button.foreground"));
		textFieldQuickBackupSourcePath.setBounds(22, 158, 247, 35);
		panel_1.add(textFieldQuickBackupSourcePath);
		
		textFieldQuickBackupDestinationPath = new JTextField();
		textFieldQuickBackupDestinationPath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnQuickBackup.doClick();
				}
			}
		});
		textFieldQuickBackupDestinationPath.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFieldQuickBackupDestinationPath.getText().trim().equals("/home/***/**")) {
					textFieldQuickBackupDestinationPath.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldQuickBackupDestinationPath.getText().trim().equals("")) {
					textFieldQuickBackupDestinationPath.setText("/home/***/**");
				}
			}
		});
		textFieldQuickBackupDestinationPath.setText("/home/***/**");
		textFieldQuickBackupDestinationPath.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldQuickBackupDestinationPath.setForeground(Color.WHITE);
		textFieldQuickBackupDestinationPath.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldQuickBackupDestinationPath.setColumns(10);
		textFieldQuickBackupDestinationPath.setBorder(null);
		textFieldQuickBackupDestinationPath.setBackground(UIManager.getColor("Button.foreground"));
		textFieldQuickBackupDestinationPath.setBounds(22, 282, 247, 25);
		panel_1.add(textFieldQuickBackupDestinationPath);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(22, 197, 247, 12);
		panel_1.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(22, 313, 247, 7);
		panel_1.add(separator_1);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				textFieldQuickBackupSourcePath.setText("");
				textFieldQuickBackupDestinationPath.setText("");
			}
		});
		btnReset.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReset.setForeground(UIManager.getColor("Button.foreground"));
		btnReset.setFocusable(false);
		btnReset.setBorder(null);
		btnReset.setBackground(new Color(51, 153, 153));
		btnReset.setBounds(22, 352, 114, 30);
		panel_1.add(btnReset);
		
		JButton btnBackToDashboard = new JButton("Back to Dashboard");
		btnBackToDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DashboardJFrame dashboardJFrameObject = new DashboardJFrame();
				dashboardJFrameObject.setVisible(true);
				dashboardJFrameObject.setLocationRelativeTo(null);					
				dispose();
				
			}
		});
		btnBackToDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBackToDashboard.setForeground(UIManager.getColor("Button.foreground"));
		btnBackToDashboard.setFocusable(false);
		btnBackToDashboard.setBorder(null);
		btnBackToDashboard.setBackground(new Color(51, 153, 153));
		btnBackToDashboard.setBounds(22, 458, 178, 30);
		panel_1.add(btnBackToDashboard);
		
		JButton btnBrowseHere = new JButton("Browse Here");
		btnBrowseHere.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Choose the Source File/Directory");
				//chooser.setMultiSelectionEnabled(true);
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int response = chooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					textFieldQuickBackupSourcePath.setText(selectedFile.getAbsolutePath());
					
				}
				
			}
		});
		btnBrowseHere.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBrowseHere.setForeground(UIManager.getColor("Button.foreground"));
		btnBrowseHere.setFocusable(false);
		btnBrowseHere.setBorder(null);
		btnBrowseHere.setBackground(new Color(153, 153, 153));
		btnBrowseHere.setBounds(189, 96, 114, 30);
		panel_1.add(btnBrowseHere);
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Select the Destination Directory");
				//chooser.setMultiSelectionEnabled(true);
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int response = chooser.showOpenDialog(null);
				if(response == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					textFieldQuickBackupDestinationPath.setText(selectedFile.getAbsolutePath());
					
				}
			}
		});
		btnSelect.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSelect.setForeground(UIManager.getColor("Button.foreground"));
		btnSelect.setFocusable(false);
		btnSelect.setBorder(null);
		btnSelect.setBackground(new Color(153, 153, 153));
		btnSelect.setBounds(193, 240, 114, 30);
		panel_1.add(btnSelect);
		
		JLabel labelMinimize = new JLabel("");
		labelMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		labelMinimize.setBounds(189, 23, 48, 48);
		panel_1.add(labelMinimize);
		Image img1 = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
		labelMinimize.setIcon(new ImageIcon(img1));
		
		JLabel labelClose = new JLabel("");
		labelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		labelClose.setBounds(259, 23, 48, 48);
		panel_1.add(labelClose);
		Image labelCloseImage = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		labelClose.setIcon(new ImageIcon(labelCloseImage));
	}

	public String getQuickBackupSourcepath() {
		return quickBackupSourcepath;
	}

	public void setQuickBackupSourcepath(String quickBackupSourcepath) {
		this.quickBackupSourcepath = quickBackupSourcepath;
	}

	public String getQuickBackupDestinationPath() {
		return quickBackupDestinationPath;
	}

	public void setQuickBackupDestinationPath(String quickBackupDestinationPath) {
		this.quickBackupDestinationPath = quickBackupDestinationPath;
	}
}
