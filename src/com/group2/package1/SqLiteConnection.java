package com.group2.package1;
import java.sql.*;

import javax.swing.JOptionPane;

public class SqLiteConnection {
	Connection conn = null;
	public static Connection getSqliteConnection() {
		try {
			Class.forName("org.sqlite.JDBC");
			//Connection conn = DriverManager.getConnection("jdbc:sqlite:fallout.db");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:/home/thanos18/eclipse-workspace/FalloutShelter/src/fallout.db");
			return conn;
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}

}
