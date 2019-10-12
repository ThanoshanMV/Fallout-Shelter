package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
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
public class PrivateKeyJFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordfieldPrivateKey;
	private String privateKey;
	static boolean b3 = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					PrivateKeyJFrame frame = new PrivateKeyJFrame();
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
	public PrivateKeyJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 370);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Hey there,\n");
		label.setFont(new Font("Dialog", Font.BOLD, 18));
		label.setBounds(37, 70, 355, 61);
		contentPane.add(label);

		JLabel lblPleaseConfirmYour = new JLabel("Please confirm your Private key ");
		lblPleaseConfirmYour.setFont(new Font("Dialog", Font.BOLD, 18));
		lblPleaseConfirmYour.setBounds(37, 117, 472, 61);
		contentPane.add(lblPleaseConfirmYour);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				PrivateKeyJFrame PrivateKeyJFrameObject = new PrivateKeyJFrame();
				PrivateKeyJFrameObject.setPrivateKey(String.valueOf(passwordfieldPrivateKey.getPassword()));
				
				DbConnToAdvancedExecution dBConnToAdvancedExecutionObject1 = new DbConnToAdvancedExecution();
				b3 = dBConnToAdvancedExecutionObject1.isUserAuthorizedToRestore();
				System.out.println(b3);
				
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					//ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForPrivateKeyJFrame);
					ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForPrivateKeyJFrame);
					ps.setString(1, PrivateKeyJFrameObject.getPrivateKey());
					if (StaticFields.isUserEnteredTheSystemByLoggingIn) {
						ps.setString(2, StaticFields.loggedInUsersName);
					} else {
						ps.setString(2, StaticFields.newlyRegisteredUsersName);
					}
					rs = ps.executeQuery();

					if (rs.next()) {

						
						if (b3) {
							Decryption decryptionObject1 = new Decryption();
							try {
								decryptionObject1.checkPathExistence(StaticFields.restoreSourcePath,
										StaticFields.restoreDestinationPath);
								JOptionPane.showMessageDialog(null, "Restoration was Succesful!");
							} catch (IOException e1) {
								JOptionPane.showMessageDialog(null, "IOException in PrivateKeyJFrame.");
								e1.printStackTrace();
							} catch (Exception e1) {
								JOptionPane.showMessageDialog(null, "Some sort of error in PrivateKeyJFrame.");
								e1.printStackTrace();
							}
						} else {
							JOptionPane.showMessageDialog(null,
									"Sorry!, You don't have access to other users' documents!");
						}
						RestoreJFrame restoreJFrameObject = new RestoreJFrame();
						restoreJFrameObject.setVisible(true);
						restoreJFrameObject.setLocationRelativeTo(null);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Please check your Public key!");
						passwordfieldPrivateKey.setText("");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error while establishing connection.");
				}
				 finally {
						try {
							ps.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							rs.close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							SqLiteConnection.getSqliteConnection().close();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
			}
		});
		btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("Dialog", Font.BOLD, 16));
		btnNext.setFocusable(false);
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(51, 51, 51));
		btnNext.setBounds(157, 266, 179, 35);
		contentPane.add(btnNext);

		passwordfieldPrivateKey = new JPasswordField();
		passwordfieldPrivateKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNext.doClick();
				}
			}
		});
		passwordfieldPrivateKey.setHorizontalAlignment(SwingConstants.CENTER);
		passwordfieldPrivateKey.setFont(new Font("Dialog", Font.BOLD, 20));
		passwordfieldPrivateKey.setBorder(null);
		passwordfieldPrivateKey.setBackground(new Color(51, 153, 153));
		passwordfieldPrivateKey.setBounds(102, 190, 260, 33);
		contentPane.add(passwordfieldPrivateKey);
		passwordfieldPrivateKey.setDocument(new SetCharLimit(10));

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(112, 224, 241, 30);
		contentPane.add(separator);
	}

	public String getPrivateKey() {
		return privateKey;
	}

	public void setPrivateKey(String privateKey) {
		this.privateKey = privateKey;
	}

}
