package Default;

import java.sql.*;
import javax.swing.*;

public class sqliteConnection {
	Connection conn = null;
	
	public static Connection dbConnector(String path){
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:F:\\sqlites.sqlite");
			return conn;
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e+": Can't connect to the database!");
			return null;
		}
	}
}
