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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class ChangePasswordJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JPasswordField passwordFieldCurrentPassword;
	private JPasswordField passwordFieldNewPassword;
	private JPasswordField passwordFieldConfimPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ChangePasswordJFrame frame = new ChangePasswordJFrame();
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
	public ChangePasswordJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 580);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, -12, 250, 562);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label labelChangePassword = new Label("Change Password");
		labelChangePassword.setForeground(Color.WHITE);
		labelChangePassword.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelChangePassword.setBounds(10, 89, 188, 49);
		panel.add(labelChangePassword);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(239, -12, 375, 562);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Label labelName = new Label("Name");
		labelName.setForeground(UIManager.getColor("Button.disabledText"));
		labelName.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelName.setBounds(22, 45, 226, 48);
		panel_1.add(labelName);
		
		textFieldName = new JTextField();
		textFieldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textFieldName.getText().trim().equals("Enter Your Username Here!")) {
					textFieldName.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldName.getText().trim().equals("")) {
					textFieldName.setText("Enter Your Username Here!");
				}
			}
		});
		textFieldName.setText("Enter Your Username Here!");
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setForeground(Color.WHITE);
		textFieldName.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldName.setColumns(10);
		textFieldName.setBorder(null);
		textFieldName.setBackground(UIManager.getColor("Button.foreground"));
		textFieldName.setBounds(22, 96, 252, 30);
		panel_1.add(textFieldName);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(22, 128, 247, 30);
		panel_1.add(separator);
		
		Label labelCurrentPassword = new Label("Current Password");
		labelCurrentPassword.setForeground(UIManager.getColor("Button.disabledText"));
		labelCurrentPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelCurrentPassword.setBounds(22, 157, 139, 33);
		panel_1.add(labelCurrentPassword);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(22, 238, 247, 30);
		panel_1.add(separator_1);
		
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
		passwordFieldCurrentPassword.setBounds(22, 209, 252, 30);
		panel_1.add(passwordFieldCurrentPassword);
		
		Label labelSetNewPassword = new Label("Set New Password");
		labelSetNewPassword.setForeground(UIManager.getColor("Button.disabledText"));
		labelSetNewPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelSetNewPassword.setBounds(22, 271, 139, 35);
		panel_1.add(labelSetNewPassword);
		
		passwordFieldNewPassword = new JPasswordField();
		passwordFieldNewPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordFieldNewPassword.getPassword()).trim().equals("Set new password")) {
					passwordFieldNewPassword.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldNewPassword.getPassword()).trim().equals("")) {
					passwordFieldNewPassword.setText("Set new password");
				}
			}
		});
		passwordFieldNewPassword.setText("Set new password");
		passwordFieldNewPassword.setSelectedTextColor(Color.WHITE);
		passwordFieldNewPassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldNewPassword.setForeground(Color.WHITE);
		passwordFieldNewPassword.setBorder(null);
		passwordFieldNewPassword.setBackground(UIManager.getColor("Button.foreground"));
		passwordFieldNewPassword.setBounds(22, 312, 252, 30);
		panel_1.add(passwordFieldNewPassword);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(22, 351, 247, 30);
		panel_1.add(separator_2);
		
		JButton btnLooksGreat = new JButton("Looks Great!");
		btnLooksGreat.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = textFieldName.getText();
				String current_password = String.valueOf(passwordFieldCurrentPassword.getPassword());
				String new_password = String.valueOf(passwordFieldNewPassword.getPassword());
				//String confirm_password = String.valueOf(passwordFieldConfimPassword.getPassword());
				
				if(name.equals("") || name.equals("Enter Your UserName Here!")) {
					JOptionPane.showMessageDialog(null, "Please add a valid User Name!");
				}
				else if(String.valueOf(passwordFieldCurrentPassword.getPassword()).equals("") || String.valueOf(passwordFieldCurrentPassword.getPassword()).equals("Password Here!")) {
					JOptionPane.showMessageDialog(null, "Please enter a valid current Password!");
				}
				else if(String.valueOf(passwordFieldNewPassword.getPassword()).equals("") || String.valueOf(passwordFieldNewPassword.getPassword()).equals("Password Here!")) {
					JOptionPane.showMessageDialog(null, "Please add a valid new Password!");
				}
				else if(!String.valueOf(passwordFieldNewPassword.getPassword()).equals(String.valueOf(passwordFieldConfimPassword.getPassword()))) {
					JOptionPane.showMessageDialog(null, "Please confirm new Password!");
				}
				else {

				PreparedStatement ps;
				String query = "UPDATE `signup` SET `user_password`= ? WHERE `user_name`= ? AND `user_password`= ?";	
				try {
					ps = MyConnection.getConnection().prepareStatement(query);
					//ps = SqLiteConnection.getSqliteConnection().prepareStatement(query);
					ps.setString(1,new_password);
					ps.setString(2,name);
					ps.setString(3,current_password);
								
					if(ps.executeUpdate() > 0) {
						JOptionPane.showMessageDialog(null, "Successfully password changed ;)");
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
		btnLooksGreat.setBounds(220, 485, 118, 44);
		panel_1.add(btnLooksGreat);
		
		Label labelConfirmNewPassword = new Label("Confirm New Password");
		labelConfirmNewPassword.setForeground(UIManager.getColor("Button.disabledText"));
		labelConfirmNewPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelConfirmNewPassword.setBounds(22, 378, 226, 32);
		panel_1.add(labelConfirmNewPassword);
		
		passwordFieldConfimPassword = new JPasswordField();
		passwordFieldConfimPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnLooksGreat.doClick();
				}
			}
		});
		passwordFieldConfimPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordFieldConfimPassword.getPassword()).trim().equals("Confirm new password")) {
					passwordFieldConfimPassword.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldConfimPassword.getPassword()).trim().equals("")) {
					passwordFieldConfimPassword.setText("Confirm new password");
				}
			}
		});
		passwordFieldConfimPassword.setText("Confirm new password");
		passwordFieldConfimPassword.setSelectedTextColor(Color.WHITE);
		passwordFieldConfimPassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldConfimPassword.setForeground(Color.WHITE);
		passwordFieldConfimPassword.setBorder(null);
		passwordFieldConfimPassword.setBackground(UIManager.getColor("Button.foreground"));
		passwordFieldConfimPassword.setBounds(22, 416, 252, 30);
		panel_1.add(passwordFieldConfimPassword);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(22, 448, 247, 30);
		panel_1.add(separator_3);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingsJFrame settingsJFrameObject = new SettingsJFrame();
				settingsJFrameObject.setVisible(true);
				//t.setSize(450,500);
				settingsJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setForeground(UIManager.getColor("Button.foreground"));
		btnBack.setFocusable(false);
		btnBack.setBorder(null);
		btnBack.setBackground(new Color(51, 153, 153));
		btnBack.setBounds(32, 495, 114, 30);
		panel_1.add(btnBack);
	}

}
