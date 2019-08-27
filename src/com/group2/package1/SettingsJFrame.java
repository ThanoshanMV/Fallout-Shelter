package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class SettingsJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SettingsJFrame frame = new SettingsJFrame();
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
	public SettingsJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 572, 489);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);	
		
		Label labelSettings = new Label("Settings");
		labelSettings.setForeground(Color.WHITE);
		labelSettings.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelSettings.setBounds(37, 96, 159, 49);
		contentPane.add(labelSettings);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(Color.WHITE);
		separator.setBounds(201, 71, 43, 293);
		contentPane.add(separator);
		
		JButton btnChangePublicKey = new JButton("Change Public key");
		btnChangePublicKey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePublicKeyJFrame changePublicKeyJFrameObject = new ChangePublicKeyJFrame();
				changePublicKeyJFrameObject.setVisible(true);
				//t.setSize(450,500);
				changePublicKeyJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnChangePublicKey.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChangePublicKey.setForeground(UIManager.getColor("Button.disabledText"));
		btnChangePublicKey.setFocusable(false);
		btnChangePublicKey.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnChangePublicKey.setBackground(new Color(51, 51, 51));
		btnChangePublicKey.setBounds(256, 96, 150, 30);
		contentPane.add(btnChangePublicKey);
		
		JButton btnChangePrivateKey = new JButton("Change Private key");
		btnChangePrivateKey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePrivatekeyJFrame changePrivatekeyJFrameObject = new ChangePrivatekeyJFrame();
				changePrivatekeyJFrameObject.setVisible(true);
				//t.setSize(450,500);
				changePrivatekeyJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnChangePrivateKey.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChangePrivateKey.setForeground(UIManager.getColor("Button.disabledText"));
		btnChangePrivateKey.setFocusable(false);
		btnChangePrivateKey.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnChangePrivateKey.setBackground(new Color(51, 51, 51));
		btnChangePrivateKey.setBounds(256, 159, 150, 30);
		contentPane.add(btnChangePrivateKey);
		
		JButton btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePasswordJFrame changePasswordJFrameObject = new ChangePasswordJFrame();
				changePasswordJFrameObject.setVisible(true);
				//t.setSize(450,500);
				changePasswordJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnChangePassword.setHorizontalTextPosition(SwingConstants.CENTER);
		btnChangePassword.setForeground(UIManager.getColor("Button.disabledText"));
		btnChangePassword.setFocusable(false);
		btnChangePassword.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnChangePassword.setBackground(new Color(51, 51, 51));
		btnChangePassword.setBounds(256, 221, 150, 30);
		contentPane.add(btnChangePassword);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PreparedStatement ps;
				PreparedStatement ps1;
				try {
					ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForDeleteUserAccount);
					ps1 = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForDeleteUserBackupHistory);
					if (StaticFields.isUserEnteredTheSystemByLoggingIn) {
						ps.setString(1, StaticFields.loggedInUsersName);
						ps1.setString(1, StaticFields.loggedInUsersName);
					} else {
						ps.setString(1, StaticFields.newlyRegisteredUsersName);
						ps1.setString(1, StaticFields.newlyRegisteredUsersName);
					}
					if((ps.executeUpdate()>0)) {
						if(ps1.executeUpdate()>0) {
							JOptionPane.showMessageDialog(null, "Your account, backup history and restore history has been deleted!");
							JOptionPane.showMessageDialog(null, "Note:- Your already backedup and restored files won't be deleted. Please do it manually.");
							StartJFrame startJFrameObject = new StartJFrame();
							startJFrameObject.setVisible(true);
							startJFrameObject.setLocationRelativeTo(null);
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Your account has been deleted!");
							StartJFrame startJFrameObject = new StartJFrame();
							startJFrameObject.setVisible(true);
							startJFrameObject.setLocationRelativeTo(null);
							dispose();
						}
							
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDeleteAccount.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDeleteAccount.setForeground(UIManager.getColor("Button.disabledText"));
		btnDeleteAccount.setFocusable(false);
		btnDeleteAccount.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnDeleteAccount.setBackground(new Color(51, 51, 51));
		btnDeleteAccount.setBounds(256, 282, 150, 30);
		contentPane.add(btnDeleteAccount);
		
		JButton btnDashboard = new JButton("Back to Dashboard");
		btnDashboard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DashboardJFrame dashboardJFrameObject = new DashboardJFrame();
				dashboardJFrameObject.setVisible(true);
				//t.setSize(450,500);
				dashboardJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnDashboard.setHorizontalTextPosition(SwingConstants.CENTER);
		btnDashboard.setForeground(UIManager.getColor("Button.foreground"));
		btnDashboard.setFocusable(false);
		btnDashboard.setBorder(null);
		btnDashboard.setBackground(new Color(51, 153, 153));
		btnDashboard.setBounds(366, 402, 178, 30);
		contentPane.add(btnDashboard);
	}
}
