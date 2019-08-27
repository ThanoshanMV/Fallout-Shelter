package com.group2.package1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.LineBorder;
import java.awt.Label;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class DashboardJFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					DashboardJFrame frame = new DashboardJFrame();
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
	public DashboardJFrame() {
		
		
		setBackground(new Color(51, 51, 51));
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 493);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(51, 51, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(255, 255, 255));
		separator.setBounds(256, 76, 21, 295);
		contentPane.add(separator);
		
		JButton btnQuickBackup = new JButton("Quick Backup\n");
		btnQuickBackup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				QuickBackUpJFrame quickBackUpJFrameObject = new QuickBackUpJFrame();
				quickBackUpJFrameObject.setVisible(true);
				quickBackUpJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		
		Label labelDashboard = new Label("Dashboard");
		labelDashboard.setForeground(Color.WHITE);
		labelDashboard.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		labelDashboard.setBounds(22, 106, 188, 49);
		contentPane.add(labelDashboard);
		
		Label labelUserName = new Label("");
		labelUserName.setAlignment(Label.CENTER);
		labelUserName.setForeground(Color.WHITE);
		labelUserName.setFont(new Font("URW Gothic L", Font.BOLD | Font.ITALIC, 30));
		labelUserName.setBounds(10, 219, 240, 68);
		contentPane.add(labelUserName);
		
		Label labelWelcome = new Label("Welcome");
		labelWelcome.setForeground(Color.WHITE);
		labelWelcome.setFont(new Font("URW Chancery L", Font.PLAIN, 44));
		labelWelcome.setBounds(22, 158, 206, 68);
		contentPane.add(labelWelcome);
		
		JLabel closelabel = new JLabel("");
		closelabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		closelabel.setBounds(492, 7, 48, 40);
		contentPane.add(closelabel);
		Image closeLabelImage = new ImageIcon(this.getClass().getResource("/close.png")).getImage();
		closelabel.setIcon(new ImageIcon(closeLabelImage));
		
		JLabel minimizeLabel = new JLabel("");	
		minimizeLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		minimizeLabel.setBounds(424, 7, 48, 40);
		contentPane.add(minimizeLabel);
		Image minimizeLabelImage = new ImageIcon(this.getClass().getResource("/minimize.png")).getImage();
		minimizeLabel.setIcon(new ImageIcon(minimizeLabelImage));
		btnQuickBackup.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnQuickBackup.setHorizontalTextPosition(SwingConstants.CENTER);
		btnQuickBackup.setForeground(new Color(153, 153, 153));
		btnQuickBackup.setFocusable(false);
		btnQuickBackup.setBackground(new Color(51, 51, 51));
		btnQuickBackup.setBounds(322, 90, 150, 30);
		contentPane.add(btnQuickBackup);
		
		JButton btnAdvancedBackup = new JButton("Advanced Backup\n\n");
		btnAdvancedBackup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AdvBackUpJFrame advBackUpJFrameObject = new AdvBackUpJFrame();
				advBackUpJFrameObject.setVisible(true);
				advBackUpJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnAdvancedBackup.setHorizontalTextPosition(SwingConstants.CENTER);
		btnAdvancedBackup.setForeground(new Color(153, 153, 153));
		btnAdvancedBackup.setFocusable(false);
		btnAdvancedBackup.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnAdvancedBackup.setBackground(new Color(51, 51, 51));
		btnAdvancedBackup.setBounds(322, 171, 150, 30);
		contentPane.add(btnAdvancedBackup);
		
		JButton btnRestore = new JButton("Restore");
		btnRestore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				RestoreJFrame restoreJFrameObject = new RestoreJFrame();
				restoreJFrameObject.setVisible(true);
				restoreJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnRestore.setHorizontalTextPosition(SwingConstants.CENTER);
		btnRestore.setForeground(new Color(153, 153, 153));
		btnRestore.setFocusable(false);
		btnRestore.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnRestore.setBackground(new Color(51, 51, 51));
		btnRestore.setBounds(322, 244, 150, 30);
		contentPane.add(btnRestore);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SettingsJFrame settingsJFrameObject = new SettingsJFrame();
				settingsJFrameObject.setVisible(true);
				//t.setSize(450,500);
				settingsJFrameObject.setLocationRelativeTo(null);					
				dispose();
			}
		});
		btnSettings.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSettings.setForeground(UIManager.getColor("Button.disabledText"));
		btnSettings.setFocusable(false);
		btnSettings.setBorder(new LineBorder(new Color(51, 153, 153), 2, true));
		btnSettings.setBackground(new Color(51, 51, 51));
		btnSettings.setBounds(322, 317, 150, 30);
		contentPane.add(btnSettings);
		
		JButton btnSignOut = new JButton("Sign out");
		btnSignOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				StaticFields.otp = GenerateOTP.generateOTP();
				StartJFrame startJFrameObject = new StartJFrame();
				startJFrameObject.setVisible(true);
				startJFrameObject.setLocationRelativeTo(null);
				dispose();
			}
		});
		btnSignOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignOut.setHideActionText(true);
		btnSignOut.setHorizontalTextPosition(SwingConstants.CENTER);
		btnSignOut.setForeground(UIManager.getColor("Button.disabledText"));
		btnSignOut.setFocusable(false);
		btnSignOut.setBorder(new MatteBorder(1, 1, 1, 1, new Color(204, 51, 0)));
		btnSignOut.setBackground(new Color(51, 51, 51));
		btnSignOut.setBounds(433, 403, 94, 30);
		contentPane.add(btnSignOut);
		if(StaticFields.isUserEnteredTheSystemByLoggingIn) {
			labelUserName.setText(StaticFields.loggedInUsersName+" !");
		}
		else {
			labelUserName.setText(StaticFields.newlyRegisteredUsersName+" !");
		}
	
	}
}
