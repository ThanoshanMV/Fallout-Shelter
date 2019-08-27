package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.WindowConstants;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class PublicKeyJFrame extends JFrame {
	private JPanel contentPane;
	private JPasswordField passwordfieldPublicKey;
	private String publicKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PublicKeyJFrame frame = new PublicKeyJFrame();
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
	public PublicKeyJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 367);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelHeyThere = new JLabel("Hey there,\n");
		labelHeyThere.setFont(new Font("Dialog", Font.BOLD, 18));
		labelHeyThere.setBounds(35, 68, 355, 61);
		contentPane.add(labelHeyThere);
		
				JButton btnNext = new JButton("Next");
				btnNext.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						PublicKeyJFrame PublicKeyJFrameObject = new PublicKeyJFrame();
						PublicKeyJFrameObject.setPublicKey(String.valueOf(passwordfieldPublicKey.getPassword()));

						PreparedStatement ps;
						ResultSet rs;
						try {
							ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForPublicKeyJFrame);
						//	ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForPublicKeyJFrame);
							ps.setString(1, PublicKeyJFrameObject.getPublicKey());
							if (StaticFields.isUserEnteredTheSystemByLoggingIn) {
								ps.setString(2, StaticFields.loggedInUsersName);
							} else {
								ps.setString(2, StaticFields.newlyRegisteredUsersName);
							}
							rs = ps.executeQuery();

							if (rs.next()) {
									try {
										Encryption encryptionObject = new Encryption();
										DbConnToAdvancedExecution dBConnToAdvancedExecutionObject2 = new DbConnToAdvancedExecution();
										dBConnToAdvancedExecutionObject2.insertAdvancedBackupDestinationPathToDatabase();
										encryptionObject.checkPathExistence(StaticFields.advancedBackupSourcePath,StaticFields.advancedBackupDestinationPath);
										JOptionPane.showMessageDialog(null, "Advanced Backup was succesfully completed!");
									} catch (IOException e1) {
										JOptionPane.showMessageDialog(null, "IOException in AdvBackupJFrame.");
										e1.printStackTrace();
									} catch (Exception e1) {
										JOptionPane.showMessageDialog(null, "Some sort of error in AdvBackupJFrame.");
										e1.printStackTrace();
									}
								AdvBackUpJFrame advBackupJFrameObject2 = new AdvBackUpJFrame();
								advBackupJFrameObject2.setVisible(true);
								advBackupJFrameObject2.setLocationRelativeTo(null);
								dispose();
							} else {
								JOptionPane.showMessageDialog(null, "Please check your Public key!");
								passwordfieldPublicKey.setText("");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(null, "Error while establishing connection.");
						}

					}
				});
				btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
				btnNext.setForeground(Color.WHITE);
				btnNext.setFont(new Font("Dialog", Font.BOLD, 16));
				btnNext.setFocusable(false);
				btnNext.setBorder(null);
				btnNext.setBackground(new Color(51, 51, 51));
				btnNext.setBounds(143, 257, 179, 35);
				contentPane.add(btnNext);

		JLabel labelConform = new JLabel("Please confirm your Public key ");
		labelConform.setFont(new Font("Dialog", Font.BOLD, 18));
		labelConform.setBounds(35, 112, 472, 61);
		contentPane.add(labelConform);

		passwordfieldPublicKey = new JPasswordField();
		passwordfieldPublicKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNext.doClick();
				}
			}
		});
		passwordfieldPublicKey.setHorizontalAlignment(SwingConstants.CENTER);
		passwordfieldPublicKey.setFont(new Font("Dialog", Font.BOLD, 20));
		passwordfieldPublicKey.setBorder(null);
		passwordfieldPublicKey.setBackground(new Color(51, 153, 153));
		passwordfieldPublicKey.setBounds(109, 185, 260, 33);
		contentPane.add(passwordfieldPublicKey);
		passwordfieldPublicKey.setDocument(new SetCharLimit(10));

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(119, 222, 241, 30);
		contentPane.add(separator);
	}

	public String getPublicKey() {
		return publicKey;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}
}
