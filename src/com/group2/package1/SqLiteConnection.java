package com.group2.package1;

import java.sql.*;

import javax.swing.JOptionPane;

public class SqLiteConnection {
	public static Connection getSqliteConnection() {
		Connection conn = null;
		try {
			Class.forName("org.sqlite.JDBC");
			conn = DriverManager.getConnection("jdbc:sqlite:" + System.getProperty("user.dir") + "\\falloutshelter.db");
			return conn;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

	static void createSignUpTable() {
		try {

			Statement statement1 = null;

			statement1 = getSqliteConnection().createStatement();
			// "INSERT INTO
			// `signup`(`user_name`,`user_password`,`user_email`,`user_publickey`,`user_privatekey`)
			// VALUES (?,?,?,?,?)";
			String createAdminTableQuery = "CREATE TABLE IF NOT EXISTS 'signup' ('ID' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 'user_name' TEXT NOT NULL, 'user_password' TEXT NOT NULL, 'user_email' TEXT NOT NULL, 'user_publickey' TEXT NOT NULL, 'user_privatekey' TEXT NOT NULL)";
			statement1.executeUpdate(createAdminTableQuery);
			statement1.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			try {
				getSqliteConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	static void createOtpTable() {
		try {

			Statement statement1 = null;

			statement1 = getSqliteConnection().createStatement();
//"INSERT INTO `otpStore`(`user_name`, `otp`) VALUES (?,?)";
			String createAdminTableQuery = "CREATE TABLE IF NOT EXISTS 'otpStore' ('ID' INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, 'user_name' TEXT NOT NULL, 'otp' TEXT NOT NULL)";
			statement1.executeUpdate(createAdminTableQuery);
			statement1.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			try {
				getSqliteConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	static void createAdvBackupTable() {
		try {

			Statement statement1 = null;

			statement1 = getSqliteConnection().createStatement();
// "INSERT INTO `adv_backup`(`user_name`,`destination`) VALUES (?,?)";
			String createAdminTableQuery = "CREATE TABLE IF NOT EXISTS `adv` (`user_name` TEXT NOT NULL, `destination` TEXT NOT NULL)";
			//String createAdminTableQuery = "CREATE TABLE IF NOT EXISTS `adv_backup` (`ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, `user_name` TEXT NOT NULL)";
			statement1.executeUpdate(createAdminTableQuery);
			statement1.close();

		} catch (Exception e) {
			System.err.println(e.getClass().getName() + ": " + e.getMessage());
			System.exit(0);
		} finally {
			try {
				getSqliteConnection().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
