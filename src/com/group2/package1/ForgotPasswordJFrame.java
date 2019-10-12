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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JLabel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class ForgotPasswordJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private String name;
	private String email;
	private String password;
	static boolean b1 = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ForgotPasswordJFrame frame = new ForgotPasswordJFrame();
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
	public ForgotPasswordJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 599, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 153));
		panel.setBounds(0, -12, 278, 426);
		contentPane.add(panel);
		panel.setLayout(null);

		Label label = new Label("Forgot Password ?");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		label.setBounds(25, 79, 188, 49);
		panel.add(label);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(268, -12, 343, 426);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setFocusable(true);

		JLabel closeLabel = new JLabel("");
		closeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closeLabel.setBounds(257, 22, 48, 48);
		panel_1.add(closeLabel);
		Image img1 = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		closeLabel.setIcon(new ImageIcon(img1));

		Label labelName = new Label("Name");
		labelName.setForeground(UIManager.getColor("Button.disabledText"));
		labelName.setFont(new Font("Dialog", Font.PLAIN, 14));
		labelName.setBounds(21, 127, 98, 30);
		panel_1.add(labelName);

		Label labelForgotName = new Label("Forgot Name?");
		labelForgotName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ForgotNameJFrame forgotNameJFrameObject = new ForgotNameJFrame();
				forgotNameJFrameObject.setVisible(true);
				// t.setSize(450,500);
				forgotNameJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});

		Label labelCreateNewAcc = new Label("Create new account?\n");
		labelCreateNewAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelCreateNewAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartJFrame startJFrameObject = new StartJFrame();
				startJFrameObject.setVisible(true);
				// t.setSize(450,500);
				startJFrameObject.setLocationRelativeTo(null);
				dispose();

			}
		});
		labelCreateNewAcc.setForeground(UIManager.getColor("Button.disabledText"));
		labelCreateNewAcc.setFont(new Font("Dialog", Font.BOLD, 12));
		labelCreateNewAcc.setBounds(143, 320, 176, 12);
		panel_1.add(labelCreateNewAcc);
		labelForgotName.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		labelForgotName.setBounds(195, 368, 124, 12);
		panel_1.add(labelForgotName);
		labelForgotName.setForeground(UIManager.getColor("Button.disabledText"));
		labelForgotName.setFont(new Font("Dialog", Font.BOLD, 12));

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ForgotPasswordJFrame forgotPasswordJFrameObject = new ForgotPasswordJFrame();
				forgotPasswordJFrameObject.setName(textFieldName.getText());
				PreparedStatement ps = null;
				ResultSet rs = null;

				try {
					//ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForForgotPasswordJFrame);
					ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForForgotPasswordJFrame);
					ps.setString(1, forgotPasswordJFrameObject.getName());

					rs = ps.executeQuery();

					if (rs.next()) {
						forgotPasswordJFrameObject.setEmail(rs.getString("user_email"));
						StaticFields.temporaryPassword = GenerateOTP.getAlphaNumericString(10);
						StaticFields.emailAddressOfTheReceiver = forgotPasswordJFrameObject.getEmail();
						StaticFields.userName = rs.getString("user_name");
						b1 = true;
						JOptionPane.showMessageDialog(null, "Dont't worry. Check your email");
						EmailSender.sendEmailForForgetPass();
						LoginFormJFrame lf = new LoginFormJFrame();
						lf.setVisible(true);
						// t.setSize(450,500);
						lf.setLocationRelativeTo(null);
						dispose();

					} else {
						JOptionPane.showMessageDialog(null, "Check User Name!");
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
						if(b1) {
							System.out.println(b1);
							StaticFields.updateTempPassAsCurrentUserPassword();
						}
						else {
							System.out.println(b1);
						}
					}
			}
		});
		btnSubmit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSubmit.setForeground(UIManager.getColor("Button.foreground"));
		btnSubmit.setBorder(null);
		btnSubmit.setBackground(new Color(51, 204, 204));
		btnSubmit.setBounds(168, 244, 114, 35);
		panel_1.add(btnSubmit);

		JSeparator separator = new JSeparator();
		separator.setBounds(21, 183, 252, 12);
		panel_1.add(separator);
		separator.setForeground(Color.WHITE);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(153, 338, 152, 1);
		panel_1.add(separator_1);
		separator_1.setForeground(Color.WHITE);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(197, 386, 108, 1);
		panel_1.add(separator_2);

		textFieldName = new JTextField();
		textFieldName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnSubmit.doClick();
				}
			}
		});
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
		textFieldName.setBounds(21, 154, 258, 30);
		panel_1.add(textFieldName);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
