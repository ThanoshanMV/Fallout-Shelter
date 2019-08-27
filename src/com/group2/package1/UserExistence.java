package com.group2.package1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class UserExistence {
	public static boolean isUserNameExist(String username) {
		PreparedStatement ps;
		ResultSet rs;
		boolean checkUserName = false;
		String query = "SELECT * FROM `signup` WHERE `user_name`= ?";
		try {
			ps = MyConnection.getConnection().prepareStatement(query);
			//ps = SqLiteConnection.getSqliteConnection().prepareStatement(query);
			ps.setString(1, username);

			rs = ps.executeQuery();

			if (rs.next()) {
				checkUserName = true;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error while establishing connection.");
		}
		return checkUserName;
	}

	public static boolean isUserEmailExist(String email) {
		PreparedStatement ps;
		ResultSet rs;
		boolean checkUserEmail = false;
		String query = "SELECT * FROM `signup` WHERE `user_email`= ?";
		try {
			ps = MyConnection.getConnection().prepareStatement(query);
			//ps = SqLiteConnection.getSqliteConnection().prepareStatement(query);
			ps.setString(1, email);

			rs = ps.executeQuery();

			if (rs.next()) {
				checkUserEmail = true;
			}

		} catch (SQLException ex) {
			JOptionPane.showMessageDialog(null, "Error while establishing connection.");
		}
		return checkUserEmail;
	}

}
