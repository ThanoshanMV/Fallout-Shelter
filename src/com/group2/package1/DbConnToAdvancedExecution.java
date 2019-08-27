package com.group2.package1;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DbConnToAdvancedExecution {

	private boolean restoreSourcePathMatched;
	private String UserNameToInsertInDB;
	private String UserNameToAuthorizeRestoration;
	void insertAdvancedBackupDestinationPathToDatabase() {
		DbConnToAdvancedExecution dbConnToAdvancedExecutionObject = new DbConnToAdvancedExecution();
		PreparedStatement preparedStatement;
		{
			try {
				preparedStatement = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForInsertPathToDB);
				// preparedStatement = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForInsertPathToDB);
				if (StaticFields.isUserEnteredTheSystemByLoggingIn) {
					 preparedStatement.setString(1, StaticFields.loggedInUsersName);
					dbConnToAdvancedExecutionObject.setUserNameToInsertInDB(StaticFields.loggedInUsersName);
				} else {
					 preparedStatement.setString(1, StaticFields.newlyRegisteredUsersName);
					dbConnToAdvancedExecutionObject.setUserNameToInsertInDB(StaticFields.newlyRegisteredUsersName);
				}
				File advBackupSourceFile = new File(StaticFields.advancedBackupSourcePath);
				if(advBackupSourceFile.isFile()) {
					String pathWithUserName =StaticFields.advancedBackupDestinationPath + dbConnToAdvancedExecutionObject.getUserNameToInsertInDB();
					 preparedStatement.setString(2, pathWithUserName);
				}
				else {
					 preparedStatement.setString(2, StaticFields.advancedBackupDestinationPath);
				}
				
				if ( preparedStatement.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Destination insertion was successful!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Database isn't update!. Check your network!");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error while establishing connection.");
			}

		}
	}

	boolean isUserAuthorizedToRestore() {
		DbConnToAdvancedExecution object1 = new DbConnToAdvancedExecution();
		object1.setRestoreSourcePathMatched(false);
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForSelectAutorizedUserToRestore);
			//ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForSelectAutorizedUserToRestore);
			if (StaticFields.isUserEnteredTheSystemByLoggingIn) {
				ps.setString(1, StaticFields.loggedInUsersName);
				object1.setUserNameToAuthorizeRestoration(StaticFields.loggedInUsersName);
			} else {
				ps.setString(1, StaticFields.newlyRegisteredUsersName);
				object1.setUserNameToAuthorizeRestoration(StaticFields.newlyRegisteredUsersName);
			}

			rs = ps.executeQuery();
			while (rs.next()) {
				String path = rs.getString("destination");
				File restoreSourceFile = new File(StaticFields.restoreSourcePath);
				if(restoreSourceFile.isFile()) {
					if(path.equals(restoreSourceFile.getParent() + object1.getUserNameToAuthorizeRestoration()));
					object1.setRestoreSourcePathMatched(true);
				}
				else {
					if (path.equals(StaticFields.restoreSourcePath)) {
						object1.setRestoreSourcePathMatched(true);
					}
				}
				
			}
		}

		catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Error while establishing connection.");
		}
		return object1.isRestoreSourcePathMatched();
	}

	public boolean isRestoreSourcePathMatched() {
		return restoreSourcePathMatched;
	}

	public void setRestoreSourcePathMatched(boolean restoreSourcePathMatched) {
		this.restoreSourcePathMatched = restoreSourcePathMatched;
	}

	public String getUserNameToInsertInDB() {
		return UserNameToInsertInDB;
	}

	public void setUserNameToInsertInDB(String userNameToInsertInDB) {
		UserNameToInsertInDB = userNameToInsertInDB;
	}

	public String getUserNameToAuthorizeRestoration() {
		return UserNameToAuthorizeRestoration;
	}

	public void setUserNameToAuthorizeRestoration(String userNameToAuthorizeRestoration) {
		UserNameToAuthorizeRestoration = userNameToAuthorizeRestoration;
	}
}
