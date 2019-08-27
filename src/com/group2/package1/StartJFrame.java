package com.group2.package1;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import java.awt.Panel;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

@SuppressWarnings("serial")
public class StartJFrame extends JFrame {
	private JPasswordField passwordFieldPassword;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JPasswordField passwordFieldRetypePassword;
	private String name;
	private String password;
	private String retypePassword;
	private String email;
	private String query;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					StartJFrame frame = new StartJFrame();
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
	public StartJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 554);

		setLocationRelativeTo(null);

		Panel panelMain = new Panel();
		getContentPane().add(panelMain, BorderLayout.CENTER);
		panelMain.setLayout(null);
		panelMain.setFocusable(true);

		Panel panelLeftSide = new Panel();
		panelLeftSide.setBackground(new Color(32, 178, 170));
		panelLeftSide.setBounds(0, -12, 343, 536);
		panelMain.add(panelLeftSide);
		panelLeftSide.setLayout(null);

		Label labelMaster = new Label("You are the Master!");
		labelMaster.setForeground(new Color(255, 255, 255));
		labelMaster.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelMaster.setBounds(55, 77, 247, 61);
		panelLeftSide.add(labelMaster);

		Label labelWelcome = new Label("Welcome to Fallout Shelter!");
		labelWelcome.setForeground(Color.WHITE);
		labelWelcome.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelWelcome.setBounds(21, 433, 305, 50);
		panelLeftSide.add(labelWelcome);

		JLabel labelImageFalloutShelter = new JLabel("");
		Image imageFalloutShelter = new ImageIcon(this.getClass().getResource("/fallout.jpeg")).getImage();
		labelImageFalloutShelter.setIcon(new ImageIcon(imageFalloutShelter));
		labelImageFalloutShelter.setBounds(85, 156, 169, 199);
		panelLeftSide.add(labelImageFalloutShelter);

		JSeparator separatorDivider1 = new JSeparator();
		separatorDivider1.setBounds(33, 392, 269, 35);
		panelLeftSide.add(separatorDivider1);

		JSeparator separatorDivider2 = new JSeparator();
		separatorDivider2.setBounds(65, 413, 210, 28);
		panelLeftSide.add(separatorDivider2);

		Panel panelRightSide = new Panel();
		panelRightSide.setBackground(new Color(51, 51, 51));
		panelRightSide.setBounds(337, 0, 323, 524);
		panelMain.add(panelRightSide);
		panelRightSide.setLayout(null);

		Label labelSignup = new Label("Sign Up ");
		labelSignup.setForeground(new Color(153, 153, 153));
		labelSignup.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 14));
		labelSignup.setBounds(29, 47, 108, 48);
		panelRightSide.add(labelSignup);

		Label labelName = new Label("Name");
		labelName.setForeground(new Color(153, 153, 153));
		labelName.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelName.setBounds(29, 101, 98, 33);
		panelRightSide.add(labelName);

		Label labelPassword = new Label("Password");
		labelPassword.setForeground(new Color(153, 153, 153));
		labelPassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelPassword.setBounds(29, 182, 98, 23);
		panelRightSide.add(labelPassword);

		Label labelEmail = new Label("Email");
		labelEmail.setForeground(new Color(153, 153, 153));
		labelEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelEmail.setBounds(29, 340, 57, 23);
		panelRightSide.add(labelEmail);

		JLabel labelAlreadyAMember = new JLabel("Already a Member?");
		labelAlreadyAMember.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LoginFormJFrame loginFormJFrameObject = new LoginFormJFrame();
				loginFormJFrameObject.setVisible(true);
				// t.setSize(450,500);
				loginFormJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});
		labelAlreadyAMember.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelAlreadyAMember.setForeground(new Color(102, 102, 102));
		labelAlreadyAMember.setBounds(161, 469, 132, 35);
		panelRightSide.add(labelAlreadyAMember);

		Label labelRetypePassword = new Label("Retype Password");
		labelRetypePassword.setForeground(UIManager.getColor("Button.disabledText"));
		labelRetypePassword.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelRetypePassword.setBounds(29, 257, 153, 23);
		panelRightSide.add(labelRetypePassword);

		JLabel minimizeLabel = new JLabel("");
		Image minimizeLabelImage = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
		minimizeLabel.setIcon(new ImageIcon(minimizeLabelImage));
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		minimizeLabel.setBounds(177, 12, 48, 48);
		panelRightSide.add(minimizeLabel);

		JLabel closeLabel = new JLabel("");
		Image closeLabelImage = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		closeLabel.setIcon(new ImageIcon(closeLabelImage));
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeLabel.setBounds(245, 12, 48, 48);
		panelRightSide.add(closeLabel);

		JSeparator separatorDivider3 = new JSeparator();
		separatorDivider3.setBounds(29, 162, 247, 18);
		panelRightSide.add(separatorDivider3);

		JSeparator separatorDivider4 = new JSeparator();
		separatorDivider4.setBounds(29, 235, 247, 16);
		panelRightSide.add(separatorDivider4);

		JSeparator separatorDivider5 = new JSeparator();
		separatorDivider5.setBounds(29, 398, 247, 35);
		panelRightSide.add(separatorDivider5);

		textFieldName = new JTextField();
		textFieldName.setText("Enter your name here!");
		textFieldName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textFieldName.getText().trim().equals("Enter your name here!")) {
					textFieldName.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldName.getText().trim().equals("")) {
					textFieldName.setText("Enter your name here!");
				}
			}
		});

		JSeparator separatorDivider6 = new JSeparator();
		separatorDivider6.setBounds(161, 494, 132, 18);
		panelRightSide.add(separatorDivider6);

		JSeparator separatorDivider7 = new JSeparator();
		separatorDivider7.setBounds(29, 313, 247, 16);
		panelRightSide.add(separatorDivider7);
		textFieldName.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldName.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldName.setBorder(null);
		textFieldName.setBackground(new Color(51, 51, 51));
		textFieldName.setSelectedTextColor(new Color(255, 255, 255));
		textFieldName.setForeground(new Color(255, 255, 255));
		textFieldName.setBounds(29, 131, 247, 30);
		panelRightSide.add(textFieldName);
		textFieldName.setColumns(10);

		passwordFieldPassword = new JPasswordField();
		passwordFieldPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwordFieldPassword.getPassword()).trim().equals("Password here!")) {
					passwordFieldPassword.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwordFieldPassword.getPassword()).trim().equals("")) {
					passwordFieldPassword.setText("Password here!");
				}
			}
		});
		passwordFieldPassword.setText("Password here!");
		passwordFieldPassword.setToolTipText("");
		passwordFieldPassword.setForeground(new Color(255, 255, 255));
		passwordFieldPassword.setSelectedTextColor(new Color(255, 255, 255));
		passwordFieldPassword.setBorder(null);
		passwordFieldPassword.setBackground(new Color(51, 51, 51));
		passwordFieldPassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldPassword.setBounds(29, 211, 251, 23);
		panelRightSide.add(passwordFieldPassword);

		passwordFieldRetypePassword = new JPasswordField();
		passwordFieldRetypePassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (String.valueOf(passwordFieldRetypePassword.getPassword()).trim().equals("Retype Password here!")) {
					passwordFieldRetypePassword.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (String.valueOf(passwordFieldRetypePassword.getPassword()).trim().equals("")) {
					passwordFieldRetypePassword.setText("Retype Password here!");
				}
			}
		});
		passwordFieldRetypePassword.setText("Retype Password here!");
		passwordFieldRetypePassword.setSelectedTextColor(Color.WHITE);
		passwordFieldRetypePassword.setHorizontalAlignment(SwingConstants.CENTER);
		passwordFieldRetypePassword.setForeground(Color.WHITE);
		passwordFieldRetypePassword.setBorder(null);
		passwordFieldRetypePassword.setBackground(UIManager.getColor("Button.foreground"));
		passwordFieldRetypePassword.setBounds(29, 286, 247, 23);
		panelRightSide.add(passwordFieldRetypePassword);

		textFieldEmail = new JTextField();
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (textFieldEmail.getText().trim().equals("Enter your email here!")) {
					textFieldEmail.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (textFieldEmail.getText().trim().equals("")) {
					textFieldEmail.setText("Enter your email here!");
				}
			}
		});
		textFieldEmail.setText("Enter your email here!");
		textFieldEmail.setSelectedTextColor(Color.WHITE);
		textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(UIManager.getColor("Button.foreground"));
		textFieldEmail.setBounds(29, 369, 247, 25);
		panelRightSide.add(textFieldEmail);

		JCheckBox termsAndServicesCheckbox = new JCheckBox("I agree to all Terms & Services");
		termsAndServicesCheckbox.setBorder(null);
		termsAndServicesCheckbox.setFont(new Font("Dialog", Font.PLAIN, 14));
		termsAndServicesCheckbox.setForeground(new Color(153, 153, 153));
		termsAndServicesCheckbox.setBackground(new Color(51, 51, 51));
		termsAndServicesCheckbox.setBounds(29, 424, 247, 23);
		panelRightSide.add(termsAndServicesCheckbox);

		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StartJFrame objectOneOfStartJFrame = new StartJFrame();
				objectOneOfStartJFrame.setName(textFieldName.getText());
				objectOneOfStartJFrame.setPassword(String.valueOf(passwordFieldPassword.getPassword()));
				objectOneOfStartJFrame.setReTypePassword(String.valueOf(passwordFieldRetypePassword.getPassword()));
				objectOneOfStartJFrame.setEmail(textFieldEmail.getText());

				boolean isCheckboxSelected = termsAndServicesCheckbox.isSelected();

				if (objectOneOfStartJFrame.getName().equals("")
						|| objectOneOfStartJFrame.getName().equals("Enter Your UserName Here!")) {
					JOptionPane.showMessageDialog(null, "Please add a valid User Name!");
				}

				else if (objectOneOfStartJFrame.getPassword().equals("")
						|| objectOneOfStartJFrame.getPassword().equals("Password Here!")) {
					JOptionPane.showMessageDialog(null, "Please add a valid Password!");
				}

				else if (!objectOneOfStartJFrame.getPassword().equals(objectOneOfStartJFrame.getRetypePassword())) {
					JOptionPane.showMessageDialog(null, "Please Re-Type Password!");
				}

				else if (objectOneOfStartJFrame.getEmail().equals("")
						|| objectOneOfStartJFrame.getEmail().equals("Enter Your Email Here!")
						|| !EmailValidation.isEmailAddress(objectOneOfStartJFrame.getEmail())) {
					JOptionPane.showMessageDialog(null, "Please add a valid Email!");
				}

				else if (!isCheckboxSelected) {
					JOptionPane.showMessageDialog(null, "To be a member, agree to our Terms & Services");
				}

				else if (UserExistence.isUserNameExist(objectOneOfStartJFrame.getName())) {
					JOptionPane.showMessageDialog(null, "Sorry! This Username already Exists :(");
				}

				else if (UserExistence.isUserEmailExist(objectOneOfStartJFrame.getEmail())) {
					JOptionPane.showMessageDialog(null, "Sorry! This Email already Exists :(");
				} 

				else {
					PreparedStatement ps;
					objectOneOfStartJFrame.setQuery(StaticFields.sqlQueryForRegistration);
					try {
						ps = MyConnection.getConnection().prepareStatement(objectOneOfStartJFrame.getQuery());
					//	ps = SqLiteConnection.getSqliteConnection().prepareStatement(objectOneOfStartJFrame.getQuery());
						ps.setString(1, objectOneOfStartJFrame.getName());
						ps.setString(2, objectOneOfStartJFrame.getPassword());
						ps.setString(3, objectOneOfStartJFrame.getEmail());
						ps.setString(4, objectOneOfStartJFrame.getPassword());
						ps.setString(5, objectOneOfStartJFrame.getPassword());

						if (ps.executeUpdate() > 0) {
							JOptionPane.showMessageDialog(null, "Registration Successful!");
							StaticFields.isUserRegisteredSuccesfully = true;
							StaticFields.newlyRegisteredUsersName = objectOneOfStartJFrame.getName();
							StaticFields.emailAddressOfTheReceiver = objectOneOfStartJFrame.getEmail();
							JOptionPane.showMessageDialog(null, "Please wait for a few seconds..");
							EmailSender.sendEmailOTP();
							JOptionPane.showMessageDialog(null, "Check your email,We've sent you a 4-digit code.");
							ConformationJFrame conformObject1 = new ConformationJFrame();
							conformObject1.setVisible(true);
							// t.setSize(450,500);
							conformObject1.setLocationRelativeTo(null);
							dispose();
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Error while establishing connection.");
					}

				}
			}
		});
		btnSignUp.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignUp.setBorder(null);
		btnSignUp.setBackground(new Color(51, 204, 204));
		btnSignUp.setForeground(new Color(51, 51, 51));
		btnSignUp.setBounds(29, 469, 114, 35);
		panelRightSide.add(btnSignUp);
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

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setReTypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}

}
