package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import java.awt.Label;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class LoginFormJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JPasswordField passwordFieldPassword;
    private int attempts = 3;
	private String name;
	private String password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					LoginFormJFrame frame = new LoginFormJFrame();
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
	public LoginFormJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 634, 563);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, -11, 333, 544);
		contentPane.add(panel);
		panel.setLayout(null);
		panel.setFocusable(true);
		
		JLabel labelImage = new JLabel("");
		labelImage.setIcon(null);
		labelImage.setBounds(56, 155, 242, 255);
		panel.add(labelImage);
		Image img = new ImageIcon(this.getClass().getResource("/login.png")).getImage();
		labelImage.setIcon(new ImageIcon(img));
		
		JSeparator separatorDivider4 = new JSeparator();
		separatorDivider4.setBounds(41, 432, 269, 35);
		panel.add(separatorDivider4);
		
		JSeparator separatorDivider5 = new JSeparator();
		separatorDivider5.setBounds(70, 455, 210, 28);
		panel.add(separatorDivider5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panel_1.setForeground(new Color(51, 51, 51));
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(332, -11, 302, 544);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		Label labelLogin = new Label("Login");
		labelLogin.setForeground(UIManager.getColor("Button.disabledText"));
		labelLogin.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelLogin.setBounds(25, 65, 53, 25);
		panel_1.add(labelLogin);
		
		Label labelName = new Label("Name");
		labelName.setForeground(UIManager.getColor("Button.disabledText"));
		labelName.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelName.setBounds(25, 110, 53, 30);
		panel_1.add(labelName);
		
		Label labelPassword = new Label("Password");
		labelPassword.setForeground(UIManager.getColor("Button.disabledText"));
		labelPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelPassword.setBounds(25, 238, 80, 25);
		panel_1.add(labelPassword);
		
		JLabel lblDidYouForgetPassword = new JLabel("Forgot Password ?");
		lblDidYouForgetPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPasswordJFrame forgotPasswordJFrameObject = new ForgotPasswordJFrame();
				forgotPasswordJFrameObject.setVisible(true);
				//t.setSize(450,500);
				forgotPasswordJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblDidYouForgetPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblDidYouForgetPassword.setFocusable(false);
		lblDidYouForgetPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblDidYouForgetPassword.setHorizontalTextPosition(SwingConstants.CENTER);
		lblDidYouForgetPassword.setForeground(new Color(102, 102, 102));
		lblDidYouForgetPassword.setBounds(103, 444, 168, 25);
		panel_1.add(lblDidYouForgetPassword);
		
		JLabel lblForgotName = new JLabel("Forgot Name ?");
		lblForgotName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotNameJFrame forgotNameJFrameObject = new ForgotNameJFrame();
				forgotNameJFrameObject.setVisible(true);
				//t.setSize(450,500);
				forgotNameJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});
		lblForgotName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblForgotName.setHorizontalTextPosition(SwingConstants.CENTER);
		lblForgotName.setHorizontalAlignment(SwingConstants.CENTER);
		lblForgotName.setForeground(new Color(102, 102, 102));
		lblForgotName.setFocusable(false);
		lblForgotName.setBounds(104, 488, 168, 25);
		panel_1.add(lblForgotName);
		
		JLabel minimizeLabel = new JLabel("");
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		minimizeLabel.setBounds(167, 12, 48, 48);
		Image img1 = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
		minimizeLabel.setIcon(new ImageIcon(img1));
		panel_1.add(minimizeLabel);
		
		JLabel closeLabel = new JLabel("New label");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeLabel.setBounds(229, 12, 48, 48);
		Image img2 = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		closeLabel.setIcon(new ImageIcon(img2));
		panel_1.add(closeLabel);
		
		JSeparator separatorDivider1 = new JSeparator();
		separatorDivider1.setForeground(new Color(255, 255, 255));
		separatorDivider1.setBounds(25, 202, 247, 8);
		panel_1.add(separatorDivider1);
		
		textFieldName = new JTextField();
		textFieldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFieldName.getText().trim().equals("Enter Your Username Here!")) {
					textFieldName.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldName.getText().trim().equals("")) {
					textFieldName.setText("Enter Your Username Here!");
				}
			}
		});

		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				LoginFormJFrame loginFormJFrameObject1 = new LoginFormJFrame();
				loginFormJFrameObject1.setName(textFieldName.getText());
				loginFormJFrameObject1.setPassword( String.valueOf(passwordFieldPassword.getPassword()));
				PreparedStatement ps;
				PreparedStatement ps1;
				ResultSet rs;
				ResultSet rs1;
				try {
					
					ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForLogIn);	
					//ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForLogIn);
					ps.setString(1, loginFormJFrameObject1.getName());
					ps.setString(2, loginFormJFrameObject1.getPassword());
					rs = ps.executeQuery();
					
					ps1 = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForAttempt);
					//ps1 = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForAttempt);
					ps1.setString(1, loginFormJFrameObject1.getName());
					rs1 = ps1.executeQuery();
					
					if(rs.next()) {
						StaticFields.loggedInUsersName = loginFormJFrameObject1.getName();
						if(StaticFields.isSuspendedAccount()) {
							JOptionPane.showMessageDialog(null,"Your account is suspended. Please provide the retrieval code.");
							StaticFields.isUserEnteredTheSystemByLoggingIn = true;
							RetrievalJFrame retrievalJFrameObject = new RetrievalJFrame();
							retrievalJFrameObject.setVisible(true);
							//t.setSize(450,500);
							retrievalJFrameObject.setLocationRelativeTo(null);
							dispose();
						}
						else {
							StaticFields.emailAddressOfTheReceiver = rs.getString("user_email");
							JOptionPane.showMessageDialog(null, "Check your email,We've sent you a 4-digit code.");
							EmailSender.sendEmailOTP();
							StaticFields.isUserEnteredTheSystemByLoggingIn = true;
							ConformationJFrame conformObject2 = new ConformationJFrame();
							conformObject2.setVisible(true);
							//t.setSize(450,500);
							conformObject2.setLocationRelativeTo(null);
							dispose();
						}	
					}
					else if(rs1.next()) {
						StaticFields.loggedInUsersName = loginFormJFrameObject1.getName();
						if(StaticFields.isSuspendedAccount()) {
							System.out.println("The account is suspended!. So don't count attempts.");
							JOptionPane.showMessageDialog(null, "The password is incorrect.");
						}
						else {
							System.out.println("The account isn't suspended!. So count attempts.");
							attempts --;
						}
						} 
					
					else {
						JOptionPane.showMessageDialog(null, "Check Name or Password.");
						
					}
					if(attempts == 2) {
						JOptionPane.showMessageDialog(null, rs1.getString("user_name")+", you have "+attempts+" attempst(s) left!.");
					}
					if(attempts == 0) {
						JOptionPane.showMessageDialog(null, "Intruder identified!. " + rs1.getString("user_name") + ", Check your email. Now this application will exit.");
						StaticFields.emailAddressOfTheReceiver = rs1.getString("user_email");
						StaticFields.UserNameForAccountRetrieve = rs1.getString("user_name");
						StaticFields.otpForRetrieval = StaticFields.otp;
						EmailSender.sendEmailForRetrieveAccount();
						System.out.println(StaticFields.otpForRetrieval);
						StaticFields.insertOtpToDb();
						System.exit(0);
					}
					if(attempts == 1) {
						JOptionPane.showMessageDialog(null, rs1.getString("user_name")+", you have "+attempts+" attempst(s) left!.");
						JOptionPane.showMessageDialog(null, "If you fail in the 3rd and final attempt your account will be suspended due to our security protocols");
					}
				}
			
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error while establishing connection.");
				}
				
				
			}
		});
		
		JSeparator separatorDivider2 = new JSeparator();
		separatorDivider2.setForeground(Color.WHITE);
		separatorDivider2.setBounds(25, 311, 252, 8);
		panel_1.add(separatorDivider2);
		
		JSeparator separatorDivider3 = new JSeparator();
		separatorDivider3.setForeground(Color.WHITE);
		separatorDivider3.setBounds(113, 473, 148, 2);
		panel_1.add(separatorDivider3);
		
		JSeparator separatorDivider6 = new JSeparator();
		separatorDivider6.setForeground(Color.WHITE);
		separatorDivider6.setBounds(113, 513, 148, 2);
		panel_1.add(separatorDivider6);
		btnLogin.setBorder(null);
		btnLogin.setFocusable(false);
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBackground(new Color(51, 153, 153));
		btnLogin.setForeground(new Color(51, 51, 51));
		btnLogin.setHorizontalTextPosition(SwingConstants.CENTER);
		btnLogin.setBounds(159, 367, 118, 44);
		panel_1.add(btnLogin);
		textFieldName.setText("Enter Your Username Here!");
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setForeground(new Color(255, 255, 255));
		textFieldName.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldName.setBorder(null);
		textFieldName.setBackground(new Color(51, 51, 51));
		textFieldName.setBounds(25, 164, 252, 30);
		panel_1.add(textFieldName);
		textFieldName.setColumns(10);
		

		
		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(String.valueOf(passwordFieldPassword.getPassword()).trim().equals("Password Here!")) {
					passwordFieldPassword.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(String.valueOf(passwordFieldPassword.getPassword()).trim().equals("")) {
					passwordFieldPassword.setText("Password Here!");
				}
			}
		});
		passwordFieldPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					btnLogin.doClick();
				}
			}
		});

		passwordFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldPassword.setBorder(null);
		passwordFieldPassword.setBackground(new Color(51, 51, 51));
		passwordFieldPassword.setForeground(new Color(255, 255, 255));
		passwordFieldPassword.setSelectedTextColor(new Color(255, 255, 255));
		passwordFieldPassword.setText("Password Here!");
		passwordFieldPassword.setBounds(25, 281, 252, 30);
		panel_1.add(passwordFieldPassword);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StartJFrame startJFrameObject = new StartJFrame();
				startJFrameObject.setVisible(true);
				//t.setSize(450,500);
				startJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnBack.setFocusable(false);
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(null);
		btnBack.setForeground(new Color(51, 51, 51));
		btnBack.setBackground(new Color(51, 153, 153));
		btnBack.setHorizontalTextPosition(SwingConstants.CENTER);
		btnBack.setBounds(25, 374, 114, 30);
		panel_1.add(btnBack);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
