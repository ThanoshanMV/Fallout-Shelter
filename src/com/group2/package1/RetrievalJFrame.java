package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class RetrievalJFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldOTP;
	private String userOtp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					RetrievalJFrame frame = new RetrievalJFrame();
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
	public RetrievalJFrame() {
		setBackground(new Color(51, 51, 51));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 493, 353);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel labelHey = new JLabel("Hey there,\n");
		labelHey.setForeground(new Color(51, 153, 153));
		labelHey.setFont(new Font("Dialog", Font.BOLD, 18));
		labelHey.setBounds(12, 65, 117, 40);
		contentPane.add(labelHey);
		
		JLabel labelRetrievalCode = new JLabel("Please provide the account retrieval code.");
		labelRetrievalCode.setForeground(new Color(51, 153, 153));
		labelRetrievalCode.setFont(new Font("Dialog", Font.BOLD, 18));
		labelRetrievalCode.setBounds(12, 104, 455, 40);
		contentPane.add(labelRetrievalCode);
		
		JLabel labelBackImage = new JLabel("");
		Image imageBack = new ImageIcon(this.getClass().getResource("/Go-back-icon.png")).getImage();
		labelBackImage.setIcon(new ImageIcon(imageBack));
		labelBackImage.addMouseListener(new MouseAdapter() {
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
		labelBackImage.setFont(new Font("Dialog", Font.BOLD, 30));
		labelBackImage.setBounds(25, 12, 40, 30);
		contentPane.add(labelBackImage);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBounds(131, 191, 171, 18);
		contentPane.add(separator);
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RetrievalJFrame RetrievalJFrameObject = new RetrievalJFrame();
				RetrievalJFrameObject.setUserOtp(textFieldOTP.getText());
				if (RetrievalJFrameObject.getUserOtp().equalsIgnoreCase(StaticFields.otpForRetrieval)) {
					StaticFields.deleteOtpStoreDbRow();
					JOptionPane.showMessageDialog(null, "Your account has retrieved and you've logged in successfully. ;)");
					DashboardJFrame djf = new DashboardJFrame();
					djf.setVisible(true);
					// t.setSize(450,500);
					djf.setLocationRelativeTo(null);
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
		btnNext.setBounds(296, 240, 118, 44);
		contentPane.add(btnNext);
		
		textFieldOTP = new JTextField();
		textFieldOTP.setDocument(new SetCharLimit(4));
		textFieldOTP.addKeyListener(new KeyAdapter() {
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
		textFieldOTP.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldOTP.setForeground(Color.WHITE);
		textFieldOTP.setFont(new Font("Dialog", Font.PLAIN, 25));
		textFieldOTP.setColumns(10);
		textFieldOTP.setBorder(null);
		textFieldOTP.setBackground(UIManager.getColor("Button.foreground"));
		textFieldOTP.setBounds(131, 156, 171, 30);
		contentPane.add(textFieldOTP);
	}

	public String getUserOtp() {
		return userOtp;
	}

	public void setUserOtp(String userOtp) {
		this.userOtp = userOtp;
	}
}
