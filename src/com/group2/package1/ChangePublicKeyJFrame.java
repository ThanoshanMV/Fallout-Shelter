package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class ChangePublicKeyJFrame extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordFieldCurrentPassword;
	private JPasswordField passwordFieldCurrentPublicKey;
	private JPasswordField passwordFieldNewPublicKey;
	private JPasswordField passwordFieldConfirmNewPublicKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ChangePublicKeyJFrame frame = new ChangePublicKeyJFrame();
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
	public ChangePublicKeyJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 559);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, -12, 271, 541);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label labelChangePublicKey = new Label("Change Public Key");
		labelChangePublicKey.setForeground(Color.WHITE);
		labelChangePublicKey.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelChangePublicKey.setBounds(28, 85, 188, 49);
		panel.add(labelChangePublicKey);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(271, -12, 320, 541);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setFocusable(true);
		
		Label labelCurrentPassword = new Label("Current Password");
		labelCurrentPassword.setForeground(UIManager.getColor("Button.disabledText"));
		labelCurrentPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelCurrentPassword.setBounds(20, 70, 146, 43);
		panel_1.add(labelCurrentPassword);
		
		passwordFieldCurrentPassword = new JPasswordField();
		passwordFieldCurrentPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordFieldCurrentPassword.getPassword()).trim().equals("Password Here!")) {
					passwordFieldCurrentPassword.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldCurrentPassword.getPassword()).trim().equals("")) {
					passwordFieldCurrentPassword.setText("Password Here!");
				}
			}
		});
		passwordFieldCurrentPassword.setText("Password Here!");
		passwordFieldCurrentPassword.setSelectedTextColor(Color.WHITE);
		passwordFieldCurrentPassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldCurrentPassword.setForeground(Color.WHITE);
		passwordFieldCurrentPassword.setBorder(null);
		passwordFieldCurrentPassword.setBackground(UIManager.getColor("Button.foreground"));
		passwordFieldCurrentPassword.setBounds(12, 109, 250, 21);
		panel_1.add(passwordFieldCurrentPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(20, 140, 242, 16);
		panel_1.add(separator_1);
		
		Label labelCurrentPublicKey = new Label("Current Public Key");
		labelCurrentPublicKey.setForeground(UIManager.getColor("Button.disabledText"));
		labelCurrentPublicKey.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelCurrentPublicKey.setBounds(20, 162, 146, 36);
		panel_1.add(labelCurrentPublicKey);
		
		passwordFieldCurrentPublicKey = new JPasswordField();
		passwordFieldCurrentPublicKey.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordFieldCurrentPublicKey.getPassword()).trim().equals("Public key Here!")) {
					passwordFieldCurrentPublicKey.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldCurrentPublicKey.getPassword()).trim().equals("")) {
					passwordFieldCurrentPublicKey.setText("Public key Here!");
				}
			}
		});
		passwordFieldCurrentPublicKey.setText("Public key Here!");
		passwordFieldCurrentPublicKey.setSelectedTextColor(Color.WHITE);
		passwordFieldCurrentPublicKey.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldCurrentPublicKey.setForeground(Color.WHITE);
		passwordFieldCurrentPublicKey.setBorder(null);
		passwordFieldCurrentPublicKey.setBackground(UIManager.getColor("Button.foreground"));
		passwordFieldCurrentPublicKey.setBounds(12, 204, 250, 21);
		panel_1.add(passwordFieldCurrentPublicKey);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(20, 229, 242, 16);
		panel_1.add(separator);
		
		Label labelSetNewPublicKey = new Label("Set new Public Key");
		labelSetNewPublicKey.setForeground(UIManager.getColor("Button.disabledText"));
		labelSetNewPublicKey.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelSetNewPublicKey.setBounds(20, 262, 146, 36);
		panel_1.add(labelSetNewPublicKey);
		
		passwordFieldNewPublicKey = new JPasswordField();
		passwordFieldNewPublicKey.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordFieldNewPublicKey.getPassword()).trim().equals("Set new public key")) {
					passwordFieldNewPublicKey.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldNewPublicKey.getPassword()).trim().equals("")) {
					passwordFieldNewPublicKey.setText("Set new public key");
				}
			}
		});
		passwordFieldNewPublicKey.setText("Set new public key");
		passwordFieldNewPublicKey.setSelectedTextColor(Color.WHITE);
		passwordFieldNewPublicKey.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldNewPublicKey.setForeground(Color.WHITE);
		passwordFieldNewPublicKey.setBorder(null);
		passwordFieldNewPublicKey.setBackground(UIManager.getColor("Button.foreground"));
		passwordFieldNewPublicKey.setBounds(12, 296, 250, 21);
		panel_1.add(passwordFieldNewPublicKey);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(20, 320, 242, 16);
		panel_1.add(separator_2);
		
		JButton btnLooksGreat = new JButton("Looks Great!");
		btnLooksGreat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String current_password = String.valueOf(passwordFieldCurrentPassword.getPassword());
				String current_publickey = String.valueOf(passwordFieldCurrentPublicKey.getPassword());
				String new_publickuy = String.valueOf(passwordFieldNewPublicKey.getPassword());
			//	String confirm_new_publickuy = String.valueOf(passwordFieldConfirmNewPublicKey.getPassword());
				
				if(String.valueOf(passwordFieldCurrentPassword.getPassword()).equals("") || String.valueOf(passwordFieldCurrentPassword.getPassword()).equals("Password Here!")) {
					JOptionPane.showMessageDialog(null, "Please enter correct current Password!");
				}
				else if(String.valueOf(passwordFieldCurrentPublicKey.getPassword()).equals("") || String.valueOf(passwordFieldCurrentPublicKey.getPassword()).equals("Password Here!")) {
					JOptionPane.showMessageDialog(null, "Please enter correct current Public Key!");
				}
				else if(String.valueOf(passwordFieldNewPublicKey.getPassword()).equals("") || String.valueOf(passwordFieldNewPublicKey.getPassword()).equals("Password Here!")) {
					JOptionPane.showMessageDialog(null, "Please enter new Public Key!");
				}
				else if(String.valueOf(passwordFieldConfirmNewPublicKey.getPassword()).equals("") || String.valueOf(passwordFieldConfirmNewPublicKey.getPassword()).equals("Password Here!") || !String.valueOf(passwordFieldNewPublicKey.getPassword()).equals(String.valueOf(passwordFieldConfirmNewPublicKey.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Please Confirm Public Key!");
				}
				else {
					PreparedStatement ps;
					String query = "UPDATE `signup` SET `user_publicKey`= ? WHERE `user_publicKey`= ? AND `user_password`= ?";	
					try {
						ps = MyConnection.getConnection().prepareStatement(query);
						//ps = SqLiteConnection.getSqliteConnection().prepareStatement(query);
						ps.setString(1,new_publickuy);
						ps.setString(2,current_publickey);
						ps.setString(3,current_password);
									
						if(ps.executeUpdate() > 0) {
							JOptionPane.showMessageDialog(null, "Successfully public key changed ;)");
							SettingsJFrame ssjf = new SettingsJFrame();
							ssjf.setVisible(true);
							//t.setSize(450,500);
							ssjf.setLocationRelativeTo(null);					
							dispose();
						}
						else {
							JOptionPane.showMessageDialog(null, "Please add a valid user name! OR Check your current password!");
						}
					}
					
					catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Error while establishing connection.");
					}
				}
				
			}
		});
		btnLooksGreat.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLooksGreat.setForeground(UIManager.getColor("Button.foreground"));
		btnLooksGreat.setFocusable(false);
		btnLooksGreat.setBorder(null);
		btnLooksGreat.setBackground(new Color(51, 153, 153));
		btnLooksGreat.setBounds(171, 453, 118, 44);
		panel_1.add(btnLooksGreat);
		
		Label labelConfirmNewPublicKey = new Label("Confirm New Public Key");
		labelConfirmNewPublicKey.setForeground(UIManager.getColor("Button.disabledText"));
		labelConfirmNewPublicKey.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelConfirmNewPublicKey.setBounds(20, 343, 184, 36);
		panel_1.add(labelConfirmNewPublicKey);
		
		passwordFieldConfirmNewPublicKey = new JPasswordField();
		passwordFieldConfirmNewPublicKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnLooksGreat.doClick();
				}
			}
		});
		passwordFieldConfirmNewPublicKey.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordFieldConfirmNewPublicKey.getPassword()).trim().equals("Confirm new public key")) {
					passwordFieldConfirmNewPublicKey.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldConfirmNewPublicKey.getPassword()).trim().equals("")) {
					passwordFieldConfirmNewPublicKey.setText("Confirm new public key");
				}
			}
		});
		passwordFieldConfirmNewPublicKey.setText("Confirm new public key");
		passwordFieldConfirmNewPublicKey.setSelectedTextColor(Color.WHITE);
		passwordFieldConfirmNewPublicKey.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldConfirmNewPublicKey.setForeground(Color.WHITE);
		passwordFieldConfirmNewPublicKey.setBorder(null);
		passwordFieldConfirmNewPublicKey.setBackground(UIManager.getColor("Button.foreground"));
		passwordFieldConfirmNewPublicKey.setBounds(20, 378, 250, 21);
		panel_1.add(passwordFieldConfirmNewPublicKey);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(20, 404, 242, 16);
		panel_1.add(separator_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingsJFrame sjfm1 = new SettingsJFrame();
				sjfm1.setVisible(true);
				//t.setSize(450,500);
				sjfm1.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(UIManager.getColor("Button.foreground"));
		btnBack.setFocusable(false);
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(51, 153, 153));
		btnBack.setBounds(20, 460, 114, 30);
		panel_1.add(btnBack);
	}
}
