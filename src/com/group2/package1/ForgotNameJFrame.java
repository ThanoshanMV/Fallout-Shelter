package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Label;
import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class ForgotNameJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private String email;
	private String userName;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ForgotNameJFrame frame = new ForgotNameJFrame();
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
	public ForgotNameJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 552, 455);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLeftSide = new JPanel();
		panelLeftSide.setBackground(new Color(51, 153, 153));
		panelLeftSide.setBounds(0, -15, 251, 440);
		contentPane.add(panelLeftSide);
		panelLeftSide.setLayout(null);
		
		Label labelForgotName = new Label("Forgot Name ?");
		labelForgotName.setForeground(Color.WHITE);
		labelForgotName.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelForgotName.setBounds(10, 68, 188, 49);
		panelLeftSide.add(labelForgotName);
		
		JPanel panelRightSide = new JPanel();
		panelRightSide.setBackground(new Color(51, 51, 51));
		panelRightSide.setBounds(240, -15, 312, 440);
		contentPane.add(panelRightSide);
		panelRightSide.setLayout(null);
		panelRightSide.setFocusable(true);
		
		JButton buttonSubmit = new JButton("Submit");
		buttonSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		buttonSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ForgotNameJFrame forgotNameJFrameObject = new ForgotNameJFrame();
				forgotNameJFrameObject.setEmail(textFieldEmail.getText());
				PreparedStatement ps;
				ResultSet rs;
				
				try {
					ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForForgetNameJFrame);
					//ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForForgetNameJFrame);

					ps.setString(1, forgotNameJFrameObject.getEmail());
				
					rs = ps.executeQuery();
					
					if(rs.next()) {

						forgotNameJFrameObject.setUserName(rs.getString("user_name"));						
						StaticFields.emailAddressOfTheReceiver = forgotNameJFrameObject.getEmail();
						StaticFields.userName = forgotNameJFrameObject.getUserName();
						JOptionPane.showMessageDialog(null, "Dont't worry. Check your email");
						EmailSender.sendEmailForForgetName();
						LoginFormJFrame loginFormJFrameObject = new LoginFormJFrame();
						loginFormJFrameObject.setVisible(true);
						//t.setSize(450,500);
						loginFormJFrameObject.setLocationRelativeTo(null);
						dispose();
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect email!. Please try again.");
					}
				}
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Error while establishing connection.");
				}
			}
		});
		
		Label labelEmail = new Label("Email");
		labelEmail.setForeground(UIManager.getColor("Button.disabledText"));
		labelEmail.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelEmail.setBounds(19, 92, 98, 30);
		panelRightSide.add(labelEmail);
		
		Label labelForgotPassword = new Label("Forgot Password?");
		labelForgotPassword.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelForgotPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotPasswordJFrame forgotPasswordJFrameObject = new ForgotPasswordJFrame();
				forgotPasswordJFrameObject.setVisible(true);
				//t.setSize(450,500);
				forgotPasswordJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});
		labelForgotPassword.setForeground(UIManager.getColor("Button.disabledText"));
		labelForgotPassword.setFont(new Font("Dialog", Font.BOLD, 12));
		labelForgotPassword.setBounds(146, 368, 156, 12);
		panelRightSide.add(labelForgotPassword);
		
		Label labelCreateNewAcc = new Label("Create new account?");
		labelCreateNewAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelCreateNewAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartJFrame startJFrameObject = new StartJFrame();
				startJFrameObject.setVisible(true);
				//t.setSize(450,500);
				startJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});
		labelCreateNewAcc.setForeground(UIManager.getColor("Button.disabledText"));
		labelCreateNewAcc.setFont(new Font("Dialog", Font.BOLD, 12));
		labelCreateNewAcc.setBounds(130, 315, 165, 12);
		panelRightSide.add(labelCreateNewAcc);
		buttonSubmit.setForeground(UIManager.getColor("Button.foreground"));
		buttonSubmit.setBorder(null);
		buttonSubmit.setBackground(new Color(51, 204, 204));
		buttonSubmit.setBounds(159, 220, 114, 35);
		panelRightSide.add(buttonSubmit);
		
		JSeparator separatorDivider1 = new JSeparator();
		separatorDivider1.setForeground(Color.WHITE);
		separatorDivider1.setBounds(20, 170, 252, 12);
		panelRightSide.add(separatorDivider1);
		
		textFieldEmail = new JTextField();
		textFieldEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					buttonSubmit.doClick();
				}
			}
		});
		textFieldEmail.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if(textFieldEmail.getText().trim().equals("Enter Your Email Here!")) {
					textFieldEmail.setText("");
				}
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(textFieldEmail.getText().trim().equals("")) {
					textFieldEmail.setText("Enter Your Email Here!");
				}
			}
		});
		textFieldEmail.setText("Enter Your Email Here!");
		textFieldEmail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldEmail.setForeground(Color.WHITE);
		textFieldEmail.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBorder(null);
		textFieldEmail.setBackground(UIManager.getColor("Button.foreground"));
		textFieldEmail.setBounds(19, 131, 253, 30);
		panelRightSide.add(textFieldEmail);
		
		JSeparator separatorDivider2 = new JSeparator();
		separatorDivider2.setForeground(Color.WHITE);
		separatorDivider2.setBounds(130, 339, 148, 12);
		panelRightSide.add(separatorDivider2);
		
		JSeparator separatorDivider3 = new JSeparator();
		separatorDivider3.setForeground(Color.WHITE);
		separatorDivider3.setBounds(143, 386, 134, 2);
		panelRightSide.add(separatorDivider3);
		
		JLabel labelClose = new JLabel("");
		labelClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		labelClose.setBounds(224, 23, 48, 48);
		panelRightSide.add(labelClose);
		Image labelCloseImage = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		labelClose.setIcon(new ImageIcon(labelCloseImage));
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
