package com.group2.package1;

import java.io.File;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLTimeoutException;

import javax.swing.JOptionPane;

public class DbConnToAdvancedExecution {

	private boolean restoreSourcePathMatched;
	private String UserNameToInsertInDB;
	private String UserNameToAuthorizeRestoration;
	void insertAdvancedBackupDestinationPathToDatabase() {
		DbConnToAdvancedExecution dbConnToAdvancedExecutionObject = new DbConnToAdvancedExecution();
		PreparedStatement preparedStatement = null;

			try {
				//preparedStatement = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForInsertPathToDB);
				 String sqlQueryForInsertPathToDB = "INSERT INTO `adv`(`user_name`,`destination`) VALUES (?,?)";
				// String sqlQueryForInsertPathToDB = "INSERT INTO `adv`(`user_name`,`destination`) VALUES ('saamy','aaru')";
				 preparedStatement = SqLiteConnection.getSqliteConnection().prepareStatement(sqlQueryForInsertPathToDB);
				if (StaticFields.isUserEnteredTheSystemByLoggingIn) {
					System.out.println("Logged : "+StaticFields.loggedInUsersName);
					preparedStatement.setString(1, StaticFields.loggedInUsersName);
				} else {
					System.out.println("Not Logged : "+StaticFields.newlyRegisteredUsersName);
					preparedStatement.setString(1, StaticFields.newlyRegisteredUsersName);
				}
				File advBackupSourceFile = new File(StaticFields.advancedBackupSourcePath);
				if(advBackupSourceFile.isFile()) {
					String pathWithUserName =StaticFields.advancedBackupDestinationPath + dbConnToAdvancedExecutionObject.getUserNameToInsertInDB();
					preparedStatement.setString(2, pathWithUserName);
					 System.out.println(pathWithUserName);
					 System.out.println(sqlQueryForInsertPathToDB);
				}
				else {
					preparedStatement.setString(2, StaticFields.advancedBackupDestinationPath);
					 System.out.println("Directoryyyyyyyy "+StaticFields.advancedBackupDestinationPath);
					 System.out.println(sqlQueryForInsertPathToDB);
				}
				if (preparedStatement.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Destination insertion was successful!!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Database isn't update!. Check your network!");
				}

			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error while establishing connection in inserteting");
			}
			catch (Exception x) {
				JOptionPane.showMessageDialog(null, "Game On");
			}
			 finally {
					try {
						preparedStatement.close();
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


	boolean isUserAuthorizedToRestore() {
		DbConnToAdvancedExecution object1 = new DbConnToAdvancedExecution();
		object1.setRestoreSourcePathMatched(false);
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//ps = MyConnection.getConnection().prepareStatement(StaticFields.sqlQueryForSelectAutorizedUserToRestore);
			ps = SqLiteConnection.getSqliteConnection().prepareStatement(StaticFields.sqlQueryForSelectAutorizedUserToRestore);
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
