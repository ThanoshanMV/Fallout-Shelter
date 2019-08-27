package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class ConformationJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ConformationJFrame frame = new ConformationJFrame();
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
	public ConformationJFrame() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 368);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setForeground(new Color(153, 153, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel labelBack = new JLabel("");
		labelBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StaticFields.otp = GenerateOTP.generateOTP();
				StartJFrame startJFrameObject = new StartJFrame();
				startJFrameObject.setVisible(true);
				// t.setSize(450,500);
				startJFrameObject.setLocationRelativeTo(null);
				dispose();

			}
		});
		labelBack.setIcon(null);
		labelBack.setFont(new Font("Dialog", Font.BOLD, 30));
		labelBack.setBounds(46, 27, 40, 30);
		contentPane.add(labelBack);
		Image imageBack = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		labelBack.setIcon(new ImageIcon(imageBack));

		JLabel lblNewLabel = new JLabel("Hey there,\n");
		lblNewLabel.setForeground(new Color(51, 153, 153));
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 18));
		lblNewLabel.setBounds(46, 69, 355, 61);
		contentPane.add(lblNewLabel);

		JLabel lblWeHaveSent = new JLabel("We have sent you a temporary pass code");
		lblWeHaveSent.setForeground(new Color(51, 153, 153));
		lblWeHaveSent.setFont(new Font("Dialog", Font.BOLD, 18));
		lblWeHaveSent.setBounds(46, 99, 472, 61);
		contentPane.add(lblWeHaveSent);

		JLabel lblEnterThe = new JLabel("Enter the 4 digit code sent to your Email");
		lblEnterThe.setForeground(new Color(51, 153, 153));
		lblEnterThe.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnterThe.setBounds(46, 155, 355, 61);
		contentPane.add(lblEnterThe);

		textField1 = new JTextField();
		textField1.setForeground(Color.WHITE);
		textField1.setHorizontalAlignment(SwingConstants.CENTER);
		textField1.setDocument(new SetCharLimit(1));
		textField1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();

				}

			}
		});
		textField1.setBorder(null);
		textField1.setBackground(new Color(51, 51, 51));
		textField1.setFont(new Font("Dialog", Font.PLAIN, 25));
		textField1.setBounds(71, 203, 77, 30);
		contentPane.add(textField1);
		textField1.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(81, 234, 62, 30);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBounds(170, 234, 62, 30);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(Color.WHITE);
		separator_2.setBounds(264, 234, 62, 30);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(Color.WHITE);
		separator_3.setBounds(362, 234, 62, 30);
		contentPane.add(separator_3);

		textField2 = new JTextField();
		textField2.setHorizontalAlignment(SwingConstants.CENTER);
		textField2.setForeground(Color.WHITE);
		textField2.setFont(new Font("Dialog", Font.PLAIN, 25));
		textField2.setColumns(10);
		textField2.setBorder(null);
		textField2.setBackground(new Color(51, 51, 51));
		textField2.setBounds(167, 203, 77, 30);
		contentPane.add(textField2);
		textField2.setDocument(new SetCharLimit(1));
		textField2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();

				}

			}
		});

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder sb = new StringBuilder();
				sb.append(textField1.getText()).append(textField2.getText()).append(textField3.getText())
						.append(textField4.getText());

				String otp_num = sb.toString();

				String email_otp_num = StaticFields.otp;

				/*
				 * System.out.println("otp_num = "+otp_num);
				 * System.out.println("sendEmail.otp = "+email_otp_num);
				 * 
				 * boolean b = false;
				 * 
				 * if(otp_num.equalsIgnoreCase(email_otp_num)) { b = true; }
				 * System.out.println("b value = "+b);
				 */

				if (otp_num.equalsIgnoreCase(email_otp_num)) {
					JOptionPane.showMessageDialog(null, "Successfully Logged in ;)");

					DashboardJFrame dashboardJFrameObject = new DashboardJFrame();
					dashboardJFrameObject.setVisible(true);
					// t.setSize(450,500);
					dashboardJFrameObject.setLocationRelativeTo(null);
					dispose();

				}

				else {
					JOptionPane.showMessageDialog(null, "Sorry, wrong code :(. Please try again.");
				}
			}
		});
		btnNext.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNext.setForeground(UIManager.getColor("Button.foreground"));
		btnNext.setFocusable(false);
		btnNext.setBorder(null);
		btnNext.setBackground(new Color(51, 153, 153));
		btnNext.setBounds(196, 264, 118, 44);
		contentPane.add(btnNext);

		textField3 = new JTextField();
		textField3.setHorizontalAlignment(SwingConstants.CENTER);
		textField3.setForeground(Color.WHITE);
		textField3.setFont(new Font("Dialog", Font.PLAIN, 25));
		textField3.setColumns(10);
		textField3.setBorder(null);
		textField3.setBackground(new Color(51, 51, 51));
		textField3.setBounds(264, 203, 77, 30);
		contentPane.add(textField3);
		textField3.setDocument(new SetCharLimit(1));
		textField3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();

				}

			}
		});

		textField4 = new JTextField();
		textField4.setHorizontalAlignment(SwingConstants.CENTER);
		textField4.setForeground(Color.WHITE);
		textField4.setFont(new Font("Dialog", Font.PLAIN, 25));
		textField4.setColumns(10);
		textField4.setBorder(null);
		textField4.setBackground(new Color(51, 51, 51));
		textField4.setBounds(362, 203, 77, 30);
		contentPane.add(textField4);
		textField4.setDocument(new SetCharLimit(1));

		textField4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();

				if (!((Character.isDigit(c)) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
					e.consume();

				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNext.doClick();
				}
			}
		});

	}
}
