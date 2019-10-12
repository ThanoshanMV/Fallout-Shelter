package com.group2.package1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class StaticFields {
	/* static variables in StartJFrame */
	static boolean isUserRegisteredSuccesfully = false;
	static String newlyRegisteredUsersName;
	static String sqlQueryForRegistration = "INSERT INTO `signup`(`user_name`,`user_password`,`user_email`,`user_publickey`,`user_privatekey`) VALUES (?,?,?,?,?)";

	/* static variables in EmailSender */
	static String otp = GenerateOTP.generateOTP();
	static String emailAddressOfTheReceiver;
	static String userName;
	static String temporaryPassword;
	
	/* static variables in QuickBackupJFrame and AdvancedBackupJFrame*/
	static String sourcePathOfBackupToZip;
	static String quickBackupDestinationPath;
	static String fileName;
	/* static variables in LoginFormJFrame */
	static String loggedInUsersName;
	static boolean isUserEnteredTheSystemByLoggingIn = false;
	static String sqlQueryForLogIn = "SELECT * FROM `signup` WHERE `user_name`= ? AND `user_password`= ?";
	static String sqlQueryForAttempt = "SELECT * FROM `signup` WHERE `user_name`= ?";
	static String UserNameForAccountRetrieve;
	static String sqlQueryForStoreOTP = "INSERT INTO `otpStore`(`user_name`, `otp`) VALUES (?,?)";
	static String otpForRetrieval;
	static String sqlQueryForSelectOtpStore = "SELECT * FROM `otpStore` WHERE `user_name`= ?";
	static String sqlQueryForDeleteSpecifiedRow = "DELETE FROM `otpStore` WHERE `user_name`= ?";

	/* static variables in ForgotPasswordJFrame */
	static String sqlQueryForForgotPasswordJFrame = "SELECT * FROM `signup` WHERE `user_name`= ?";
  //static String sqlQueryForInsertTempPassword = "INSERT INTO `temporaryPasswordStore`(`user_name`, `temp_password`) VALUES (?,?)";
	static String sqlQueryForUpdateTempPassAsCurrentPassword = "UPDATE `signup` SET `user_password`= ? WHERE `user_name`= ?";
	

	/* static variables in ForgotNameJFrame */
	static String sqlQueryForForgetNameJFrame = "SELECT * FROM `signup` WHERE `user_email`= ?";

	/* static variables in PublicKeyJFrame */
	static String sqlQueryForPublicKeyJFrame = "SELECT * FROM `signup` WHERE `user_publicKey`= ? AND `user_name`= ?";
	static boolean isThePublicKeyCorrect = false;

	/* static variables in AdvBackUpJFrame */
	static String advancedBackupSourcePath;
	static String advancedBackupDestinationPath;

	/* static variables in RestoreJFrame */
	static String restoreSourcePath;
	static String restoreDestinationPath;
	static boolean isFileCompressed = false;

	/* static variables in PrivateKeyJFrame */
	static String sqlQueryForPrivateKeyJFrame = "SELECT * FROM `signup` WHERE `user_privateKey`= ? AND `user_name`= ?";
	static boolean isThePrivateKeyCorrect = false;

	/* static variables in DbConnToAdvancedExecution */
	
	static String sqlQueryForSelectAutorizedUserToRestore = "SELECT * FROM `adv` WHERE `user_name`= ?";

	/* static variables in SettingsJFrame */
	static String sqlQueryForDeleteUserAccount = "DELETE FROM `signup` WHERE `user_name`= ?";
	static String sqlQueryForDeleteUserBackupHistory = "DELETE FROM `adv` WHERE `user_name`= ?";

	/* static method for insert otp to DB */
	static void insertOtpToDb() {
		PreparedStatement ps = null;
		try {
			ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForStoreOTP);

			ps.setString(1, StaticFields.UserNameForAccountRetrieve);
			ps.setString(2, StaticFields.otpForRetrieval);

			if (ps.executeUpdate() > 0) {
				System.out.println("insertOtpToDb was successfully executed!.");
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
				SqLiteConnection.getSqliteConnection().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	/*static boolean isSuspendedAccount() {
		PreparedStatement ps = null;
		boolean isQueryExecuted = false;
		ResultSet rs = null;
		try {

			ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForSelectOtpStore);
			ps.setString(1, StaticFields.loggedInUsersName);
			rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("The account is suspended!");
				isQueryExecuted = true;
				StaticFields.otpForRetrieval = rs.getString("otp");
			} else {
				System.out.println("The account isn't suspended!");
				isQueryExecuted = false;
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
		}
		return isQueryExecuted;
	}*/

	static void deleteOtpStoreDbRow() {
		PreparedStatement ps = null;
		try {
			ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForDeleteSpecifiedRow);

			ps.setString(1, StaticFields.loggedInUsersName);

			if (ps.executeUpdate() > 0) {
				System.out.println("Row was successfullt deleted!.");
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
				SqLiteConnection.getSqliteConnection().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}
/*	static void insertTemporaryPasswordToDb() {
		PreparedStatement ps;
		try {
			ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForInsertTempPassword);

			ps.setString(1, StaticFields.userName);
			ps.setString(2, StaticFields.temporaryPassword);

			if (ps.executeUpdate() > 0) {
				System.out.println("insertTemporaryPasswordToDb was successfully executed!.");
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error while establishing connection.");
		}
	} */
	static void updateTempPassAsCurrentUserPassword() {
		PreparedStatement ps = null;
		try {
			ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForUpdateTempPassAsCurrentPassword);

			ps.setString(1, StaticFields.temporaryPassword);
			ps.setString(2, StaticFields.userName);

			if (ps.executeUpdate() > 0) {
				System.out.println("Temporary password is set as user current password.");
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
				SqLiteConnection.getSqliteConnection().close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
