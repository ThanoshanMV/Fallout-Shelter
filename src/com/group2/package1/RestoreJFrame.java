package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class RestoreJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField restoreSourcePath;
	private JTextField restoreDestinationPath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RestoreJFrame frame = new RestoreJFrame();
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
	public RestoreJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, -12, 309, 533);
		contentPane.add(panel);
		panel.setLayout(null);

		Label labelRestore = new Label("Restore");
		labelRestore.setForeground(Color.WHITE);
		labelRestore.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelRestore.setBounds(28, 107, 247, 61);
		panel.add(labelRestore);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(305, -12, 320, 533);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setFocusable(true);

		Label labelSourcePath = new Label("Source Path");
		labelSourcePath.setForeground(UIManager.getColor("Button.disabledText"));
		labelSourcePath.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelSourcePath.setBounds(26, 94, 102, 23);
		panel_1.add(labelSourcePath);

		restoreSourcePath = new JTextField();
		restoreSourcePath.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (restoreSourcePath.getText().trim().equals("/home/***/**")) {
					restoreSourcePath.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (restoreSourcePath.getText().trim().equals("")) {
					restoreSourcePath.setText("/home/***/**");
				}
			}
		});
		restoreSourcePath.setText("/home/***/**");
		restoreSourcePath.setHorizontalAlignment(SwingConstants.CENTER);
		restoreSourcePath.setForeground(Color.WHITE);
		restoreSourcePath.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		restoreSourcePath.setColumns(10);
		restoreSourcePath.setBorder(null);
		restoreSourcePath.setBackground(UIManager.getColor("Button.foreground"));
		restoreSourcePath.setBounds(26, 143, 252, 30);
		panel_1.add(restoreSourcePath);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(26, 177, 247, 30);
		panel_1.add(separator);

		JButton btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticFields.isFileCompressed = false;
				StaticFields.restoreSourcePath = restoreSourcePath.getText();
				StaticFields.restoreDestinationPath = restoreDestinationPath.getText();
				File src = new File(StaticFields.restoreSourcePath);
				if (src.isFile()) {
					if (GZipUtil.isGZipped(src)) {
						StaticFields.isFileCompressed = true;
					} else {
						StaticFields.isFileCompressed = false;
					}
				} else {
					String files[] = src.list();
					for (String fileName : files) {
						File srcFile = new File(src, fileName);
						if (srcFile.isFile()) {
							if (GZipUtil.isGZipped(srcFile)) {
								StaticFields.isFileCompressed = true;
								break;
							} else {
								continue;
							}
						}
					}
				}

				if (StaticFields.isFileCompressed == true) {
					System.out.println("File is zipped");
					try {
						
						DeCompress deCompressObject1 = new DeCompress();
						deCompressObject1.checkPathExistence(StaticFields.restoreSourcePath,
								StaticFields.restoreDestinationPath);
						JOptionPane.showMessageDialog(null, "Restoration was Succesful!");
					} catch (FileNotFoundException e1) {
						JOptionPane.showMessageDialog(null, "FileNotFoundException in RestoreJFrame.");
						e1.printStackTrace();
					} catch (IOException e1) {
						JOptionPane.showMessageDialog(null, "IOException in RestoreJFrame.");
						e1.printStackTrace();
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Some sort of error in RestoreJFrame.");
						e1.printStackTrace();
					}
				} else {
					System.out.println("File is not zipped");
					PrivateKeyJFrame privateKeyJFrameObject1 = new PrivateKeyJFrame();
					privateKeyJFrameObject1.setVisible(true);
					// t.setSize(450,500);
					privateKeyJFrameObject1.setLocationRelativeTo(null);
					dispose();
				}

			}
		});
		btnRestore.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRestore.setForeground(UIManager.getColor("Button.foreground"));
		btnRestore.setFocusable(false);
		btnRestore.setBorder(null);
		btnRestore.setBackground(new Color(51, 153, 153));
		btnRestore.setBounds(177, 373, 118, 44);
		panel_1.add(btnRestore);

		Label labelDestinationPath = new Label("Destination Path");
		labelDestinationPath.setForeground(UIManager.getColor("Button.disabledText"));
		labelDestinationPath.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelDestinationPath.setBounds(26, 217, 147, 61);
		panel_1.add(labelDestinationPath);

		restoreDestinationPath = new JTextField();
		restoreDestinationPath.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnRestore.doClick();
				}
			}
		});
		restoreDestinationPath.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (restoreDestinationPath.getText().trim().equals("/home/***/**")) {
					restoreDestinationPath.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (restoreDestinationPath.getText().trim().equals("")) {
					restoreDestinationPath.setText("/home/***/**");
				}
			}
		});
		restoreDestinationPath.setText("/home/***/**");
		restoreDestinationPath.setHorizontalAlignment(SwingConstants.CENTER);
		restoreDestinationPath.setForeground(Color.WHITE);
		restoreDestinationPath.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		restoreDestinationPath.setColumns(10);
		restoreDestinationPath.setBorder(null);
		restoreDestinationPath.setBackground(UIManager.getColor("Button.foreground"));
		restoreDestinationPath.setBounds(26, 284, 252, 30);
		panel_1.add(restoreDestinationPath);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(26, 319, 247, 30);
		panel_1.add(separator_1);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				restoreSourcePath.setText("");
				restoreDestinationPath.setText("");
			}
		});
		btnReset.setHorizontalTextPosition(SwingConstants.CENTER);
		btnReset.setForeground(UIManager.getColor("Button.foreground"));
		btnReset.setFocusable(false);
		btnReset.setBorder(null);
		btnReset.setBackground(new Color(51, 153, 153));
		btnReset.setBounds(26, 387, 114, 30);
		panel_1.add(btnReset);

		JButton btnDashboard = new JButton("Back to Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DashboardJFrame dashboard_1 = new DashboardJFrame();
				dashboard_1.setVisible(true);
				dashboard_1.setLocationRelativeTo(null);
				dispose();

			}
		});
		btnDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDashboard.setForeground(UIManager.getColor("Button.foreground"));
		btnDashboard.setFocusable(false);
		btnDashboard.setBorder(null);
		btnDashboard.setBackground(new Color(51, 153, 153));
		btnDashboard.setBounds(26, 461, 178, 30);
		panel_1.add(btnDashboard);

		JButton btnBrowse = new JButton("Browse Here");
		btnBrowse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.setDialogTitle("Choose the Source File/Directory");
				// chooser.setMultiSelectionEnabled(true);
				chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("fallout_Express and fallout_Premiere",
						"fallout_Express", "fallout_Premiere");
				chooser.addChoosableFileFilter(filter);
				int response = chooser.showOpenDialog(null);
				if (response == JFileChooser.APPROVE_OPTION) {
					File selectedFile = chooser.getSelectedFile();
					restoreSourcePath.setText(selectedFile.getAbsolutePath());
				}
			}
		});
		btnBrowse.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBrowse.setForeground(UIManager.getColor("Button.foreground"));
		btnBrowse.setFocusable(false);
		btnBrowse.setBorder(null);
		btnBrowse.setBackground(new Color(153, 153, 153));
		btnBrowse.setBounds(179, 87, 114, 30);
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
					restoreDestinationPath.setText(selectedFile.getAbsolutePath());

				}
			}
		});
		btnSelect.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSelect.setForeground(new Color(51, 51, 51));
		btnSelect.setFocusable(false);
		btnSelect.setBorder(null);
		btnSelect.setBackground(new Color(153, 153, 153));
		btnSelect.setBounds(181, 229, 114, 30);
		panel_1.add(btnSelect);

		JLabel labelMinimize = new JLabel("");
		labelMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		labelMinimize.setBounds(177, 12, 48, 48);
		Image labelMinimizeImage = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
		labelMinimize.setIcon(new ImageIcon(labelMinimizeImage));
		panel_1.add(labelMinimize);

		JLabel labelClose = new JLabel("");
		labelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		labelClose.setBounds(247, 12, 48, 48);
		Image labelCloseImage = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		labelClose.setIcon(new ImageIcon(labelCloseImage));
		panel_1.add(labelClose);
	}
}
